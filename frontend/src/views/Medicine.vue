<template>
    <div>
        <!-- <v-container fluid>
            <v-row align="center">
            <v-col class="d-flex" cols="12" sm="6">
                <v-select :items="manufacturers" label="生产厂商" v-model="manufacturer"></v-select>
            </v-col>

            <v-col class="d-flex" cols="12" sm="6">
                <v-select :items="types" label="药物种类" v-model="type"></v-select>
            </v-col>
            
            </v-row>
        </v-container> -->
        生产厂家
        <select v-model="manufacturer" style="background-color:grey">
            <option>任意</option>
            <option>白云</option>
            <option>葵花</option>
            <option>何氏</option>
            <option>徐氏</option>
            <option>周氏</option>
            <option>康泰克</option>
            <option>泰诺</option>
        </select>

        药物种类
        <select v-model="type" style="background-color:grey">
            <option>任意</option>
            <option>中药</option>
            <option>西药</option>
        </select>
        
        <v-form>
            <v-container>
            <v-row>
                <v-col cols="12" sm="6">
                    <v-text-field label="药名" outlined shaped v-model="name">
                        <input type="text" id="name">
                    </v-text-field>
                </v-col>

                <v-col cols="12" sm="6">
                    <v-text-field label="药物介绍" outlined shaped v-model="introduction">
                        <input type="text" id="introduction">
                    </v-text-field>
                </v-col>
                
                <v-col cols="12" sm="6">
                    <v-text-field label="显示页数" outlined shaped v-model="pg">
                        <input type="text" id="page">
                    </v-text-field>
                </v-col>

                <v-col cols="12" sm="6">
                    <v-text-field label="显示记录数" outlined shaped v-model="len">
                        <input type="text" id="SIZE">
                    </v-text-field>
                </v-col>
            </v-row>
            </v-container>
        </v-form>
        
         
        <!-- <input type="button" value="search" @click="search()" append-icon="mdi-magnify" label="Search"><br> -->
        <v-btn @click="search()">SEARCH
            <v-icon>mdi-magnify</v-icon>
        </v-btn>

        <v-card>
            <v-card-title>
            <!-- <v-text-field v-model="srh" append-icon="mdi-magnify" label="Search" 
                single-line hide-details>
            </v-text-field> -->
            </v-card-title>
            <v-data-table :headers="headers" :items="medicine"></v-data-table>
        </v-card>
        
    </div>
</template>

<script>
export default {
    name:"Medicine",
    data()
    {
        return {
            srh: '',
            headers: [
                {
                    text: 'id',
                    align: 'start',
                    filterable: false,
                    value: 'medicine_id',
                },
                { text: '药物名称', value: 'medicine_name' },
                { text: '生产厂商', value: 'manufacturer' },
                { text: '药物介绍', value: 'introduction' },
                { text: '药物类型', value: 'type' },
                
            ],
            manufacturers: ['任意','白云','葵花','何氏','徐氏','周氏','康泰克','泰诺'],
            types:['任意','中药','西药'],
            

            pg:1,
            len:84,
            name:"",
            manufacturer:"",
            introduction:"",
            type:"",
            medicine:[]
        }
    },
    
    created()
    {
        const that = this;
        
        axios.get("http://localhost:8181/medicine/getMedicineInfo",{params:{page:that.pg,size:that.len}}).
        then(function(res)
        {
            that.medicine=res.data.data;
        })
    },
    methods:
    {
        search()
        {
            const that = this;
            console.log(that.name);
            console.log(that.manufacturer);
            console.log(that.pg);
            console.log(that.type);
            console.log(that.introduction);
            console.log(that.len);

            if(that.name=="任意")
                that.name=null;
            
            if(that.manufacturer=="任意")
                that.manufacturer=null;

            if(that.introduction=="任意")
                that.introduction=null;

            if(that.type=="任意")
                that.type=null;

            axios.get("http://localhost:8181/medicine/getMedicineInfo",{params:{name:that.name,manufacturer:that.manufacturer,introduction:that.introduction,type:that.type,page:this.pg,size:this.len}}).
            then(function(res)
            {
                that.medicine=res.data.data;
            })
        },
    }
    
}
</script>



<style>
</style>