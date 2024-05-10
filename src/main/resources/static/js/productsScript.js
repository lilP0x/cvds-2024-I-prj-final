
function goToCarrito() {
    window.location.href = "carrito.html";
}

function handleClick(platform) {
    if (platform === 'instagram') {
        window.location.href = "https://www.instagram.com/topgearbogota/";
    } else {
        window.location.href = "https://api.whatsapp.com/send/?phone=573153764044&text=Hola+%2ATopGear+Bogot%C3%A1%2A.+Necesito+que+me+ayuden+con+...";
    }
}

function formatAsCurrency(value) {
    const formatter = new Intl.NumberFormat('en-CO', {
        style: 'currency',
        currency: 'COP'
    });
    return formatter.format(value);
}

function fetchAndDisplayProducts() {
    fetch('/api/products')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('productos-container');

            data.forEach(product => {
                const productContainer = document.createElement('div');
                productContainer.classList.add('container_product');

                if (product.iconUrl) {
                    const productImage = document.createElement('img');
                    productImage.src = product.iconUrl; 
                    productImage.alt = `Imagen de ${product.nombre}`; 
                    productContainer.appendChild(productImage);
                }

                if (product.valor != 0) {
                    const productValue = document.createElement('label');
                    productValue.textContent = formatAsCurrency(product.valor);
                    productContainer.appendChild(productValue);
                }


                const productLink = document.createElement('a');
                productLink.href = `/products/${product.id}`;
                productLink.appendChild(productContainer);

                const productItem = document.createElement('div');
                productItem.classList.add('product_item');
                productItem.appendChild(productLink);
                container.appendChild(productItem);

                const productButton = document.createElement('button');
                productContainer.appendChild(productButton);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
}

// Llamar a la función para cargar y mostrar productos al cargar la página
document.addEventListener('DOMContentLoaded', fetchAndDisplayProducts);


