<template>
    <!--<form @submit="save">-->
    <!--<input type="text" placeholder="Единица измерения" v-model="measure" />-->
    <!--<button type="submit">Save</button>-->
    <!--<table class="table table-bordered">-->
    <!--<thead>-->
    <!--<tr>-->
    <!--<th>№</th>-->
    <!--<th>Единица измерения</th>-->
    <!--</tr>-->
    <!--</thead>-->
    <!--</table>-->
    <!--</form>-->

    <form @submit="save">
        <v-layout row> <!--чтобы ввод и кнопка были в одной строке-->
            <v-text-field
                    label="New measurement"
                    placeholder="Единица измерения"
                    v-model="measure"/>
            <v-btn type="submit">Сохранить</v-btn>
        </v-layout>
    </form>


</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++) {
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
            save(e) {
                e.preventDefault();
                const measurement = {measure: this.measure}
                if (this.id) {
                    this.$resource('/measurement{/id}').update({id: this.id}, measurement).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.measurements, data.id)
                            this.measurements.splice(index, 1, data)
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