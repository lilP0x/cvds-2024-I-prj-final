
document.addEventListener("DOMContentLoaded", function() {
    function formatCurrency(value) {
        return new Intl.NumberFormat('es-CO', { style: 'currency', currency: 'COP' }).format(value);
    }

    // Seleccionar todos los elementos de etiqueta label que muestran el valor del producto
    const valueLabels = document.querySelectorAll('.login-box label');

    valueLabels.forEach(label => {
        const rawValue = parseFloat(label.textContent.split(':')[1]);

        const formattedValue = formatCurrency(rawValue);

        label.textContent = formattedValue;
    });
});