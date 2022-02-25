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
                > {{tema.name}} </div>
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
        <v-col></v-col>
        <hr class="mb-3">

    </v-row>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: "DropTrain2",
        data() {
            return {
                topics: [],
                draggedTopic:[],
                droppedTopic:[],
                topics2: [
                    {
                        id: 1,
                        name: 'First',
                        parent:0
                    },
                    {
                        id: 2,
                        name: 'Second',
                        parent:0
                    },
                    {
                        id: 3,
                        name: 'Third',
                        parent:0
                    },
                    {
                        id: 4,
                        name: 'First a',
                        parent:1
                    },
                    {
                        id: 5,
                        name: 'Second a',
                        parent:2
                    },
                    {
                        id: 6,
                        name: 'Third a',
                        parent:2
                    },

                ]
            }
        },
        computed:{
            ...mapGetters(['getTopicsTotalList', 'getSelectedTopic']),
        },
        mounted(){
            this.setTopics();
            },
        methods:{
            setTopics(){
                return this.topics=this.getTopicsTotalList
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
        padding: 5px;
        border: 1px solid sandybrown;
    }

</style>