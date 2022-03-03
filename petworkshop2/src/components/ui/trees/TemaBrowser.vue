<template>
    <div class="node ml-2">
        <h2>Tema browser</h2>
        <div >
            {{nodes.children}}
        </div>

    </div>
</template>

<script>
    export default {
        name: "TemaBrowser",
        props: {
            nodes: [],
            depth: {
                type: Number,
                default: 0
            }
        },
        data() {
            return {
                expanded: false,
                items: this.nodea
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