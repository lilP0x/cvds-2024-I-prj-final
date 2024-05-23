
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

    const valueLabels = document.querySelectorAll('.container_product label');

    valueLabels.forEach(label => {
        const rawValue = parseFloat(label.textContent.split(':')[1]);

        const formattedValue = formatCurrency(rawValue);

        label.textContent = formattedValue;
    });
});



