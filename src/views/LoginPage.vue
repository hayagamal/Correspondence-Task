<template>
    <v-sheet width="400" class="mx-auto form">
        <h3 class="my-8">Login to your Account</h3>
    <v-form ref="form">
        <v-text-field
        v-model="user.username"
        label="Username"
        :rules="inputRules"

      ></v-text-field>
      <v-text-field
        v-model="user.password"
        type="password"
        label="Password"
        :rules="inputRules"

      ></v-text-field>
      <v-btn class="submit-btn" @click="login">Login</v-btn>
    </v-form>
</v-sheet>
</template>

<script>

export default {
    name: 'LoginPage',
    components: {

    },
    data(){
        return {
            user:{
                username: '',
                password: ''
            },
            inputRules: [
            v=> v.length > 0  || 'Please Fill the empty fields.',
            
        ],
        }
    },
    methods: {
        login(){
            if(this.$refs.form.validate()){
                console.log(this.user)
            }
        }

    }
}
</script>
<style scoped>
.submit-btn{
    display: flex;
    justify-content: center;
    margin-left: auto;
    margin-right: auto;
    margin-top: 40px;
}
</style>
