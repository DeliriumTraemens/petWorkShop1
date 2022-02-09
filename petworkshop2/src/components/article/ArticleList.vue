<template>
    <v-container>
        <v-card>
            <v-card-title >
                {{name}}
            </v-card-title>
            <hr>
            <v-card-subtitle>
               topicId {{topicID}}
            </v-card-subtitle>
            <hr>
            <v-card-text>
                <ArticleCard v-for="(article, i) in articlesList" :key="i" :article="article" />
                <div v-if="articlesList.length===0">Статей нет</div>
            </v-card-text>
            <v-card-actions>
                <!--TODO Article add Dialog to be created-->
                <ArticleDialogMy1 :parTop="topicID"/>
<!--                <v-btn x-small color="warning" >Add Article</v-btn>-->
            </v-card-actions>
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
            articlesList:[]
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