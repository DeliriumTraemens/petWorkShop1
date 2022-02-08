<template>
    <v-container>
        <v-row>
            <v-col cols="4">
                <h3>Topics</h3>
                <hr>
                <TopicTreeRoot :items="topicList" />
                <hr>
<!--                <TopicsTree :impData="topicList"/>-->
            </v-col>
            <v-col>
                <div>
                <v-row>
                    <v-col cols="12"> <H2>Col 2</H2>
                        <TopicsExpansion1 :items="topicList"  @sendup="getdata"/>
                    </v-col>
                </v-row>
                </div>
            </v-col>
            <v-col>
<!--                <v-card>-->
<!--                    <v-card-title>-->
<!--                        {{currentTopic.name}}-->
<!--                    </v-card-title>-->
<!--                    <v-card-text>-->
<!--                        {{currentTopic}}-->
<!--                    </v-card-text>-->
<!--                </v-card>-->
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import axios from 'axios'
    // import TopicsTree from "../components/ui/trees/TopicsTree";
    import TopicTreeRoot from "../components/ui/trees/TopicTreeRoot";
    import TopicsExpansion1 from "../components/ui/lists/TopicsExpansion1";
    // import TopicDialogMy1 from "../components/ui/dialogs/TopicDialogMy1";
    export default {
        name: "TopicsPage",
        components: {
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
                currentTopic: null
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
                this.currentTopic=item
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