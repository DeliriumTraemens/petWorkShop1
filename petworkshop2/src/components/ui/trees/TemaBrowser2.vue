<template>
    <div class="node">
        <v-layout class="lay1" justify-space-between @click="nodeClicked(nodes)">

                <span v-if="nodes.children.length>0" class="type" style="font-size:10px; color: darkorange">
                                {{ expanded ? '&#9660;' : '&#9658;'}}
                        </span>
                <span v-else style="font-size:10px; color: mediumblue"> &#9671; </span>
                {{nodes.name}}

                <v-layout align-start justify-end>
                    <v-btn x-small icon @click="pressed">
                        <v-icon small dark>
                            mdi-plus
                        </v-icon>
                    </v-btn>
                </v-layout>
        </v-layout>


        <div v-if="expanded" class="ml-3">
            <TemaBrowser2
                    v-for="(child, indx) in nodes.children" :key="indx"
                    :nodes="child"
                    :depth="depth + 1"
            />
        </div>

    </div>
</template>

<script>
    export default {
        name: "TemaBrowser2",
        components: {},
        props:{
            nodes: Array,
            depth: {
                type: Number,
                default: 0
            }
        },
        data(){
            return{
                expanded: false
            }
        },
        mounted() {

        },

        methods: {
            pressed(){
                alert('pressed')
            },
            nodeClicked(node){
                this.expanded = !this.expanded
               console.log(node)

            },
        },
    }
</script>

<style scoped>
    .node {
        border-top: 1px solid;
        border-left: 3px solid;

        border-left-color: #0802aa;

        text-align: left;
        margin-top: 3px;
        font-size: 14px;
        /*max-height: 2em;*/
    }

    .lay1{
        background-color: #f8eee7;
        max-height:30px;
        padding-left:0.5em;
    }
</style>