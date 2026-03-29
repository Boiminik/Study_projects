<!DOCTYPE html>
<html lang="de">
    <?php
    if(session_status()==PHP_SESSION_NONE)session_start();
include("db/dbaccess.php");

?>
<head>
    <title><?php echo $pageTitle?></title>
    <link rel="stylesheet" href="\Hotel_Huber_Pierdiluca\css\bootstrap.min.css">
    <link rel="stylesheet" href="\Hotel_Huber_Pierdiluca\css\style.css">
    <script src="\Hotel_Huber_Pierdiluca\js\bootstrap.bundle.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<header>
    <nav>
        <ul class="navbar">
            <li class="navbarlist"><a href="hilfe.php">Hilfe</a></li>
            <li class="navbarlist"><a href="homepage.php">Homepage</a></li>
            <?php 
                if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true) {
                   echo '<li class="navbarlist"><a href="profil.php">Profil</a></li>';
                   echo '<li class="navbarlist"><a href="Logout.php" onclick="confirmLogout()">Logout</a></li>';
                }
                else{
                    echo '<li class="navbarlist"><a href="registrierung.php">Registrierung</li>';
                    echo '<li class="navbarlist"><a href="login.php">Login</a></a></li>';
                    $_SESSION["loggedin"]=false;
                }
            ?>
            <li class="navbarlist"><a href="news.php">News</a></li>
        </ul>
    </nav>
</header>
<main>