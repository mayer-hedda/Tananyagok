<?php

require_once('fuzzy-logic-class.php');

    $p = new Fuzzy_Logic();

    $p->clearMembers();
    // input
    $p->SetInputNames(array('alkoholtartalom', 'erintkezes'));

    $p->addMember('alkoholtartalom', 'alacsony', 0, 0.15, 0.3, MemberShipFunctionType::LINFINITY->value);
    $p->addMember('alkoholtartalom', 'kozepes', 0.2, array(0.3, 0.4), 0.5, MemberShipFunctionType::TRAPEZOID->value);
    $p->addMember('alkoholtartalom', 'magas', 0.46, 0.54, 0.65, MemberShipFunctionType::RINFINITY->value);

    $p->addMember('erintkezes', 'keves', 0, 0.2, 0.5, MemberShipFunctionType::LINFINITY->value);
    $p->addMember('erintkezes', 'eleg', 0.4, array(0.5, 0.69), 1, MemberShipFunctionType::TRAPEZOID->value);
    $p->addMember('erintkezes', 'sok', 0.8, 1.2, 1.5, MemberShipFunctionType::RINFINITY->value);

    // output
    $p->SetOutputNames(array('iz'));

    $p->addMember('iz', 'rossz', 0, 0.15, 0.3, MemberShipFunctionType::LINFINITY->value);
    $p->addMember('iz', 'elmegy', 0.25, array(0.37, 0.59), 0.7, MemberShipFunctionType::TRAPEZOID->value);
    $p->addMember('iz', 'finom', 0.67, 0.8, 1, MemberShipFunctionType::RINFINITY->value);

    // szabályok
    $p->clearRules();

    $p->addRule('IF alkoholtartalom.alacsony AND erintkezes.keves THEN iz.elmegy');
    $p->addRule('IF alkoholtartalom.alacsony AND erintkezes.eleg THEN iz.finom');
    $p->addRule('IF alkoholtartalom.alacsony AND erintkezes.sok THEN iz.rossz');

    $p->addRule('IF alkoholtartalom.kozepes AND erintkezes.keves THEN iz.elmegy');
    $p->addRule('IF alkoholtartalom.kozepes AND erintkezes.eleg THEN iz.finom');
    $p->addRule('IF alkoholtartalom.kozepes AND erintkezes.sok THEN iz.elmegy');

    $p->addRule('IF alkoholtartalom.magas AND erintkezes.keves THEN iz.rossz');
    $p->addRule('IF alkoholtartalom.magas AND erintkezes.eleg THEN iz.finom');
    $p->addRule('IF alkoholtartalom.magas AND erintkezes.sok THEN iz.elmegy');

    $p->SetRealInput('alkoholtartalom', 0.43);
    $p->SetRealInput('erintkezes', 1);
    $fuzzy_output_array = $p->calcFuzzy();
    print_r($fuzzy_output_array);

?>