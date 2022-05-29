<template>
  <v-expansion-panels>
    <v-expansion-panel>
      <v-expansion-panel-header>
        <strong>Topic List</strong>
      </v-expansion-panel-header>
      <v-expansion-panel-content>
        <TopicTreeRoot
          :items="items"
          @sendup="sendup"
          @updateTopicList="updateTopicList"
        />
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
    import TopicTreeRoot from "../trees/TopicTreeRoot";
    export default {
        name: "TopicsExpansion1",
        components: {TopicTreeRoot},
        props: {
            items: []
        },
        methods: {
            sendup(item){
                this.$emit('sendup', item)
            },
           async updateTopicList(){
                this.$emit('updateTopicList')
            }
        }
    }
</script>

<style scoped>

</style>