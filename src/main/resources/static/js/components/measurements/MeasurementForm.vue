<template>
    <div>
        <input type="text" placeholder="Write something" v-model="measure" />
        <input type="button" value="Save" @click="save" />
    </div>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i
            }
        }
        return -1
    }
    export default {
        props: ['measurements', 'measurementAttr'],
        data() {
            return {
               measure: '',
                id: ''
            }
        },
        watch: {
            measurementAttr(newVal, oldVal) {
                this.measure = newVal.measure
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                const measurement = {measure: this.measure }
                if (this.id) {
                    this.$resource('/measurement{/id}').update({id: this.id}, measurement).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.measurements, data.id)
                            this.measurement.splice(index, 1, data)
                            this.measure = ''
                            this.id = ''
                        })
                    )
                } else {
                    this.$resource('/measurement{/id}').save({}, measurement).then(result =>
                        result.json().then(data => {
                            this.measurements.push(data)
                            this.measure = ''
                        })
                    )
                }
            }
        }
    }
</script>

<style>
</style>