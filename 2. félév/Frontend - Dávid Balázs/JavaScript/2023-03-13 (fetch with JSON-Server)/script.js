let tbody = document.getElementById('tbody');

fetch("http://localhost:3000/users")
    .then(res => res.json())
    .then(json => {
        console.log(json);
        json.map(data => {
            tbody.append(td_fun(data.id, data.name, data.email, data.status, data.role));
        })
    });



function td_fun(id, name, email, status, role) {
    let td = document.createElement('tr');
    td.innerHTML = 
    `
    <td class="id">${id}</td>
    <td>
        <div class="name">${name}</div>
        <div class="email">${email}</div>
    </td>
    <td class="status">${status}</td>
    <td class="role">${role}</td>
    `;

    return td;
}

function createAndUpdateUser() {
    var inputId = document.getElementById('inputId').value;
    var inputName = document.getElementById('inputName').value;
    var inputEmail = document.getElementById('inputEmail').value;
    var status = document.getElementById('inputStatus');
    var inputStatus = status.options[status.selectedIndex].text;
    var role = document.getElementById('inputRole');
    var inputRole = role.options[role.selectedIndex].text;

    let dataToSend = {
        "name": inputName,
        "email": inputEmail,
        "status": inputStatus,
        "role": inputRole
    }

    if (inputId == '') {
        fetch("http://localhost:3000/users", {
            method: "POST", 
            body: JSON.stringify(dataToSend),
            headers: {
                "content-type": "application/json; charset=UTF-8"
            }
        })
    } else {
        fetch(`http://localhost:3000/users/${inputId}`, {
            method: "PUT",
            body: JSON.stringify(dataToSend),
            headers: {
                "content-type": "application/json; charset=UTF-8"
            }
        })
    }
}

function deleteUser() {
    var inputId = document.getElementById('inputId').value;

    fetch(`http://localhost:3000/users/${inputId}`, {
        method: "DELETE"
    })
}

const submitBtn = document.getElementById('submitBtn');
const deleteBtn = document.getElementById('deleteBtn');

submitBtn.addEventListener("click", function(event) {
    event.preventDefault();
    createAndUpdateUser();
});

deleteBtn.addEventListener("click", function(event) {
    event.preventDefault();
    deleteUser();
});