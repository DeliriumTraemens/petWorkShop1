<template>
    <v-card>
        <v-card-title> Карточка TopicCard2 </v-card-title>
        <v-card-subtitle>
            <h4>{{data.name}} Id#{{data.id}}</h4>
        </v-card-subtitle>
        <v-card-text>
<!--            <div v-for="(item, id) in data" :key="id">-->
<!--                {{item.name}}-->
<!--            </div>-->
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: "TopicCard2",
        props: {
            data: {
                type: Array
            }
        }
    }
</script>

<style scoped>

</style>