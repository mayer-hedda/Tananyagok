document.addEventListener("DOMContentLoaded", function(){

    window.fetch("https://swapi.dev/api/people", {
        method:"GET"
    }).then(res=>{
        res.json().then(data=>{
            console.log(data)
        })
    })
    .catch(err=>{
        console.error(err)
    }) 

    fetch("https://swapi.dev/api/people")
    .then(res=>res.json())
    .then(data=>console.log(data))

    //fetch
    /*return new Promise((alma, error)=>{
        alma("Alma")

        error("Error")
    })*/

    /*fetch("myWebServer.hu/user/login", {
        method: "POST",
        body:{
            username: "petertoth406",
            password: "Alma123"
        }
    })*/
})