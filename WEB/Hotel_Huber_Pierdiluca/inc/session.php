<?php
    if(session_status()==PHP_SESSION_NONE)session_start();
    if($_SERVER["REQUEST_METHOD"]=="POST"){
        if(isset($_POST["email"])){
            if($_POST["email"]==="example@test.com"
            && $_POST["password"]=== "test123"){
                $_SESSION["email"] = $_POST["email"];
                $_SESSION["password"] = $_POST["password"];
                 echo "Wilkommen " . $_SESSION["email"];
            }
        }
    }
        if(isset($_SESSION["email"])){
            echo "Wilkommen test". $_SESSION["email"];
    }else{}
?>
