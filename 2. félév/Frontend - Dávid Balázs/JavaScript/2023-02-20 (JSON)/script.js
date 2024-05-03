// JSON: javascript object notation
// nyelvtanilag / alaktanilag / szerkezetileg megegyezik a JS object szerkezettel, ezért nagyon könnyen lehet JSON-t JS object-é alakítani
// csak szöveges üzenetek mennek adatként

var data = 
`{"posts": [
    {
        "posterName": "Sanyi", 
        "postTitle": "Otthoni edzés"
    },
    {
        "posterName": "Géza",
        "postTitle": "Egyszerű receptek"
    },
    {
        "posterName": "Júlia",
        "postTitle": "Főzési tippek"
    }
]
}`


// kiiratom a data változó tartalmát
console.log(data);

// JSON objectummá alakítom a változó tartalmát
console.log(JSON.parse(data));

// kiiratom a JSON objectum "posts" elemének a 0. indexű elemét
objectData = JSON.parse(data);
console.log(objectData.posts[0]);

// végigmegyek a JSON objectum "posts" elemének összes elemén és kiiratom a "posterName"-hez tartozó értékeket
for (let i = 0; i < objectData.posts.length; i++) {
    console.log(objectData.posts[i].posterName);
}



// objectből JSON string
var dog = {
    name: "Rex",
    age: 5,
    breed: "Great Dane",
    sex: "male"
}
console.log(dog);

var JSONString = JSON.stringify(dog);
// így már lehet adatként küldeni
console.log(JSONString);