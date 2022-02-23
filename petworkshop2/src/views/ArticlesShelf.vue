<template>
    <div>
        <h1>Articles</h1>
        <v-row>
            <v-col cols="4">
                <div class="px-2">
                    <h1>Col 1</h1>
                <TopicTreeExpansion2 :data="getTopicsTotalList"/>
                    <hr class="mb-4">
                    <!-- Tree Browser -->
                    <div>TreeBrowser</div>
                    <hr class="mb-4 mt-4">
                    <TreeBrowser
                            v-for="node in getTopicsTotalList" :key="node.id"
                            :node="node" />
                </div>
            </v-col >
            <v-col cols="4" >
                <h1 >Col 2</h1>

                <div >
                    <v-btn @click="isActive=!isActive">Show</v-btn>
                    <h3 :class="{isActive}">Articles dd</h3>
                </div>
                <div>
                    <hr class="mb-3">
                    <h3>sss
                        {{getTopicsSelectedTopicId}}
                    </h3>
                    <v-btn @click="incrementSelectedId">Increment</v-btn>
                    <hr>
                    <v-text-field label="Set Value" v-model="value"></v-text-field>
                    <v-btn @click="setValue">Set Value</v-btn>
                    <hr>
                </div>
                <div class="my-3" >
                    <p>Article List Component</p>
                    <p>articlesList= getSelectedTopic.articleSet</p>
                    <!-- Article List Component -->
                    <ArticleList :name="getSelectedTopic.name"
                                 :topicID="getSelectedTopic.id"
                                 :articlesList="getSelectedTopic.articleSet" />
                </div>
                <hr>

            </v-col>
            <v-col cols="4">
                <h1>Col 3</h1>

                <TopicNewRootForm2 />
                <hr class="mb-5">
                scroller
<!--                <Scroller1 />-->
                <hr class="mb-5">
                <TopicCard2  :data="getSelectedTopic" />
                <hr class="mb-5">

            </v-col>
        </v-row>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex'
    import TopicTreeExpansion2 from "../components/ui/trees/TopicTreeExpansion2";
    import TopicNewRootForm2 from "../components/topic/TopicNewRootForm2";
    import TreeBrowser from "../components/ui/trees/TreeBrowser";
    import ArticleList from "../components/article/ArticleList";
    import TopicCard2 from "../components/ui/cards/TopicCard2";
    // import Scroller1 from "../components/ui/scroll/Scroller1";

    export default {
        name: "ArticlesShelf",
        components: {TopicCard2, ArticleList, TreeBrowser, TopicNewRootForm2, TopicTreeExpansion2},
        data() {
            return{
                value: '',
                isActive:false,

            }
        },
        computed: mapGetters(['getTopicsTotalList','getSelectedTopic' ,'getTopicsSelectedTopicId', 'getTopicsSelectedTopic']),
        methods: {
            ...mapActions(['updateTopicList','setSelectedTopic' ,'incrementSelectedId', 'setSelectedTopicId']),
            setValue(){
                this.setSelectedTopicId(this.value)
            },
            // headerClick(item){
            //     this.setSelectedTopic(item.id)
            // },
            updateRootArray(){
                this.root.children.push(this.getTopicsTotalList)
                console.log('Root Array')
                console.log(this.root)
            }
        },
        async created() {
            await this.updateTopicList()
                // await this.updateRootArray()

        }
    }
</script>

<style scoped>
.isActive{
    display: none;
}
</style>