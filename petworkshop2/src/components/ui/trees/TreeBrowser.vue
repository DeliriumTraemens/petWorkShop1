<template>
    <div class="node" >
        <!--Container form node Element-->
        <v-layout class="lay1" justify-space-between @click="nodeClicked(node)">
            <div  >
                <!--            <span v-if="hasChildren" class="type">-->

                    <span v-if="node.children.length>0" class="type" style="font-size:10px; color: darkorange">
                            {{ expanded ? '&#9660;' : '&#9658;'}}
                    </span>
                    <span v-else style="font-size:10px; color: mediumblue"> &#9671; </span>
                    {{node.name}} {{depth}}
            </div>
            <v-layout align-start justify-end>
                <TopicDialogMy1 :topicData="node"/>
                <TopicEdit1 :topicData="node"/>
                <v-btn icon>
                    <v-icon small dark>mdi-minus</v-icon>
                </v-btn>

            </v-layout>


        </v-layout>
        <!--Container form recursion Traverse-->
        <div v-if="expanded" class="ml-3">
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
    import TopicEdit1 from "../dialogs/TopicEdit1";
    import TopicDialogMy1 from "../dialogs/TopicDialogMy1";

    export default {
        name: "TreeBrowser",
        components: {TopicEdit1, TopicDialogMy1},
        props: {
            node: Object,
            depth: {
                type: Number,
                default: 0
            }
        },
        data() {
            return {
                expanded: false
            }
        },
        methods: {
            ...mapActions(['updateTopicList', 'setSelectedTopic', 'incrementSelectedId', 'setSelectedTopicId']),
            nodeClicked(node) {
                this.expanded = !this.expanded
                this.setSelectedTopic(node)
            }
        },
        computed: {
            hasChildren() {
                return this.node.children;
            }
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

    .span-wrap {
        border: 1px solid;
        margin-left: 1px;
    }
</style>