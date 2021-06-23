<template>
    <v-card>
        
    </v-card>
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