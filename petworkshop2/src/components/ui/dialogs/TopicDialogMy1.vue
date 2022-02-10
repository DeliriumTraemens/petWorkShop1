<template>
    <div>

        <div class="pt-0.5">
            <v-btn icon
                   color="indigo"
                   @click.stop="dialog = true">
                <v-icon small dark>
                    mdi-plus
                </v-icon>
            </v-btn>
        </div>

        <v-dialog
                v-model="dialog"
                max-width="390"
        >
            <v-card>
                <v-card-title class="text-h5">
                    Input Topic Data
                </v-card-title>

                <v-card-text>
                    <v-text-field label="Name" v-model="newSubTopicName"></v-text-field>
                    <v-text-field label="Description" v-model="newSubTopicDescription"></v-text-field>
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
                            @click="createSubTopic(topicData.id)"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    import axios from "axios";


    export default {
        name: "TopicDialogMy1",
        components: {},
        props: {
            topicData: []
        },
        data() {
            return {
                dialog: false,
                newSubTopicName: '',
                newSubTopicDescription: '',
                subtopicUrl: 'http://localhost:9090/topic/newsub'
            }
        },
        methods: {
           async createSubTopic(id) {
                this.dialog = false
                console.log('Current topic Id')
                console.log(id)
                const fd = new FormData()
                fd.append('parentId',id)
                fd.append('name', this.newSubTopicName)
                fd.append('description', this.newSubTopicDescription)
                axios.post(this.subtopicUrl, fd).then(res =>{
                    console.log(res)
                    /*Add event for the topic list refreshing */
                    this.$emit('updateTopicList')
                })
            }
        }
    }
</script>

<style scoped>

</style>