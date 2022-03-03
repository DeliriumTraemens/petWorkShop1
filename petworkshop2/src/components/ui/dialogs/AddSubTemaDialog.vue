<template>
    <div>

        <div class="pt-0.5">
            <v-btn icon
                   color="indigo"
                   @click.stop="dialog = true">
                <v-icon small dark>
                    mdi-plus
                </v-icon>
            </v-btn>
        </div>

        <v-dialog
                v-model="dialog"
                max-width="390"
        >
            <v-card>
                <v-card-title class="text-h5">
                    AddSubTemaDialog {{temaData.name}}
                </v-card-title>

                <v-card-text>
                    <v-text-field label="Name" v-model="newSubTema.name"></v-text-field>
                    <v-text-field label="Description" v-model="newSubTema.description"></v-text-field>
                    Lorem ipsum.
                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn
                            color="warning"
                            text
                            @click="dialog = false"
                    >
                        Cancel
                    </v-btn>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="createSubTema()"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    export default {
        name: "AddSubTemaDialog",
        props:{
            temaData: []
        },
        data(){
            return{
                dialog: false,
                newSubTema:{
                    parentId: this.temaData.id,
                    name:'',
                    description:'',
                    url: 'http://localhost:9090/topic/newsub'
                },
            }
        },
        methods:{
            createSubTema(){

            }
        },
    }
</script>

<style scoped>

</style>