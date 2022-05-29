<template>
  <div>
    <p>EditorWrap</p>
    <WisiwigEdit1Template
      v-model="sometext"
      :innerdata="texeedit"
    />
    <hr>
    <div>{{ sometext }}</div>
  </div>
</template>

<script>
    import WisiwigEdit1Template from "./WisiwigEditTemplate";
    export default {
        name: "HtmlEditorWrap1",
        components: {WisiwigEdit1Template},
        props: {data:{
            type: Object
            }
        },
        data(){
            return {
            sometext:'',
            texeedit:'Blah blah'

            }
        }
    }
</script>

<style scoped>

</style>