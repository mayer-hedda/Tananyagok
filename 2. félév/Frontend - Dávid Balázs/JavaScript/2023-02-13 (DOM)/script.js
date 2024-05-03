// JS: programozás + DOM manipuláció
    /* DOM: html struktúrált megjelenítése
            embereknek szól, nem a számítógépnek
            html tag-eket, azok tartalmát, tulajdonságait és relációit tartalmazza 
            böngésző oldal betöltéskor elkészíti a Document-et
            ezen tudunk mi mindenféle műveletet elvégezni*/



// document vizsgálata
var doc = document;

// document-nek a tulajdonságai, metódusai
doc = document.all;
doc = document.all.length;
doc = document.all[17];
doc = document.all[17].textContent;

// ugyanígy lehet document .head / doctype / domaint / characterSet
doc = document.URL;
doc = document.forms;





// DOM szelektor metódusok, egyszerűbb, egyértelműbb kiválasztásért
var element;

element = document.getElementsByTagName('h1');
element = document.getElementById('input-form');
element = document.getElementsByClassName('list-group-item');

// CSS szelektorok szerint
element = document.querySelector('#input-form');
element = document.querySelector('.p-3');
element = document.querySelectorAll('.p-3');
element = document.querySelectorAll('ul li');
element = document.querySelectorAll('li:nth-child(odd)');





// DOM elemek módosítása

// tartalom módosítása
element = document.getElementById('list-title');

// csak a szöveget, ahogy megjelenne
element.innerText = 'Hello <br> Lista';  // benne marad szövegként a <br>
element.innerHTML = 'Hello <br> Lista';  // megtöri a sort

// console.log(document.getElementById('list-wrapper').innerText);

// elem tulajdonságok megtekintése / módosítása (tulajdonságok = attributes)
element = document.querySelector('li:first-child');
console.log(element.id);

element.id = 'first-list-item';
console.log(element.id);

element.className = 'p-3';

console.log(element.style);
element.style.color = 'red';
element.style.margin = '100px 50px 0 0';
// element.style.display = 'none';

// több elem stílusának változtatása egyszerre
var listItem = document.querySelectorAll('li');

for (let i = 0; i < listItem.length; i++) {
    listItem[i].style.color = 'red';
}





// Mozgás a DOM-ban 
// eddig "abszolút" kiválasztás volt, de lehet ezt "relatív" módon is végezni
element = document.getElementsByTagName('ul')[0];

// gyermekelemek kiválasztása
var child = element.childNodes;
child = element.childNodes[1].childNodes;

child = element.children;
child = element.children[2].innerHTML;

// amíg van további gyermek, addig egymásba is lehet füzögetni
// ezen kívül a leggyakoribbak
console.log('NODE:');
child = element.firstChild;  // node!
console.log(child);

console.log('ELEMENT:');
child = element.firstElementChild;  // element
console.log(child);


var inp = document.getElementById('input');

console.log(inp);