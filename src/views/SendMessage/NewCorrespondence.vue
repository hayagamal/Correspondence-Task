<template>
 <v-sheet width="400" class="mx-auto form">
    <v-form ref='form' validate-on="submit" @submit.prevent="submit">
      <v-text-field
        v-model="correspondence.reciever"
        label="To"
        :rules="inputRules"

      ></v-text-field>
      <v-text-field
        v-model="correspondence.subject"
        label="Subject"
        :rules="inputRules"

      ></v-text-field>
      <v-select
        v-model="correspondence.select"
        :items="items"
        :rules="[v => !!v || 'Priority is required']"
        label="Priority"
        required
      ></v-select>
      <v-textarea label="Description" v-model="correspondence.description" :rules="inputRules"></v-textarea>
      <v-text-field
        v-model="correspondence.comment"
        label="Comment"
        :rules="inputRules"
      ></v-text-field>
     <v-btn @click="sendData" type="submit" block class="mt-5 black" dark>Next</v-btn>
    </v-form>
  </v-sheet>

</template>
<script>

export default {
  name: 'NewCorrespondence',

  components: {
   
  },

  data() {
    return {
      correspondence: {
        reciever: '',
      subject: '',
      select: null,
      description: '',
      comment: ''
      },
      show: true,
     
      items: [
        'Low',
        'Medium',
        'High',
       
      ],
      inputRules: [
            v=> v.length > 0  || 'Please Fill the empty fields.',
            
        ],
      
    }
  },
  methods: {
    sendData(){
      if(this.$refs.form.validate()){
       
        this.$emit('sendData', {correspondence: this.correspondence})
      }
    }
  }
  }
</script>
<style scoped>
 .form{
  margin-top: 50px;
 }
 .black{
  text-decoration: none;
 }
</style>

