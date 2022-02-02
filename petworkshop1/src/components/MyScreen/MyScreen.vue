<template>
    <v-container>
        <h2 style="margin-bottom: 3rem">My Screen Page</h2>

    <div>
<!--        <ExpList :topics="topicList"/>-->
        <TopicList :topicList="topicList"/>
    </div>


    </v-container>
</template>

<script>
    // import ExpList from "../uicomponents/ExpList.vue";
    import axios from 'axios'
    import TopicList from "../uicomponents/TopicList.vue";

    export default {
        name: "MyScreen",
        components: {
            // ExpList
            TopicList
        },
        data() {
            return{
                topicList:[],
                topName:'',
                topDescription:'',
                categoryUrl: 'http://localhost:9090/topic',

            }
        },

        mounted() {
            axios.get(this.categoryUrl).then(res =>{
                console.log(res.data);
                this.topicList.push(...res.data)
            })
        }
    }
</script>

<style scoped>

</style>