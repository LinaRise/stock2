<template>
    <v-layout align-space-around justify-start column>
        <measurement-form :measurements="measurements" :measurementAttr="measurement"/>
        <measurement-row v-for="measurement in sortedMeasurements"
                         :key="measurement.id"
                         :measurement="measurement"
                         :editMeasurement="editMeasurement"
                         :deleteMeasurement="deleteMeasurement"
                         :measurements="measurements"/>
    </v-layout>
</template>

<script>
    import MeasurementRow from 'components/measurements/MeasurementRow.vue'
    import MeasurementForm from 'components/measurements/MeasurementForm.vue'

    export default {
        components: {
            MeasurementRow,
            MeasurementForm
        },
        data() {
            return {
                measurement: null,
                measurements: []
            }
        },
        //в computed опишем поля которые будут рассчитываться при изменении свойств от которых онии зависят
        computed: {
            sortedMeasurements(){
                return this.measurements.sort((a,b)=> -(a.id-b.id))
            }
        },
        methods: {
            editMeasurement(measurement) {
                this.measurement = measurement
            },
            deleteMeasurement(measurement) {
                this.$resource('/measurement{/id}').remove({id: measurement.id}).then(result => {
                    if (result.ok) {
                        this.measurements.splice(this.measurements.indexOf(measurement), 1)
                    }
                })
            }
        },
        created() {
            this.$resource('/measurement').get().then(result => {
                result.json().then(data => {
                    data.forEach(element => this.measurements.push(element));
                })
            })
        }
    }
</script>

<style>
</style>