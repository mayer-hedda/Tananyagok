let alma = "Alma";
test(sum);
test(sub);
test(mult);
test(function(a, b){
    return a / b;
});

test((a, b)=>{
    return a / b;
});

//callback function: paraméterként átadott függvény

//console.log(test())
console.log(sum(4, 3))

function test(fuggveny){

    console.log(fuggveny(7, 8))

}

function test2(fuggveny){

    console.log(fuggveny(7, 8))
}

function sum(a, b){
    return a + b;
}

function sub(a, b){
    return a - b;
}

function mult(a, b){
    return a * b;
}

function kattint(){
    console.log("Click")
}

function parameter(){
    console.log(sum(4, 4))
}

let btn = document.getElementById("sumBtn")

btn.onclick = kattint;
btn.onclick = function(){
    console.log(sum(4, 3))
};
btn.onclick = parameter;


console.log(btn)
