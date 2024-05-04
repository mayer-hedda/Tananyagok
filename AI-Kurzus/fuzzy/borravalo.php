<?php
    /*
    Feladat: borravaló probléma
        - input:
            - előzetes elvárás (putri, átlagos, elit) --> V = {P, Á, L}
            - anyagi helyzet (csóró, átlagos, gazdag) --> A = {CS, Á, G}
            - kiszolgálás (szar, átlagos, jó) --> K = {SZ, Á, J}
            - milyen finom volt az étel (fos, átlagos, ínycsiklandozó) --> M = {F, Á, I}

        - output:
            - borravaló (zero, kevés, sok) --> BV = {Z, K, S}
    */

    require_once ('fuzzy-logic-class.php');
    $fuzzy = new Fuzzy_Logic();


    $fuzzy->clearMembers(); 

    // INPUTOK
    $fuzzy->SetInputNames(array('V'));  // előzetes elvárás
    $fuzzy->addMember('V', 'P', 0, 2.4, 4, MemberShipFunctionType::LINFINITY->value);               // putri
    $fuzzy->addMember('V', 'Á', 3.5, 4.4, 6.3, 7.2, MemberShipFunctionType::TRAPEZOID->value);      // átlagos  
    $fuzzy->addMember('V', 'L', 6.5, 8.1, 10, MemberShipFunctionType::RINFINITY->value);            // elit

    $fuzzy->SetInputNames(array('A'));  // anyagi helyzet
    $fuzzy->addMember('A', 'CS', 0, 2, 4.2, MemberShipFunctionType::LINFINITY->value);              // csóró
    $fuzzy->addMember('A', 'Á', 3.7, 4.5, 6.2, 7.8, MemberShipFunctionType::TRAPEZOID->value);      // átlagos  
    $fuzzy->addMember('A', 'G', 7, 8.3, 10, MemberShipFunctionType::RINFINITY->value);              // gazdag

    $fuzzy->SetInputNames(array('K'));  // kiszolgálás
    $fuzzy->addMember('K', 'SZ', 0, 3.4, 4.2, MemberShipFunctionType::LINFINITY->value);            // szar 
    $fuzzy->addMember('K', 'Á', 4, 4.6, 6.1, 8.1, MemberShipFunctionType::TRAPEZOID->value);        // átlagos
    $fuzzy->addMember('K', 'J', 7.4, 8.4, 10, MemberShipFunctionType::RINFINITY->value);            // jó

    $fuzzy->SetInputNames(array('M'));  // milyen finom volt az étel
    $fuzzy->addMember('M', 'F', 0, 3.5, 5.8, MemberShipFunctionType::LINFINITY->value);             // fos
    $fuzzy->addMember('M', 'Á', 4.9, 6, 7.7, 8.9, MemberShipFunctionType::TRAPEZOID->value);        // átlagos  
    $fuzzy->addMember('M', 'Í', 8.2, 9.1, 10, MemberShipFunctionType::RINFINITY->value);            // ínycsiklandozó


    // OUTPUTOK
    $fuzzy->setOutputNames(array('BV'));   // borravaló
    $fuzzy->addMember('BV', 'Z', 0, 0, 1.6, MemberShipFunctionType::LINFINITY->value);              // zéró
    $fuzzy->addMember('BV', 'K', 0.4, 1.8, 5.9, 7.2, MemberShipFunctionType::TRAPEZOID->value);          // kevés
    $fuzzy->addMember('BV', 'S', 6.1, 8.2, 10, MemberShipFunctionType::RINFINITY->value);          // sok



    $fuzzy->clearRules();

    // SZABÁLYOK
    $fuzzy->addRule('IF V.P AND A.CS AND K.SZ AND M.F THEN BV.Z');
    // $fuzzy->addRule('IF V.P AND A.CS AND K.SZ AND M.Á THEN BV.Z');
    // $fuzzy->addRule('IF V.P AND A.CS AND K.Á AND M.F THEN BV.Z');
    // $fuzzy->addRule('IF V.P AND A.Á AND K.SZ AND M.F THEN BV.Z');
    // $fuzzy->addRule('IF V.Á AND A.CS AND K.SZ AND M.F THEN BV.Z');
    $fuzzy->addRule('IF V.P AND A.Á AND K.J AND M.Á THEN BV.K');
    $fuzzy->addRule('IF V.Á AND A.Á AND K.Á AND M.Á THEN BV.K');
    $fuzzy->addRule('IF V.P AND A.G AND K.Á AND M.Í THEN BV.S');
    $fuzzy->addRule('IF V.E AND A.G AND K.J AND M.Í THEN BV.S');
    $fuzzy->addRule('IF V.Á AND A.CS AND K.Á AND M.F THEN BV.Z');


    $elvaras = (isset($_GET['elvaras'])) ? $_GET['elvaras'] : 40;   
    $anyagiHelyzet = (isset($_GET['anyagiHelyzet'])) ? $_GET['anyagiHelyzet'] : 70; 
    $kiszolgalas = (isset($_GET['kiszolgalas'])) ? $_GET['kiszolgalas'] : 30; 
    $elegedettseg = (isset($_GET['elegedettseg'])) ? $_GET['elegedettseg'] : 100; 

    $fuzzy->SetRealInput('elvaras', $elvaras);
    $fuzzy->SetRealInput('anyagiHelyzet', $anyagiHelyzet);
    $fuzzy->SetRealInput('kiszolgalas', $kiszolgalas);
    $fuzzy->SetRealInput('elegedettseg', $elegedettseg);
    $fuzzy_arr = $fuzzy->calcFuzzy();
    $risk = $fuzzy_arr['risk'];
    $bar_width = 320;

?>

<div class="container">
    <h2 align="center">Borravaló kalkulátor</h2>
    <div class="span-16 prepend-4 append-4 last">
        <form>
            <label for="Elvaras">Előzetes elvárás: [0..100%]</label>
            <input type="text" id="elvaras" name="Elvaras" value="<?php echo $project_funding;?>"><br> 

            <label for="anyagiHelyzet">Anyagi helyzet: [0..100%]</>
            <input type="text" id="anyagiHelyzet" name="anyagiHelyzet" value="<?php echo $project_staffing;?>"><br> 

            <label for="kiszolgalas">Kiszolgálás: [0..100%]</>
            <input type="text" id="kiszolgalas" name="kiszolgalas" value="<?php echo $project_staffing;?>"><br> 

            <label for="elegedettseg">Mennyire volt finom az étel:  [0..100%]</>
            <input type="text" id="elegedettseg" name="elegedettseg" value="<?php echo $project_staffing;?>"><br> 


            <input type="submit" name="calculate" value="calculate">
            <div style="width: <?php echo $bar_width;?>px;height:22px;border: 1px solid #000;;text-align:center;">
                <div style="width: <?php echo round($risk*$bar_width/100); ?>px;height:18px;margin:1px;background-color:red;border: 1px solid #000"><?php echo sprintf("%3.1f %%",$risk);?></div>
            </div>
        </form>
    </div>
</div>

