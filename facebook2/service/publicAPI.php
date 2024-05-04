<?php
    //! Csapat: Mikola Bálint, Kánya Szabolcs, Mayer Hedda

    //? POST
    // header('content-type: application/json');
    // $langT = array('en', 'de');
    // $lang = $langT[rand(0, 1)];
    // $url = 'https://uselessfacts.jsph.pl/api/v2/facts/random?language=' . $lang;
    // $result = file_get_contents($url);
    // echo $result;


    //? GET
    // header('content-type: application/json');

    // $url = 'https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos';
    // $opts = array('http' =>
    //     array(
    //         'method' => 'GET',
    //         'header' => 'Content-type: application/x-www-form-urlencoded',
    //     )
    // );
    // $context = stream_context_create($opts);
    // $result = file_get_contents($url, false, $context);
    // echo $result;

    class publicAPI {
        // private $url = 'https://api.genderize.io/?name=';

        public function getNameInfo(string $name) {
            $url = 'https://api.genderize.io/?name=';
            return file_get_contents($url.$name);
        }

        public function getCalendarInfo(string $cuontry, string $year) {
            $apiKey = '';
            $url = 'https://calendarific.com/api/v2/jolidays?';
            return file_get_contents($url.'country='.$cuontry.'&year='.$year);
        }

        public function formUpload() {
            $data = array();
            $data['entry.400586822'] = 'Ez egy szöveges válasz';
            $data['entry.400586822'] = 'Körte';
            // $data['entry.400586822'] = 'Ez egy szöveges válasz';

            $url = '';
            $postdata = http_build_query(
                array(
                    'entry.1607227231' => 'szőlő', 
            'entry.951057824' => 'phpteszt',
            'entry.123924037' => 'körte',
                )
            );
            $opts = array('http' =>
                array(
                    'method' => 'POST',
                    'header' => 'Content-type: application/x-www-form-urlencoded',
                    'content' => $postdata
                )
            );
            $context = stream_context_create($opts);
            $result = file_get_contents($url, false, $context);
            echo $result;
        }

    }

?>