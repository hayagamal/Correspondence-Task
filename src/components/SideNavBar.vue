<template>

  <nav>
    <v-app-bar flat app>
    <v-app-bar-nav-icon class="grey--text" @click="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title class="text-uppercase blue--text">
            <span class="font-weight-light">Corre</span>
            <span>spondence</span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <!-- <router-link to="/"> <v-btn class="primary dark">
            + New
        </v-btn></router-link> -->
       
    
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app class="primary">
       
       <ul class="nav-ul">
       <router-link to="/"> <li>Inbox</li></router-link>
       <router-link to="/"> <li>Sent Messages</li></router-link>
       </ul>
    </v-navigation-drawer>
  </nav>
</template>
<script>


export default ({
    name: 'SideNavBar',

  components: {

  },

  data(){
    return {
        drawer: false
    }
   
  }
})
</script>
<style scoped>
.text-h6{
    padding: 20px;
}

li{
    color: white;
    list-style-type: none;
    text-decoration: none;
    
}
.nav-ul{
    display: flex;
    flex-direction: column;
    gap: 20px;
    margin-top: 50px;

}

</style>