<template>

    <div>


        <div class="button-wrap">
            <v-btn small @click="applyBold">
                <v-icon small dark>mdi-format-bold</v-icon>
            </v-btn>
            <v-btn small @click="applyItalic">
                <v-icon small dark>mdi-format-italic</v-icon>
            </v-btn>
            <v-btn  small @click="applyHeading">
                <v-icon small dark>mdi-format-header-1</v-icon>
            </v-btn>
            <v-btn small @click="applyUl">
                <v-icon small dark>mdi-format-list-bulleted</v-icon>
            </v-btn>
            <v-btn small @click="applyOl">
                <v-icon small dark>mdi-format-list-numbered</v-icon>
            </v-btn>
            <v-btn small @click="undo">
                <v-icon small dark>mdi-arrow-u-left-bottom</v-icon>
            </v-btn>
            <v-btn small @click="redo">
                <v-icon small dark>mdi-arrow-u-right-top</v-icon>
            </v-btn>
        </div>

        <div
                @input="onInput"
                v-html="innerdata"
                contenteditable="true"
                class="wysiwyg-output outline-none border-3 p-6 rounded-lg border-gray-300 focus:border-green-300"
                id="wised1" >

        </div>

    </div>


</template>

<script>
    export default {
        name: "WisiwigEdit1",
        props: {
            innerdata: {
                type:String,
                default: 'Default text'
            }

        },

        data() {
            return {
                innerValue: ''
            }
        },

        beforeMount() {
            this.setData()
            // document.execCommand('defaultParagraphSeparator', false, 'p')
        },
        methods: {
            setData(){
                this.innerValue=this.innerdata
                console.log('typeof this.text')
                console.log(typeof this.innerdata)
                console.log(this.innerdata)
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
    background-color:ivory;
    min-height: 100px;
    border: 1px solid;
    border-radius: 4px;
    margin-top: 10px;
    margin-bottom: 4px;
    padding: 3px;
}
.button-wrap{
    padding: 3px;
    border: 1px solid;
    border-radius: 4px;
}
</style>