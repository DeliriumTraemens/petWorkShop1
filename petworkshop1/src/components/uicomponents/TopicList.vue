<template>
    <v-container >
        <v-row>
            <v-col cols="4">
                <TopicItem v-for="(item, i) in topicList" :key="i" :item="item" @showtopic="showInfo"/>
            </v-col>
            <v-col cols="6">
                <ArticleList :articles="articleList.articleSet" :topicid="selectedTopicId"/>
            </v-col>
            <v-col></v-col>
        </v-row>

        <hr>
    </v-container>
</template>

<script>
    import TopicItem from "./TopicItem.vue";
    // import ExpList from "./ExpList.vue";
    import ArticleList from "./ArticleList.vue";
    import axios from 'axios'

    export default {
        name: "TopicList",
        components: {
            ArticleList,
            // ExpList,
          TopicItem
        },
        props: {
            topicList:{
                type: Array
            },
            id:Number

        },
        data() {
            return{
                articleList:[],
                articleUrl:'http://localhost:9090/article',
                topicUrl:'http://localhost:9090/topic/',
                selectedTopicId: Number
            }
        },
        methods: {
            showInfo(id){
                // alert('TopicList'+id)
                //Write select by Topic Id
                this.selectedTopicId=id
                axios.get(this.topicUrl+id).then(res=>{
                    console.log(res.data.children)
                    this.articleList=res.data
                    console.log(this.articleList)
                })
            }
        }
    }
</script>

<style scoped>

</style>