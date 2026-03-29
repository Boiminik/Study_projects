<?php
session_start();
$pageTitle = "Logout";
$metaDesc = "Ausloggen";
include("inc/header.php");  
include("inc/session.php");
require_once("db/dbaccess.php");
$user_id = $_SESSION["user_id"];
$query = "SELECT firstname FROM user WHERE uID = ?";
$stmt = $db->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($firstname);
$stmt->fetch();
$stmt->close();

// Check if the user is logged in
if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == false) {
    // If not logged in, redirect to login page
    header("Location: login.php");
    exit();
}

// Check if the user has confirmed logout
if (isset($_POST["confirm_logout"])) {
    // Logout logic
    // Unset all of the session variables
    $_SESSION = array();

    // Destroy the session
    session_destroy();

    // Redirect to the login page (you can change the location based on your file structure)
    header("Location: login.php");
    exit();
}
?>
<body>


<div class="container">
<div class="row justify-content-md-center">
<div class="col-lg-4">
<div class="col-md-auto">
    <h1>Ausloggen bestätigen</h1>
    <p>Bist du dir sicher dass du dich ausloggen möchtest, <?php echo $firstname; ?>?</p>

    <form method="post" action="">
        <input type="hidden" name="confirm_logout" value="1">
        <button type="submit">Ja, Ausloggen</button>
    </form>
</div>
</div>
</div>
</div>

<?php
    include("inc/footer.php");
    ?>
