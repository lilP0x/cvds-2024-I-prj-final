// Function to validate that the value is within the range of 0 to 100
function validateRange(value) {
    return (value >= 0 && value <= 100);
}

// Function to validate the discount field
function validateDiscount() {
    var discount = document.getElementById("discount").value;
    if (!validateRange(discount)) {
        alert("The discount must be between 0 and 100.");
        document.getElementById("discount").value = 0;
    }
}

// Function to validate the taxes field
function validateTaxes() {
    var taxes = document.getElementById("taxes").value;
    if (!validateRange(taxes)) {
        alert("The taxes must be between 0 and 100.");
        document.getElementById("taxes").value = 0;
    }
}

// Assign validation events to the discount and taxes fields
document.getElementById("discount").addEventListener("change", validateDiscount);
document.getElementById("taxes").addEventListener("change", validateTaxes);
