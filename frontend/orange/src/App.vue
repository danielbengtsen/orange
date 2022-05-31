<template>
  <v-app>
    <HeaderComponent/>
    <v-main app class="color1-background">
      <router-view></router-view>
    </v-main>
    <FooterComponent/>
  </v-app>
</template>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap');
</style>

<script>
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

export default {
  name: 'App',

  components: {
    HeaderComponent,
    FooterComponent,
},

  data: () => ({
    //
  }),
};
</script>
