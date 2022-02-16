<template>
        <div class="mytree1">
            <v-layout justify-space-between>
                <div @click="itemClicked(items)" >
                    <span v-if="items.children.length>0" style="font-size:10px; color: darkorange">{{ expanded ? '&#9660;' : '&#9658;'}}</span>
                    <span v-else style="font-size:10px; color: mediumblue"> &#9671; </span>
                        {{items.name}}
                </div>

                <v-layout align-start justify-end>
                    <TopicDialogMy1 :topicData="items" />

                    <v-btn icon>
                        <v-icon small dark>mdi-minus</v-icon>
                    </v-btn>

                    <TopicEdit1 :topicData="items"/>

<!--                    <v-btn icon @click="editTopic">-->
<!--                        <v-icon small dark>mdi-pencil</v-icon>-->
<!--                    </v-btn>-->
                </v-layout>


            </v-layout>

            <div class="ml-4" v-if="expanded">

                    <TopicTreeMy1 v-for="item in items.children" :key="item.name"
                                  :items="item"/>
                </div>
        </div>
</template>

<script>
    import TopicDialogMy1 from "../dialogs/TopicDialogMy1";
    import {mapActions} from 'vuex';
    import {mapGetters} from 'vuex';
    import TopicEdit1 from "../dialogs/TopicEdit1";
    export default {
        name: "TopicTreeMy1",
        components: {TopicEdit1, TopicDialogMy1},
        props: {
            items: []
        },
        data() {
            return{
                isActive:true,
                expanded: false

            }
        },
        computed: {
            ...mapGetters(['getSelectedTopic'])
        },
        methods: {
            ...mapActions(['setSelectedTopic']),
            itemClicked(items){
                this.expanded=!this.expanded
                this.setSelectedTopic(items)
                this.$emit("showItem",items)
            },
            editTopic(){

            },
            showItem(items){
                // alert('TopicTreeMy1')
                // alert(items.name)
                // this.isActive=false;
                // this.expanded=!this.expanded
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