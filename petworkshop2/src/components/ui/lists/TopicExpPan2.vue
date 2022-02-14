<template>
    <v-expansion-panels accordion>
        <v-expansion-panel>
            <v-expansion-panel-header @click="headerClick(data)">
                {{data.name}}
            </v-expansion-panel-header>
            <v-expansion-panel-content>
                <div v-if="data.children.length >0 ">
                    <TopicExpPan2 v-for="(child, i) in data.children" :key="i"
                                  :data="child"/>
                </div>
                <div>
                    <v-btn x-small color="warning" >Blah</v-btn>
                </div>
            </v-expansion-panel-content>
        </v-expansion-panel>
    </v-expansion-panels>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "TopicExpPan2",
        props: {
            data: []
        },
        computed: mapGetters(['getTopicsTotalList','getSelectedTopic' ,'getTopicsSelectedTopicId', 'getTopicsSelectedTopic']),
        methods: {
            ...mapActions(['updateTopicList', 'setSelectedTopic', 'incrementSelectedId', 'setSelectedTopicId']),
            headerClick(data) {
                console.log(data.name);
                this.setSelectedTopic(data)
            }
        }
    }
</script>

<style scoped>

</style>