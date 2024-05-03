async function keres(){
    await setTimeout(function(){
        console.log("2 sec");
    }, 2000);
}

document.addEventListener("DOMContentLoaded", ()=>{
    pelda();

    for(let p of document.getElementsByTagName("p")){
        p.addEventListener("click", function(){
            console.log(this)
        })
    }

    console.log(this)

    nagyBonyolultSzamitasPromise(123, 456)
    .then(res=>{
        console.log("Eredmény:" , res)
    })
    .catch(err => {
        console.error(err)
    })

    //JavaScript Object Notation
    let kintVan = "";
    fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(response => response.json())
      .then(json=>{console.log(json)})

    console.log(kintVan)

    let obj = {
        "kulcs" : "1",
        "age": "13",
        "name" : "Péter",
    }

    let jsObj = {
        kulcs : 1,
        name : "Péter",
        age: "13"
    }

    console.log(obj.name)

})

async function pelda(){

    console.log(5 + 8);
    console.log(5 * 8);

    await keres();

    console.log("Ennek csak a kérés után kell látszania");

    console.log(nagyBonyolultSzamitas(20, 30))
}


function nagyBonyolultSzamitas(a, b){
    let res = setTimeout(function(){
        logger(a*b)
        //return a * b;
    }, 2000);

    return res;
}

function logger(data){
    console.log(data)
}

function nagyBonyolultSzamitasPromise(a, b){

    /*return new Promise((barmi, akarmi)=>{

    })*/
    return new Promise((resolve, reject)=>{
        /*"10 usert" <- {username: "Pista", grades: []} resolve()
        "10 usert" <- "Nincs ilyen user" reject()
        "10 usert" <- 404 reject()*/

        setTimeout(function(){
            let elvegezheto = false;

            if(elvegezheto){
                let res = a * b;
                resolve(res);
            }else{
                reject("Nem tudom elvégezni")
            }           

        }, 2000);

    })


    /*let res = setTimeout(function(){
        return a * b;
    }, 2000);

    return res;*/
}