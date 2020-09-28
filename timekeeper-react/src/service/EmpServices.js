import Api from "./api"

const list=()=>{
    const getlist="list";
    return Api.get(Api.url.Employee+getlist);
};

const detail=id=>{
    const getdetail="details/";
    return Api.get(Api.url.Employee+ getdetail + id);

};
const update=() => {
    const putdata="edit"
    return Api.url.baseUrl + Api.url.Employee + putdata
};


export default{
    list: list,
    detail: detail,
    update: update
};