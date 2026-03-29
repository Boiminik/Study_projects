<?php
require_once("db/dbaccess.php");
// Check if the user is logged in
include("inc/session.php");

if (!isset($_SESSION['isAdmin']) || $_SESSION['isAdmin'] == false) {
    header("Location: profil.php"); // Redirect non-admin users
    exit();
}

// Handle user activation/deactivation button click
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['action'])) {
    $userID = $_POST['user_id'];

    // Toggle isActive value in the database
    $updateQuery = "UPDATE user SET isActive = 1 - isActive WHERE uID = ?";
    $updateStmt = $db->prepare($updateQuery);
    $updateStmt->bind_param("i", $userID);
    $updateStmt->execute();
    $updateStmt->close();

    // Redirect to refresh the page
    header("Location: profile_uebersicht.php");
    exit();
}

// Fetch all users
$query = "SELECT uID, firstname, lastname, uname, uemail, sex, isActive FROM user WHERE isAdmin = 0";
$result = $db->query($query);

// Check if users are found
if ($result) {
    // Include your header.php, backgroundchange.php, and any other necessary files here.
    $pageTitle = "User Management";
    $metaDesc = "Manage user profiles";
    include("inc/header.php");
    include("inc/backgroundchange.php");
?>
    <div class="background-overlay">
        <div class="container">
            <div class="placeholder-container"></div>
            <div class="panel-container">
                <div class="table-panel">
                    <h1 class="panel_heading">Nutzer bearbeiten</h1>

                    <?php
                    // Display user data in a table
                    echo "<div class='table-container'><table border='1'>
                            <tr>
                                <th>Bearbeiten</th>
                                <th>uID</th>
                                <th>Vorname</th>
                                <th>Nachname</th>
                                <th>Nutzername</th>
                                <th>Email</th>
                                <th>Geschlecht</th>
                                <th>Status</th>
                            </tr>";

                    while ($row = $result->fetch_assoc()) {
                        $statusButton = ($row['isActive'] == 1) ? 'Deaktivieren' : 'Aktivieren';

                        echo "<tr>
                                <td><a href='profile_verwalten.php?user_id={$row['uID']}'>Edit</a></td>
                                <td>{$row['uID']}</td>
                                <td>{$row['firstname']}</td>
                                <td>{$row['lastname']}</td>
                                <td>{$row['uname']}</td>
                                <td>{$row['uemail']}</td>
                                <td>{$row['sex']}</td>
                                <td>
                                    <form method='post'>
                                        <input type='hidden' name='user_id' value='{$row['uID']}'>
                                        <input type='hidden' name='action' value='toggleStatus'>
                                        <button type='submit'>{$statusButton}</button>
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
