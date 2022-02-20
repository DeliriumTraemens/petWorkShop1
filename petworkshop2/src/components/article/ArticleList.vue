<template>
    <v-container>
        <v-card>
            <v-card-title >
                ArticleList
            </v-card-title>
            <v-card-subtitle>
                <h3>
                    {{name}}
                </h3>
            </v-card-subtitle>
            <v-card-actions>
                <ArticleDialogMy1 :parTop="topicID"/>
            </v-card-actions>
            <hr>
            <v-card-subtitle>
               topicId {{topicID}}
            </v-card-subtitle>
            <hr>
            <v-card-text>
                <div v-if="articlesList.length===0">Статей нет</div>
                <div v-else>
                    <ArticleCard v-for="(article, i) in articlesList"
                                 :key="i"
                                 :article="article"/>
                </div>
            </v-card-text>
        </v-card>
    </v-container>
</template>

<script>
    import ArticleCard from "./ArticleCard";
    import ArticleDialogMy1 from "../ui/dialogs/ArticleDialogMy1";
    export default {
        name: "ArticleList",
        components: {ArticleDialogMy1, ArticleCard},
        props: {
            name: String,
            topicID:{
                type:Number
            },
            articlesList:{
                type:Array
            }
        },
        methods: {

        },
        mounted() {
            console.log('ArticleList Component')
            console.log(this.articlesList)
        }
    }
</script>

<style scoped>

</style>