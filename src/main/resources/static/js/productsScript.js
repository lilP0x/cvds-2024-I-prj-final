
function handleClick(platform) {
    if (platform === 'instagram') {
        window.location.href = "https://www.instagram.com/topgearbogota/";
    } else {
        window.location.href = "https://api.whatsapp.com/send/?phone=573153764044&text=Hola+%2ATopGear+Bogot%C3%A1%2A.+Necesito+que+me+ayuden+con+...";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    function formatCurrency(value) {
        return new Intl.NumberFormat('es-CO', { style: 'currency', currency: 'COP' }).format(value);
    }

<<<<<<< HEAD
    // Seleccionar todos los elementos de etiqueta label que muestran el valor del producto
    const valueLabels = document.querySelectorAll('.container_product label');

    // Iterar sobre cada etiqueta de valor y formatear el texto como moneda colombiana
    valueLabels.forEach(label => {
        // Obtener el valor sin formato
        const rawValue = parseFloat(label.textContent.split(':')[1]);

        // Formatear el valor como moneda colombiana
        const formattedValue = formatCurrency(rawValue);

        // Actualizar el texto de la etiqueta con el valor formateado
=======
    const valueLabels = document.querySelectorAll('.container_product label');

    valueLabels.forEach(label => {
        const rawValue = parseFloat(label.textContent.split(':')[1]);

        const formattedValue = formatCurrency(rawValue);

>>>>>>> 606fb7b7e7f3a961531f26e43fc59b3b0c3ea46c
        label.textContent = formattedValue;
    });
});



