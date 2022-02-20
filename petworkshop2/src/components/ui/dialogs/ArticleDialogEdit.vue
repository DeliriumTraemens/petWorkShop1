<template>
    <div>

        <div class="pt-0.5">
            <v-btn
                    x-small
                    color="warning"
                    @click.stop="dialog = true">
                Edit Article
            </v-btn>

            <v-dialog
                    v-model="dialog"
                    max-width="800px"
            >
                <v-card>
                    <v-card-title class="text-h5">
                        Edit The Article id#{{article.id}} , topic#{{article.artTopic}}
                    </v-card-title>

                    <v-card-text>

                        <hr class="mb-3">
                        <v-text-field label="Name" v-model="article.name" ></v-text-field>
                        <v-textarea
                                auto-grow
                                label="Description"
                                v-model="article.description" ></v-textarea>
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
                                @click="saveArticle"
                        >
                            Submit
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>

        </div>




    </div>
</template>

<script>
    import {mapActions} from 'vuex';

    export default {
        name: "ArticleDialogEdit",
        props: {
            data:{}
        },
        data() {
            return{
                dialog: false,

                article:{
                    id:String,
                    artTopic:String,
                    name:String,
                    description:String,

                }

            }
        },
        created(){
            this.setVModelFields()
        },
        methods:{
            ...mapActions(['updateArticleAction','updateTopicList','setSelectedTopic']),
          async  saveArticle(){
                // alert('Submit')
                this.dialog = false
               await this.updateArticleAction(this.article)
              this.article.name = ''
              this.article.description = ''
            },

            setVModelFields(){
                this.article.id = this.data.id;
                this.article.artTopic = this.data.artTopic;
                this.article.name = this.data.name;
                this.article.description = this.data.description;
            }
        },
        beforeDestroy(){
               //todo   update selected topic from server
               // this.setSelectedTopic(this.article.artTopic)
        }
    }
</script>

<style scoped>

</style>