<!--suppress ALL -->
<template>
    <div class="mx-4">

    <v-card>
        <v-card-title>Create new Tema</v-card-title>
        <v-card-text>
            <v-text-field label="TemaName"  v-model="tema.name" ></v-text-field>
            <v-text-field label="TemaDescription" v-model="tema.description"></v-text-field>
        </v-card-text>
        <v-card-actions>
            <v-btn @click="addNewTema">Submit</v-btn>
        </v-card-actions>
    </v-card>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "TemaForm",
        data (){
            return{
                tema:{
                    name:'ddd',
                    description:'',
                    root:''
                }
            }
        },
        methods :{
            addNewTema(){
                const sd = new FormData();
                sd.append('name', this.tema.name)
                sd.append('description', this.tema.description)
                axios.post('http://localhost:9090/tema',sd)
                .then(resp=>{
                    console.log(resp.data.data)
                })
            }
        }
    }
</script>

<style scoped>

</style>