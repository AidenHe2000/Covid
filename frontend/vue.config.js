module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  css: {
    loaderOptions: {
        sass: {
            prependData: `@import "@/assets/global.scss";`,
            // prependData: `@import "@/assets/styles/global.scss";`
        },
        
    }
  }
}
