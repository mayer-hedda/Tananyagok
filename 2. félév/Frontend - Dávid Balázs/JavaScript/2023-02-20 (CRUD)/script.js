const form = document.getElementById('input-form');
const inputFields = document.getElementsByTagName('input');
const tableBody = document.getElementById('tbody');

tableBody.addEventListener('click', deleteRow);

function deleteRow(e) {
    console.log(e.target.classList);

    if (e.target.classList.contains('delete')) {
        e.target.parentElement.parentElement.remove();
    }
}


const submitBtn = document.getElementById('submit-button');

submitBtn.addEventListener('click', function(event) {
    event.preventDefault();
    let newRow = document.createElement('tr');
    newRow.setAttribute('scope', 'row');

    for (let i = 0; i < inputFields.length; i++) {
        let newTd = document.createElement('td');
        let tdText = document.createTextNode(inputFields[i].value);
        newTd.appendChild(tdText);
        console.log(inputFields[i].value);
        newRow.appendChild(newTd);
    }
    
    let delBtnTd = document.createElement('td');
    delBtnTd.innerHTML = '<button class="delete btn btn-primary">X</button>';
    newRow.appendChild(delBtnTd);
    tableBody.appendChild(newRow);
});