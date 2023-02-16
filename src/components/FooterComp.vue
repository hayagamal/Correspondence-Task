<template>
    <v-footer class="d-flex flex-column" app bottom fixed padless>
      <div class="bg-teal d-flex w-100 align-center px-4">
        <strong>Get connected with us on social networks!</strong>
  
        <v-spacer></v-spacer>
  <div  v-for="icon in icons" :key="icon">
        <v-btn
         
          
          class="mdi-vuetify"
          :icon="icons"
          variant="plain"
          size="small"
          
        >
        <v-icon>{{ icon }}</v-icon>   
      </v-btn>
      </div>
      </div>
  
      <div class="px-4 py-2 bg-black text-center w-100">
        {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
      </div>
    </v-footer>
  </template>
  
  <script>
    export default {
      data: () => ({
        icons: [
          'mdi-facebook',
          'mdi-twitter',
          'mdi-linkedin',
          'mdi-instagram',
        ],
      }),
    }
  </script>

  <style>



  </style>