<template>
    <v-row>
        <h2>Drop Train 2 2 aa</h2>
          <v-col>


            <div v-for="tema in topics" :key="tema.name" class="topicOuter mb-2">
                <div
                        draggable="true"
                        @dragover.prevent
                        @dragenter.prevent
                        @dragstart="startDrag1(tema)"
                        @drop="onDrop1(tema)"
                > {{tema.name}}
                    <AddSubTemaDialog :temaData="tema"/>

                    <div  v-if="tema.children">
                        <div class="topicOuter mb-2" v-for="child in tema.children" :key="child.name">
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
        </v-col>
        <v-col>
            <TemaForm />

              <hr class="my-4">

            <TemaBrowser2
                    v-for="nodes in topics" :key="nodes.id"
                    :nodes="nodes" />
        </v-col>
        <hr class="mb-3">

    </v-row>
</template>

<script>
    import axios from 'axios'
    import {mapGetters} from 'vuex'
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
            ...mapGetters(['getTopicsTotalList', 'getSelectedTopic']),
        },
        mounted(){
            // this.setTopics();
            this.setTema()
            },
        methods:{
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
                // ev.dataTransfer.dropEffect = 'move'
                // ev.dataTransfer.effectAllowed ='move'
                // ev.dataTransfer.setData('temaname', tema.name)
                // ev.dataTransfer.setData('temaid', tema.id)
                this.draggedTopic = tema
                // console.log('dragged'+tema.name)
            },
            onDrop1(tema){
                this.droppedTopic=tema
                // const dropData = ev.dataTransfer.getData('temaname')
                // console.log('dropped')
                // console.log('from '+ dropData + ' to ' +tema.name)
            }
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