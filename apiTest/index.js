const axios = require('axios');

axios.get("http://mangamanagerapi:8080/mangas").then(d =>{
    console.log(d.data);
})

axios.post("http://mangamanagerapi:8080/mangas",{title: "test", author: "1test1", year: 2004, status: "ONGOING"}).then(d =>{
    console.log(d.data);
})

axios.get("http://mangamanagerapi:8080/mangas").then(d =>{
    console.log(d.data);
})