<template>
    <v-expansion-panels class="mt-4">
        <v-expansion-panel>
            <v-expansion-panel-header>
                <strong>Add new Root Topic</strong>
            </v-expansion-panel-header>
            <v-expansion-panel-content>
                <v-text-field label="Input Topic Name" v-model="newTopicName" />
                <v-text-field label="Input Topic Description" v-model="newTopicDescription" />
                <v-btn color="warning" x-small @click="submitNewRootTopic" >Submit</v-btn>
            </v-expansion-panel-content>
        </v-expansion-panel>
    </v-expansion-panels>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "TopicNewRootForm",
        data() {
            return {
                newTopicName: '',
                newTopicDescription: '',
                topicUrl: 'http://localhost:9090/topic'
            }
        },
        methods: {
            submitNewRootTopic(){
                const fd = new FormData()
                fd.append('name', this.newTopicName)
                fd.append('description', this.newTopicDescription)
                axios.post(this.topicUrl, fd)
                .then(res=>{
                    console.log(res)
                    /*Add TopicList Update*/
                })
                this.newTopicName=''
                this.newTopicDescription=''

            }
        }
    }
</script>

<style scoped>

</style>