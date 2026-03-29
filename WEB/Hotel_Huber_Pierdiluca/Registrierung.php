<?php
error_reporting(E_ALL);
ini_set('display_errors', '1');
$pageTitle = "Registrierung";
$metaDesc = "Bitte erstellen Sie einen Account";
include("inc/header.php");
include("inc/session.php");
include("inc/backgroundchange.php");
require_once("db/dbaccess.php");

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["insert"]) && isset($_POST["uemail"]) &&isset($_POST["uname"])&& isset($_POST["upassword"]) && isset($_POST["sex"]) && isset($_POST["firstname"]) && isset($_POST["lastname"]) && isset($_POST["passwordControl"])) {
        // Verify passwords
        if ($_POST["upassword"] === $_POST["passwordControl"]) {
            $query = "INSERT INTO user (uemail, uname, upassword, sex, firstname, lastname, isAdmin, isActive) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            $stmt = $db->prepare($query);
            $stmt->bind_param("ssssssii", $uemail, $uname, $upassword, $sex, $firstname, $lastname, $isAdmin, $isActive);

            $uemail = $_POST["uemail"];
            $uname = $_POST["uname"];
            $upassword = password_hash($_POST["upassword"], PASSWORD_DEFAULT);
            $sex = $_POST["sex"];
            $firstname = $_POST["firstname"];
            $lastname = $_POST["lastname"];
            $isAdmin = 0; // The state 'isAdmin' is 0/false by default 
            $isActive = 1; //The state 'isActive' is 1/true by default

            $stmt->execute();

            if ($stmt->errno) {
                die("Execute failed: (" . $stmt->errno . ") " . $stmt->error);
            }

            $stmt->close();

            header("Location: Login.php");
            exit();
        } else {
            echo "Die Passwörter stimmen nicht überein!";
        }
    }
}
?>

<body>
    <div class="background-overlay">
        <div id="container">
            <div class="placeholder-container">
            </div>
            <div class="panel-container">
                <div class="panel">
                    <h1 class="panel_heading">Registrierung</h1>
                    <p class="panel_subheading">
                        Sie haben bereits einen Account? <a href="Login.php">Login</a>
                    </p>

                    <form method="post" action="registrierung.php">

                        <div class="name">
                            <div class="input">
                                <label for="firstname">Vorname</label>
                                <input id="firstname" name="firstname" type="text" placeholder="Ihr Vorname" required>
                            </div>
                            <div class="input">
                                <label for="lastname">Nachname</label>
                                <input id="lastname" name="lastname" type="text" placeholder="Ihr Nachname" required>
                            </div>
                        </div>
                        <div class="row-3">
                            <label for="männlich">Männlich</label>
                            <input type="radio" id="männlich" name="sex" value="male">

                            <label for="weiblich">Weiblich</label>
                            <input type="radio" id="weiblich" name="sex" value="female">

                            <label for="diverse">Divers</label>
                            <input type="radio" id="diverse" name="sex" value="other">
                        </div>
                        <div class="input">
                                <label for="uname">Nutzername</label>
                                <input id="uname" name="uname" type="text" placeholder="Ihr Nutzername" required>
                            </div>
                        <div class="input">
                            <label for="uemail">Email</label>
                            <input id="uemail" name="uemail" type="email" placeholder="Ihre E-mailadresse" required>
                        </div>
                        <div class="input">
                            <label for="upassword">Passwort</label>
                            <input id="upassword" placeholder="Ihr Passwort" type="password" name="upassword" required>
                        </div>
                        <div class="input">
                            <label for="passwordControl">Passwort bestätigen</label>
                            <input id="passwordControl" placeholder="Passwort bestätigen" type="password" name="passwordControl" required>
                        </div>
                        <button type="submit" name="insert">Jetzt registrieren</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <?php include("inc/footer.php"); ?>
</body>
