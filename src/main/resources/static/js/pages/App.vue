<template>
    <v-app>
        <v-app-bar app>
            <v-toolbar-title>Склад</v-toolbar-title>
            <v-spacer/>
            <v-btn v-if="profile" href="/income">Приходная накладная</v-btn>
            <v-btn v-if="profile" href="/outcome">Отпускная накладная</v-btn>
            <!--<v-btn v-if="profile" href="/measurements">Единицы измерения</v-btn>-->
            <v-spacer/>
            <span v-if="profile">{{profile.name}}</span>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-app-bar>
        <v-content>
            <v-container v-if="!profile">
                Необходимо авторизоваться через
                <a href="/login">Google</a>
            </v-container>
            <v-container v-if="profile">
                <router-view/>
            </v-container>
        </v-content>
    </v-app>
</template>


<script>

    export default {
        data() {
            return {
                profile: frontendData.profile
            }
        }
    }
</script>

<style>
</style>