
document.addEventListener("DOMContentLoaded", function() {
    function formatCurrency(value) {
        return new Intl.NumberFormat('es-CO', { style: 'currency', currency: 'COP' }).format(value);
    }

    // Seleccionar todos los elementos de etiqueta label que muestran el valor del producto
    const valueLabels = document.querySelectorAll('.container_product label');

    // Iterar sobre cada etiqueta de valor y formatear el texto como moneda colombiana
    valueLabels.forEach(label => {
        // Obtener el valor sin formato
        const rawValue = parseFloat(label.textContent.split(':')[1]);

        // Formatear el valor como moneda colombiana
        const formattedValue = formatCurrency(rawValue);

        // Actualizar el texto de la etiqueta con el valor formateado
        label.textContent = formattedValue;
    });
});
