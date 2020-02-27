<template>
    <!--<div>-->
    <!--<i>({{ measurement.id }})</i> {{ measurement.measure }}-->
    <!--<span style="position: absolute; right: 0">-->
    <!--<input type="button" value="Edit" @click="edit" />-->
    <!--<input type="button" value="X" @click="del" />-->
    <!--</span>-->
    <!--</div>-->


    <!--<table class="table table-bordered table-hover">-->
    <!--<tbody>-->
    <!--<tr>-->
    <!--<th scope="row">{{measurement.id}}&nbsp&nbsp&nbsp</th>-->
    <!--<td>{{measurement.measure}}</td>-->
    <!--<td ><button type="button" @click="edit">Изменить</button></td>-->
    <!--<td ><button type="button" @click="del">Удалить</button></td>-->
    <!--</tr>-->
    <!--</tbody>-->
    <!--</table>-->

    <v-card class="my-3">
        <v-card-text primary-title>
            <i>({{ measurement.id }})</i> {{ measurement.measure }}
        </v-card-text>
        <v-card-actions>
            <v-btn value="Edit" @click="edit" small flat round>Редактировать</v-btn>
            <v-btn icon @click="del" small>
                <v-icon>delete</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
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
