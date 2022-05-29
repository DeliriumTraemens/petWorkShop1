<template>
  <div class="itemForm1">
    <h1>ItemForm</h1>
    <h3>{{ getSelectedTema.name }}</h3>
    <v-text-field
      v-model="item.name"
      label="Input Name"
    />
    <v-textarea
      v-model="item.description"
      label="Input Description"
    />
    <v-file-input
      v-model="item.selectedFile"
      label="Input picture"
    />
    <v-btn @click="submitNewItem">
      Submit
    </v-btn>
  </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex';
    export default {
        name: "ItemForm",
        data() {
            return{
                item:{
                    temaId:'',
                    name: '',
                    description: '',
                    selectedFile: null,
                }

            }
        },
        computed: {
            ...mapGetters(['getSelectedTema'])
        },
        methods: {
            ...mapActions(['createNewItem']),
            submitNewItem(){
                // this.item.temaId = this.getSelectedTema.name

                this.$store.dispatch('createNewItem', this.item)

                this.item.temaId =''
                this.item.name =''
                this.item.description =''
                this.item.selectedFile = null
            }


        }
    }
</script>

<style scoped>
    .itemForm1{
        padding: 10px;
        border: 1px solid;
        border-radius: 5px;
    }
</style>