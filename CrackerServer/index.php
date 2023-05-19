<?php
// Récupération du mot de passe envoyé en POST
if (isset($_POST['mot_de_passe'])) {
    $motDePasseRecu = $_POST['mot_de_passe'];

    // Mot de passe initialisé dans le serveur
    $motDePasseServeur = "passer";

    if ($motDePasseRecu === $motDePasseServeur) {
        // Mot de passe correct
        $success = true;
        $message = 'Mot de passe correct';
        $http_status = 200; //Code de statut OK
    } else {
        // Mot de passe incorrect
        $success = false;
        $message = 'Mot de passe incorrect';
        $http_status = 401; // Code de statut Unauthorized
    }
} else {
    // Pas de mot de passe reçu en POST
    $success = false;
    $message = 'Mot de passe non reçu';

    $http_status = 400; // Code de statut Bad Request
}

$response = array('success' => $success, 'message' => $message,'httpStatus'=>$http_status);
// Conversion de la réponse en JSON
$jsonResponse = json_encode($response);

// Envoi de la réponse au client avec le code de statut approprié
http_response_code($httpStatus);
header('Content-Type: application/json');
echo $jsonResponse;
?>
