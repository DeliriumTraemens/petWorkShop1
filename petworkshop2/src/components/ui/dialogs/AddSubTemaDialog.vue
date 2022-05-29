<template>
  <div>
    <div class="pt-0.5">
      <v-btn
        icon
        color="indigo"
        @click.stop="dialog = true"
      >
        <v-icon
          small
          dark
        >
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
          AddSubTemaDialog {{ temaData.name }}
        </v-card-title>

        <v-card-text>
          <v-text-field
            v-model="newSubTema.name"
            label="Name"
          />
          <v-text-field
            v-model="newSubTema.description"
            label="Description"
          />
          Lorem ipsum.
        </v-card-text>

        <v-card-actions>
          <v-spacer />

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
    import axios from 'axios'
    import {mapActions} from 'vuex';
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
                    url: 'http://localhost:9090/tema/newSubTema'
                },
            }
        },
        methods:{
            ...mapActions(['setTemaTotal']),
          async  createSubTema(){
                const fd = new FormData();
                fd.append('idParent', this.newSubTema.parentId)
                fd.append('name', this.newSubTema.name)
                fd.append('description', this.newSubTema.description)
               await axios.post(this.newSubTema.url, fd)
                                        .then(res=>{
                                            console.log(res.data);
                                        })
                this.dialog = false
              await this.$store.dispatch('setTemaTotal')
            }
        },
    }
</script>

<style scoped>

</style>