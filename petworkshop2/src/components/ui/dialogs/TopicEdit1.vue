<template>
    <div class="wrap1">

        <div class="pt-0.5 ">
            <v-btn icon

                   color="warning"
                   @click.stop="dialog = true">
                <v-icon small dark>
                    mdi-pencil
                </v-icon>
            </v-btn>
        </div>

        <v-dialog
                v-model="dialog"
                max-width="390"
        >
            <v-card>
                <v-card-title class="text-h5">
                    Input Topic Data For dd{{topicData.id}}
                </v-card-title>

                <v-card-text>
                    <v-text-field label="Name" v-model="topic.name"></v-text-field>
                    <v-text-field label="Description" v-model="topic.description"></v-text-field>
                    Lorem ipsum dolor sit amet.
                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn
                            color="warning"
                            text
                            @click="dialog = false"
                    >
                        Cancel
                    </v-btn>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="saveChanges"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

    </div>
</template>

<script>
    import {mapActions} from 'vuex';
    export default {
        name: "TopicEdit1",
        props: {
            topicData:{}
        },
        data() {
            return{
                dialog: false,
                topic:{
                    id: String,
                    name: String,
                    description: String
                }
                
            }
        },
        computed: {

        },
        methods: {
            ...mapActions(['editTopicAction']),
            editTopicVModel(){
                this.topic.id = this.topicData.id
                this.topic.name = this.topicData.name
                this.topic.description = this.topicData.description

            },
            saveChanges(){
                this.editTopicAction(this.topic)
                this.dialog = false
            }
        },
        mounted() {
            this.editTopicVModel()
        }
    }
</script>

<style scoped>

</style>