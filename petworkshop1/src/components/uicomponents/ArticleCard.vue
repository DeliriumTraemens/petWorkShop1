<template>
    <v-card class="crd1">
        <v-card-title>
            {{article.name}}
        </v-card-title>
        <v-card-subtitle>
            <p>Id # {{article.id}}</p>
        </v-card-subtitle>
        <v-card-text v-html="article.description">
            <!--                        {{article.description}}-->
        </v-card-text>
        <v-card-actions>
            <v-btn x-small fab color="orange" @click="articleEdit">
                Edit
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "ArticleCard",
        props: {
            article: Object
        },
        methods: {
            articleEdit(){
                alert('Hurraaah!')
            }
        }
    }
</script>

<style scoped>

</style>