import axios from 'axios';
export default {
    state: {
        articleSet:[]
    },
    getters: {
        getArticleSet(state){
            return state.articleSet
        }
    },
    mutations: {},
    actions: {

        async createArticleAction(context, arg){
            //шлем новый артикл
            //.id - номер топика для отдельного вызова
            const fd = new FormData();
            fd.append('id', arg.topicId)
            fd.append('name', arg.name)
            fd.append('description', arg.description)

            await axios.post('http://localhost:9090/article', fd).then(res =>{
                console.log('News Article Actions data')
                console.log(res.data)

                context.dispatch('setSelectedTopic',res.data.artTopic)
            })


            //Achtung: В АртиклКонтроллер пробуем преобразовать постМетод в тип  Topic,
            //чтобы в промис получать текущий топик для горячей замены SelectedTopic
            //-- А нихуя - в промисе артикла прилетает артикл с готовым топиком!!!

        },

       async updateArticleAction(context, arg){
            const fd=new FormData()
            fd.append('id', arg.id)
            fd.append('artTopic', arg.artTopic)
            fd.append('name', arg.name)
            fd.append('description', arg.description)

            await axios.post('http://localhost:9090/article/edit', fd)
                .then(res=>{console.log(res)
            context.dispatch('setSelectedTopic',res.data.artTopic)

                })
           await context.dispatch('updateTopicList')
           //Получить articleSet по топику, и обновить selectedTopic.articleSet ??
       }
    },
}