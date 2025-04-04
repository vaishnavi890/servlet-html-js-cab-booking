function makePayment() {
    const uid = document.getElementById("puserId").value;
    const rid = document.getElementById("prideId").value;
    const amount = document.getElementById("amount").value;
    const method = document.getElementById("method").value;

    fetch('PaymentController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `action=pay&userId=${uid}&rideId=${rid}&amount=${amount}&method=${method}`
    }).then(res => res.text())
      .then(() => {
        alert("Payment successful!");
        getAllPayments();
    });
}

function getAllPayments() {
    fetch('PaymentController?action=getAll')
        .then(res => res.json())
        .then(payments => {
            let list = "<h3>Payment History</h3><ul>";
            payments.forEach(p => list += `<li>${p.paymentId}: ₹${p.amount} via ${p.paymentMethod}</li>`);
            document.getElementById("paymentList").innerHTML = list + "</ul>";
        });
}

window.onload = getAllPayments;
