//Megvárjuk, hogy betöltsön az oldal,
//és a js elérjen minden dolgot a DOM-ról
document.addEventListener("DOMContentLoaded", function(){
    
    //alert("Alma")

    let inner = document.getElementById("inner")
    //let append = document.getElementById("append")
    let create = document.getElementById("create")

    //inner.innerHTML = '<p id="alma">Alma</p>';
    let id = "alma";
    inner.innerHTML = `<p id="${id}">${id.toUpperCase()}</p>`;

    //append.append(`<p id="${id}">${id.toUpperCase()}</p>`)

    let ul = document.createElement("ul");
    ul.id = "fruitList";
    ul.className = "lista";
    ul.classList.add("Valami");
    ul.classList.add("alma");

    let img = document.createElement("img");
    img.src = "link";
    img.alt = "kép";

    //ul.innerHTML = "<li>Alma</li><li>Körte</li>";
    let data = ["Alma", "Körte", "Barack", "Szőlő"];

    /*let html = "";
    for(let d of data){
        html += "<li>"+ d + "</li>";
    }
    create.innerHTML = html;*/

    for(let d of data){
        let li = document.createElement("li");
        li.innerText = d;

        ul.appendChild(li)
    }

    create.appendChild(ul) //<ul><li>Alma</li></ul>

    /*let body = document.getElementById("body");
    body.addEventListener("click", function(){
        alert("Click")
    })*/
})


function addFruitToList(){
    //1. Mi volt az input mezőben?
    let fruitName = document.getElementById("fruitInput").value;
    //2. li -> input
    let li = document.createElement("li"); //<li></li>
    li.innerText = fruitName; //<li>Barack</li>

    //3. új lista elem hozzáadása a fruitList
    let fruitList = document.getElementById("fruitList");
    fruitList.appendChild(li);
    //alert("Stop")
    document.getElementById("fruitInput").value = "";
}

//elem lekérés DOM: getElementBy akármi
//elemhez esemény figyelő: addeventListener
//elem létrehozása és DOMhoz adása: createElement
                                    //appendChild