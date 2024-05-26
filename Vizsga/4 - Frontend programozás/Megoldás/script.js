document.addEventListener("DOMContentLoaded", function(){
    
    fetch('https://dummyjson.com/products')
    .then(res => res.json())
    .then(data => loadTable(data.products));

    document.getElementById("searchBtn").addEventListener("click", search)
    document.getElementById("close").addEventListener("click", closeModal)
})

function openModal(){
    $("#modal").show();
}

function closeModal(){
    $("#modal").hide();
}

function loadTable(data){
    let tbody = document.getElementById("products").getElementsByTagName('tbody')[0];
    tbody.innerHTML = "";

    for(let row of data){
        let newRow = tbody.insertRow();

        newRow.insertCell().innerHTML = row.id;
        newRow.insertCell().innerHTML = row.title;
        newRow.insertCell().innerHTML = row.price;
        newRow.insertCell().innerHTML = row.stock;

        newRow.addEventListener("click", function(){
            fetch(`https://dummyjson.com/products/${row.id}`)
            .then(res => res.json())
            .then(data=>{
                document.getElementById("description").innerText = data.description;
                openModal();
            });
        })
    }
}

function search(){
    let text = document.getElementById("searchText").value;
    fetch(`https://dummyjson.com/products/search?q=${text}`)
    .then(res => res.json())
    .then(data => loadTable(data.products));
}