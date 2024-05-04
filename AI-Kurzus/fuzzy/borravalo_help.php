<?php

require_once ('fuzzy-logic-class.php');

$x = new Fuzzy_Logic;

$x->clearMembers();
$x->SetInputNames(array('elvaras','anyagi_helyzet','kiszolgalas','minoseg'));

$x->addMember($x->getInputName(0),'putri',  0, 20, 40 ,MemberShipFunctionType::LINFINITY->value);
$x->addMember($x->getInputName(0),'atlagos',  35, 50, 65 ,MemberShipFunctionType::TRAPEZOID->value);
$x->addMember($x->getInputName(0),'elit',  60, 80, 100 ,MemberShipFunctionType::RINFINITY->value);

$x->addMember($x->getInputName(1),'csoro',  0, 20, 40 ,MemberShipFunctionType::LINFINITY->value);
$x->addMember($x->getInputName(1),'atlagos',  35, 50, 65 ,MemberShipFunctionType::TRAPEZOID->value);
$x->addMember($x->getInputName(1),'gazdag',  60, 80, 100 ,MemberShipFunctionType::RINFINITY->value);

$x->addMember($x->getInputName(2),'szar',  0, 20, 40 ,MemberShipFunctionType::LINFINITY->value);
$x->addMember($x->getInputName(2),'atlagos',  35, 50, 65 ,MemberShipFunctionType::TRAPEZOID->value);
$x->addMember($x->getInputName(2),'jo',  60, 80, 100 ,MemberShipFunctionType::RINFINITY->value);

$x->addMember($x->getInputName(3),'fos',  0, 20, 40 ,MemberShipFunctionType::LINFINITY->value);
$x->addMember($x->getInputName(3),'atlagos',  35, 50, 65 ,MemberShipFunctionType::TRAPEZOID->value);
$x->addMember($x->getInputName(3),'inycsiklando',  60, 80, 100 ,MemberShipFunctionType::RINFINITY->value);

$x->SetOutputNames(array('borravalo'));
$x->addMember($x->getOutputName(0),'zero', 0, 20 , 40 ,MemberShipFunctionType::LINFINITY->value);
$x->addMember($x->getOutputName(0),'keves', 35, 50 , 65 ,MemberShipFunctionType::TRAPEZOID->value);
$x->addMember($x->getOutputName(0),'sok', 60, 80 , 100 ,MemberShipFunctionType::RINFINITY->value);

$x->clearRules();
$x->addRule('IF kiszolgalas.szar AND minoseg.fos THEN borravalo.zero');
$x->addRule('IF elvaras.putri AND kiszolgalas.jo AND minoseg.inycsiklando THEN borravalo.sok');
$x->addRule('IF elvaras.atlagos OR anyagi_helyzet.atlagos OR kiszolgalas.atlagos OR minoseg.atlagos THEN borravalo.keves');
$x->addRule('IF anyagi_helyzet.gazdag THEN borravalo.sok');

$elvaras = (isset($_GET['elvaras'])) ? $_GET['elvaras'] : 50;   
$anyagi_helyzet = (isset($_GET['anyagi_helyzet'])) ? $_GET['anyagi_helyzet'] : 50; 
$kiszolgalas = (isset($_GET['kiszolgalas'])) ? $_GET['kiszolgalas'] : 50; 
$minoseg = (isset($_GET['minoseg'])) ? $_GET['minoseg'] : 50;

$x->SetRealInput('elvaras', $elvaras);
$x->SetRealInput('anyagi_helyzet', $anyagi_helyzet);
$x->SetRealInput('kiszolgalas', $kiszolgalas);
$x->SetRealInput('minoseg', $minoseg);

$fuzzy_arr = $x->calcFuzzy();
$risk = $fuzzy_arr['borravalo'];
$bar_width = 320;

?>

<html>
<head>
    <title>Borravaló</title>
</head>
<body>
    <div class="container">
        <h2 align="center">Borravaló</h2>
        <div class="span-16 prepend-4 append-4 last">
        <form>
            <label for="elvaras">Elvárás
            <input type="text" id="elvaras" name="elvaras" value="<?php echo $elvaras;?>" /><br />  
            <label for="anyagi_helyzet">Anyagi helyzet
            <input type="text" id="anyagi_helyzet" name="anyagi_helyzet" value="<?php echo $anyagi_helyzet;?>" /><br /> 
            <label for="kiszolgalas">Kiszolgálás
            <input type="text" id="kiszolgalas" name="kiszolgalas" value="<?php echo $kiszolgalas;?>" /><br /> 
            <label for="minoseg">Minőség
            <input type="text" id="minoseg" name="minoseg" value="<?php echo $minoseg;?>" /><br /> 
            <input type="submit" name="kiszámol" value="kiszámol" />
            <div style="width: <?php echo $bar_width;?>px;height:22px;border: 1px solid #000;;text-align:center;">
            <div style="width: <?php echo round($risk*$bar_width/100); ?>px;height:18px;margin:1px;background-color:red;border: 1px solid #000"><?php echo sprintf("%3.1f %%",$risk);?></div>
        </form>
    </div>
</body>
</html>