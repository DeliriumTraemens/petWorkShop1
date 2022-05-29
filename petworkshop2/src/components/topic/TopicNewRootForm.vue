<template>
  <v-expansion-panels class="mt-4">
    <v-expansion-panel>
      <v-expansion-panel-header>
        <strong>TopicNewRootForm —> Add new Root Topic</strong>
      </v-expansion-panel-header>
      <v-expansion-panel-content>
        <v-text-field
          v-model="topic.name"
          label="Input Topic Name"
        />
        <v-text-field
          v-model="topic.description"
          label="Input Topic Description"
        />
        <v-btn
          color="warning"
          x-small
          @click="submitNewRootTopic"
        >
          Submit
        </v-btn>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
    // import axios from 'axios';
    import {mapActions} from 'vuex'

    export default {
        name: "TopicNewRootForm",
        data() {
            return {
                newTopicName: '',
                newTopicDescription: '',
                topicUrl: 'http://localhost:9090/topic',
                topic:{
                    name: '',
                    description: ''
                }
            }
        },
        methods: {
            ...mapActions(['createNewRootTopic']),

            submitNewRootTopic(){

                this.createNewRootTopic(this.topic)
                this.topic.name = ''
                this.topic.description = ''

            }
        }
    }
</script>

<style scoped>

</style>