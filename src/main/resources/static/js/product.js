function formatAsCurrency(value) {
    const formatter = new Intl.NumberFormat('en-CO', {
        style: 'currency',
        currency: 'COP'
    });
    return formatter.format(value);
}


// Función para obtener el valor de un parámetro específico en la URL
function getProductIdFromPath() {
    const path = window.location.pathname; // Obtiene la ruta actual
    const pathParts = path.split('/'); 
    return pathParts[pathParts.length - 1];
}


const productId = getProductIdFromPath();

console.log(productId)

// Función para obtener información de un producto específico
function fetchProductDetails(productId) {
    fetch(`/api/products/${productId}`) 
        .then(response => response.json())
        .then(product => {
            displayProductDetails(product);
        })
        .catch(error => console.error('Error fetching product details:', error));
}

// Llama a la función para obtener detalles del producto al cargar la página
document.addEventListener('DOMContentLoaded', () => {
    
    if (productId) { // Solo busca detalles si hay un ID en la URL
        fetchProductDetails(productId);
    } else {
        console.error('No product ID found in URL');
    }
});


// Función para mostrar los detalles del producto en el DOM
function displayProductDetails(product) {
    const productContainer = document.getElementById('product-details'); // Contenedor donde se mostrarán los detalles del producto

    // Añadir información del producto
    const productName = document.createElement('h2');
    productName.textContent = product.nombre; 
    productContainer.appendChild(productName);
    
    console.log(product.iconUrl);
    if (product.iconUrl) {
        const productImage = document.createElement('img');
        productImage.src = '/static/'+ product.iconUrl; 
        productImage.alt = `Imagen de ${product.nombre}`; 
        productContainer.appendChild(productImage);
    }

    if (product.valor) {
        const productPrice = document.createElement('p'); 
        productPrice.textContent = formatAsCurrency(product.valor); 
        productContainer.appendChild(productPrice);
    }

    if (product.descripcion) {
        const productDescription = document.createElement('p'); // Descripción del producto
        productDescription.textContent = product.descripcion; // Establece la descripción del producto
        productContainer.appendChild(productDescription);
    }
}