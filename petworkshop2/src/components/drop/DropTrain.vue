<template>
  <div>
    <!--        <div class='drop-zone' @drop="onDrop($event, 1)"-->
    <!--             @dragover.prevent-->
    <!--             @dragenter.prevent>-->
    <!--            <div v-for='item in listOne' :key='item.title'-->
    <!--                 class='drag-el' draggable-->
    <!--                 @dragstart="startDrag($event, item)">-->
    <!--                {{ item.title }}-->
    <!--            </div>-->
    <!--        </div>-->
    <!--        <div class='drop-zone' @drop="onDrop($event, 2)"-->
    <!--             @dragover.prevent-->
    <!--             @dragenter.prevent>-->
    <!--            <div v-for='item in listTwo' :key='item.title' class='drag-el'-->
    <!--                 draggable-->

    <!--                 @dragstart="startDrag($event, item)" >-->
    <!--                {{ item.title }}-->
    <!--            </div>-->
    <!--        </div>-->
    <hr>
    <div>
      <div
        v-for="tema in topics"
        :key="tema.name"
        class="topicOuter"
        draggable="true"
        @onDrop="onDrop1($event)"
      >
        <div
          draggable="true"
          @dragover.prevent
          @dragenter.prevent
          @dragstart="startDrag1($event, tema)"
        >
          {{ tema.name }} # {{ tema.id }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: "DropTrain",
        data () {
            return {
                // items: [
                //     {
                //         id: 0,
                //         title: 'Item A',
                //         list: 1
                //     },
                //     {
                //         id: 1,
                //         title: 'Item B',
                //         list: 1
                //     },
                //     {
                //         id: 2,
                //         title: 'Item C',
                //         list: 2
                //     },
                //     {
                //         id: 3,
                //         title: 'Item D',
                //         list: 2
                //     }
                //
                //     ],
                topics:[]
            }
        },


        computed: {
            ...mapGetters(['getTopicsTotalList', 'getSelectedTopic']),
            listOne () {
                return this.items.filter(item => item.list === 1)
            },
            listTwo () {
                return this.items.filter(item => item.list === 2)
            }
        },
        created() {
            this.setTopics()
        },
        methods: {
            startDrag1(evt, tema){
                // alert('FFF')
                evt.dataTransfer.dropEffect = 'move'
                evt.dataTransfer.effectAllowed ='move'
                evt.dataTransfer.setData('temaname', tema.name)
                evt.dataTransfer.setData('temaid', tema.id)
                // const dtr = evt.dataTransfer.getData('tema')
                console.log(evt.dataTransfer.getData('temaid'))
                console.log(evt.dataTransfer.getData('temaname'))
                // evt.dataTransfer.setData('itemTitle', item.title)

            },
            onDrop1 (evt) {
                // const topicParentId = evt.dataTransfer.getData('temaid')
                // const topicParentName = evt.dataTransfer.getData('temaname')
                // const item = this.items.find(item => item.id == itemID)
                // item.list = list
                console.log(evt)
                alert('FFF')
            },
            // startDrag(evt, item){
            //     // alert('FFF')
            //     evt.dataTransfer.dropEffect = 'move'
            //     evt.dataTransfer.effectAllowed ='move'
            //     evt.dataTransfer.setData('itemId', item.id)
            //     evt.dataTransfer.setData('itemTitle', item.title)
            //
            // },
            // onDrop (evt, list) {
            //     const itemID = evt.dataTransfer.getData('itemID')
            //     const item = this.items.find(item => item.id == itemID)
            //     item.list = list
            //     // console.log(evt.dataTransfer.getData('itemTitle'))
            // },
            setTopics(){
                return this.topics=this.getTopicsTotalList
            }

        }
    }
</script>

<style scoped>
    .drop-zone {
        background-color: #eee;
        margin-bottom: 10px;
        padding: 10px;
    }

    .drag-el {
        background-color: #fff;
        margin-bottom: 10px;
        padding: 5px;
    }

    .topicOuter{
        padding: 5px;
        border: 1px solid sandybrown;
    }

</style>