function registerDriver() {
    const name = document.getElementById("dname").value;
    const email = document.getElementById("demail").value;
    const phone = document.getElementById("dphone").value;
    const cabDetails = document.getElementById("dcab").value;

    fetch('DriverController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `action=register&name=${name}&email=${email}&phone=${phone}&cabDetails=${cabDetails}`
    }).then(res => res.text())
      .then(data => {
        alert("Driver registered!");
        getAllDrivers();
    });
}

function getAllDrivers() {
    fetch('DriverController?action=getAll')
        .then(res => res.json())
        .then(drivers => {
            let list = "<h3>All Drivers</h3><ul>";
            drivers.forEach(d => list += `<li>${d.driverId} - ${d.name} (${d.cabDetails})</li>`);
            document.getElementById("driverList").innerHTML = list + "</ul>";
        });
}

window.onload = getAllDrivers;
