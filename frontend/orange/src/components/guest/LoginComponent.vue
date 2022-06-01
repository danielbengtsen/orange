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
                        type="text"
                        name="user"
                        v-model="form.user"
                        color="#FF8303"
                        label="Username / E-mail"
                        required
                    ></v-text-field>

                    <v-text-field
                        v-model="form.password"
                        color="#FF8303"
                        label="Password"
                        required
                        name="password"
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
    <v-row>
        <v-col cols="12">
            <v-alert
                dense
                outlined
                type="error"
                v-if="showError"
            >
                {{ errorMessage }}
            </v-alert>
        </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from 'vuex';

  export default {
    name: 'LoginComponent',

    data: () => ({
        form: {
            user: '',
            password: '',
        },
        errorMessage: '',
        showError: false,
        boatAudio: new Audio(require('../../assets/audio/den-baad-der.mp3')),
    }),

    methods: {
        ...mapActions(["LogIn"]),
        async login() 
        {
            if(this.user == 'fynbo' && this.password == 'båd')
            {
                this.boatAudio.play();
            }
            else
            {
                const User = new FormData();
                User.append("user", this.form.user);
                User.append("password", this.form.password);
                try
                {
                    await this.LogIn(User);
                    this.$router.push("/home");
                    this.showError = false;
                }
                catch(error)
                {
                    this.showError = true;
                    this.errorMessage = error;
                }
            }
        }
    }

  }
</script>
