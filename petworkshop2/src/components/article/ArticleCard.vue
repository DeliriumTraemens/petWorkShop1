<template>
        <v-card class="mb-2">
            <v-card-title>
                {{article.name}}
            </v-card-title>
            <v-card-subtitle>
                Topic id #{{article.artTopic}}
            </v-card-subtitle>
            <v-card-text>
                {{article.description}}
            </v-card-text>
            <v-card-actions>
<!--                <v-btn color="warning" x-small>Edit</v-btn>-->
                <ArticleDialogEdit :data="article"/>
            </v-card-actions>
        </v-card>
</template>

<script>
    import ArticleDialogEdit from "../ui/dialogs/ArticleDialogEdit";
    export default {
        name: "ArticleCard",
        components: {ArticleDialogEdit},
        props: {
            article:[]
        },
    }
</script>

<style scoped>

</style>