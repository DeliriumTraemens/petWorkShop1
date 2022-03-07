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
    actions: {}
}