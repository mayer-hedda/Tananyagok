var szamlalo = 3;

function insert_Row() {
    var table = document.getElementById('sampleTable');

    var sor = table.insertRow();
    var cella1 = sor.insertCell(0);
    var cella2 = sor.insertCell(1);

    cella1.innerHTML = "Sor" + szamlalo + " cella1";
    cella2.innerHTML = "Sor"+ szamlalo + " cella2";
    
    szamlalo += 1;
}