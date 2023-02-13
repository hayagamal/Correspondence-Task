<template>
      <div>
  
  <!-- <nav class="steps">
    <ul>
     <router-link class="link" to="/correspondence"> <li >Correspondence Details</li></router-link>
     <router-link class="link" to="/attachment"><li>Add Attachment</li> </router-link>--
    </ul>
  </nav>
<NewCorrespondence v-if="show" @sendData="send"/> -->
<v-card>
    <v-tabs
      v-model="tab"
      color="deep-purple-accent-4"
      align-tabs="center"
    >
      <v-tab :value="0">Correspondence Details</v-tab>
      <v-tab :value="1">Add Attachment</v-tab>
    
    </v-tabs>

  </v-card>


  <component :is="tab ?  'AddAttachment' : 'NewCorrespondence' " @sendData = 'send' @uploadFile = 'uploadFile'></component>


</div>

 
</template>
<script>
import AddAttachment from './AddAttachment.vue';
import NewCorrespondence from './NewCorrespondence.vue';

export default {
 name: 'SendNewCorr',

components: {
    AddAttachment,
    NewCorrespondence
},

data() {
  return {
    tab: 0,
    correspondence: '',
    attachment: '',
    correspondenceAttached: ''

  }
},
methods: {
    send(data){
        console.log(data)
        this.correspondence = data
        this.tab +=1
    },
    uploadFile(attach){
        this.attachment = attach;
        this.correspondenceAttached = {correspondence: this.correspondence , attachment: this.attachment}
        console.log(this.correspondenceAttached)
    }
}
}
</script>
<style scoped>
.steps{
  width: 100%;
  margin-top: 20px;
}
.steps ul{
  display: flex;
  gap: 5px;
  justify-content: center;
}
.steps .link{
  list-style-type: none;
  width: 30%;
  text-align: center;
  background-color:#2074d4;
  color: white;
  padding: 5px;
  cursor: pointer;
  text-decoration: none;
}
.link.router-link-active{
  background-color: black;
}
</style>