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
                    Input Topic Data
                </v-card-title>

                <v-card-text>
                  <v-text-field label="Name"></v-text-field>
                  <v-text-field label="Description"></v-text-field>
                    Lorem ipsum dolor sit amet.
                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                    >
                        Cancel
                    </v-btn>

                    <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                    >
                        Submit
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    export default {
        name: "TopicDialogMy1",
        data () {
            return {
                dialog: false,
            }
        },
    }
</script>

<style scoped>

</style>