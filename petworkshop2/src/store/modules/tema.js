import axios from 'axios'
export default {

    state:{
        temaTotal:[],
        temaDragged:{},
        temaDropped:{}
    },
    getters:{
        getTemaTotal(state){
            return state.temaTotal
        },

        getTemaDragged(state){
            return state.temaDragged
        },

        getTemaDropped(state){
            return state.temaDropped
        }
    },
    mutations:{
        temaTotalMutation(state, arg){
            state.temaTotal = arg
        },

        temaDraggedMutation(state, arg){
            state.temaDragged = arg
        },

        temaDroppedMutation(state, arg){
            state.temaDropped = arg
        }


    },
    actions:{
        async setTemaTotal(context){
            await axios.get('http://localhost:9090/tema')
                .then(res=>{
                    context.commit('temaTotalMutation', res.data)
                })

        },

        setTemaDragged(context, arg){
            context.commit('temaDraggedMutation', arg)
        },

        async setTemaDropped(context, arg){
            await context.commit('temaDroppedMutation', arg)
                const temaForEdit = context.state.temaDragged.id;
                const temaNewParent = context.state.temaDropped.id;

            const fd = new FormData()
            fd.append('id',temaForEdit)
            fd.append('parentTema', temaNewParent)

            await axios.post('http://localhost:9090/tema/dragedit', fd)
                .then(res=>{
                    context.commit('temaTotalMutation', res.data)
                })


                console.log(context.state.temaTotal)

        },

    },

}