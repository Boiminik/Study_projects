<script>
        var images = ["Rooms-and-Suites.jpg","colorful.jpg"];
        function changeBackground() {
            var randomNumber = Math.floor(Math.random() * images.length);
            document.body.style.backgroundImage = "url(uploads/" + images[randomNumber] + ")";
        }
        window.onload = changeBackground;
</script>