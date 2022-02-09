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
                    <v-text-field label="Name" v-model="articleName" ></v-text-field>
                    <v-textarea label="Description"  v-model="articleDescription" ></v-textarea>

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
    import axios from 'axios'
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
                topicParentId:''
            }
        },
        methods: {
            createNewArticle(id){
                this.dialog = false
                console.log(id)
                const fd = new FormData()
                fd.append('id', id)
                fd.append('name', this.articleName)
                fd.append('text', this.articleDescription)
                console.log(fd)
                axios.post(this.articleUrl, fd).then(res =>{
                    console.log('RESPONSE')
                    console.log(res)
                })


            }
        },
    }
</script>

<style scoped>

</style>