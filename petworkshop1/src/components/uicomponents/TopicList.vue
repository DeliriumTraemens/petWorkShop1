<template>
    <div >
        <TopicItem v-for="(item, i) in topicList" :key="i" :item="item"/>

        <hr>
        <hr class="mt-2">
        <ExpList :topics="topicList"/>
    </div>
</template>

<script>
    import TopicItem from "./TopicItem.vue";
    import ExpList from "./ExpList";

    export default {
        name: "TopicList",
        components: {
            ExpList,
          TopicItem
        },
        props: {
            topicList:[]
        },
    }
</script>

<style scoped>

</style>