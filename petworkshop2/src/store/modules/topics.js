import axios from "axios";

export default {
    state: {
        topicsTotalList: [],

        selectedTopic:[],

        selectedTopicId:5,

        newTopic:{
            name:'',
            description:''
        },

        newSubTopic:{
            parentId:'',
            name:'',
            description:'',
            url:''
        },

        topicUrl: 'http://localhost:9090/topic'
    },
    getters: {
        getTopicsTotalList(state) {
            return state.topicsTotalList
        },

        getSelectedTopic(state){
            return state.selectedTopic
        },

        getTopicsSelectedTopicId(state){
            return state.selectedTopicId
        },

        getTopicsSelectedTopic(state){
            return state.selectedTopic
        },

        getNewTopic(state){
            return state.newTopic
        },

        getNewSubTopic(state){
            return state.newSubTopic
        }
    },
    mutations: {
        topicTotalListMutation(state, argTotalTopics) {
            state.topicsTotalList = argTotalTopics
        },

        selectedTopicMutation(state, arg){
            state.selectedTopic = arg
        },

        selectedTopicIdIncrementMutation(state){
            state.selectedTopicId++
        },

        selectedTopicIdSetterMutation(state, arg){
            state.selectedTopicId=arg
        },

        newTopicMutation(state, arg){
            state.newTopic=arg
        },

        newSubTopicMutation(state, arg){
            state.newSubTopic = arg
        }


    },
    actions: {
        async updateTopicList(context) {
            // this.loadMainTopicList()
            await axios.get('http://localhost:9090/topic')
                .then(res => {
                    const totalTopics = res.data;
                    console.log(totalTopics)
                    context.commit('topicTotalListMutation', totalTopics)
                })
                    // alert('Update TOPIC LIST')
        },

        setSelectedTopic(context, arg){
            context.commit('selectedTopicMutation',arg)
        },

        async createNewRootTopic(context, arg){
            const fd=new FormData()
            fd.append('name', arg.name)
            fd.append('description', arg.description)

            await axios.post('http://localhost:9090/topic',fd).then(res =>{
                console.log(res.data)
            })

             await context.dispatch('updateTopicList')

        },

        async createNewSubTopic(context, arg){
            context.commit('newSubTopicMutation', arg)
            const fd = new FormData()
            fd.append('parentId', context.state.newSubTopic.parentId)
            fd.append('name', context.state.newSubTopic.name)
            fd.append('description', context.state.newSubTopic.description)

            await axios.post(context.state.newSubTopic.url, fd).then(res =>{
                console.log(res.data)
            })
            await context.dispatch('updateTopicList')
        },

        async editTopicAction(context, arg){
            const fd = new FormData()
            fd.append('id', arg.id)
            fd.append('name', arg.name)
            fd.append('description', arg.description)
            await axios.post('http://localhost:9090/topic/edit',fd)
            await context.dispatch('updateTopicList')

        },

        incrementSelectedId(context){
            context.commit('selectedTopicIdIncrementMutation')
        },

        setSelectedTopicId(context, value){
            context.commit('selectedTopicIdSetterMutation', value)
        }
    },
}