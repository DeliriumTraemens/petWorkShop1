<template>
        <div class="mytree1">
            <v-layout justify-space-between>
                <div @click="showItem(items)">{{items.name}}</div>

                <v-layout align-start justify-end>
                    <TopicDialogMy1/>

                    <v-btn icon>
                        <v-icon small dark>mdi-minus</v-icon>
                    </v-btn>

                    <v-btn icon>
                        <v-icon small dark>mdi-pencil</v-icon>
                    </v-btn>
                </v-layout>


            </v-layout>

            <div class="ml-4" v-if="items.children" >
                    <TopicTreeMy1 v-for="item in items.children" :key="item.id"
                                  :items="item"
                                    @showItem="showItem"/>
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
        methods: {
            showItem(items){
                alert(items)
                this.$emit("showItem",items)
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
</style>