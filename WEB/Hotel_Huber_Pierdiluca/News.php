<?php 
$pageTitle = "News";
$metaDesc = "News";
include("inc/header.php");
include("inc/session.php");
include("db/dbaccess.php");

// Initialize $uploadSuccess
$uploadSuccess = false;

// Handle file upload
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $target_dir = "uploads/news/";
    $target_file = $target_dir . basename($_FILES["file"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

    // Check if image file is a actual image or fake image
    $check = getimagesize($_FILES["file"]["tmp_name"]);
    if ($check !== false) {
        echo "File is an image - " . $check["mime"] . ".";
        $uploadOk = 1;
    } else {
        echo "File is not an image.";
        $uploadOk = 0;
    }

    // Check file size
    if ($_FILES["file"]["size"] > 50000000) {
        echo "Sorry, your file is too large.";
        $uploadOk = 0;
    }

    // Allow certain file formats
    if ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif") {
        echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
        $uploadOk = 0;
    }

    // Check if $uploadOk is set to 0 by an error
    if ($uploadOk == 0) {
        echo "Sorry, your file was not uploaded.";
    } else {
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file " . htmlspecialchars(basename($_FILES["file"]["name"])) . " has been uploaded.";

            // Check the file format to set specific functions
            if ($imageFileType == "jpeg" || $imageFileType == "jpg") {
                $imagecreate = "imagecreatefromjpeg";
                $imageformat = "imagejpeg";
            }
            if ($imageFileType == "png") {
                $imagecreate = "imagecreatefrompng";
                $imageformat = "imagepng";
            }
            if ($imageFileType == "gif") {
                $imagecreate = "imagecreatefromgif";
                $imageformat = "imagegif";
            }

            // Get size of original image
            list($width, $height) = getimagesize($target_file);

            // Set size for thumbnail
            $thumb_width = 100;
            $thumb_height = 65;

            // Load image
            $thumb = imagecreatetruecolor($thumb_width, $thumb_height);
            $image = $imagecreate($target_file);

            // Resize original image according to the thumbnail size
            imagecopyresized($thumb, $image, 0, 0, 0, 0, $thumb_width, $thumb_height, $width, $height);

            // Save resized image in 'thumb' folder using the original file name
            $imageformat($thumb, "uploads/news/thumb/" . htmlspecialchars(basename($_FILES["file"]["name"])));
            
            // Set $uploadSuccess to true
            $uploadSuccess = true;
        } else {
            echo "Sorry, there was an error uploading your file.";
        }
    }
}

// Continue with the rest of your code only if file upload is successful
if ($uploadSuccess) {
    // Handle news submission
    $newsTitle = $_POST["news-title"];
    $newsDescription = $_POST["news-description"];
    $newsImagePath = "uploads/news/thumb/" . basename($_FILES["file"]["name"]);
    $postDate = date("Y-m-d");
    $postTime = date("H:i:s");
    $fk_uID = $_SESSION["user_id"];

    // Insert news into the database
    $insertQuery = "INSERT INTO news (title, description, imagepath, postDate, postTime, fk_uID) VALUES (?, ?, ?, ?, ?, ?)";
    $insertStmt = $db->prepare($insertQuery);
    $insertStmt->bind_param("sssssi", $newsTitle, $newsDescription, $newsImagePath, $postDate, $postTime, $fk_uID);
    $insertStmt->execute();
    $insertStmt->close();

    // Redirect back to news.php
    header("Location: news.php");
    exit();
}
?>

<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>News Beiträge</h1>
            </div>
        </div>
        <?php//only allow admins to see the form
        if (isset($_SESSION['isAdmin']) && $_SESSION['isAdmin'] == true) {?>
            <form method="post" enctype="multipart/form-data" action="news.php">
                <div>
                    <textarea cols="70" rows="1" name="news-title" placeholder="Neuer Beitrag"></textarea>
                </div>
                <div>
                    <textarea cols="160" rows="5" name="news-description" placeholder="maximale Länge: 500 Zeichen"></textarea>
                </div>
                <div class="mb-3">
                    <label for="file" class="form-label">File</label>
                    <input class="form-control" type="file" id="file" name="file">
                </div>
                <button class="btn btn-primary" type="submit">Posten</button>
            </form>
        <?php }?>
        <div class="row mt-3">
            <div class="col">
                <h2>Beiträge</h2>
            </div>
        </div>

        <div class="row grid">
            <div class="col">
                <ul class="list-group">
                    <?php
                    // Fetch news posts from the database
                    $newsQuery = "SELECT title, description, imagepath, postDate, postTime, uname
                                  FROM news
                                  INNER JOIN user ON news.fk_uID = user.uID
                                  ORDER BY postDate DESC, postTime DESC";
                    $newsResult = $db->query($newsQuery);
                    
                    if ($newsResult) {
                        while ($row = $newsResult->fetch_assoc()) {
                            echo '<li class="list-group-item">' . htmlspecialchars($row['title']) . '</li>';
                            echo '<li class="list-group-thumb"><img src="' . htmlspecialchars($row['imagepath']) . '" ></li>';
                            echo '<li class="text">' . htmlspecialchars($row['description']) . '</li>';
                            echo 'Posted by ' . htmlspecialchars($row['uname']) . ' am ' . htmlspecialchars($row['postDate']) . '<p class="newsinfo"> um ' . htmlspecialchars($row['postTime']) . '</p>';
                        }

                        if ($newsResult->num_rows == 0) {
                            echo '<li class="list-group-item">Keine Beiträge gefunden..</li>';
                        }

                        $newsResult->free();
                    } else {
                        echo "Error fetching news posts: " . $db->error;
                    }
                    ?>
                </ul>
            </div>
        </div>
    </div>
</body>

<?php
include("inc/footer.php");
?>
