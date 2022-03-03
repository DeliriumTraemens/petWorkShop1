<template>
    <div class="mb-4">
        <h1>TemaTreeRoot</h1>

            <TemaBrowser
                    :nodea="node" />
    </div>
</template>

<script>
    // import axios from "axios";
    import TemaBrowser from "./TemaBrowser";

    export default {
        name: "TemaTreeRoot",
        components: {TemaBrowser},
        props:{
            node:[]
        },
        data(){
            return{
                expanded: false,
            }
        },
        mounted() {
        },
        methods:{
            // async setTema(){
            //     await axios.get('http://localhost:9090/tema')
            //         .then(res=>{
            //             this.temas=res.data
            //             console.log(res.data)
            //             console.log(this.topics)
            //         })
            // },

            nodeClicked(node){
                this.expanded = !this.expanded
                this.setSelectedTopic(node)
            }
        },
    }
</script>

<style scoped>
    .lay1{
        background-color: #f8eee7;
        max-height:30px;
        padding-left:0.5em;
    }
</style>