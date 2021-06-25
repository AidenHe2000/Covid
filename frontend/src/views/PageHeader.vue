<template>
  <div class="header mb-3">
    <h2 class="pageTitle">
      <v-icon size="40" class="mr-2">mdi-clock</v-icon>
      {{nowTime}}
    </h2>
 </div>
</template>


<script>
export default {
  props: {
    title: {
      type: String,
      required: true,
      default: ''
    },
    icon: {
      type: String,
      required: false,
      default: ''
    },
  },
  data() {
    return {nowTime:new Date()};
  },
  mounted() {
    let _this = this; // 声明一个变量指向Vue实例this，保证作用域一致
    this.timer = setInterval(() => {
      _this.nowTime = new Date(); // 修改数据date
    }, 1000)
  },
  beforeDestroy() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  }
}
</script>
<style scoped>

</style>