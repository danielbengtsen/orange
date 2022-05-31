<template>
  <v-container>
    <v-row class="pt-8">
      <v-col cols="12" class="text-center">
        <h1 class="orange-title">Login</h1>
      </v-col>
    </v-row>
    <v-row>
        <v-container>
            <v-col cols="12">
                <v-form
                    ref="form"
                    v-model="valid"
                    lazy-validation
                >
                    <v-text-field
                        v-model="user"
                        color="#FF8303"
                        label="Username / E-mail"
                        required
                    ></v-text-field>

                    <v-text-field
                        v-model="password"
                        color="#FF8303"
                        :rules="passwordRules"
                        label="Password"
                        required
                        type="password"
                    ></v-text-field>
        
                    <v-btn
                        color="#FF8303"
                        dark
                        class="float-right"
                        @click="login"
                    >
                    Login
                    </v-btn>
                </v-form>
            </v-col>
        </v-container>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'LoginComponent',

    data: () => ({
        user: '',
        password: '',
        boatAudio: new Audio(require('../../audio/den-baad-der.mp3')),
        passwordRules: [
            v => v.length >= 8 || 'Min 8 characters',
        ],
    }),

    methods: {
        login() 
        {
            if(this.user == 'fynbo' && this.password == 'båd')
            {
                this.boatAudio.play();
            }
            else
            {
                console.log("login her");
            }
        }
    }

  }
</script>
