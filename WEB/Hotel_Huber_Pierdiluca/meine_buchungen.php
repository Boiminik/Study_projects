<?php
// Start the session
session_start();
$pageTitle = "Reservierungen";
$metaDesc = "Liste Ihrer Reservierungen";
include("inc/header.php");
include("inc/backgroundchange.php");
// Check if the user is logged in
include("inc/session.php");
include("db/dbaccess.php");
if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit();
}

// Check if the form is submitted for updating the status
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['action']) && isset($_POST['booking_ID'])) {
    $bookingID = $_POST['booking_ID'];
    $newStatus = ($_POST['action'] == 'storniert') ? 'storniert' : 'neu';

    // Set status to the new value in the database
    $updateQuery = "UPDATE reservations SET status = ? WHERE rID = ?";
    $updateStmt = $db->prepare($updateQuery);
    $updateStmt->bind_param("si", $newStatus, $bookingID);
    $updateStmt->execute();
    $updateStmt->close();
}

// Fetch all reservations for the logged-in user
$query = "SELECT rID, room, currDate, currTime, dateStart, dateEnd, price, extras, status
          FROM reservations
          WHERE fk_uID = ?";
$stmt = $db->prepare($query);

// Check if the prepare statement succeeded
if ($stmt) {
    // Bind the parameter
    $stmt->bind_param("i", $_SESSION['user_id']);
    
    // Execute the statement
    $stmt->execute();

    // Get the result set
    $result = $stmt->get_result();
} else {
    // Handle the error
    echo "Error: " . $db->error;
}
?>

<div class="background-overlay">
        <div class="container">
            <div class="placeholder-container"></div>
            <div class="panel-container">
                <div class="table-panel">
    <h1>Ihre Reservierungen</h1>

    <?php
    // Check if reservations are found
    if ($result->num_rows > 0) {
        // Display reservations in a table
        echo "<table border='1'>
                <tr>
                    <th>rID</th>
                    <th>Raum</th>
                    <th>Buchungsdatum</th>
                    <th>Buchungszeit</th>
                    <th>Start</th>
                    <th>Ende</th>
                    <th>Preis</th>
                    <th>Extras</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>";

        while ($row = $result->fetch_assoc()) {
            $statusButton = ($row['status'] == 'storniert') ? 'neu' : 'storniert';

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
                    <td>
                        <form method='post'>
                            <input type='hidden' name='booking_ID' value='{$row['rID']}'>
                            <input type='hidden' name='action' value='{$statusButton}'>
                            <button type='submit'>setz auf {$statusButton}</button>
                        </form>
                    </td>
                </tr>";
        }

        echo "</table>";
    } else {
        echo "<p>Keine Reservierungen gefunden.</p>";
    }


    include("inc/footer.php");
    ?>
                        </div>
            </div>
        </div>
    </div>