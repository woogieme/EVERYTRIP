import { tripInstance } from "./http.js";

// const plan = tripInstance();
const api = tripInstance();

function create(location, success, fail) {
  api.post(`/api/v1/plan/create`, JSON.stringify(location)).then(success).catch(fail);
}

function likeregion(success, fail) {
  api.post(`/api/v1/plan/likeregion`).then(success).catch(fail);
}

function realPlanAdd(realPlan, success, fail) {
  api.post(`/api/v1/plan/realPlanAdd`, JSON.stringify(realPlan)).then(success).catch(fail);
}

function planDelete(plan_id, success, fail) {
  api.delete(`/api/v1/plan/planDelete/${plan_id}`).then(success).catch(fail);
}

function addMemeber(plan_name, userId, success, fail) {
  api.get(`/api/v1/plan/addMemeber/${plan_name}/${userId}`).then(success).catch(fail);
}
function chooseWishList(success, fail) {
  console.log("asdas");
  api.get(`/wishList/3`).then(success).catch(fail);
}
function nearAttractXY(location, success, fail) {
  api.post(`/plan/create/`, location).then(success).catch(fail);
}
function userPlan(userId, success, fail) {
  api.get(`/plan/myplanList/${userId}`).then(success).catch(fail);
}

function planDetail(planId, success, fail) {
  api.get(`plan/planDetail/${planId}`).then(success).catch(fail);
}

function joinPlanMember(planId, userAccount, success, fail) {
  api.get(`plan/joinPlanMember/${planId}/${userAccount}`).then(success).catch(fail);
}

function deletePlan_User(planId, ownerUserId, userId, success, fail) {
  api.get(`plan/deletePlan/${planId}/${ownerUserId}/${userId}`).then(success).catch(fail);
}

export {
  create,
  likeregion,
  realPlanAdd,
  planDelete,
  addMemeber,
  chooseWishList,
  nearAttractXY,
  userPlan,
  planDetail,
  joinPlanMember,
  deletePlan_User,
};
