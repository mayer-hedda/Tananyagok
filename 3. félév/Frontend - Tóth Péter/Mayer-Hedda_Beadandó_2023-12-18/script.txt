class Beer {
    constructor(id, name, tagline, description, ibu, malt, image_url) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.ibu = ibu;
        this.malt = malt;
        this.image_url = image_url;
    }
}

let beersData = [];

fetch('https://api.punkapi.com/v2/beers')
    .then(response => response.json())
    .then(data => {
        beersData = data.map(beer => new Beer(
            beer.id,
            beer.name,
            beer.tagline,
            beer.description,
            beer.ibu,
            beer.ingredients.malt,
            beer.image_url
        ));
        populateSelect();
    })
    .catch(error => console.error('Hiba:', error));

function populateSelect() {
    const beerName = document.getElementById('beerName');
    const defaultOption = document.createElement('option');
    defaultOption.text = 'Válasszon egy sört az alábbiak közül';
    beerName.add(defaultOption);

    beersData.forEach(beer => {
        const option = document.createElement('option');
        option.value = beer.id;
        option.text = beer.name;
        beerName.add(option);
    });

    beerName.addEventListener('change', function () {
        const selectedBeerId = beerName.value;
        const selectedBeer = beersData.find(beer => beer.id == selectedBeerId);

        if (selectedBeer) {
            refreshedPage(selectedBeer);
        }
    });
}

function refreshedPage(selectedBeer) {
    const mainContent = document.querySelector('.main-content');
    const beerInfo = document.querySelector('.beerInfo');
    const beerDetails = document.querySelector('.beerDetails');
    const taglineInput = document.getElementById('tagline');
    const descriptionParagraph = document.getElementById('description');
    const malata = document.getElementById('malata');
    const beerImage = document.getElementById('beerImg_url');
    const ibuProgress = document.getElementById('progressBar');

    mainContent.style.display = 'block';
    beerInfo.removeAttribute('disabled');
    beerDetails.removeAttribute('disabled');

    taglineInput.value = selectedBeer.tagline;
    descriptionParagraph.textContent = selectedBeer.description;

    const existingRows = malata.querySelectorAll('tbody tr:not(:first-child)');
    existingRows.forEach(row => row.remove());

    selectedBeer.malt.forEach(malt => {
        const row = malata.querySelector('tbody').insertRow();
        row.insertCell(0).textContent = malt.name;
        row.insertCell(1).textContent = `${malt.amount.value}`;
        row.insertCell(2).textContent = `${malt.amount.unit}`;
    });

    beerImage.src = selectedBeer.image_url;
    ibuProgress.value = selectedBeer.ibu;
}
