<template>
    <v-footer
        color="#2b2b2b"
        padless
    >
        <v-col
            class="text-center"
            cols="12"
            style="color: #F0E3CA;"
        >
        {{ new Date().getFullYear() }} — <strong>Orange Kitchen</strong>
        </v-col>
  </v-footer>
</template>

<script>
export default {
  name: 'FooterComponent',

  data: () => ({
    //
  }),
};
</script>