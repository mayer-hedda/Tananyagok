<?php

    require_once('fuzzy-logic-class.php');

    $f = new Fuzzy_Logic();

    $f->clearMembers();
    // input
    $f->SetInputNames(array('eletkor', 'onallosag'));

    $f->addMember('eletkor', 'csecsemo', 0, 0.1, 0.2, MemberShipFunctionType::LINFINITY->value);
    $f->addMember('eletkor', 'gyerek', 0.15, array(2, 10), 15, MemberShipFunctionType::TRAPEZOID->value);
    $f->addMember('eletkor', 'serdulo', 12, 15, 18, MemberShipFunctionType::RINFINITY->value);

    $f->addMember('onallosag', 'alacsony', 0, 0.2, 0.4, MemberShipFunctionType::LINFINITY->value);
    $f->addMember('onallosag', 'kozepes', 0.35, array(0.5, 0.58), 0.73, MemberShipFunctionType::TRAPEZOID->value);
    $f->addMember('onallosag', 'magas', 0.6, 0.73, 1, MemberShipFunctionType::RINFINITY->value);

    // output
    $f->SetOutputNames(array('kutya'));

    $f->addMember('kutya', 'nem', 0, 0.15, 0.3, MemberShipFunctionType::TRIANGLE->value);
    $f->addMember('kutya', 'talan', 0.25, 0.5, 0.7, MemberShipFunctionType::TRIANGLE->value);
    $f->addMember('kutya', 'igen', 0.69, 0.8, 1, MemberShipFunctionType::TRIANGLE->value);

    // szabályok
    $f->clearRules();

    $f->addRule('IF eletkor.csecsemo AND onallosag.alacsony THEN kutya.nem');
    $f->addRule('IF eletkor.csecsemo AND onallosag.kozepes THEN kutya.nem');
    $f->addRule('IF eletkor.csecsemo AND onallosag.magas THEN kutya.nem');

    $f->addRule('IF eletkor.gyerek AND onallosag.alacsony THEN kutya.nem');
    $f->addRule('IF eletkor.gyerek AND onallosag.kozepes THEN kutya.talan');
    $f->addRule('IF eletkor.gyerek AND onallosag.magas THEN kutya.igen');

    $f->addRule('IF eletkor.serdulo AND onallosag.alacsony THEN kutya.nem');
    $f->addRule('IF eletkor.serdulo AND onallosag.kozepes THEN kutya.igen');
    $f->addRule('IF eletkor.serdulo AND onallosag.magas THEN kutya.igen');

    $f->SetRealInput('eletkor', 18);
    $f->SetRealInput('onallosag', 1);
    $fuzzy_output_array = $f->calcFuzzy();
    print_r($fuzzy_output_array);

?>