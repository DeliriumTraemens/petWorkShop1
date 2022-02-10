<template>
    <div>
        <v-row>
            <v-col cols="4">
                <div class="px-2">
                    <h1>Col 1</h1>
                <TopicTreeExpansion2 :data="getTopicsTotalList"/>
                </div>
            </v-col>
            <v-col>
                <h1>Col 2</h1>
                    <h3>Articles</h3>
                    <hr class="mb-3">
                    <h3>
                        {{getTopicsSelectedTopicId}}
                    </h3>
                    <v-btn @click="incrementSelectedId">Increment</v-btn>
                    <hr>
                    <v-text-field label="Set Value" v-model="value"></v-text-field>
                    <v-btn @click="setValue">Set Value</v-btn>
                <hr>
                <div class="my-3">
                    {{getSelectedTopic.id}}<br>
                    {{getSelectedTopic.name}}<br>
                    <div v-if="getSelectedTopic.children" class="ml-4">
                        <div v-for="(subTopic, i) in getSelectedTopic.children" :key="i">
                            {{subTopic.id}}
                            {{subTopic.name}}
                        </div>


                    </div>

                </div>
                <hr>

            </v-col>
            <v-col>
                <h1>Col 3</h1>

                <TopicNewRootForm2 />

                <div v-for="item in getTopicsTotalList" :key="item.id">
                    {{item.name}}
                </div>
            </v-col>
        </v-row>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import TopicTreeExpansion2 from "../components/ui/trees/TopicTreeExpansion2";
    import TopicNewRootForm2 from "../components/topic/TopicNewRootForm2";

    export default {
        name: "ArticlesShelf",
        components: {TopicNewRootForm2, TopicTreeExpansion2},
        data() {
            return{
                value: ''
            }
        },
        computed: mapGetters(['getTopicsTotalList','getSelectedTopic' ,'getTopicsSelectedTopicId', 'getTopicsSelectedTopic']),
        methods: {
            ...mapActions(['updateTopicList', 'incrementSelectedId', 'setSelectedTopicId']),
            setValue(){
                this.setSelectedTopicId(this.value)
            }
        },
        async mounted() {
            await this.updateTopicList()
        }
    }
</script>

<style scoped>

</style>