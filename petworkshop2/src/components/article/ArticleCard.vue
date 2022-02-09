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
                <v-btn color="warning" x-small>Edit</v-btn>
            </v-card-actions>
        </v-card>
</template>

<script>
    export default {
        name: "ArticleCard",
        props: {
            article:[]
        },
    }
</script>

<style scoped>

</style>