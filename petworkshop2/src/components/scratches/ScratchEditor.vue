<template>
  <v-card>
    <v-card-title>Type The Scratch Here</v-card-title>
    <v-card-text>
      <div class="ml-3 mb-2">
        <v-btn
          x-small
          outlined
          color="blue darken-4"
          class="mr-1"
          @click="applyBold"
        >
          <v-icon
            small
            dark
            color="blue darken-4"
          >
            mdi-format-bold
          </v-icon>
        </v-btn>
        <v-btn
          x-small
          outlined
          color="blue darken-4"
          class="mr-1"
          @click="applyItalic"
        >
          <v-icon
            small
            dark
            color="blue darken-4"
          >
            mdi-format-italic
          </v-icon>
        </v-btn>
        <v-btn
          x-small
          outlined
          color="blue darken-4"
          @click="applyHeading"
        >
          <v-icon
            small
            dark
          >
            mdi-format-header-1
          </v-icon>
        </v-btn>
      </div>
      <ScratchInputDiv
        v-model="article.description"
        :scratch-text="scratchText"
      />
      <!--            <div class="mt-2"> {{article.description}} </div>-->
    </v-card-text>
    <v-card-actions>
      <v-btn
        x-small
        dark
        color="warning"
        @click="submitScratch"
      >
        Submit The Scratch
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
    import ScratchInputDiv from "./ScratchInputDiv";
    import { mapActions } from 'vuex';

    export default {
        name: "ScratchEditor",
        components: {ScratchInputDiv},
        data() {
            return {
                scratchText: '',
                article:{
                    topicId:'29',
                    name:'Scratch',
                    description:'',
                }
            }
        },
        methods: {
            ...mapActions(['createArticleAction']),
            async submitScratch(){
                await this.createArticleAction(this.article)
                this.scratchText = ''
            //TODO Добавить в стор счетчик скретчей и добавлять номер к имени
            // TODO вероятно создать отдельный контроллер для скретчей?

            },

            applyBold() {
                document.execCommand('bold')
            },
            applyItalic() {
                document.execCommand('italic')
            },
            applyHeading() {
                document.execCommand('formatBlock', false, '<h1>')
            },
        }
    }
</script>

<style scoped>

</style>