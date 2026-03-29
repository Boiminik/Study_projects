<?php 
$pageTitle = "homepage";
$metaDesc = "Homepage von Hotel Huber-Pierdiluca";
include("inc/header.php");
include("inc/session.php");
include("inc/backgroundchange.php");
?>
<div class=" background-overlay">
    <div id="container">
        <div class="card">
            <img src="uploads/colorful.jpg" alt="room-first-floor" style="width:100%">
            <h4>Suite</br></h4>
            <p>First Class suite on the first floor</p>
            <form method="post" action="http://localhost/Hotel_Huber_Pierdiluca/buchen.php">
                <input type="hidden" name="roomType" value="101">
                <label for="parkplatz">Inklusive Parkplatz</br></label>
                <input type="checkbox" id="parkplatz" name="parking" value="parkplatz">
                <label for="all">Inklusive All-inclusive</br></label>
                <input type="checkbox" id="all-inclusive" name="all" value="allinclusive"></br>
                <label for="pets">Mit Haustieren</br></label>
                <input type="checkbox" id="haustiere" name="pets" value="pets"></br>
                <label for="date">Start date:</label>
                <input type="date" id="start" name="trip-start" value="2024-01-24" min="2024-01-24" max="2025-01-01" /></br>
                <label for="date">End date:</label>
                <input type="date" id="end" name="trip-end" value="2024-01-24" min="2024-01-24" max="2025-01-01" />
                <button type="submit" name="buchen1">Buchen</button>
            </form>
        </div>
        <div class="card">
            <img src="uploads/hotel.jpg" alt="room-second-floor" style="width:100%">
            <h4>Doppelbettzimmer</h4>
            <p>A comfy loft on the second floor</p>
            <form method="post" action="http://localhost/Hotel_Huber_Pierdiluca/buchen.php">
                <input type="hidden" name="roomType" value="101">
                <label for="parkplatz">Inklusive Parkplatz</br></label>
                <input type="checkbox" id="parkplatz" name="parking" value="parkplatz">
                <label for="all">Inklusive All-inclusive</br></label>
                <input type="checkbox" id="all-inclusive" name="all" value="allinclusive"></br>
                <label for="pets">Mit Haustieren</br></label>
                <input type="checkbox" id="haustiere" name="pets" value="pets"></br>
                <label for="date">Start date:</label>
                <input type="date" id="start" name="trip-start" value="2024-01-24" min="2024-01-24" max="2025-01-01" /></br>
                <label for="date">End date:</label>
                <input type="date" id="end" name="trip-end" value="2024-01-24" min="2024-01-24" max="2025-01-01" />
                <button type="submit" name="buchen2">Buchen</button>
            </form>
        </div>
        <div class="card">
            <img src="uploads/Rooms-and-Suites.jpg" alt="room-third-floor" style="width:100%">
            <h4>Loft</h4>
            <p>A comfortable loft on the third floor</p>
            <form method="post" action="http://localhost/Hotel_Huber_Pierdiluca/buchen.php">
                <input type="hidden" name="roomType" value="101">
                <label for="parkplatz">Inklusive Parkplatz</br></label>
                <input type="checkbox" id="parkplatz" name="parking" value="parkplatz">
                <label for="all">Inklusive All-inclusive</br></label>
                <input type="checkbox" id="all-inclusive" name="all" value="allinclusive"></br>
                <label for="pets">Mit Haustieren</br></label>
                <input type="checkbox" id="haustiere" name="pets" value="pets"></br>
                <label for="date">Start date:</label>
                <input type="date" id="start" name="trip-start" value="2024-01-24" min="2024-01-24" max="2025-01-01" /></br>
                <label for="date">End date:</label>
                <input type="date" id="end" name="trip-end" value="2024-01-24" min="2024-01-24" max="2025-01-01" />
                <button type="submit" name="buchen3">Buchen</button>
            </form>
        </div>
    </div>
            </div>
<?php 
include("inc/footer.php")
?>