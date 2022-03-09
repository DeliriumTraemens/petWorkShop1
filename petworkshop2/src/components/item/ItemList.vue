<template>
    <div>
        <h2>Items List</h2>
        <div v-for="item in getSelectedTema.items" :key="item.name">
            <v-card>
                <v-card-title>
                    {{item.name}}
                    <v-card-text>
                        <v-img width="200px"
                        :src="'http://localhost:9090/pictures/'+item.image"
                        ></v-img>
                    </v-card-text>
                    <v-card-actions>
                        <v-btn x-small color="warning"> Details</v-btn>
                    </v-card-actions>

                </v-card-title>
            </v-card>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex';
    export default {
        name: "ItemList",
        data() {
            return{
                items: this.$store.getters.getSelectedTema
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