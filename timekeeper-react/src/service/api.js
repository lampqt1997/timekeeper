import EmployeeList from "../pages/employeeList"
import axios from "axios"

const url ={
    baseUrl: "http://localhost:8080/",
    Employee:"Employee/",
    Position: "Position/",
    Dept:"Dept/",
    Login:"login"
};

const instance = axios.create({
    baseURL: url.baseUrl,
    headers: {"Content-Type": "application/json", "Accept": "application/json"}
});
export default{
    url: url,
    axios: instance,
    get: instance.get,
    post: instance.post,
    put: instance.put,
    delete: instance.delete,
};