<template>
        <v-treeview
                dense
                :items="items"
        ></v-treeview>
</template>

<script>
    export default {
        props:{
            items:[{}]
        },
        data: () => ({
            items: [{}],
        }),
        methods:{
                updateList(){
                        return this.items= this.props.items;
                }
        },
        created(){
                this.updateList()
        }


    }
</script>
<!--<script>-->
<!--    export default {-->
<!--        name: "TreeViewTopics"-->
<!--    }-->
<!--</script>-->


<style scoped>

</style>