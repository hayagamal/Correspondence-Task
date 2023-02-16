<template>
  <v-app>
    <v-main>
      <SideNavBar/>
      
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>

import SideNavBar from '@/components/SideNavBar.vue';


export default {
  name: 'App',

  components: {
    SideNavBar,
  
  },

  data: () => ({
    //
  }),
};
</script>
