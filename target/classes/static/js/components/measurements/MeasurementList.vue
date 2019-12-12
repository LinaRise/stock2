<template>
    <div style="position: relative; width: 300px;">
        <measurement-form :measurements="measurements" :measurementAttr="measurement"/>
        <measurement-row v-for="measurement in measurements"
                         :key="measurement.id"
                         :measurement="measurement"
                         :editMeasurement="editMeasurement"
                         :deleteMeasurement="deleteMeasurement"
                         :measurements="measurements"/>
    </div>
</template>

<script>
    import MeasurementRow from 'components/measurements/MeasurementRow.vue'
    import MeasurementForm from 'components/measurements/MeasurementForm.vue'

    export default {
        props: ['measurements'],
        components: {
            MeasurementRow,
            MeasurementForm
        },
        data() {
            return {
                measurement: null
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
        }
    }
</script>

<style>
</style>
