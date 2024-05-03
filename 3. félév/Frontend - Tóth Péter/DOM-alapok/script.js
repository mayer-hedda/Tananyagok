console.log("Működök!")

//document -> DOM

//Id alapján kéri le

//Az alcim változó az egy object
let alcim = document.getElementById("alcim");

//innerText = Az elemen belül található szöveg
alcim.innerText = "<i>Ez itt most dőlt</i>"

//innerHTML = Az elemen belüli HTML-t éri el
alcim.innerHTML = "<i>Ez itt most dőlt</i>"


console.log(alcim.innerText);

//A lista egy HTMLCollection, hasonlít egy tömbbre
let lista = document.getElementsByClassName("lista")
console.log(lista)
console.log(lista[0])

//lista[1].innerHTML = "<p>Alma</p>";

//A lista egy HTMLCollection, hasonlít egy tömbbre
let uls = document.getElementsByTagName("ul")
console.log(uls)

//CSS hivatkozás alapján

//document.querySelector -> csak 1 dolgot tud vissza adni,
//általában a legelsőt

let id = document.querySelector("#alcim");
let className = document.querySelector(".lista");

console.log(id, "Alma", "Körte");

console.log(className);

//document.querySelectorAll -> több elemet is vissza tud adni,
let classNames = document.querySelectorAll("#alcim")
console.log(classNames)


//getElementById
//getElementsByClassName
//getElementsByTagName
//getElementsByName
//querySelector
//querySelectorAll

let elsoLista = document.getElementById("elsoLista")
console.log(elsoLista.children[0].children[0].children)
console.log(elsoLista.parentNode.parentNode.children[0])

elsoLista.children[0].children[2].innerText = "Krumpli"