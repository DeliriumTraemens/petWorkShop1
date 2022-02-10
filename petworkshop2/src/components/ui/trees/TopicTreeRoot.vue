<template>
    <v-container>
        <TopicTreeMy1 v-for="(item,i) in items" :key="i"
                      :items="item"
                      @showItem="sendup"
                      @updateTopicList="updateTopicList"
        />
    </v-container>
</template>

<script>
    import TopicTreeMy1 from "./TopicTreeMy1";
    export default {
        name: "TopicTreeRoot",
        components: {
            TopicTreeMy1
        },
        props: {
            items: []
        },
        methods: {
            sendup(item){
                // alert('TopicTreeRoot method sendup'+item.name)
                console.log(item)
                this.$emit('sendup', item)
            },
            async updateTopicList(){
                this.$emit('updateTopicList')
            }
        }
    }
</script>

<style scoped>

</style>