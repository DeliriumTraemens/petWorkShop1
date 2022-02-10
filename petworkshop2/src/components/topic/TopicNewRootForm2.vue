<template>
    <v-expansion-panels class="mt-4">
        <v-expansion-panel>
            <v-expansion-panel-header>
                <strong>Add new Root Topic</strong>
            </v-expansion-panel-header>
            <v-expansion-panel-content>
                <v-text-field label="Input Topic Name" v-model="topic.name" />
                <v-text-field label="Input Topic Description" v-model="topic.description" />
                <v-btn color="warning" x-small @click="submitNewRootTopic" >Submit</v-btn>
            </v-expansion-panel-content>
        </v-expansion-panel>
    </v-expansion-panels>
</template>

<script>
    // import axios from "axios";
    import {mapActions} from 'vuex'

    export default {
        name: "TopicNewRootForm2",
        data() {
            return {
                topic:{
                    name: '',
                    description: ''
                },
                // newTopicName: '',
                // newTopicDescription: '',
                topicUrl: 'http://localhost:9090/topic'
            }
        },
        methods: {
            ...mapActions(['createNewRootTopic']),
            submitNewRootTopic(){
                this.createNewRootTopic(this.topic)
                // const fd = new FormData()
                // fd.append('name', this.newTopicName)
                // fd.append('description', this.newTopicDescription)
                // axios.post(this.topicUrl, fd)
                //     .then(res=>{
                //         console.log(res)
                //         /*Add TopicList Update*/
                //     })
                // this.newTopicName=''
                // this.newTopicDescription=''
                // console.log('New TopicName Data')
                // console.log(this.topic)
                // console.log(this.topic.name)
                // console.log(this.topic.description)
            }
        }
    }
</script>

<style scoped>

</style>