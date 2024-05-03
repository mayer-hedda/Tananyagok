const tbody = document.getElementById('tbody');

fetch("http://localhost:3000/Rendelesek")
    .then((response) => response.json())
    .then((datas) => {
        // console.log(data);
        datas.map(data => {
            console.log(data);
            tbody.append(fillTable(data.id, data.name, data.date, data.cim, data.fajta, data.mennyiseg));
        })
    })


function fillTable(id, name, date, cim, fajta, mennyiseg) {
    const tr = document.createElement("tr");

    tr.innerHTML = 
    `
    <td class="text-center">${id}</td>
    <td class="text-center">${name}</td>
    <td class="text-center">${date}</td>
    <td class="text-center">${cim}</td>
    <td class="text-center">${fajta}</td>
    <td class="text-center">${mennyiseg}</td>
    `;

    return tr;
}


function submitRendeles() {
    const inputId = document.getElementById('inputId').value;
    const inputName = document.getElementById('inputName').value;
    const inputDate = document.getElementById('inputDate').value;
    const inputCim = document.getElementById('inputCim').value;
    const inputFajta = document.getElementById('inputFajta').value;
    const inputMennyiseg = document.getElementById('inputMennyiseg').value;

    dataToSend = {
        id: inputId,
        name: inputName,
        date: inputDate,
        cim: inputCim,
        fajta: inputFajta,
        mennyiseg: inputMennyiseg
    }


    if(inputId == "") {
        fetch("http://localhost:3000/Rendelesek", {
            method: "POST",
            body: JSON.stringify(dataToSend),
            headers: {
                "Content-type": "application/json"
            }
        })
    } else {
        fetch(`http://localhost:3000/Rendelesek/${inputId}`, {
            method: "PUT",
            body: JSON.stringify(dataToSend),
            headers: {
                "Content-type": "application/json"
            }
        })
    }
}



function deleteRendeles() {
    const id = document.getElementById('inputId').value;

    fetch(`http://localhost:3000/Rendelesek/${id}`, {
        method: "DELETE"
    })
}



const submitBtn = document.getElementById('submitBtn');
const deleteBtn = document.getElementById('deleteBtn');

submitBtn.addEventListener("click", (event) => {
    event.preventDefault();
    submitRendeles();
});
deleteBtn.addEventListener("click", (event) => {
    event.preventDefault();
    deleteRendeles();
})