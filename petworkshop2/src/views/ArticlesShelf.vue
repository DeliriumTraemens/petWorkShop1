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
                <h1 >Col 2</h1>



                <div >
                    <v-btn @click="isActive=!isActive">Show</v-btn>
                    <h3 :class="{isActive}">Articles dd</h3>
                </div>
                    <hr class="mb-3">
                    <h3>
                        {{getTopicsSelectedTopicId}}
                    </h3>
                    <v-btn @click="incrementSelectedId">Increment</v-btn>
                    <hr>
                    <v-text-field label="Set Value" v-model="value"></v-text-field>
                    <v-btn @click="setValue">Set Value</v-btn>
                <hr>
                <div class="my-3" >
                  <v-card>
                      <v-card-title>
                    {{getSelectedTopic.name}} id# {{getSelectedTopic.id}}

                      </v-card-title>
                      <v-card-text>
                            <div v-if="getSelectedTopic.children" class="ml-4">
                                <div v-for="(subTopic, i) in getSelectedTopic.children" :key="i">
                                    {{subTopic.id}}
                                    {{subTopic.name}}
                                </div>
                            </div>
                      </v-card-text>
                      <v-card-actions>
                          <v-btn x-small color="warning">Add An Article</v-btn>
                      </v-card-actions>
                  </v-card>

                    <div v-if="getSelectedTopic.articleSet">
                        <div v-for="(article, i) in getSelectedTopic.articleSet" :key="i" class="mt-3">
                            <v-card class="py-2 px-2">
                                <v-card-title>
                                    {{article.name}} {{article.id}}
                                </v-card-title>
                                <v-card-text v-html="article.description">

                                </v-card-text>
                                <v-card-actions>
                                    <v-btn x-small color="warning">Edit</v-btn>
                                </v-card-actions>
                            </v-card>
                        </div>
                    </div>

                </div>
                <hr>

            </v-col>
            <v-col>
                <h1>Col 3</h1>

                <TopicNewRootForm2 />
                <hr class="mb-5">
                <!-- Tree Browser -->
                <!--                <TreeBrowser :node="root" />-->
                <TreeBrowser
                        v-for="(node, i) in getTopicsTotalList" :key="i"
                        :node="node" />
                <hr class="mb-5">

                <div v-for="item in getTopicsTotalList" :key="item.id" >
                    <div @click="headerClick(item)">{{item.name}}</div>
                </div>
            </v-col>
        </v-row>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import TopicTreeExpansion2 from "../components/ui/trees/TopicTreeExpansion2";
    import TopicNewRootForm2 from "../components/topic/TopicNewRootForm2";
    import TreeBrowser from "../components/ui/trees/TreeBrowser";

    export default {
        name: "ArticlesShelf",
        components: {TreeBrowser, TopicNewRootForm2, TopicTreeExpansion2},
        data() {
            return{
                value: '',
                isActive:false,
                root:{
                    name: '/',
                    children: [
                        {
                            name: 'workspace',
                            children: [
                                {
                                    name: 'table',
                                    children: []
                                },
                                {
                                    name: 'comp',
                                    children: []
                                },
                            ]
                        },
                        {
                            name: 'songs',
                            children: [
                                {
                                    name: 'rock',
                                    children: []
                                },
                                {
                                    name: 'folk',
                                    children: []
                                },
                                {
                                    name: 'country',
                                    children: []
                                },
                            ]
                        },
                        {
                            name: 'instrumental',
                            children: []
                        },
                    ]
                },
            }
        },
        computed: mapGetters(['getTopicsTotalList','getSelectedTopic' ,'getTopicsSelectedTopicId', 'getTopicsSelectedTopic']),
        methods: {
            ...mapActions(['updateTopicList','setSelectedTopic' ,'incrementSelectedId', 'setSelectedTopicId']),
            setValue(){
                this.setSelectedTopicId(this.value)
            },
            headerClick(item){
                this.setSelectedTopic(item)
            },
            updateRootArray(){
                this.root.children.push(this.getTopicsTotalList)
                console.log('Root Array')
                console.log(this.root)
            }
        },
        async mounted() {
            await this.updateTopicList(),
                await this.updateRootArray()

        }
    }
</script>

<style scoped>
.isActive{
    display: none;
}
</style>