<template>
    <div class="topitem">
        <hr>
        <v-layout>
        <h4>{{item.name}}</h4>
            <span class="sp1">
            <v-btn x-small @click="showInfo(item)">Show Info</v-btn>
            <v-btn x-small >PRESS IT</v-btn>
        </span>

        </v-layout>
        <hr>
    </div>
</template>

<script>

    export default {
        name: "TopicItem",
        components: {
        },
        props: {
            item:{}
        },
        methods: {
            showInfo(item){
                alert(item.id + ' ' + item.name);
            }
        }
    }
</script>

<style scoped>
.topitem{
    margin-bottom: 2rem;
}
    .sp1{
        alignment: right;
        margin-left: 2rem;
    }
</style>