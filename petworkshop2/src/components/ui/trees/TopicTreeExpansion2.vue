<template>
    <div>
        <h2>TopicExpPan2</h2>
        <TopicExpPan2 v-for="(topic,i) in data" :key="i"
        :data="topic"/>
    </div>
</template>
<!--На предыдущем компоненте передаем в пропсы массив
2) В Текущем компоненте вызываем Компонент Списка и сразу задаем итерацию
с передачей объекта, полученного итератором, в пропсы вызываемого компонента-->
<script>
    import TopicExpPan2 from "../lists/TopicExpPan2";
    export default {
        name: "TopicTreeExpansion2",
        components: {TopicExpPan2},
        props: {
            data:[]
        },
    }
</script>

<style scoped>

</style>