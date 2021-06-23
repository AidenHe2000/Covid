<template>
  <v-app class="text-center">
    <v-chip
      class="ma-2"
      label
    >
      Label
    </v-chip>

    <v-chip
      
      color="red"
      label
      text-color="white"
    >
      <v-icon left>
        mdi-label
      </v-icon>
      Tags
    </v-chip>

    <v-chip
      class="ma-2"
      color="primary"
      label
    >
      <v-icon left>
        mdi-account-circle-outline
      </v-icon>
      John Leider
    </v-chip>

    <v-chip
      class="ma-2"
      close
      color="cyan"
      label
      text-color="white"
    >
      <v-icon left>
        mdi-twitter
      </v-icon>
      New Tweets
    </v-chip>
  </v-app>
</template>