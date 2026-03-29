<?php
require_once("db/dbaccess.php");
// Check if the user is logged in and is an admin
include("inc/session.php");

if (!isset($_SESSION['isAdmin']) || $_SESSION['isAdmin'] == false) {
    header("Location: profil.php"); // Redirect non-admin users
    exit();
}

// Handle status change button click
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['action']) && isset($_POST['booking_ID'])) {
    $bookingID = $_POST['booking_ID'];
    $newStatus = $_POST['action'];

    // Set status to the new value in the database
    $updateQuery = "UPDATE reservations SET status = ? WHERE rID = ?";
    $updateStmt = $db->prepare($updateQuery);
    $updateStmt->bind_param("si", $newStatus, $bookingID);
    $updateStmt->execute();
    $updateStmt->close();

    // Redirect to refresh the page
    header("Location: buchungen_uebersicht.php");
    exit();
}

// Fetch all reservations with user information
$query = "SELECT r.rID, r.room, r.currDate, r.currTime, r.dateStart, r.dateEnd, r.price, r.extras, r.status, u.uname
          FROM reservations r
          INNER JOIN user u ON r.fk_uID = u.uID";
$result = $db->query($query);

// Check if reservations are found
if ($result) {
    $pageTitle = "Reservations Overview (Admin)";
    $metaDesc = "Manage reservations";
    include("inc/header.php");
    include("inc/backgroundchange.php");
?>

    <div class="background-overlay">
        <div class="container">
            <div class="placeholder-container"></div>
            <div class="panel-container">
                <div class="table-panel">
                    <h1 class="panel_heading">Reservations Overview (Admin)</h1>

                    <?php
                    // Display reservation data in a table
                    echo "<div class='table-container'><table border='1'>
                            <tr>
                                <th>rID</th>
                                <th>Raum</th>
                                <th>Buchungsdatum</th>
                                <th>Buchungszeit</th>
                                <th>Start</th>
                                <th>End</th>
                                <th>Preis</th>
                                <th>Extras</th>
                                <th>Status</th>
                                <th>User</th>
                                <th>Action</th>
                            </tr>";

                    while ($row = $result->fetch_assoc()) {
                        echo "<tr>
                                <td>{$row['rID']}</td>
                                <td>{$row['room']}</td>
                                <td>{$row['currDate']}</td>
                                <td>{$row['currTime']}</td>
                                <td>{$row['dateStart']}</td>
                                <td>{$row['dateEnd']}</td>
                                <td>{$row['price']}</td>
                                <td>{$row['extras']}</td>
                                <td>{$row['status']}</td>
                                <td>{$row['uname']}</td>
                                <td>
                                    <form method='post'>
                                        <input type='hidden' name='booking_ID' value='{$row['rID']}'>
                                        <button type='submit' name='action' value='neu'>setz auf Neu</button>
                                        <button type='submit' name='action' value='bestätigt'>setz auf Bestätigt</button>
                                        <button type='submit' name='action' value='storniert'>setz Storniert</button>
                                    </form>
                                </td>
                              </tr>";
                    }

                    echo "</table></div>";

                    $result->free();
                    ?>

                </div>
            </div>
        </div>
    </div>

<?php
    include("inc/footer.php");
} else {
    echo "Error: " . $db->error;
}

$db->close();
?>
