<template>
    

    <v-app id="inspire">
  <h1  >Inbox</h1>
      <!-- <div  class="text-left" >
        <Send @setParentComponentDetails="setDetailsForComponent" />
      </div> -->
      <!-- <v-system-bar>
          <v-spacer></v-spacer>
    
          <v-icon>mdi-square</v-icon>
    
          <v-icon>mdi-circle</v-icon>
    
          <v-icon>mdi-triangle</v-icon>
        </v-system-bar> -->
  
      <!-- <v-navigation-drawer v-model="drawer">
          <v-sheet
            color="grey-lighten-4"
            class="pa-4"
          >
            <v-avatar
              class="mb-4"
              color="grey-darken-1"
              size="64"
            ></v-avatar> -->
  
      <!-- <div>john@google.com</div>
          </v-sheet>
    
          <v-divider></v-divider>
    
          <v-list>
            <v-list-item
              v-for="[icon, text] in links"
              :key="icon"
              link
            >
              <template v-slot:prepend>
                <v-icon>{{ icon }}</v-icon>
              </template>
    
              <v-list-item-title>{{ text }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer> -->
  
      <v-main class="px-6 py-1 container">
        <v-container fluid >
          <v-row >
            <v-col v-for="card in cards" :key="card" >
              <v-card width="">
  
                <v-list>
                  <v-list-subheader>{{ now }}</v-list-subheader>
                  <template>
                    <v-list-item v-for="(messege, index) in messeges" :key="index"  @click="menuActionClick(messege.from)">
                      <template v-slot:prepend>
                        <v-avatar color="grey-darken-1"></v-avatar>
                      </template>
  
                      <v-list-item-title class="c">{{ messege.from }}</v-list-item-title>
  
                      <v-list-item-subtitle>
                        {{ messege.text }}
                      </v-list-item-subtitle>
                    </v-list-item>
  
                    <!-- <v-divider v-if="n !== 6" :key="`divider-${n}`" inset></v-divider> -->
                  </template>
                </v-list>
              </v-card>
            </v-col>
          </v-row>
           <FooterComp/>
        </v-container>
      </v-main>
    </v-app>
  </template>
  
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js">
  </script>
  <script>
  
//   import SendMessege from './SendMessege.vue';
  import FooterComp from './FooterComp.vue';
  
  export default {
    name:'MessageCard',
    components: {FooterComp} ,
  
  
    data (){
      return {
      now : new Date(),
      messege:"",
      messeges:[
      {  from: "Reem",
         text:"Hello",},],
      
      cards: ['Today'],
      drawer: null,
    };
    },
    methods: {  
      menuActionClick(from) {
        if (from === "Reem") {
          alert('TEST!!')
        }
      },},
    
  };
  </script>
  <style scoped>
  .container{
    display: flex;
    margin-left: auto;
    margin-right: auto;
    justify-content: center;
    color:rgb(6, 45, 221);

  }

    .c{
      color:#2074d4 !important;
        
    }

  h1{
    margin-left: 85px;
    margin-top: 30px;
    font-weight: normal;
    color:#2074d4;
  }

</style>