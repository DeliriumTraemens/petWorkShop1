<template>
        <div class="mytree1">
            <v-layout justify-space-between>
                <div @click="showItem(items)" >{{items.name}}

                </div>

                <v-layout align-start justify-end>
                    <TopicDialogMy1 :topicData="items" @updateTopicList="updateTopicList"/>

                    <v-btn icon>
                        <v-icon small dark>mdi-minus</v-icon>
                    </v-btn>

                    <v-btn icon>
                        <v-icon small dark>mdi-pencil</v-icon>
                    </v-btn>
                </v-layout>


            </v-layout>

            <div class="ml-4" v-if="items.children" >
                <div >

                    <TopicTreeMy1 v-for="item in items.children" :key="item.id"
                                  :items="item"
                                  :class="{isActive}"
                                  @showItem="showItem"/>
                </div>
            </div>
        </div>
</template>

<script>
    import TopicDialogMy1 from "../dialogs/TopicDialogMy1";
    export default {
        name: "TopicTreeMy1",
        components: {TopicDialogMy1},
        props: {
            items: []
        },
        data() {
            return{
                isActive:true

            }
        },
        methods: {
            showItem(items){
                // alert('TopicTreeMy1')
                // alert(items.name)
                this.isActive=false;
                this.$emit("showItem",items)
            },
            collapse(){
                this.isActive=false;

            },
          async  updateTopicList(){
                this.$emit("updateTopicList")
            }
        },
        created () {
            console.log('Tree Items')
            console.log(this.items)
        }
    }
</script>

<style scoped>
.mytree1{
    /*background-color:honeydew;*/
    border-top:1px solid;
    height:50%;
    text-vertical-align: center;
}

.isActive{
    display: none;
}

</style>