<?php
require_once("db/dbaccess.php");
// Check if the user is logged in
include("inc/session.php");
include("inc/backgroundchange.php");
if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit();
}

// Fetch user data
$user_id = $_SESSION["user_id"];
$query = "SELECT uemail, uname, sex, firstname, lastname, upassword,isAdmin FROM user WHERE uID = ?";
$stmt = $db->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($uemail, $uname, $sex, $firstname, $lastname, $oldPassword,$isAdmin);
$stmt->fetch();
$stmt->close();

// Update user information
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["update_profile"])) {
        if (password_verify($_POST["old_password"], $oldPassword)) {
            if (isset($_POST["enable_new_firstname"])){
                $newFirstname = $_POST["new_firstname"];
            } else{
                $newFirstname = $firstname;
            }
            if (isset($_POST["enable_new_lastname"])){
                $newLastname = $_POST["new_lastname"];
            } else{
                $newLastname = $lastname;
            }
            if (isset($_POST["enable_new_uname"])){
                $newUname = $_POST["new_uname"];
            } else{
                $newUname = $uname;
            }
            if (isset($_POST["enable_new_email"])){
            $newEmail = $_POST["new_email"];
            } else{
                $newEmail = $uemail;
            }
            if (isset($_POST["enable_new_sex"])){
                $newSex = $_POST["new_sex"];
            } else{
                $newSex = $sex;
            }
            if (isset($_POST["enable_new_password"])){
                $newPassword = $_POST["new_password"];
                $updateQuery = "UPDATE user SET firstname=?, lastname=?, uname=?, uemail=?, upassword=?, sex=? WHERE uID=?";
                $updateStmt = $db->prepare($updateQuery);
                $updateStmt->bind_param("ssssssi", $newFirstname, $newLastname, $newUname, $newEmail, password_hash($newPassword, PASSWORD_DEFAULT), $newSex, $user_id);
            } else{
                $newPassword = $oldPassword;
                $updateQuery = "UPDATE user SET firstname=?, lastname=?, uname=?, uemail=?, sex=? WHERE uID=?";
                $updateStmt = $db->prepare($updateQuery);
                $updateStmt->bind_param("sssssi", $newFirstname, $newLastname, $newUname, $newEmail, $newSex, $user_id);
            }
            // Verify the old password

            // Validate and update user data in the database
            $updateStmt->execute();
            $updateStmt->close();

            // Redirect or display success message
            $updateInfo = "Die Daten wurden erfolgreich übernommen.";
            header("Location: profil.php");
            exit();
        } else {
            $updateInfo = "Das alte Passwort ist nicht korrekt.";
        }
    }
}
?>

<?php
$pageTitle = "Profil";
$metaDesc = "Ihr Benutzerprofil";
include("inc/header.php");
include("inc/backgroundchange.php");
?>

<script>
    function toggleField(fieldName) {
        var field = document.getElementById(fieldName);
        var checkbox = document.querySelector('input[name="enable_' + fieldName + '"]');
        
        field.readOnly = !checkbox.checked;
        field.disabled = !checkbox.checked;
    }
</script>

<body>
    <div class="background-overlay">
        <div id="container">
            <div class="placeholder-container"></div>
            <div class="panel-container">
                <div class="panel">
                    <h1 class="panel_heading">Ihr Profil</h1>

                    <form method="post" action="profil.php">
                    <input type="checkbox" name="enable_new_firstname" onclick="toggleField('new_firstname');" <?php if (isset($_POST['enable_new_firstname'])) echo 'checked'; ?>> Vornamen ändern
                        <div class="input">
                            <label for="new_firstname">Vorname</label>
                            <input id="new_firstname" name="new_firstname" type="text" value="<?php echo $firstname; ?>" <?php if (!isset($_POST['enable_new_firstname'])) echo 'readonly'; ?>>
                        </div>
                        <input type="checkbox" name="enable_new_lastname" onclick="toggleField('new_lastname');" <?php if (isset($_POST['enable_new_lastname'])) echo 'checked'; ?>> Nachnamen ändern
                        <div class="input">
                            <label for="new_lastname">Nachname</label>
                            <input id="new_lastname" name="new_lastname" type="text" value="<?php echo $lastname; ?>" <?php if (!isset($_POST['enable_new_lastname'])) echo 'readonly'; ?>>
                        </div>
                        <input type="checkbox" name="enable_new_uname" onclick="toggleField('new_uname');" <?php if (isset($_POST['enable_new_uname'])) echo 'checked'; ?>> Nutzernamen ändern
                        <div class="input">
                            <label for="new_uname">Nutzername</label>
                            <input id="new_uname" name="new_uname" type="text" value="<?php echo $uname; ?>" <?php if (!isset($_POST['enable_new_uname'])) echo 'readonly'; ?>>
                        </div>
                        <input type="checkbox" name="enable_new_email" onclick="toggleField('new_email');" <?php if (isset($_POST['enable_new_email'])) echo 'checked'; ?>> Email ändern
                        <div class="input">
                            <label for="new_email">Email</label>
                            <input id="new_email" name="new_email" type="email" value="<?php echo $uemail; ?>" <?php if (!isset($_POST['enable_new_email'])) echo 'readonly'; ?>>
                        </div>
                        <input type="checkbox" name="enable_new_password" onclick="toggleField('new_password');" <?php if (isset($_POST['enable_new_password'])) echo 'checked'; ?>> Passwort ändern
                        <div class="input">
                            <label for="new_password">Neues Passwort</label>
                            <input id="new_password" type="password" name="new_password" <?php if (!isset($_POST['enable_new_password'])) echo 'readonly'; ?>>
                        </div>
                        <input type="checkbox" name="enable_new_sex" onclick="toggleField('new_sex');" <?php if (isset($_POST['enable_new_sex'])) echo 'checked'; ?>> Geschlecht ändern
                        <div class="row-3">

                            <label for="new_sex">Geschlecht</label>
                            <select id="new_sex" name="new_sex" <?php if (!isset($_POST['enable_new_sex'])) echo 'disabled'; ?>>
                                <option value="male" <?php echo ($sex == 'male') ? 'selected' : ''; ?>>Männlich</option>
                                <option value="female" <?php echo ($sex == 'female') ? 'selected' : ''; ?>>Weiblich</option>
                                <option value="other" <?php echo ($sex == 'other') ? 'selected' : ''; ?>>Divers</option>
                            </select>
                        </div>
                        <div class="input">
                            <label for="old_password">Altes Passwort</label>
                            <input id="old_password" type="password" name="old_password" required>
                            <a   role ="button" class="password-button">
                                <i class="far fa-eye passwort-anzeigen-icon"></i>
                                <i class="far fa-eye-slash passwort-verstecken-icon"></i>
                            </a>
                        </div>
                        <?php if (isset($updateInfo)) { ?>
                            <div class="error-message"><?php echo $updateInfo; ?></div>
                        <?php } ?>

                        <button type="submit" name="update_profile">Profil aktualisieren</button>
                    </form>

                    <?php 
                    echo '<a href="meine_buchungen.php"> Meine Buchungen Anzeigen</a>';
                    if($isAdmin == 1){
                        echo '<br><a href="profile_uebersicht.php">User Profile Verwalten</a><br>';
                        echo '<a href="buchungen_uebersicht.php"> User Buchungen Verwalten</a>';
                    }
                    ?>
                </div>
            </div>
        </div>
    </div>


    <?php
    include("inc/footer.php");
    ?>