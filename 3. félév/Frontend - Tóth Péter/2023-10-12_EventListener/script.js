let obj = {
    name: "Alma",
    count: 10,
    available: true
}

//Java
/*class Fruit{
    public String name;
    public int count;

    Fruit(name){
        name = name;
    }

    public sell(){

    }
}

Fruit alma = new Fruit("alma", 10, true)*/

//Osztály példányosítás
let now = new Date();
console.log(now.toLocaleDateString())

console.log(now.toDateString())
console.log(now.toTimeString())


//Construktor függvény
function Fruit(name, count, available){
    this.name = name;
    this.count = count;
    this.available = available;
}

let fruits = [
    new Fruit("Körte", 5, true),
    new Fruit("Narancs", 0, false)
]

console.log(fruits[0].name)
console.log(fruits[1].name)
console.log(fruits[0].count)
console.log(fruits[1])

/*let obj = {
    name: "Alma",
    count: 10,
    available: true
}*/

let text = document.getElementById("text");

//Callback function: Olyan függvény, ami paraméterként lett átadva egy másik függvény
text.addEventListener("click", kattint);
text.addEventListener("copy", function(event){

    //this == event.target
    console.log("This", this) //A html elem, amin az esemény történt
    console.log("Event",event)
    console.log("Másolás")
});
text.addEventListener("cut", (event)=>{

    //Az arrow function nem lehet construnktor function

    console.log("This", this) //Globalis This
    console.log("Event", event)
    console.log("Kivágás")
});

//Global This, "Az alkalmazás éppen aktuális példánya"
console.log("Global", this)

let keret = document.getElementById("keret")
keret.addEventListener("mouseenter", function(){
    console.log("Belép")
}) 
keret.addEventListener("mouseleave", function(){
    console.log("Kilép")
}) 
keret.addEventListener("mouseover", function(){
    console.log("Fölötte")
}) 
keret.addEventListener("", function(){
    console.log("Kint")
}) 
function kattint(){
    console.log("Click")
}
