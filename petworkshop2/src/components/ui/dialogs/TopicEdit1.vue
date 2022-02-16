<template>
    <div>

        <div class="pt-0.5">
            <v-btn icon
                   color="indigo"
                   @click.stop="dialog = true">
                <v-icon small dark>
                    mdi-plus
                </v-icon>
            </v-btn>
        </div>

        <v-dialog
                v-model="dialog"
                max-width="390"
        >
            <v-card>
                <v-card-title class="text-h5">
                    Input Topic Data For {{newSubTopic.parentId}}
                </v-card-title>

                <v-card-text>
                    <v-text-field label="Name" v-model="newSubTopic.name"></v-text-field>
                    <v-text-field label="Description" v-model="newSubTopic.description"></v-text-field>
                    Lorem ipsum dolor sit amet.
                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn
                            color="warning"
                            text
                            @click="dialog = false"
                    >
                        Cancel
                    </v-btn>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="createSubTopic2()"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    export default {
        name: "TopicEdit1",
        data() {
            return{
                dialog: false,
                
            }
        },
        computed: {
            ...mapGetters(['getSelectedTopic'])
        },
        methods: {
            editTopic(){

            }
        }
    }
</script>

<style scoped>

</style>