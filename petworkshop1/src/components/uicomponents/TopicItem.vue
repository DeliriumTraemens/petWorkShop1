<template>
    <ul class="topitem">
<!--        <hr>-->
            <v-row >
                    <v-layout justify="space-between">
                <v-col>
                    <h5>{{item.name}}</h5>
                </v-col>
                <v-col >
                    <v-layout justify="right">
                        <v-btn x-small @click="showInfo(item.id)" color="primary">Show</v-btn>
                        <v-btn x-small color="orange">Edit</v-btn>
                        <DialogNewTopic :dataItem="item"/>
                    </v-layout>
                </v-col>
                    </v-layout>
            </v-row>
            <div v-if="item.children">
                <div v-for="child in item.children" :key="child.id">
                    <TopicItem :item="child" @showtopic="showInfo"/>
                </div>
            </div>
    </ul>
</template>

<script>

    import DialogNewTopic from "./DialogNewTopic.vue";
    export default {
        name: "TopicItem",
        components: {
            DialogNewTopic
        },
        props: {
            item:[]
        },
        methods: {
            showInfo(id){
                this.$emit("showtopic",id)
                // alert(item);
            }
        }
    }
</script>

<style scoped>
.topitem{
    /*margin-bottom: 2rem;*/
    margin-left: 1rem;
}
    .sp1{
        alignment: right;
        margin-left: 2rem;
    }
</style>