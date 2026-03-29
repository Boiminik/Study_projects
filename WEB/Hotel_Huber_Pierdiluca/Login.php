<?php
if(session_status()==PHP_SESSION_NONE)session_start();
$pageTitle = "Login";
$metaDesc = "Loggen Sie sich in ihren Account";
include("inc/header.php");  
include("inc/backgroundchange.php");
include("inc/session.php");
require_once("db/dbaccess.php");
?>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["login"]) && isset($_POST["uemail"]) && isset($_POST["upassword"])) {
        $uemail = $_POST["uemail"];
        $upassword = $_POST["upassword"];

        $query = "SELECT uID, uemail, upassword,isAdmin,isActive FROM user WHERE uemail = ?";
        $stmt = $db->prepare($query);
        $stmt->bind_param("s", $uemail);
        $stmt->execute();
        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            $stmt->bind_result($uID, $dbUemail, $dbUpassword,$isAdmin,$isActive);
            $stmt->fetch();

            if (password_verify($upassword, $dbUpassword)) {
                // Login successful
                if ($isActive == 1){
                    //user is not deactivated
                    if($isAdmin == 0){ //check if admin
                        $_SESSION["isAdmin"]=false;
                    } else{
                        $_SESSION["isAdmin"]=true;
                    }
                    $_SESSION["loggedin"]=true;
                    $_SESSION["user_id"] = $uID;
                    header("Location: Profil.php"); // Redirect to Profil.php
                  exit();
                } else {
                    //user is deactivated
                    $loginError = "Ihr account wurde deaktiviert, bitte kontaktieren Sie einen Admin!";
                }
            }else {
                    //user entered the wrong password
                $loginError = "Passwort oder Email fehlerhaft!";
            }
        } else {
            //the email was not found in the database
            $loginError = "Nutzer konnte nicht gefunden werden";
        }

        $stmt->close();
    }
}
?>



<body>
    <?php
        if($_SERVER["REQUEST_METHOD"]=="POST"){
            if(isset($_POST["uemail"])){
                $uemail = $_POST["uemail"];
                if(strlen($uemail)==0){
                    $invalidEmailMessage = "Bitte geben Sie Ihre E-Mail-Adresse an";
                } elseif(!filter_var($uemail, FILTER_VALIDATE_EMAIL)){
                    $invalidEmailMessage = "Bitte überprüfen Sie das Format Ihrer E-mail Adresse";
                }
            }
        }
    ?>
	<div class=" background-overlay">
        <div id="container">
            <div class="placeholder-container">
            </div>
            <div class="panel-container">
                
                    <div class="panel">
                        <h1 class="panel_heading">Login</h1>
                        <p class="panel_subheading">
                            Sie haben noch keinen Account? <a href="Registrierung.php">Registrieren</a>
                        </p>
                        
                        <form method="post">
                            <div class="input">
                                <label for="uemail">Email</label>
                                <input id="uemail" name="uemail" type="email" placeholder="Ihre E-mailadresse" required>
                            </div>
                            <div class="input">
                                <label for="upassword">Passwort</label>
                                <input id="upassword" placeholder="Ihr Passwort" type="password" name="upassword" required>
                            </div>
                            <?php if (isset($loginError)) { ?>
                        <div class="error-message"><?php echo $loginError; ?></div>
                    <?php } ?>
                            <button type="submit" value="login" name="login">Login</button>
                        </form>    
                    </div>
            </div>
        </div>
    </div>

<?php 
include("inc/footer.php");
?>
