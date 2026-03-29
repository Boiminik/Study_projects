<?php
require_once("db/dbaccess.php");
// Check if the user is logged in
include("inc/session.php");

if (!isset($_SESSION['isAdmin']) || $_SESSION['isAdmin'] == false) {
    header("Location: profil.php"); // Redirect non-admin users
    exit();
}

// Check if a user ID is provided in the URL
if (!isset($_GET['user_id'])) {
    header("Location: profile_verwalten.php"); // Redirect to the user management page if user ID is not provided
    exit();
}

$user_id = $_GET['user_id'];

// Fetch user data based on user_id
$query = "SELECT uID, firstname, lastname, uname, uemail, upassword, sex FROM user WHERE uID = ? AND isAdmin = 0";
$stmt = $db->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($user_id, $firstname, $lastname, $uname, $uemail, $upassword, $sex);
$stmt->fetch();
$stmt->close();

// Check if user data is found
if (empty($user_id)) {
    header("Location: profile_verwalten.php"); // Redirect to the user management page if user data is not found
    exit();
}

// Update user information
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["update_profile"])) {
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
                $updateStmt->bind_param("ssssssi", $newFirstname, $newLastname,$newUname, $newEmail, password_hash($newPassword, PASSWORD_DEFAULT), $newSex, $user_id);
            } else{
                $newPassword = $upassword;
                $updateQuery = "UPDATE user SET firstname=?, lastname=?, uname=?, uemail=?, sex=? WHERE uID=?";
                $updateStmt = $db->prepare($updateQuery);
                $updateStmt->bind_param("sssssi", $newFirstname, $newLastname,$newUname, $newEmail, $newSex, $user_id);
            }
        $updateStmt->execute();

        if ($updateStmt->errno) {
            die("Update failed: (" . $updateStmt->errno . ") " . $updateStmt->error);
        }

        $updateStmt->close();
        header("Location:profile_uebersicht.php");
    }
}
?>

<?php
$pageTitle = "Benutzer bearbeiten";
$metaDesc = "Benutzerdaten bearbeiten";
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
                    <h1 class="panel_heading">Benutzer bearbeiten</h1>


                    <form method="post" action="profile_verwalten.php?user_id=<?php echo $user_id; ?>">
                    <input type="hidden" name="user_id" value="<?php echo $user_id; ?>">
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
                        <button type="submit" name="update_profile">Profil aktualisieren</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <?php
    include("inc/footer.php");
    ?>
