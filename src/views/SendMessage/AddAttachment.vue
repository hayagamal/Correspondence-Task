<template>
  <div class="upload">
    <v-form ref="form">
      <input  type="file" ref="fileInput" @change="uploadFile"  :rules="[v => !v.target.files || 'Priority is required']"/>
      <v-btn @click="submit" class="black" dark>Send Correspondence</v-btn>
    </v-form>
  </div>
</template>

<script>
export default {
  data(){
    return {
      file: ''
    }
    
  },
  methods: {
    uploadFile(e) {
      this.file = e.target.files
     
    },
    submit(){
      if(this.$refs.form.validate()){
        console.log(this.file)
        this.$emit('uploadFile',this.file)
    }}
  },
};
</script>
<style scoped>
.upload{
  display: flex;
  justify-content: center;
  margin: 50px;
}
.upload-button{
  color: white;
  background-color: black;
}
form{
  display: flex;
  flex-direction: column;
  gap: 50px;
}
</style>
