<?php
$usernameServer = "diery";
$passwordServer = password_hash("passer", PASSWORD_DEFAULT);
$data = [];

// Récupération du mot de passe envoyé en POST
if (isset($_POST['password']) && isset($_POST['username'])) {
    $username = $_POST['username'];
    $password = $_POST['password']; 


    if ($username === $usernameServer && password_verify($password, $passwordServer)) {
        // Mot de passe correct
        $success = true;
        $message = 'authentification réussi';
        $http_status = 200; //Code de statut OK
        $data = ["username" => $usernameServer, "password"=>$passwordServer ];

    } else {
        // Mot de passe incorrect
        $success = false;
        $message = 'credential incorrect';
        $http_status = 401; // Code de statut Unauthorized
    }
} else {
    // Pas de mot de passe reçu en POST
    $success = false;
    $message = 'username ou password non reçu';

    $http_status = 400; // Code de statut Bad Request
}

$response = array('success' => $success, 'message' => $message,'httpStatus'=>$http_status, "data"=> $data);
// Conversion de la réponse en JSON
$jsonResponse = json_encode($response);

// Envoi de la réponse au client avec le code de statut approprié
http_response_code($http_status);
header('Content-Type: application/json');
echo $jsonResponse;
?>
