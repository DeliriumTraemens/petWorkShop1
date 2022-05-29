<template>
  <div
    class="ed1 mr-3"
    contenteditable="true"
    @input="onInput"
    v-html="scratchText"
  />
</template>

<script>
    export default {
        name: "ScratchInputDiv",
        props: {
            scratchText:{
                type:String
            }
        },
        data (){
            return{

            }
        },
        methods: {
            onInput(event) {
                this.$emit('input', event.target.innerHTML)
                // this.innerValue=event.target.innerHTML
            },
        }
    }
</script>

<style scoped>
    .ed1 {
        min-height: 450px;
        border: 1px solid;
        margin-left: 10px;
    }
</style>