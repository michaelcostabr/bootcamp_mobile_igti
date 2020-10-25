import axios from "axios"

export default axios.create({
    baseURL: "http://f9cc75eb50a9.ngrok.io",
    headers:{
        Authorization:"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im1pY2hhZWxiaEBnbWFpbC5jb20iLCJwYXNzd29yZCI6IjEyMzQ1IiwiaWF0IjoxNjAzNjMxMzcwLCJleHAiOjE2MDM2NDkzNzB9.jZxAyjuc5BBYMub-zB3Cgfs41KZNiMJ_qO5eDMNeK5o"
    }
});