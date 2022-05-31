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
                src="../assets/logo.png"
                transition="scale-transition"
                width="40"
                />
            </div>
        </router-link>

        <v-spacer></v-spacer>

        <router-link
            style="text-decoration: none; color: inherit;"
            to="/login"
        >
            <v-btn
                color="#FF8303"
                text="#FF8303"
            >
                Login
            </v-btn>
        </router-link>
    </v-app-bar>
</template>

<script>
export default {
  name: 'HeaderComponent',

  data: () => ({
    //
  }),
};
</script>