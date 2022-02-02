<template>
    <v-container>
        <template>
            <v-expansion-panels>
                <v-expansion-panel
                        v-for="(item,i) in topics"
                        :key="i"
                >
                    <v-expansion-panel-header>
                        {{item.name}}
                    </v-expansion-panel-header>
                    <v-expansion-panel-content>
<!--                        {{item.description}}-->
                        <p>Add SubTopic</p>
                        <v-text-field label="Input name" v-model="topicName"></v-text-field>
                        <v-btn x-small>Submit</v-btn>


                    </v-expansion-panel-content>
                </v-expansion-panel>
            </v-expansion-panels>
        </template>
    </v-container>
</template>

<script>

    // import DialogNewTopic from "./DialogNewTopic.vue";

    export default {
        name: "ExpList",
        props:{
            topics:[]
        },
        components: {
            // DialogNewTopic
        },
        data() {
            return{
                topicName:''
            }
        }
    }
</script>

<style scoped>

</style>