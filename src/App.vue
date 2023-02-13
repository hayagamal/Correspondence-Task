<template>
  <v-app>
    <v-main>
      <SideNavBar/>
      <SendNewCorr/>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>

import SideNavBar from '@/components/SideNavBar.vue';
import SendNewCorr from './views/SendMessage/SendNewCorr.vue';

export default {
  name: 'App',

  components: {
    SideNavBar,
    SendNewCorr
  },

  data: () => ({
    //
  }),
};
</script>
