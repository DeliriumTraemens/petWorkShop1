<template>
    <div>
        <h1>Topics</h1>
        <v-row>
            <v-col cols="4">
                <h2>Col1 </h2>

                <TopicsExpansion1 :items="getTopicsTotalList"  />
                <hr>
                <div>TopicTreeRoot</div>
                <hr class="mb-3">
                <v-card v-scroll="onScroll"
                        class="overflow-y-auto"
                        max-height="200">

                </v-card>
                    <TopicTreeRoot :items="getTopicsTotalList"  />

                <hr>
                <div class="mt-3">TopicNewRootForm</div>
                <TopicNewRootForm />
                <div class="cont"></div>
            </v-col>
            <v-col cols="6">
                <div>
                <v-row>
                    <v-col cols="12"> <H2>Col 2</H2>
                        <hr>
<!--                        <TopicCard1 :data="currentTopic"/>-->
                        <TopicCard1 :data="getSelectedTopic"/>
                        <!--ArticlesList-->
                        <ArticleList
                                :name="getSelectedTopic.name"
                                :topicID="getSelectedTopic.id"
                                :articlesList="getSelectedTopic.articleSet"/>
                    </v-col>
                </v-row>
                </div>
            </v-col>
            <v-col> <H2>Col 3</H2>
                <div class="mb-4">Topics 2</div>
                <hr class="mb-4">
                <div class="ed1" contenteditable="true"></div>


            </v-col>
        </v-row>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex'
    import axios from 'axios'
    // import TopicsTree from "../components/ui/trees/TopicsTree";
    import TopicTreeRoot from "../components/ui/trees/TopicTreeRoot";
    import TopicsExpansion1 from "../components/ui/lists/TopicsExpansion1";
    import ArticleList from "../components/article/ArticleList";
    import TopicNewRootForm from "../components/topic/TopicNewRootForm";
    import TopicCard1 from "../components/ui/cards/TopicCard1";
    // import TopicDialogMy1 from "../components/ui/dialogs/TopicDialogMy1";
    export default {
        name: "TopicsPage",
        components: {
            TopicCard1,
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
        // computed: {
        //     getTotalTopics(){
        //         return this.$store.getters.getTopicsTotalList
        //     }
        // },
        computed: mapGetters(['getTopicsTotalList', 'getSelectedTopic']),
        methods: {


            updateTopicList(){
                axios.get(this.topicUrl)
                    .then(res=>{
                        this.topicList=[]
                        this.topicList=res.data;
                        console.log(this.topicList)
                    })
            }

        },
         async mounted() {

            await this.$store.dispatch('updateTopicList')
        }
    }
</script>

<style scoped>
.dialogwrap{
    border: 1px solid
}
.cont{
    margin-top: 20px;
    padding: 20px;
    background-color: darkorange;
}
.ed1{
    min-height: 450px;
    border: 1px solid;
    margin-left: 10px;
}
</style>