<?php
    
    require_once __DIR__.'/vendor/autoload.php';
    use Orhanerday\OpenAi\OpenAi;
    
    $api_key = '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';
    $open_ai = new OpenAi($api_key);
    
    $translate = 'Ez egy zöld labda';
    $prompt = 'Készíts egy 3 elemű JSON objectet. A kulcsok értéke hu, en, de, a hozzá tartozó értékek pedig az alábbi szöveg a kulcsnak megfelelő nyelvre fordított változata: '.$translate;
    
//    print $prompt;
    
    $complete = $open_ai->completion(
            [
                'model' => 'text-davinci-003',
                'prompt' => $prompt,
                'temperature' => 0,
                'max_tokens' => 2000,
                'top_p' => 1,
                'frequency_penalty' => 0,
                'presence_penalty' => 0,
            ]
    );
    
    $response = json_decode($complete, true);
    print_r($response);
    
    // Ellenőrizzük, hogy a válasz tartalmazza-e a 'choices' kulcsot és nem null értékű-e
    if (isset($response['choices']) && is_array($response['choices']) && count($response['choices']) > 0) {
        $translation = trim($response['choices'][0]['text']);
        echo $translation;
    } else {
        echo "Hiba a válaszban vagy hiányzik a 'choices' kulcs.";
        // Vagy kezeld a hibát megfelelően a szükséges lépésekkel
    }
    
    
    $servername = "localhost";
    $username = "root";
    $password = "";

    try {
      $pdo = new PDO("mysql:host=$servername;dbname=openai", $username, $password);
      // set the PDO error mode to exception
      $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
      echo "Connected successfully";
    } catch(PDOException $e) {
      echo "Connection failed: " . $e->getMessage();
    }
    
    $sql = 'CALL addAsd(:translation)';
    
    $arr = [];

    $statement = $pdo->prepare($sql);
    $statement->bindParam(':translation', $translation, PDO::PARAM_STR);
    $statement->execute();

    $arr = $statement->fetchAll(PDO::FETCH_ASSOC);

    print_r($arr);

?>
