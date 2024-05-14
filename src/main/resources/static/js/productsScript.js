
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
                // Crear el contenedor del producto
                const productContainer = document.createElement('div');
                productContainer.classList.add('container_product');

                if (product.nombre) {
                    const productName = document.createElement('h2');
                    productName.textContent = product.nombre;
                    productContainer.appendChild(productName);
                }


                if (product.iconUrl) {
                    const productImage = document.createElement('img');
                    productImage.src = product.iconUrl; 
                    productImage.alt = `Imagen de ${product.nombre}`; 
                    productContainer.appendChild(productImage);
                }

                // Crear el precio del producto si existe
                if (product.valor != 0) {
                    const productValue = document.createElement('label');
                    productValue.textContent = formatAsCurrency(product.valor);
                    productContainer.appendChild(productValue);
                }

                // Crear el contenedor adicional para la imagen y el precio
                const productInfoContainer = document.createElement('div');
                productInfoContainer.classList.add('product_info_container');
                productInfoContainer.appendChild(productContainer);

        
                

                // Crear un enlace para envolver el contenedor adicional
                const productLink = document.createElement('a');
                productLink.href = `/products/${product.id}`; // Reemplaza con la URL adecuada
                productInfoContainer.appendChild(productLink);
                productLink.appendChild(productContainer);

                const productButton = document.createElement('button');
                productButton.textContent = 'Añadir al carrito'; // Personaliza el texto del botón aquí
                productButton.classList.add('product_button');
                productButton.addEventListener('click', (event) => {
                    window.location.href = '/otra_pagina.html'; // Reemplaza con la URL adecuada
                });
                productInfoContainer.appendChild(productButton);
                
                // Agregar el producto al contenedor principal de productos
                container.appendChild(productInfoContainer);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
}




// Llamar a la función para cargar y mostrar productos al cargar la página
document.addEventListener('DOMContentLoaded', fetchAndDisplayProducts);


