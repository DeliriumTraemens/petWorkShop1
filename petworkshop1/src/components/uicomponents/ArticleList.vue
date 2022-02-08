<template>
    <v-container>
        <h3>{{topicid}}</h3>
<!--        <ArticleInputForm :dataItem="topicid"/>-->
    <div class="myform1">
        <h4>Article Input Form</h4>
        <div>
            <v-text-field label="Name" v-model="articleName"/>
            <v-textarea label="Text" v-model="articleText"/>
        </div>
        <v-btn @click="createArticle(topicid)">Add</v-btn>

    </div>
                <h3>Topic # {{topicid}}</h3>
        <div v-for="(article,i) in articles" :key="i">
            <ArticleCard :article="article"/>
<!--                <v-card class="crd1">-->
<!--                    <v-card-title>-->
<!--                        {{article.name}}-->
<!--                    </v-card-title>-->
<!--                    <v-card-subtitle>-->
<!--                        <p>Id # {{article.id}}</p>-->
<!--                    </v-card-subtitle>-->
<!--                    <v-card-text v-html="article.description">-->
<!--&lt;!&ndash;                        {{article.description}}&ndash;&gt;-->
<!--                    </v-card-text>-->
<!--                </v-card>-->

        </div>
    </v-container>
</template>

<script>
    import axios from 'axios'
    import ArticleCard from "./ArticleCard.vue";
    // import ArticleInputForm from "./ArticleInputForm.vue";
    export default {
        name: "ArticleList",
        components: {ArticleCard},
        // components: {ArticleInputForm},
        props:{
            articles: {
                type: Object[{}]            },
            topicid: {
                type:Number
            }
        },
        data(){
            return {
                articleName:'',
                articleText:'',
                articleUrl:'http://localhost:9090/article',
            }
        },
        methods:{
            createArticle(id){
                const fd = new FormData();
                fd.append('id',id)
                fd.append('name', this.articleName)
                fd.append('text', this.articleText)
                axios.post(this.articleUrl, fd).then(res=>{
                    console.log(res.data);
                })
                this.articleName=''
                this.articleDescription=''
            }
        },
    }
</script>

<style scoped>
.myform1{
    border: 1px solid;
    border-radius: 5px;
    padding: 2rem;
    margin-bottom: 2rem;

}
    .crd1{
    margin-bottom: 10px;
}
</style>