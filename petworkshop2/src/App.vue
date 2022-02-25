<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-app-bar-title>PetWorkShop</v-app-bar-title>
      </div>

      <v-spacer></v-spacer>

      <v-btn fab @click="showArticles" color="primary" class="ml-4">Articles</v-btn>
      <v-btn fab @click="showTopics" color="primary" class="ml-4">Topics</v-btn>
      <v-btn fab @click="showTrainings" color="primary" class="ml-4">Trainings</v-btn>


      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
  methods: {
    showTopics(){
      this.$router.push('/Topics')
    },
    showArticles(){
      this.$router.push('/')
    },
    showTrainings(){
      this.$router.push('/Trainings')
    }
  },
};
</script>
