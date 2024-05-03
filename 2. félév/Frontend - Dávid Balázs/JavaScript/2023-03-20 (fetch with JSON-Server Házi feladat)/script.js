const tbody = document.getElementById('tbody');

fetch("http://localhost:3000/setup", {
    method: "GET"
})
.then((response) => response.json())
.then((datas) => {
    // console.log(datas);
    datas.map(data => {
        console.log(data);
        tbody.append(fillTable(data.id, data.name, data.cpu, data.ram, data.gpu, data.price, data.stock));
    })
})


function fillTable (id, name, cpu, ram, gpu, price, stock) {
    const tr = document.createElement("tr");

    if (stock == true) {
        tr.innerHTML = 
        `
        <td class="text-center">${id}</td>
        <td class="text-center">${name}</td>
        <td class="text-center">${cpu}</td>
        <td class="text-center">${ram}</td>
        <td class="text-center">${gpu}</td>
        <td class="text-center">${price}</td>
        <td class="text-center">On Stock</td>
        `;
    } else {
        tr.innerHTML = 
        `
        <td class="text-center">${id}</td>
        <td class="text-center">${name}</td>
        <td class="text-center">${cpu}</td>
        <td class="text-center">${ram}</td>
        <td class="text-center">${gpu}</td>
        <td class="text-center">${price}</td>
        <td class="text-center">Out of Stock</td>
        `;
    }

    return tr;
}


function insertSetup () {
    const inputId = document.getElementById('inputId').value;
    const inputName = document.getElementById('inputName').value;
    const inputCpu = document.getElementById('inputCpu').value;
    const inputRam = document.getElementById('inputRam').value;
    const inputGpu = document.getElementById('inputGpu').value;
    const inputPrice = document.getElementById('inputPrice').value;
    const inputStock = document.getElementById('inputStock').value;

    const dataToSend = {
        id: inputId,
        name: inputName,
        cpu: inputCpu,
        ram: inputRam,
        gpu: inputGpu,
        price: inputPrice,
        stock: inputStock
    }

    if (inputId == "") {
        fetch("http://localhost:3000/setup", {
            method: "POST",
            body: JSON.stringify(dataToSend),
            headers: {
                "Content-type": "application/json"
            }
        })
    } else {
        fetch(`http://localhost:3000/setup/${inputId}`, {
            method: "PUT",
            body: JSON.stringify(dataToSend),
            headers: {
                "Content-type": "application/json"
            }
        })
    }
}


function deleteSetup () {
    const id = document.getElementById('inputId').value;

    fetch(`http://localhost:3000/setup/${id}`, {
        method: "DELETE",
    })
}


const submitBtn = document.getElementById("submitBtn");
const deleteBtn = document.getElementById("deleteBtn");

submitBtn.addEventListener("click", (event) => {
    event.preventDefault();
    insertSetup();
})

deleteBtn.addEventListener("click", (event) => {
    event.preventDefault();
    deleteSetup();
})