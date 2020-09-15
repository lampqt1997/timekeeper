import Login from "./pages/login";
import NotFound from "./pages/404"
import Checkin from "./pages/Components/checkin";
const { default: MainPage } = require("./pages/Components");
const { default: Employee } = require("./pages/Components/employees");

const route=[
    {path:"/404", exact: true, name: "Not Found", component: NotFound},
    {path:"/Login", exact: true, name: "Login", component: Login},
    {path:"/", exact: true, name: "Home", component: MainPage},
    {path:"/Index/Employees", exact: true, name: "Employees", component: Employee},
    {path:"/Index/Checkin", exact: true, name: "Checkin", component: Checkin}
]
export default route