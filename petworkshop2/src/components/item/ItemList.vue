<template>
  <div>
    <h2>Items List</h2>
    <div
      v-for="item in getSelectedTema.items"
      :key="item.name"
    >
      <ItemCard :item="item" />
    </div>
  </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex';
    import ItemCard from "./ItemCard";
    export default {
        name: "ItemList",
        components: {ItemCard},
        data() {
            return{
                // items: this.$store.getters.getSelectedTema
            }
        },
        computed: {
            ...mapGetters(['getSelectedTema'])
        },
        methods: {
            ...mapActions([])
        },
    }
</script>

<style scoped>

</style>