<template>
    <v-app-bar
        app
        color="#2b2b2b"
        dark
        >
        <router-link
            style="text-decoration: none; color: inherit;"
            to="/"
        >
            <div class="d-flex align-center">
                <v-img
                alt="Logo"
                class="shrink mr-2"
                contain
                src="../assets/img/logo.png"
                transition="scale-transition"
                width="40"
                />
            </div>
        </router-link>

        <v-spacer></v-spacer>

        <template v-if="isLoggedIn">
            <router-link
                style="text-decoration: none; color: inherit;"
                to="/tv-booking"
            >
                <v-btn
                    color="#FF8303"
                    :text="true"
                >
                    TV Booking
                </v-btn>
            </router-link>
        </template>

        <v-spacer></v-spacer>

        <template v-if="isLoggedIn">
            <v-btn
                color="#FF8303"
                :text="true"
                @click="logout"
            >
                Logout
            </v-btn>
        </template>
        <template>
            <router-link
                style="text-decoration: none; color: inherit;"
                to="/login"
            >
                <v-btn
                    color="#FF8303"
                    :text="true"
                >
                    Login
                </v-btn>
            </router-link>
        </template>
    </v-app-bar>
</template>

<script>
export default {
    name: 'HeaderComponent',

    data: () => ({
        //
    }),

    computed : 
    {
      isLoggedIn: function(){ return this.$store.getters.isAuthenticated; }
    },

    methods: 
    {
        async logout ()
        {
            await this.$store.dispatch('LogOut');
            this.$router.push('/login');
        }
    },
};
</script>