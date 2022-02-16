<template>
    <div >
        <!--Container form node Element-->
        <div class="node"
             :style="{'margin-left': `${depth * 15}px`}"
             @click="nodeClicked(node)">
<!--            <span v-if="hasChildren" class="type">-->
            <span v-if="node.children.length>0" class="type" style="font-size:10px; color: darkorange">
                {{ expanded ? '&#9660;' : '&#9658;'}}
            </span>
            <span v-else style="font-size:10px; color: mediumblue"> &#9671; </span>
                {{node.name}} {{depth}}
        </div>
        <!--Container form recursion Traverse-->
        <div v-if="expanded">
            <TreeBrowser
                    v-for="(child, i) in node.children" :key="i"
                    :node="child"
                    :depth="depth + 1"
            />
        </div>


    </div>
</template>

<script>
    import {mapActions} from 'vuex';
    export default {
        name: "TreeBrowser",
        props: {
            node: Object,
            depth: {
                type:Number,
                default:0
            }
        },
        data() {
            return{
                expanded: false
            }
        },
        methods: {
            ...mapActions(['updateTopicList','setSelectedTopic' ,'incrementSelectedId', 'setSelectedTopicId']),
            nodeClicked(node) {
                this.expanded = !this.expanded
                this.setSelectedTopic(node)
            }
        },
        computed: {
            hasChildren(){
                return this.node.children;
            }
        },
    }
</script>

<style scoped>
.node{
    text-align: left;
    font-size: 18px


}
</style>