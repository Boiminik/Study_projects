<?php
$dbhost = "localhost";
$dbuser = "hotelUser";
$dbpassword = "HuberPierdiluca";
$dbname = "hoteldb";

mysqli_report(MYSQLI_REPORT_ERROR ^ MYSQLI_REPORT_STRICT);
$db = new mysqli($dbhost, $dbuser, $dbpassword, $dbname);
$db->set_charset("utf8mb4");
if ($db->connect_error) {
    die("Die Datenbank konnte nicht erreicht werden: " . $db->connect_error);
}

if($db->connect_error) {
    echo "Die Datenbank konnte nicht erreicht werden" .  $db->connect_error;
    exit();
}

?>