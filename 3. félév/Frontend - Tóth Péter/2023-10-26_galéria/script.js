
document.addEventListener("DOMContentLoaded", function(){
   let form = document.getElementById("addImgForm")
   form.addEventListener("submit", function(e){
        e.preventDefault()
        console.log(e)

        let urlInput = document.getElementById("imgUrl")
        let altInput = document.getElementById("imgAlt")

        let gallery = document.getElementById("gallery"); 

        let imgElement = document.createElement("img");
        imgElement.src = urlInput.value;
        imgElement.alt = altInput.value;

        let imgBox = document.createElement("div");
        imgBox.className = "img-box";

        imgBox.appendChild(imgElement)
        gallery.appendChild(imgBox)


        let table = document.getElementById("myTable");
        let row = document.createElement("tr");
        table.appendChild(row)
        //let row = table.insertRow(0);

        let  c1 = row.insertCell(0)
        let c2 = row.insertCell(1)
        c1.innerText = urlInput.value;
        c2.innerText = altInput.value;

       //alert("Alert")
   })
    /*let btn = document.getElementById("addBtn");
    btn.addEventListener("click", function(){
        muvelet(sum)
        muvelet(div)
    })*/
})

/*function muvelet(fuggveny){
    console.log(fuggveny() * fuggveny())
}

function sum(){
    console.log(5 + 3)
    return 5 + 3
}
function sub(){
    console.log(5 - 3)
}
function div(){
    console.log(5 / 3)
}*/

/*document.addEventListener("copy", function(e){
    alert("Halo halo, ne másolj légyszi")
    e.preventDefault();
    
})
document.addEventListener("paste", function(e){
    e.preventDefault();
})*/