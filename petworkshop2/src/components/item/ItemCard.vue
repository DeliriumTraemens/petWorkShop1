<template>
  <v-card class="my-3">
    <v-card-title>
      {{ item.name }}
    </v-card-title>
    <v-card-subtitle>
      <strong>Item Id: {{ item.id }}</strong>
    </v-card-subtitle>
    <v-img
      width="200px"
      :src="'http://localhost:9090/pictures/'+item.image"
    />
    <v-card-text>
      {{ item.description }}
    </v-card-text>
    <v-card-actions>
      <v-btn
        x-small
        color="warning"
      >
        Details
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
    export default {
        name: "ItemCard",
        props: {
            item: {}
        }
    }
</script>

<style scoped>

</style>