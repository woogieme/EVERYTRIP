import { tripInstance } from "./http.js";

const api = tripInstance();

async function login(user, success, fail) {
    const headers = {
        "Content-type": "application/json",
    };
    await api.post(`/user/login`, JSON.stringify(user), { headers }).then(success).catch(fail);
}

async function findById(userid, success, fail) {
    api.defaults.headers["Content-type"] = "application/json";
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");

    let a = sessionStorage.getItem("access-token");
    console.log(a);
    console.log("asdadsdasadsads");

    console.log(userid);
    await api.get(`/user/info/${userid}`).then(success).catch(fail);
}


//사용자 이미지 파일 가져오기
function getUserImg(userId, success, fail) {
    api.get(`/user/userimage/${userId}`).then(success).catch(fail);
}

export { login, findById, getUserImg };