<template>
  <div>
    <h1>Topics</h1>
    <v-row>
      <v-col cols="4">
        <h2>Col1 </h2>

        <TopicsExpansion1 :items="getTopicsTotalList" />
        <hr>
        <div>TopicTreeRoot</div>
        <hr class="mb-3">
        <v-card
          class="overflow-y-auto"
          max-height="200"
        >
          <TopicTreeRoot :items="getTopicsTotalList" />
        </v-card>

        <hr>
        <div class="mt-3">
          TopicNewRootForm
        </div>
        <TopicNewRootForm />
        <div class="cont" />
      </v-col>
      <v-col cols="5">
        <div>
          <v-row>
            <v-col cols="12">
              <H2>Col 2</H2>
              <hr>
              <hr class="mb-3">
              <!--                            <div>-->

              <!--                                <WisiwigEdit1 :innerdata="getSelectedTopic.name"/>-->
              <!--                                <hr>-->
              <!--                                <WisiwigEdit1Template/>-->
              <!--                                <hr>-->
              <!--                                <HtmlEditorWrap1 :data="getSelectedTopic.articleSet"/>-->
              <!--                            </div>-->
              <hr class="mb-3">
              <!--                        <TopicCard1 :data="currentTopic"/>-->
              <TopicCard1 :data="getSelectedTopic" />
              <!--ArticlesList-->
              <ArticleList
                :name="getSelectedTopic.name"
                :topic-i-d="getSelectedTopic.id"
                :articles-list="getSelectedTopic.articleSet"
              />
            </v-col>
          </v-row>
        </div>
      </v-col>
      <v-col>
        <H2>Col 3</H2>
        <div class="mb-4">
          Topics 2
        </div>
        <hr class="mb-4 mr-4">
        <div class="mr-3">
          <ScratchEditor />
        </div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
    import {mapGetters} from 'vuex'
    import axios from 'axios'
    // import TopicsTree from "../components/ui/trees/TopicsTree";
    import TopicTreeRoot from "../components/ui/trees/TopicTreeRoot";
    import TopicsExpansion1 from "../components/ui/lists/TopicsExpansion1";
    import ArticleList from "../components/article/ArticleList";
    import TopicNewRootForm from "../components/topic/TopicNewRootForm";
    import TopicCard1 from "../components/ui/cards/TopicCard1";
    import ScratchEditor from "../components/scratches/ScratchEditor";
    export default {
        name: "TopicsPage",
        components: {
            ScratchEditor,
            TopicCard1,
            TopicNewRootForm,
            ArticleList,
            TopicsExpansion1,
            TopicTreeRoot,
        },
        data() {
            return {
                tree: [{
                    name: 'Ddd'
                }],
                topicList: null,
                topicUrl: 'http://localhost:9090/topic',
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
        async mounted() {

            await this.$store.dispatch('updateTopicList')
        },
        methods: {
            updateTopicList() {
                axios.get(this.topicUrl)
                    .then(res => {
                        this.topicList = []
                        this.topicList = res.data;
                        console.log(this.topicList)
                    })
            }

        }
    }
</script>

<style scoped>
    .dialogwrap {
        border: 1px solid
    }

    .cont {
        margin-top: 20px;
        padding: 20px;
        background-color: darkorange;
    }


</style>