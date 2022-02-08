<template>
    <v-container>
        <template>
            <v-expansion-panels>
                <v-expansion-panel
                        v-for="(item,i) in topics"
                        :key="i"
                >
                    <v-expansion-panel-header>
                        {{item.name}}
                    </v-expansion-panel-header>
                    <v-expansion-panel-content>
                        <div v-if="item.children" >
                            <div v-for="(child,i) in item.children" :key="i">
                                <div>{{child.name}}</div>
                                <ExpList :items="child"/>
                            </div>
                        <DialogNewTopic :dataItem="item"/>
                        </div>

                    </v-expansion-panel-content>
                </v-expansion-panel>
            </v-expansion-panels>
        </template>
    </v-container>
</template>

<script>

    // import DialogNewTopic from "./DialogNewTopic.vue";

    import DialogNewTopic from "./DialogNewTopic.vue";
    export default {
        name: "ExpList",
        props:{
            topics:[]
        },
        components: {
            DialogNewTopic
        },
        data() {
            return{
                topicName:''
            }
        }
    }
</script>

<style scoped>

</style>