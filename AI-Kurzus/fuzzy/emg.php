<?php
require_once ('fuzzy-logic-class.php');
require_once ('bandpass.php');
require_once ('rms.php');
require_once ('fft.php');
$fuzzy = new Fuzzy_Logic();
$fuzzy->clearMembers(); 

$fuzzy->SetInputNames(array('input1'));
$fuzzy->addMember('input1', 'mf1', 0, 0.4167, 1, MemberShipFunctionType::LINFINITY->value);
$fuzzy->addMember('input1', 'mf2', 0, 0.345, 1, MemberShipFunctionType::RINFINITY->value);

$fuzzy->setOutputNames(array('output1'));
$fuzzy->addMember('output1', 'omf1', 0, 0, 0.01, MemberShipFunctionType::LINFINITY->value);
$fuzzy->addMember('output1', 'omf2', 0.5, 0.999, 1, MemberShipFunctionType::RINFINITY->value);

$fuzzy->clearRules();

//$fuzzy->addRule('IF project_funding.adequate OR project_staffing.small THEN risk.low');
$fuzzy->addRule('IF input1.mf1 THEN output1.omf1');
$fuzzy->addRule('IF input1.mf2 THEN output1.omf2');


//$inputValue = 0.035;
//$fuzzy->setRealInput('input1', $inputValue);
//$fuzzy_output_array = $fuzzy->calcFuzzy();
//print $fuzzy_output_array['output1'];
//$th = $fuzzy_output_array['output1'];
//print_r($fuzzy->getRules());



$path = 'iman.csv';//'./patients/' . $_SESSION['patient'] . '/' . $_SESSION['file'];
//print $path;
$file = fopen($path, 'r');

$data = array();
$k = 0;
while(!feof($file)){
    $row = fgets($file);
    $x = explode(';', $row);
    for($j = 0; $j < count($x); $j++){
        
            $data[$k] = abs($x[2]);
       
    }
    $k++;
}
//print 'ÁTALG: ' . (array_sum($data) / count($data));
//print_r($data);
$max = 488;
$norm = array();
//print $max / count($data);
for($i = 0; $i < count($data); $i++){
    if($data[$i] < $max){
        $norm[$i] = $data[$i] / $max;
    }
    else{
        $norm[$i] = 1;
    }
}
//print_r($norm);


header('Content-type: image/png');
$img = imagecreatetruecolor(4000, 700);
$green = imagecolorallocate($img, 0, 100, 0);
$green2 = imagecolorallocate($img, 0, 255, 0);
$red = imagecolorallocate($img, 255, 0, 0);
$red2 = imagecolorallocate($img, 100, 0, 0);
$yellow = imagecolorallocate($img, 255, 255, 0);
$yellow2 = imagecolorallocate($img, 100, 100, 0);

$fft = fft($norm);
for($i = 1; $i < count($fft); $i++){
   // imageline($img, $i - 1, 700 - $fft[$i - 1] * 300, $i, 700 - $fft[$i] * 300, $red);
    if($i % 100 == 0){
        imageline($img, $i, 0, $i, 700, $yellow);
    }
 
}

$band = bandpass_filter($norm, 0, 100);
//print_r($band);
$rms = rms($band, 40);


$basicOutputRMS = array();
for($i = 1; $i < count($norm); $i++){
    imageline($img, $i - 1, 700 - $norm[$i - 1] * 300, $i, 700 - $norm[$i] * 300, $green);
    $basicOutputRMS[] = $norm[$i - 1];
  
}

$fuzzyTreshold = 0.75;
if(isset($_GET['th'])){
    $fuzzyTreshold = $_GET['th'];
}
$fuzzyOut = array();
for($i = 1; $i < count($norm); $i++){
    $inputValue = $norm[$i - 1];
    $fuzzy->setRealInput('input1', $inputValue);
    $fuzzy_output_array = $fuzzy->calcFuzzy();
    $th1 = $fuzzy_output_array['output1'];

    $inputValue = $norm[$i];
    $fuzzy->setRealInput('input1', $inputValue);
    $fuzzy_output_array = $fuzzy->calcFuzzy();
    $th2 = $fuzzy_output_array['output1'];
    //print $th . '<br>';
    //imageline($img, $i - 1, 700 - $th1 * 300, $i, 700 - $th2 * 300, $yellow2);
    imagefilledellipse($img, $i - 1, 700 - $th1 * 300, 5, 5, $yellow2);
    if($th1 >= $fuzzyTreshold){
        $fuzzyOut[] = $norm[$i];
    }
    else{
        $fuzzyOut[] = 0;
    }
}
$white = imagecolorallocate($img, 255, 255, 255);

for($i = 1; $i < count($rms); $i++){
    //$color = imagecolorallocate($img, $_SESSION['color'][$i]['red'], $_SESSION['color'][$i]['green'], $_SESSION['color'][$i]['blue']);
        imageline($img, $i, 699 - $rms[$i - 1]* 300, $i, 699 - $rms[$i]* 300, $red);//red rms
    
    }

    $fuzzyOutputRMS = array();
    for($i = 1; $i < count($fuzzyOut); $i++){
        //$color = imagecolorallocate($img, $_SESSION['color'][$i]['red'], $_SESSION['color'][$i]['green'], $_SESSION['color'][$i]['blue']);
       //print_r($realOutput);
       $fuzzyOutputRMS[] = $fuzzyOut[$i - 1];
           imageline($img, $i, 699 - $fuzzyOut[$i - 1]* 300, $i, 699 - $fuzzyOut[$i]* 300, $yellow2);//yellow2
        
        }

$timeWindow = 40;
$realOutput = array();
for($i = 0; $i < count($fuzzyOut); $i+=$timeWindow){
    $slice = array_slice($fuzzyOut, $i, $timeWindow);
    $realAvg = array();
    //print_r($slice);
    for($j = 0; $j < count($slice); $j++){
        if($slice[$j] != 0){
            $realAvg[] = $slice[$j];
        }
    } 
    //print 'A: ';
    //print_r($realAvg);
    if(count($realAvg) != 0){
        $sliceAvg = array_sum($realAvg) / count($realAvg);
    }
    else{
        $sliceAvg = 0;
    }
    if(count($realAvg) < $timeWindow / 4){
        $sliceAvg = 0;
    }
    $realOutput = array_merge($realOutput, array_fill($i, $timeWindow, $sliceAvg));
    //imageline($img, $i, 699 - $sliceAvg* 300, $i + $timeWindow, 699 - $sliceAvg* 300, $yellow);
        
}

for($i = 1; $i < count($realOutput); $i++){
    //$color = imagecolorallocate($img, $_SESSION['color'][$i]['red'], $_SESSION['color'][$i]['green'], $_SESSION['color'][$i]['blue']);
  
        imageline($img, $i, 699 - $realOutput[$i - 1]* 300, $i, 699 - $realOutput[$i]* 300, $yellow);//yellow rms
        //imageline($img, $i, 699 - $realOutput* 300, $i + $timeWindow, 699 - $sliceAvg* 300, $yellow);
    }


$outputCsv = '';
for($i = 0; $i < count($fuzzyOutputRMS); $i++){
    $outputCsv .= $fuzzyOutputRMS[$i] . ';' . $basicOutputRMS[$i] . '
';
}
file_put_contents('sig_output.csv', $outputCsv);


imagepng($img);
imagedestroy($img);

?>