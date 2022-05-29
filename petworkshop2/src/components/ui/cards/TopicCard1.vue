<template>
  <v-card>
    <v-card-title>
      <h4>TopicCard1 — </h4>
      <h3>{{ data.name }}</h3>
    </v-card-title>
    <v-card-subtitle><strong>{{ data.name }} Id#{{ data.id }}</strong> </v-card-subtitle>
    <v-card-text>{{ data.description }} Description</v-card-text>
  </v-card>
</template>

<script>
    export default {
        name: "TopicCard1",
        props: {
            data: []
        }
    }
</script>

<style scoped>

</style>