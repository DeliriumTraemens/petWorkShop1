<template>
    <v-row>
        <h2>Drop Train 2 2 aa</h2>
          <v-col>
              <TemaBrowser2
                      v-for="nodes in getTemaTotal" :key="nodes.id"
                      :nodes="nodes" />
              <hr class="my-4">

            <div v-for="tema in getTemaTotal" :key="tema.name" class="topicOuter mb-2">
                <div

                > {{tema.name}}
                    <AddSubTemaDialog :temaData="tema"/>

                    <div  v-if="tema.children">
                        <div class="topicOuter mb-2" v-for="child in tema.children" :key="child.id"
                             draggable="true"
                             @dragover.prevent
                             @dragenter.prevent
                             @dragstart="startDrag2(child)"
                             @drop="onDrop2(child)"
                        >
                            <div>
                                {{child.name}}
                                <AddSubTemaDialog :temaData="child"/>
                            </div>
                            </div>
                    </div>
                </div>
            </div>
        </v-col>
        <v-col>
            <v-card class="mb-3">
                <v-card-title> Initial topic</v-card-title>
                <v-card-text>
                    {{draggedTopic.name}}
                </v-card-text>
            </v-card>
            <v-card>
                <v-card-title>Target Topic</v-card-title>
                <v-card-text>
                    {{droppedTopic.name}}
                </v-card-text>
            </v-card>
            <hr class="my-5">

            <v-card class="mb-3">
                <v-card-title> Initial browser topic</v-card-title>
                <v-card-text>
                    {{getTemaDragged.name}}
                </v-card-text>
            </v-card>
            <v-card>
                <v-card-title>Target browser Topic</v-card-title>
                <v-card-text>
                    {{getTemaDropped.name}}
                </v-card-text>
            </v-card>

        </v-col>
        <v-col>
            <TemaForm />

              <hr class="my-4">


        </v-col>
        <hr class="mb-3">

    </v-row>
</template>

<script>
    import axios from 'axios'
    import {mapGetters, mapActions} from 'vuex'
    import TemaForm from "../tema/TemaForm";
    import AddSubTemaDialog from "../ui/dialogs/AddSubTemaDialog";
    import TemaBrowser2 from "../ui/trees/TemaBrowser2";

    export default {

        name: "DropTrain2",
        components: {TemaBrowser2, AddSubTemaDialog, TemaForm},
        data() {
            return {
                topics: [],
                draggedTopic:[],
                droppedTopic:[],

            }
        },
        computed:{
            ...mapGetters(['getTopicsTotalList', 'getSelectedTopic', 'getTemaTotal','getTemaDragged','getTemaDropped']),
        },
      async  mounted(){
            // this.setTopics();
          await this.$store.dispatch('setTemaTotal')

            },
        methods:{
            ...mapActions(['setTemaTotal']),
            async setTema(){
                await axios.get('http://localhost:9090/tema')
                .then(res=>{
                    this.topics=res.data
                    console.log(res.data)
                    console.log(this.topics)
                })
            },

            createSubTema(tema){
                alert('Pressed'+tema.id)
            },


            startDrag1(tema){
                this.draggedTopic = tema
                console.log('dragged'+tema.name)
            },
            startDrag2(tema){
                this.draggedTopic = tema
                console.log('dragged'+tema.name)
            },


            onDrop1(tema){
                this.droppedTopic=tema
            },
            onDrop2(tema){
                this.droppedTopic=tema
            },

        }

    }
</script>

<style scoped>
.topicOuter{
        margin-left: 10px;
        padding: 5px;
        border: 1px solid sandybrown;
    }

</style>