<template>
    <div>
        <show-plan-list id="planList" :card="card"></show-plan-list>
        <showMapViewVue id="map" @lat="lat" @lng="lng"></showMapViewVue>
        <show-attraction-list id="list" @mom="goto" :latitude="latitude" :longitude="longitude"></show-attraction-list>
        
        <!-- //<router-view></router-view> -->
    </div>
</template>

<script>
import showPlanList from "@/components/Plan/showPlanList.vue";
import showMapViewVue from "@/components/Plan/showMapView.vue";
import showAttractionList from "@/components/Plan/showAttractionList.vue";
export default {
    components: {
        showMapViewVue,
        showAttractionList,
        showPlanList
    },
    data() {
        return {
            message: '',
            card:[],
            latitude:0,
            longitude:0,
        };
    },
    created() {},
    methods: {
        goto(child){
            if(!this.card.includes(child)){
                this.card.push(child);
            }
        },
        lat(data){
            console.log(data);
            this.latitude=data;
        },
        lng(data){
            console.log(data);
            this.longitude=data;
        },
    },
};
</script>

<style scoped>
div {
  width: 100%;
  height: 1000px;
  border: 1px solid #000;
  overflow: hidden;
}
#planList{
    width:15%;
    float: left;
    box-sizing: border-box;
}
#map{
    width:70%;
    float: left;
    box-sizing: border-box;
}

#list{
    width: 15%;
    float: right;
    box-sizing: border-box;
}

</style>