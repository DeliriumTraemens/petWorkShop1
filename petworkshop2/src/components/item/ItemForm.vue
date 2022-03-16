<template>
    <div class="itemForm1">
        <h1>ItemForm</h1>
        <h3>{{getSelectedTema.name}}</h3>
        <v-text-field label="Input Name" v-model="item.name" />
        <v-textarea label="Input Description" v-model="item.description" />
        <v-file-input label="Input picture" v-model="item.selectedFile" />
        <v-btn @click="submitNewItem" >Submit</v-btn>
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