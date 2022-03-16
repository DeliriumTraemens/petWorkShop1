import axios from 'axios'
export default {
    state: {
        item: {},
        selectedItem: {},
        selectedItems: [],
        temaItems: []
    },
    getters: {
        getItem(state) {
            return state.item
        },
        getSelectedItem(state) {
            return state.selectedItem
        },
        getSelectedItems(state) {
            return state.selectedItems
        },
        getTemaItems(state) {
            return state.temaItems
        }
    },
    mutations: {
        itemMutation(state, arg) {
            state.item = arg
        },
        selectedItemMutation(state, arg) {
            state.selectedItem = arg
        },
        selectedItemsMutation(state, arg){
            state.selectedItems = arg
        },
        temaItemsMutation(state, arg){
            state.temaItems=arg
        }
    },
    actions: {
        setSelectedItem(context, arg){
            context.commit('selectedItemMutation', arg)
        },

      async  createNewItem(context, arg){
            const selectedTema= String(context.rootGetters.getSelectedTema.id)
            console.log(typeof(arg.selectedFile))
            console.log(arg)
            const fd = new FormData()
                fd.append('tema', selectedTema)
                fd.append('name', arg.name)
                fd.append('description', arg.description)
                fd.append('file', arg.selectedFile)

               await axios.post('http://localhost:9090/item/addNewItem', fd).then(res =>{
                    context.commit('temaTotalMutation', res.data)

                })

                // const sd = new FormData()
                // sd.append('id', selectedTema)
                const temaNum = String(context.rootGetters.getSelectedTema.id)
                await axios.get('http://localhost:9090/tema/'+temaNum).then(res =>{
                    context.commit('selectedTemaMutation', res.data)
                    console.log('SelectedTema')
                    console.log(context.rootGetters.getSelectedTema)
                })
            // console.log(context.getters.getTemaTotal)
        }
    }
}