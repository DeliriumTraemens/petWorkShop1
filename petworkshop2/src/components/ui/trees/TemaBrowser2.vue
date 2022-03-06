<template>
    <div class="node">
        <v-layout class="lay1" justify-space-between @click="nodeClicked(nodes)" >

            <div draggable="true"
                 @dragover.prevent
                 @dragenter.prevent
                 @dragstart="startDrag2(nodes)"
                 @drop="onDrop2(nodes)" >
                <span v-if="nodes.children.length>0" class="type" style="font-size:10px; color: darkorange">
                                {{ expanded ? '&#9660;' : '&#9658;'}}
                        </span>
                <span v-else style="font-size:10px; color: mediumblue"> &#9671; </span>
                {{nodes.name}}
            </div>

                <v-layout align-start justify-end >
<!--                    <v-btn x-small icon @click="pressed">-->
<!--                        <v-icon small dark>-->
<!--                            mdi-plus-->
<!--                        </v-icon>-->
<!--                    </v-btn>-->
                    <AddSubTemaDialog :temaData="nodes"/>
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
    import {mapGetters, mapActions} from 'vuex';
    import AddSubTemaDialog from "../dialogs/AddSubTemaDialog";
    export default {
        name: "TemaBrowser2",
        components: {AddSubTemaDialog},
        props:{
            nodes: Object,
            depth: {
                type: Number,
                default: 0
            }
        },
        computed: {
            ...mapGetters(['getTemaTotal'])
        },
        data(){
            return{
                expanded: false
            }
        },
        mounted() {

        },

        methods: {
            ...mapActions(['setTemaDragged', 'setTemaDropped','updateDraggedTema']),

            nodeClicked(node){
                this.expanded = !this.expanded
               console.log(node)
            },

            async startDrag2(nodes){
                await this.$store.dispatch('setTemaDragged',nodes)
            },

            async onDrop2(node){
                // await this.$store.dispatch('setTemaDropped', node)
                this.setTemaDropped(node)
                // await this.$store.dispatch('updateDraggedTema')
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
</style>