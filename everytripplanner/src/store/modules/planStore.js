import { chooseWishList } from "@/api/plan";
import { nearAttractXY } from "@/api/plan";
import Vue from 'vue';

const planStore = {
  namespaced: true,
  state: {
    bcards: {},
    nearAttraction: {},
    startDate: "",
    endDate: "",
    dayDifference: 0,
    stateVisible: false,
    markersV: [],
    planItems: [], // 변경된 부분
    selectedDayNum: null,
  },
  mutations: {
    setSelectedDay(state, day) {
      state.selectedDayNum = day;
      console.log(state.selectedDayNum);
    },
    removePlannerItem(state, { key, index }) {
      if (state.planItems[key] && state.planItems[key][index]) {
        state.planItems[key].splice(index, 1);
      }
      console.log("asdasd", state.planItems);
    },
    setPlannerItem(state, { key, value }) {
      if (!state.planItems[key]) {
        Vue.set(state.planItems, key, []);
      }
      state.planItems[key].push(value);
      console.log("asdasd", state.planItems);
    },
    clearMapState(state) {
      state.markersV = [];
      state.nearAttraction = {};
      state.bcards = {};
      console.log("실행이안되고지랄야야", state.markersV);
    },
    clearDayPlan(state) {
      state.planItems = [];
    },
    setMarkers(state, markers) {
      state.markersV.push(markers);
      console.log(state.markersV);
    },
    setBcards(state, bcards) {
      state.bcards = bcards;
    },
    setNearAttraction(state, nearAttraction) {
      state.nearAttraction = nearAttraction;
    },
    setStartDate(state, date) {
      state.startDate = date;
      console.log(state.startDate);
    },
    setEndDate(state, date) {
      state.endDate = date;
      console.log(state.endDate);
    },
    setDayDifference(state, date) {
      state.dayDifference = date;
    },
    SET_MAP_STATE_VISIBILITY(state, isVisible) {
      state.stateVisible = isVisible;
    },
  },
  actions: {
    choose({ commit }) {
      chooseWishList(
        (data) => {
          console.log(data);
          commit("setBcards", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    nearAttract({ commit }, location) {
      nearAttractXY(
        location,
        (data) => {
          console.log(data);
          console.log("asdsd");
          commit("setNearAttraction", data.data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    toggleMapStateVisibility({ commit, state }) {
      commit('SET_MAP_STATE_VISIBILITY', !state.stateVisible);
      console.log(state.stateVisible);
    },
    addMarker({ commit }, chooseMarker) {
      commit('setMarkers', chooseMarker);
    },
    setPlannerItemMachine({ commit }, { day, value }) {
      commit('setPlannerItem', { key: day, value });
      console.log(day);
      console.log(value);
    }
  },
  getters: {
    getPlannerItemsByDay: (state) => (day) => {
      return state.planItems[day] || [];
    },
  },
}
export default planStore;