/*

fetch(url, {
    method: 'POST' // *GET, POST, PUT, DELETE, etc.
    mode: 'cors' //no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, *same-origin, omit
    headers: {
        'Content-Type': 'application/json'
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    redirect: 'follow', // manual, *follow, error
    referrerPolicy: 'no-referrer', // no-referrer, *client
    body: JSON.stringify(data) // body data type must match "Content-Type" header

})

*/

// a fetch visszaadja egy HTTP választ
// ----- GET -----
// lekérem az adatokat

fetch('https://jsonplaceholder.typicode.com/posts')
    .then((response) => {
        console.log(response);
        return response.json();
    }).then(json => console.log(json));
    //a fetchen belül van egy .json metódus, ami a response
    // body readable streamből kiolvassa a JSONString adatot
    // és elvégzi rajta a JSON.parse() függvényt egyben



// ----- POST -----
// hozzáadok adatokat

var dataToSend = {
    "userId":140,
    "title": "Új Post Cím",
    "body":"szöveg"
}

fetch('https://jsonplaceholder.typicode.com/posts', {
    method: "POST",
    body: JSON.stringify(dataToSend),
    headers: {
        "Content-type": "application/json; charset=UTF-8"
    }
})
.then(response => response.json())
.then(json => console.log(json));



// ----- PUT -----

fetch('https://jsonplaceholder.typicode.com/posts/1', {
    method: 'PUT',
    body: JSON.stringify({
        id: 9,
        title: 'foo',
        body: 'bar',
        userId: 1
    }),
    headers: {
        "Content-type": "application/json; charset=UTF-8"
    }
}).then(response => response.json())
.then(json => console.log(json));



// ----- DELETE -----

fetch('https://jsonplaceholder.typicode.com/posts/1', {
    method: 'DELETE'
}).then(res => console.log("Deleted"))


console.log("Ez lefut várakozástól függetlenül");

fetch('https://reqres.in/api/users/2',{
    method: 'GET'
})
.then(response => {
    return response.json()
})
.then(json => console.log(json.data));