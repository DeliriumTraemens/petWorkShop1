<template>
    <v-card>
        <v-card-title> {{data.name}} </v-card-title>
        <v-card-subtitle> {{data.name}} Id#{{data.id}} </v-card-subtitle>
        <v-card-text>{{data.description}} Description</v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: "TopicCard1",
        props: {
            data: []
        }
    }
</script>

<style scoped>

</style>