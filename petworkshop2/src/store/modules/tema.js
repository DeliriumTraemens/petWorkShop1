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
            await context.commit('temaDroppedMutation', arg).then(
                this.updateDraggedTema(context)
            )

        },

        async updateDraggedTema(context){
            const temaForEdit = this.state.temaDragged.id
            const newParentTema = this.state.temaDropped.id
            console.log(temaForEdit +' '+newParentTema)

            const fd = new FormData()
            fd.append('id',temaForEdit)
            fd.append('parentTema', newParentTema)

            await axios.post('http://localhost:9090/tema/dragedit', fd)
                .then(res=>{
                    context.commit('temaTotalMutation', res.data)
                    console.log(state.temaTotal)
                })
            alert('StoreDropped')

        }
    },

}