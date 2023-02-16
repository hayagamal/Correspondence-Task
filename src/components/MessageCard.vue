<template>
    

    <v-app id="inspire">
  <h1  >Inbox</h1>
     
      <v-main class="px-6 py-1 container">
        <v-container fluid >
                <template>
                <v-data-table
                    :items-per-page="itemsPerPage"
                    :headers="headers"
                    :items="items"
                    class="elevation-1"
                ></v-data-table>
                </template>

              <!-- <v-card width="">
  
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
  
                    <v-divider v-if="n !== 6" :key="`divider-${n}`" inset></v-divider> -->
                  <!-- </template>
                </v-list>
              </v-card> -->

        </v-container>
      </v-main>
      <FooterComp/>
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
      cards: ['Today'],
      drawer: null,
      itemsPerPage:5,
      headers: [
          {
            text: 'From',
            align: 'start',
            sortable: false,
            value: 'from',
          },
          { text: 'Message', value: 'message' },
        ],
        items: [
          {
            from: 'Reem',
            message: 'مساء الأنوار'
          },
        ],
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