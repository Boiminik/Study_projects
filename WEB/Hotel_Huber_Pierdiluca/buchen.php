<?php
$pageTitle = "Buchungsbestätigung";
$metaDesc = "Hier können Sie ihre Buchung einsehen und bestätigen";
include("inc/header.php");
include("inc/session.php");
require_once("db/dbaccess.php");
//check if user is logged in, display message if not
if (!isset($_SESSION["user_id"])) {
    echo '<p> Für dieses Feature müssen Sie eingeloggt sein: <a href="Login.php">Login</a></p>';
    exit();
}

$total = 0;

function daysBetween($dt1, $dt2)
{
    return date_diff(
        date_create($dt2),
        date_create($dt1)
    )->format('%a');
}

if (isset($_POST['buchen1'])) {
    $tagesKosten = 120;
    $total = $total + $tagesKosten * daysBetween($_POST['trip-start'], $_POST['trip-end']);
    $roomType = 101;    
}
if (isset($_POST['buchen2'])) {
    $tagesKosten = 80;
    $total = $total + $tagesKosten * daysBetween($_POST['trip-start'], $_POST['trip-end']);
    $roomType = 102;
}
if (isset($_POST['buchen3'])) {
    $tagesKosten = 60;
    $total = $total + $tagesKosten * daysBetween($_POST['trip-start'], $_POST['trip-end']);
    $roomType = 103;
}

$kostenZimmer = $tagesKosten * daysBetween($_POST['trip-start'], $_POST['trip-end']);
$extraprice = 0;
$extras = '';
if (isset($_POST['parking'])) {
    $extras .= 'Parkplatz, ';
    $extraprice += 35;
}
if (isset($_POST['all'])) {
    $extras .= 'Frühstück, ';
    $extraprice += 90;
}
if (isset($_POST['pets'])) {
    $extras .= 'Haustiere, ';
    $extraprice += 40;
}
$extras = rtrim($extras, ', '); // Remove trailing comma and space
$total = $total + $extraprice;

// Save the reservation data into the database
if (isset($_POST['bestaetigen'])) {
    $currDate = date("Y-m-d");
    $currTime = date("H:i:s");
    // Prepare and execute the INSERT query
    $insertQuery = "INSERT INTO reservations (room, currDate, currTime, dateStart, dateEnd, price, fk_uID, extras, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    $insertStmt = $db->prepare($insertQuery);
    $insertStmt->bind_param("isssisiss", $roomType, $currDate, $currTime, $_POST['trip-start'], $_POST['trip-end'], $kostenZimmer, $_SESSION['user_id'], $extras, 'neu');
    $insertStmt->execute();
    
    $insertStmt->close();
    
    // Redirect the user to homepage.php
    header("Location: http://localhost/Hotel_Huber_Pierdiluca/homepage.php");
    exit();
}
?>
<div class="container">
    <div class="panel-container">
        <div class="panel">
            <h1 class="panel-heading">Kosten</h1>
            <p class="panel-subheading">Kosten-breakdown:</p>

            <?php
            if (isset($_POST['parking'])) {
                echo '<p>Extra Parkplatz kostet 35€</p>';
            }
            if (isset($_POST['all'])) {
                echo '<p>All-inclusive kostet 90€</p>';
            }
            if (isset($_POST['pets'])) {
                echo '<p>Haustiere kosten einen Aufpreis von 40€</p>';
            }

            echo '<p>Sie haben ihr Zimmer ' . daysBetween($_POST['trip-start'], $_POST['trip-end']) . ' Tage von ' . $_POST['trip-start'] . ' bis ' . $_POST['trip-end'] . ' gebucht</p>';
            echo '<p>Ihr Zimmer kostet ' . $tagesKosten . ' pro Tag, was für ' . daysBetween($_POST['trip-start'], $_POST['trip-end']) . ' Tage ' . $kostenZimmer . '€ ausmacht</p>';
            echo '</br>';
            echo '<p>Insgesammt: ' . $total . '€</p>';
            ?>
            <form action="http://localhost/Hotel_Huber_Pierdiluca/homepage.php" method="post">
                <button type="submit" name="bestaetigen">Bestätigen</button>
            </form>
        </div>
    </div>
</div>

<?php
include("inc/footer.php")
?>
