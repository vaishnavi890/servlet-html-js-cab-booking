function bookRide() {
    const uid = document.getElementById("userId").value;
    const did = document.getElementById("driverId").value;
    const pickup = document.getElementById("pickup").value;
    const dropoff = document.getElementById("dropoff").value;

    fetch('RideController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `action=book&userId=${uid}&driverId=${did}&pickup=${pickup}&dropoff=${dropoff}`
    }).then(res => res.text())
      .then(() => {
        alert("Ride booked!");
        getAllRides();
    });
}

function getAllRides() {
    fetch('RideController?action=getAll')
        .then(res => res.json())
        .then(rides => {
            let list = "<h3>All Rides</h3><ul>";
            rides.forEach(r => list += `<li>Ride ${r.rideId}: ${r.pickupLocation} → ${r.dropoffLocation}</li>`);
            document.getElementById("rideList").innerHTML = list + "</ul>";
        });
}

window.onload = getAllRides;
