import Vue from 'vue'
import Vuetify from 'vuetify'
import VueResource from 'vue-resource'
import router from "router/router"
import App from 'pages/App.vue'
import 'vuetify/dist/vuetify.min.css'


Vue.use(VueResource)
Vue.use(Vuetify)

new Vue({
    el: '#app',
    router,
    vuetify: new Vuetify(),
    render: a=> a(App)
});
//
/*
function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var measurementApi = Vue.resource('/measurement{/id}');

Vue.component('measurement-form', {
    props: ['measurements', 'measurementAttr'],
    data: function() {
        return {
            measure: '',
            id: ''
        }
    },
    watch: {
        measurementAttr: function(newVal, oldVal) {
            this.measure = newVal.measure;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="measure" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var measurement = { measure: this.measure };

            if (this.id) {
                measurementApi.update({id: this.id}, measurement).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.measurements, data.id);
                        this.measurements.splice(index, 1, data);
                        this.measure = ''
                        this.id = ''
                    })
                )
            } else {
                measurementApi.save({}, measurement).then(result =>
                    result.json().then(data => {
                        this.measurements.push(data);
                        this.measure = ''
                    })
                )
            }
        }
    }
});

Vue.component('measurement-row', {
    props: ['measurement', 'editMethod', 'measurements'],
    template: '<div>' +
        '<i>({{ measurement.id }})</i> {{ measurement.measure }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.measurement);
        },
        del: function() {
            measurementApi.remove({id: this.measurement.id}).then(result => {
                if (result.ok) {
                    this.measurements.splice(this.measurements.indexOf(this.measurement), 1)
                }
            })
        }
    }
});

Vue.component('measurements-list', {
    props: ['measurements'],
    data: function() {
        return {
            measurement: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<measurement-form :measurements="measurements" :measurementAttr="measurement" />' +
        '<measurement-row v-for="measurement in measurements" :key="measurement.id" :measurement="measurement" ' +
        ':editMethod="editMethod" :measurements="measurements" />' +
        '</div>',

    methods: {
        editMethod: function(measurement) {
            this.measurement = measurement;
        }
    }
});

var app = new Vue({
    el: '#app',
    template:
        '<div>' +
        '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
        '<div v-else>' +
        '<div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>' +
        '<measurements-list :measurements="measurements" />' +
        '</div>' +
        '</div>',
    data: {
        measurements: frontendData.measurements,
        profile: frontendData.profile
    },
    // created: function() {
    //     measurementApi.get().then(result =>
    //         result.json().then(data =>
    //             data.forEach(measurement => this.measurements.push(measurement))
    //         )
    //     )
    // }
});*/
