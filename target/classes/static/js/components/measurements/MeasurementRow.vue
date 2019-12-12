<template>
    <div>
        <i>({{ measurement.id }})</i> {{ measurement.text }}
        <span style="position: absolute; right: 0">
            <input type="button" value="Edit" @click="edit" />
            <input type="button" value="X" @click="del" />
        </span>
    </div>
</template>

<script>
    export default {
        props: ['measurement', 'editMeasurement', 'deleteMeasurement', 'measurements'],
        methods: {
            edit() {
                this.editMeasurement(this.measurement)
            },
            del() {
                this.deleteMeasurement(this.measurement)
            }
        }
    }
</script>

<style>
</style>
