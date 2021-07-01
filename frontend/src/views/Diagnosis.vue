<template>
  <v-card :loading="loading">
    <v-card-title>处方信息
    <v-spacer></v-spacer>
    <prescription-creator v-if="editable"
                          :patient-model="patientModel" v-on:change="fetchPrescription"></prescription-creator>
    </v-card-title>
    {{prescriptionItems.length}}
  

    <v-card-text v-if="prescriptionItems.length > 0">该病人当前的正在使用的处方如下：</v-card-text>
    <v-card-text v-else>该病人下暂无处方记录。</v-card-text>

    <v-list dense three-line class="pb-6">
        <template v-for="(item, index) in prescriptionItems">
          <v-list-item>
            <v-list-item-avatar>
              <span class="medicine-avatar rounded">{{item.medicine_name.substring(0,1)}}</span>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title>{{item.medicine_name}}</v-list-item-title>
              <v-list-item-subtitle>{{item.usage + '，' + item.dosage}}</v-list-item-subtitle>
              <v-list-item-subtitle>{{item.manufacturer}}</v-list-item-subtitle>
            </v-list-item-content>
            <v-list-item-action v-if="editable">
              <v-dialog v-model="confirm_dialog[item.prescription_id]" persistent max-width="450">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn icon color="grey" @click="" v-bind="attrs" v-on="on" :disabled="loading"><v-icon>mdi-trash-can</v-icon></v-btn>
                </template>
              </v-dialog>
            </v-list-item-action>
          </v-list-item>
          <v-divider v-if="index + 1 != prescriptionItems.length"></v-divider>
        </template>
      </v-list>

  </v-card>

</template>

<script>
  import axios from 'axios'
  import PrescriptionCreator from '../picker/PrescriptionCreator'

  export default {
    name: 'PrescriptionCard',
    components: { PrescriptionCreator },
    data() {
      return {
        loading: true,
        confirm_dialog: {},
        prescriptionItems: [],
      }
      
    },

    props: {
      patientModel: Object,
      patient_id: Number,
      editable: Boolean
    },

    mounted() {
      this.fetchPrescription();
    },

    methods: {
      fetchPrescription(){
        this.loading = true;
        var that = this;
        axios.get('http://localhost:8181/prescription/getPrescriptionInfoByPatientId',  {
          params: {
            patient_id: 5,
            page:1,
            size:50
          }
        })
          .then(response => {
            that.prescriptionItems = response.data.data;
            
          })
          .catch(error => {
            alert('获取处方失败：无法连接到服务器，刷新重试。\n' + error.message);
          })
          .finally(() => {
            this.loading = false;
          });
      },

    }
  }
</script>

<style scoped>

  .medicine-avatar {
    font-size: 130%;
    font-weight: bold;
    color: white;
    padding: 6px 9px;
    border: #ff8383 10px solid;
    background-color: #ff8383;
    border-radius: 50%;
  }

</style>
