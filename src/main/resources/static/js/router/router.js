import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from "pages/App.vue";
import MeasurementListPage from "pages/MeasurementListPage.vue";
import IncomePage from "pages/IncomePage.vue";
import OutcomePage from "pages/OutcomePage.vue";

Vue.use(VueRouter);

const routes = [
    {path: '/', component: MainPage},
    {path: '/measurements', component: MeasurementListPage},
    {path: '/income', component: IncomePage},
    {path: '/outcome', component: OutcomePage},
];

export default new VueRouter({
    mode: 'history',
    routes
});