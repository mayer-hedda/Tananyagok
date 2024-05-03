// Angular fetch-et használ, fetch promise-t használ, a promise meg aszinkronos

// ----- SZINKRONOSSÁG -----
var data = ["eredeti érték"];
// console.log(data);

// function createData() {
//     data = [1, 2, 3, 4];
//     console.log("createData-ból: " + data);
// }

// function printData() {
//     console.log("printData-ból: " + data);
// }


// // Először lefut a createData(), aztán a printData()
// createData();
// printData();
// Output:  createData-ból: 1, 2, 3, 4
//          printData-ból: 1, 2, 3, 4





// ----- ASZINKRONOSSÁG -----
// function createData() {
//     setTimeout(function() {
//         data = [1, 2, 3, 4];
//         console.log("createData-ból: " + data);
//     }, 2000);
// }

// function printData() {
//     console.log("printData-ból: " + data);
// }


// // előbb fut le a printData(), majd 2 mp-el később a createData, ezért a printData()-nál még nem változtattuk meg a data értékét
// createData();
// printData();
// // Output:  printData-ból: eredeti érték
// //          createData-ból: 1, 2, 3, 4

// NEM így van, de így el lehet képzelni:
    // Ha nem tudja előre, hogy sokáig fog tartani, akkor vár rá
    // Ha előre tudja, akkor nem vár rá
    // amikből lehet tudni, hogy sokáig fog tartani: setTimeout(), setInterval(), async()

// aszinkronos: callback, promises, async/await
// promises: megígéri, hogy valami törénik, ha valami más véget ér





function createData() {
    return new Promise(function(keszVan, nemSikerult) {

        setTimeout(function() {
            data = [1, 2, 3, 4];
            console.log("setTimeout-ból: "+ data);
            if (true) {
                keszVan();
            } else {
                nemSikerult("Baj van!");
            }
        }, 2000);
    })
}

function printData() {
    console.log("printData-ból promise-szal: " + data);
}


createData().then(printData).catch(e => console.log(e));
// Output:  setTimeout-ból: 1, 2, 3, 4
//          printData-ból promise-szal: 1, 2, 3, 4



// arrow function-t megnézni otthon!!!