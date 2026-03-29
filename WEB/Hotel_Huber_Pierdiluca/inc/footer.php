<?php 
include("inc/session.php");
if(isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true){
    $user_id = $_SESSION['user_id'];
    $query = "SELECT uname FROM user WHERE uID = ?";
    $stmt = $db->prepare($query);
    $stmt->bind_param("i", $user_id);
    $stmt->execute();
    $stmt->bind_result($uname);
    $stmt->fetch();
    $stmt->close();
}
?>
</main>
    <footer class="fixed-bottom">
        <nav>
            <ul class="navbar">
                <li class="navbarlist">Copyright &copy 2023. Hotel Huber-Pierdiluca</li>
                <?php
                    if(isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true){
                    echo '<li class ="navbarlist"> Herzlich Wilkommen '.$uname.'!</li>';
                    }else{
                        echo 'Sie sind nicht eingeloggt!';
                    }
                ?>
                <li class="navbarlist"><a href="Impressum.php">Impressum</a></li>
            </ul>
        </nav>
    </footer>
</body>
</html>