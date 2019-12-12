<template>
    <div>
        <div v-if="!profile">Необходимо авторизоваться через
            <a href="/login">Google</a>
        </div>
        <div v-else>
            <div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>
            <measurements-list :measurements="measurements"/>
        </div>
    </div>
</template>

<script>
    import MeasurementsList from 'components/measurements/MeasurementList.vue'

    export default {
        components: {
            MeasurementsList
        },
        data() {
            return {
                measurements: frontendData.measurements,
                profile: frontendData.profile
            }
        }
    }
</script>

<style>
</style>