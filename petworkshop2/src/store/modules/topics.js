import axios from "axios";

export default {
    state: {
        topicsTotalList: [
        ],

        selectedTopic:[],
        selectedTopicId:5,

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

        incrementSelectedId(context){
            context.commit('selectedTopicIdIncrementMutation')
        },

        setSelectedTopicId(context, value){
            context.commit('selectedTopicIdSetterMutation', value)
        }
    },
}