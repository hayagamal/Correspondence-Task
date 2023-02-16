<template>

  <nav>
    <v-app-bar flat app>
    <v-app-bar-nav-icon class="grey--text" @click="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title class="text-uppercase blue--text">
            <span class="font-weight-light">Corre</span>
            <span>spondence</span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <router-link to="/new"> <v-btn class="primary dark">
            + New
        </v-btn></router-link>
       
    
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app class="primary">
       <router-link to="/login"  class="login-btn"><v-btn>Login</v-btn></router-link>
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
.login-btn{
    text-decoration: none;
    display: flex;
    margin-left: auto;
    margin-right: auto;
    justify-content: center;
    margin-top: 40px;
}

</style>