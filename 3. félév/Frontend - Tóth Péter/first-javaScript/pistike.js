console.log("Hello world!");

//var, const
let num = 0;
num = "Num";
num = false;


//Number, String, Boolean, 

//Array, HTMLCollection, NodeList (Collection),
/*Object => {
    name = "Pista",
    age = 23
}*/

let a = 0;
let b = "0";

//= -> értékadás

//== -> érték szerint egyenlő ("5" == 5) -> true

//=== -> típus szerint is egyenlő ("5" === 5) -> false
if (a === b) {
    console.log("Egyenlő");
} else {
    console.log("Nem egyenlő");
}

//truthy


//falsy

let alma = 1;
console.log(alma)

if(alma){
    console.log("igaz");
}

//for ciklus

for(let i = 0; i<10; i++){
    console.log(i)
}

let c = 10;

while(c > 0){
    c--;
    console.log(c);
}

do{
    console.log("Mégis lefut")
}while(c > 0)


//Olyan mint Javaban a nem generikus kollekció
let arr = [
    "Alma",
    "Körte",
    "Banán",
    false,
    null,
    1,
    3.14,
    {name: "alma"},
    [1, 2, 3]
];

console.log(arr);

for(let i = 0; i < arr.length; i++){
    console.log(arr[i]);
}


//foreach egy "a" változóval iterál végi a tömbbön
for(let a of arr){
    console.log(a);
}
//foreach egy "i" változóval iterál végi a tömb indexein
for(let i in arr){
    console.log(arr[i]);
}

arr.forEach(element=>{
    console.log(element);
});