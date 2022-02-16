import axios from 'axios';
export default {
    state: {

    },
    getters: {},
    mutations: {},
    actions: {
       async updateArticleAction(context, arg){
            const fd=new FormData()
            fd.append('id', arg.id)
            fd.append('artTopic', arg.artTopic)
            fd.append('name', arg.name)
            fd.append('description', arg.description)

            await axios.post('http://localhost:9090/article/edit', fd)
                .then(res=>{console.log(res)})
           await context.dispatch('updateTopicList')


       }
    },
}