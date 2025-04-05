function registerUser() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    fetch('UserController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `action=register&name=${encodeURIComponent(name)}&email=${encodeURIComponent(email)}&phone=${encodeURIComponent(phone)}`
    })
    .then(response => response.text())
    .then(data => {
        alert("User Registered Successfully!");
        getAllUsers(); // Refresh list after registration
    })
    .catch(error => {
        console.error("Error registering user:", error);
        alert("Registration failed!");
    });
}

function getAllUsers() {
    fetch('UserController?action=getAll')
        .then(response => response.json())
        .then(users => {
            let userList = document.getElementById("userList");
            userList.innerHTML = "<h3>Registered Users</h3><ul>";
            users.forEach(user => {
                userList.innerHTML += `<li>${user.userId} - ${user.name} (${user.email}, ${user.phone})</li>`;
            });
            userList.innerHTML += "</ul>";
        })
        .catch(error => {
            console.error("Error fetching users:", error);
        });
}

// Load users on page load
window.onload = getAllUsers;
