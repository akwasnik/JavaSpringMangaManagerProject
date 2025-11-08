const axios = require('axios');

axios.get("https://localhost:8080").then(d =>{
    console.log(d.data);
})

axios.post("https://localhost:8080",{title: "test", author: "1test1", year: 2004, status: "ONGOING"}).then(d =>{
    console.log(d.data);
})

axios.get("https://localhost:8080").then(d =>{
    console.log(d.data);
})