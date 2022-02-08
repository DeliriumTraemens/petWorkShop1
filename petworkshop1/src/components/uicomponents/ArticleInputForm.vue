<template>
    <div class="mb-2">
        <v-btn
                x-small
                color="orange"
                darker-2
                @click.stop="dialog = true"
        >
            Add New Article
        </v-btn>

        <v-dialog
                v-model="dialog"
                max-width="600px"
                height="600px"
        >
            <v-card>
                <v-card-title class="text-h5">
                    <h3>Новая статья в теме # {{dataItem}}</h3>
                </v-card-title>

                <v-card-text>

                    <v-text-field label="Input Name" v-model="articleName"/>
                    <v-textarea label="Input Description" v-model="articleDescription"/>
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
                            @click="addNewArticle()"
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
        name: "ArticleInputForm",

        props: {
            dataItem:Number
        },
        data () {
            return {
                dialog: false,
                articleName:'',
                articleDescription:'',
                articleUrl: 'http://localhost:9090/article',

            }
        },
        methods: {
            addNewArticle(){
                this.dialog = false
                // alert(id+this.topicName+' '+this.topicDescription)
                let id = String(this.dataItem)
                const fd=new FormData();
                fd.append('parentId',id);
                fd.append('name',this.articleName)
                fd.append('description',this.articleDescription)
                axios.post(this.articleUrl ,fd).then(res=>{
                    console.log(res)
                })
            }
        }
    }
</script>



<style scoped>

</style>