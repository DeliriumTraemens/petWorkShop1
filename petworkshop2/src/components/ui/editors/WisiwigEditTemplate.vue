<template>
  <div class="edwrap">
    <div class="button-wrap">
      <span class="mr-2">
        <v-btn
          small
          color="blue darken-4"
          class="mr-1"
          @click="applyBold"
        >
          <v-icon
            small
            dark
            color="yellow"
          > mdi-format-bold </v-icon>
        </v-btn>
        <v-btn
          small
          color="blue darken-4"
          class="mr-1"
          @click="applyItalic"
        >
          <v-icon
            small
            dark
            color="yellow"
          > mdi-format-italic</v-icon>
        </v-btn>
      </span>
      <span class="mr-3">
        <v-btn
          small
          @click="applyHeading"
        >
          <v-icon
            small
            dark
          >mdi-format-header-1</v-icon>
        </v-btn>
      </span>
      <!--Align-->

      <span class="mr-3">
        <v-btn
          small
          @click="applyLeft"
        >
          <v-icon
            small
            dark
          >mdi-format-align-left</v-icon>
        </v-btn>
        <v-btn
          small
          @click="applyCenter"
        >
          <v-icon
            small
            dark
          >mdi-format-align-center</v-icon>
        </v-btn>
        <v-btn
          small
          @click="applyRight"
        >
          <v-icon
            small
            dark
          >mdi-format-align-right</v-icon>
        </v-btn>
      </span>
      <!--Align-->
      <span class="mr-3">
        <v-btn
          color="default"
          small
          @click="applyUl"
        >
          <v-icon
            small
            dark
          >mdi-format-list-bulleted</v-icon>
        </v-btn>
        <v-btn
          small
          @click="applyOl"
        >
          <v-icon
            small
            dark
          >mdi-format-list-numbered</v-icon>
        </v-btn>
      </span>
      <span>
        <v-btn
          small
          color="brown"
          class="mr-1"
          @click="undo"
        >
          <v-icon
            small
            dark
            color="yellow"
          >mdi-arrow-u-left-bottom</v-icon>
        </v-btn>
        <v-btn
          small
          color="brown"
          @click="redo"
        >
          <v-icon
            small
            dark
            color="yellow"
          >mdi-arrow-u-right-top</v-icon>
        </v-btn>
      </span>
    </div>

    <div
      id="wised1"
      contenteditable="true"
      class="wysiwyg-output outline-none border-3 p-6 rounded-lg border-gray-300 focus:border-green-300"
      @input="onInput"
      v-html="innerdata"
    >
      ddddd
    </div>
    <hr class="mb-1 mt-2">
    <v-btn
      x-small
      color="warning"
    >
      Submit
    </v-btn>
  </div>
</template>

<script>
    export default {
        name: "WisiwigEdit1Template",
        props: {
            innerdata: {
                type:String,
            }

        },

        data() {
            return {
                innerValue: '',
            }
        },

        beforeMount() {
            // this.setData()
            // document.execCommand('defaultParagraphSeparator', false, 'p')
        },
        methods: {
            setData(){
                this.innerValue=this.innerdata


            },
            onInput(event) {
                this.$emit('input', event.target.innerHTML)
                // this.innerValue=event.target.innerHTML
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

            /*Alignment*/
            applyLeft(){
                document.execCommand('justifyLeft', false, null);
            },
            applyCenter(){
                document.execCommand('justifyCenter', false, null);
            },
            applyRight(){
                document.execCommand('justifyRight', false, null);
            },

            applyUl() {
                document.execCommand('insertUnorderedList')
            },
            applyOl() {
                document.execCommand('insertOrderedList')
            },
            undo() {
                document.execCommand('undo')
            },
            redo() {
                document.execCommand('redo')
            }
        },
    }
</script>

<style scoped>
.ed-3{
    margin: 5px;
    padding: 5px;
    border-bottom: 1px solid;
    border-radius: 4px;
    min-height: 100px;
    user-focus: focus;
}

.wysiwyg-output h1 {
    @apply text-2xl;
    @apply font-bold;
    @apply pb-4;
}
.wysiwyg-output p {
    @apply pb-4;
}
.wysiwyg-output p {
    @apply pb-4;
}
.wysiwyg-output ul {
    @apply ml-6;
    @apply list-disc;
}
.wysiwyg-output ol {
    @apply ml-6;
    @apply list-decimal;
}
#wised1{
    background-color: rgba(253, 249, 242, 0.99);
    min-height: 200px;
    border: 1px solid;
    border-radius: 4px;
    margin-top: 10px;
    margin-bottom: 4px;
    padding: 3px;
}
.edwrap{
    padding: 10px;
    border: 1px solid orange;
    border-radius: 4px;
    margin: 4px;
}
.button-wrap{
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
}
</style>