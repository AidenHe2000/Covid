<template>
<v-banner single-line @click:icon="alert">
    <v-icon
      slot="icon"
      color="warning"
      size="36"
    >
      mdi-wifi-strength-alert-outline
    </v-icon>
    友情提醒，您打过疫苗了吗?

    <template v-slot:actions>
      <v-btn
        color="primary"
        text
        @click="alert2()"
      >
        查看中国已接种人数
      </v-btn>
    </template>
  </v-banner>
  <!-- <div :class="$style.Container">
    <div :class="$style.Row">
      <i18n
        :class="$style.Catch"
        tag="p"
        如果被诊断为 阳性 到新冠肺炎专科就诊时
      >
        <span :class="$style.Emphasis" place="advice">
          不需要
        </span>
      </i18n>
    </div>
    <div :class="$style.Row">
      <div :class="[$style.Card, $style.CardLarge, $style.CardGray]">
        <p :class="$style.Outpatient">
          经新冠肺炎专科
        </p>
        <p :class="$style.Judge">
          （海外回国者、与确诊病例密切接触者）
        </p>
        <p :class="$style.Judge">
          医生诊断
        </p>
      </div>
    </div>
    <div :class="$style.TwoRow">
      <div :class="[$style.Card, $style.CardGreen]">
        <p :class="$style.CardGreenText">
          需要检测
        </p>
      </div>
      <div :class="[$style.Card, $style.CardWhite]">
        <p :class="$style.CardWhiteText">
          不需要检测
        </p>
      </div>
    </div>
  </div> -->

</template>

<script>

export default {
    name:'HelloWorld', 
    methods: {
      alert () {
        alert('查看本地接种点网址：http://wenda.bendibao.com/live/2021412/160904.shtm')
      },
      alert2()
      { 
        alert('目前中国已接种超11亿剂次，位居世界第一。')
      }
    },
}
</script>


<style module lang="scss">
.Container {
  // @include card-container();
  display: flex;
  flex-direction: column;
  position: relative;
  padding: 20px 30px !important;
  text-align: center;
}
.Row {
  flex: 1;
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 15px;
}
.Row:last-of-type {
  margin: 0;
}
.TwoRow {
  flex: 1;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.Catch {
  color: gray;
  font-weight: bold;
  margin: 0 !important;
}
.Card {
  flex-basis: 48%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 4px;
  padding: 10px;
  p {
    margin: 0;
  }
}
.CardLarge {
  flex-basis: 100%;
}
.CardGray {
  color: white;
  background-color: gray;
  border: 0.5px solid gray !important;
}
.CardWhite {
  background-color: white;
  border: 2px solid green !important;
  &Text {
    font-size: 22px;
    color: gray;
  }
}
.CardGreen {
  background-color: green;
  &Text {
    color: white;
    font-size: 22px;
  }
}
.Outpatient {
  font-size: 18px;
}
.Judge {
  font-size: 20px;
}
.Emphasis {
  font-size: 28px;
}
</style>
