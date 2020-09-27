import Api from "./api"

const login=(data)=>{
    
    return Api.post(Api.url.Login,data);
};



export default{
    login:login
};