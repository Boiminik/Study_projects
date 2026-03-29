<?php 
$pageTitle = "Hilfe";
$metaDesc = "Hilfe von Hotel Huber-Pierdiluca";
include("inc/header.php")
?>
<div class=container>
<div>
    <h1>Willkommen auf Hotel Huber-Pierdiluca!</h1>
    Auf der Navigationsleiste oben können verschiedene Websiteabschnitte erreicht werden. Wenn Sie öfter vorbeischauen, können sie sich auch gleich <a href=Registrierung.php>registrieren!</a>
    <h2 class="faq"> FAQ - Frequently Asked Question </h2>
</div>
<div class="accordion" id="accordionFAQ">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Wo kann ich mich registrieren?
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionFAQ">
      <div class="accordion-body">
        Auf der <a href=Registrierung.php>Registrierungsseite.</a><br>
        Diese Seite ist jederzeit über die Navigationsleiste der Webseite erreichbar.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        Wie funktioniert der File-Upload?
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionFAQ">
      <div class="accordion-body">
        Auf der <a href=News.php>News</a> Website können Administratoren Bilddateien hochladen. Folgende Dateitypen sind zugelassen:
            <ul>
                <li>JPG </li>
                <li>JPEG</li>
                <li>PNG</li>
                <li>GIF</li>
</ul>
Derzeit ist diese Funktion für nicht-Administratoren jedoch nicht verfügbar.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Wie kann ich euch kontaktieren?
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionFAQ">
      <div class="accordion-body">
        Unser <a href=Impressum.php>Impressum</a> ist jederzeit am Fuße unserer Webseite zu finden.<br>
        Dort finden Sie zahlreiche Informationen über unser Unternehmen, Kontakt und rechtliches.<br>
        Sollten wir telefonisch nicht erreichbar sein, so zögern Sie bitte nicht umgehend auf den E-Mailverkehr umzusteigen.
    </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingFour">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
        Wie verarbeitet ihr meine Daten?
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionFAQ">
      <div class="accordion-body">
        Wir verarbeiten Ihre Daten strengvertraulich nach der <a href=https://eur-lex.europa.eu/legal-content/DE/TXT/?uri=CELEX%3A32016R0679>DSGVO</a><br>
        Sollten Sie sich dennoch in Ihrem Datenschutz eingeschränkt fühlen, können Sie jederzeit einen Admin kontaktieren um Ihre Nutzerdaten aus den Datenbanken löschen zu lassen.
    </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingFive">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
       Hilfe! Ich kann mich nicht in mein Nutzerkonto einloggen!
      </button>
    </h2>
    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionFAQ">
      <div class="accordion-body">
        Überprüfen sie nochmal Ihre Eingaben, sollten dennoch Probleme auftreten, kontaktieren Sie umgehend einen System-Administrator.
    </div>
    </div>
  </div>
</div>
</div>
<?php 
include("inc/footer.php")
?>