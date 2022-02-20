<template>
    <div>

        <div class="pt-0.5">
            <v-btn
                    x-small
                    color="warning"
                    @click.stop="dialog = true">
                Add Article
            </v-btn>
        </div>

        <v-dialog
                v-model="dialog"
                max-width="600px"
        >
            <v-card>
                <v-card-title class="text-h5">
                    Input New Article {{parTop}}
                </v-card-title>

                <v-card-text>
                    <v-text-field label="Name" v-model="article.name" ></v-text-field>
                    <v-textarea label="Description"  v-model="article.description" ></v-textarea>

                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                    >
                        Cancel
                    </v-btn>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="createNewArticle(parTop)"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    // import axios from 'axios'
    import { mapActions } from 'vuex';
    export default {
        name: "ArticleDialogMy1",
        props: {
            parTop: Number
        },
        data() {
            return {
                dialog: false,
                articleName:'',
                articleDescription:'',
                articleUrl: 'http://localhost:9090/article',
                topicParentId:'',
                article:{
                    name:'',
                    description:'',
                    topicId:String,
                    url: 'http://localhost:9090/article'
                }
            }
        },
        methods: {
            ...mapActions(['createArticleAction', 'updateTopicList']),
            async createNewArticle(id){
                this.dialog = false

                this.article.topicId= String(id)
                await this.createArticleAction(this.article)
                this.article.name = ''
                this.article.description = ''

            }
        },
    }
</script>

<style scoped>

</style>