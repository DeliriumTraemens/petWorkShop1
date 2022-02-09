<template>
    <v-container>
        <v-row>
            <v-col cols="3">
                <h2>Col1 Topics</h2>

                <TopicsExpansion1 :items="topicList"  @sendup="getdata"/>
                <hr>
                <TopicTreeRoot :items="topicList" @sendup="getdata"/>
                <hr>
                <TopicNewRootForm />
            </v-col>
            <v-col cols="6">
                <div>
                <v-row>
                    <v-col cols="12"> <H2>Col 2</H2>
                        <!--ArticlesList-->
                        <ArticleList
                                :name="currentTopic.name"
                                :topicID="currentTopic.id"
                                :articlesList="currentTopic.articleSet"/>
                    </v-col>
                </v-row>
                </div>
            </v-col>
            <v-col> <H2>Col 3</H2>

            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import axios from 'axios'
    // import TopicsTree from "../components/ui/trees/TopicsTree";
    import TopicTreeRoot from "../components/ui/trees/TopicTreeRoot";
    import TopicsExpansion1 from "../components/ui/lists/TopicsExpansion1";
    import ArticleList from "../components/article/ArticleList";
    import TopicNewRootForm from "../components/topic/TopicNewRootForm";
    // import TopicDialogMy1 from "../components/ui/dialogs/TopicDialogMy1";
    export default {
        name: "TopicsPage",
        components: {
            TopicNewRootForm,
            ArticleList,
            TopicsExpansion1,
            // TopicDialogMy1,
            TopicTreeRoot,
            // TopicsTree
        },
        data() {
            return{
                tree:[{
                    name:'Ddd'
                }],
                topicList: null,
                topicUrl:'http://localhost:9090/topic',
                selectedTopicId: null,
                currentTopic: []
            }
        },
        methods: {
            loadMainTopicList(){
                axios.get(this.topicUrl)
                .then(res=>{
                    this.topicList=res.data;
                    console.log(this.topicList)
                })
            },
            getdata(item){
                // alert('TopicPage getdata')
                this.currentTopic=item
                console.log('CurrentTopic')
                console.log(this.currentTopic)
            }

        },
        created() {
            this.loadMainTopicList()
        }
    }
</script>

<style scoped>
.dialogwrap{
    border: 1px solid
}
</style>