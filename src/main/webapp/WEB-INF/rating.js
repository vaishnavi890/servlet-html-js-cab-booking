function rateDriver() {
    const uid = document.getElementById("ruserId").value;
    const did = document.getElementById("rdriverId").value;
    const rid = document.getElementById("rrideId").value;
    const rating = document.getElementById("rating").value;
    const review = document.getElementById("review").value;

    fetch('RatingController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `action=rate&userId=${uid}&driverId=${did}&rideId=${rid}&rating=${rating}&review=${review}`
    }).then(res => res.text())
      .then(() => {
        alert("Thank you for your feedback!");
        getAllRatings();
    });
}

function getAllRatings() {
    fetch('RatingController?action=getAll')
        .then(res => res.json())
        .then(ratings => {
            let list = "<h3>All Ratings</h3><ul>";
            ratings.forEach(r => list += `<li>${r.ratingId} - ${r.rating}⭐ (${r.review})</li>`);
            document.getElementById("ratingList").innerHTML = list + "</ul>";
        });
}

window.onload = getAllRatings;
