<template>
  <v-container>
    <v-row class="pt-8">
      <v-col cols="12" class="text-center">
        <h1 class="orange-title">Welcome to Orange Kitchen website</h1>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" class="text-center">
        <v-img
          alt="Why are you reading this??"
          class="img-center"
          contain
          v-bind:src="require('../assets/img/' + image)"
          width="500px"
          height="auto"
          @click="updateImage()"
        />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" class="text-center">
        <p>
          <v-icon class="material-icons">mdi-music-note</v-icon>
          {{ soundText }}
          <v-icon class="material-icons">mdi-music-note</v-icon>
        </p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'IndexComponent',

    data: () => ({
      image: 'peanutbutter.png',
      clicker: 0,
      soundText: 'Press the banana for sound',
      pbAudio: new Audio(require('../assets/audio/peanutbutter.mp3')),
      scaryAudio: new Audio(require('../assets/audio/jumpyscare.mp3')),
    }),

    methods: {
      updateImage() {
        if(this.clicker == 0)
        {
          this.soundText = 'Press again to stop';
          this.image = 'peanutbutter.gif';
          this.pbAudio.play();
        }
        /* if(this.clicker == 1)
        {
          this.stopAudio(this.pbAudio);
          this.soundText = 'You were warned...';
          this.image = 'jumpyscare.jpg';
          this.scaryAudio.play();
        }
        if(this.clicker == 2)
        {
          this.stopAudio(this.scaryAudio);
          this.clicker = -1;
          this.soundText = 'Press the banana for sound';
          this.image = 'peanutbutter.gif';
        } */
        if(this.clicker == 1)
        {
          this.stopAudio(this.pbAudio);
          this.clicker = -1;
          this.soundText = 'Press the banana for sound';
          this.image = 'peanutbutter.png';
        }
          this.clicker++;
      },
      stopAudio(audio)
      {
        audio.pause();
        audio.currentTime = 0;
      }
    }

  }
</script>
