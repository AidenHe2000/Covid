<template>
  <v-card>
    <v-navigation-drawer
      v-model="drawer"
      :mini-variant.sync="mini"
      permanent
      app
      color="red"
    >
      <v-list-item class="px-2">
        <v-list-item-avatar>
          <v-icon>mdi-account-cog</v-icon>
        </v-list-item-avatar>

        <v-list-item-title>疫情查看</v-list-item-title>

        <v-btn
          icon
          @click.stop="mini = !mini"
        >
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          @click="jump(item.web)"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-icon size="30" class="mr-2">mdi-clock</v-icon>
      <div v-show="!mini">
        {{nowTime}}
      </div>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
  export default {
    data () {
      return {
        drawer: true,
        items: [
          { title: '增加病患', icon: 'mdi-home-city',web:'/Checkin'},
          { title: '查看病患信息', icon: 'mdi-account',web:'/allPatients' },
          { title: '查看药物信息', icon: 'mdi-account-group-outline',web:'/medicine' },
        ],
        mini: true,
        nowTime:new Date()
      }
    },
    methods: {
        jump(web)
        { 
            this.$router.push(web)
        }
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