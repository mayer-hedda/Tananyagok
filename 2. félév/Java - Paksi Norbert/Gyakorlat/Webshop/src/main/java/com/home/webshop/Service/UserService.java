package com.home.webshop.Service;

import com.home.webshop.Config.Token;
import com.home.webshop.Model.User;
import org.json.JSONObject;

public class UserService {
    
    public static String createUser(String username, String email, String password, String phone, String surename, String forename) {
         // Logikai validálás
        try{
            if(!User.emailCheck(email)){
                // email vizsgálat
                // Az emailcím formailag helyet, gmail domain, és a @ előtt legalább 3 karakteres, érvényes "név" szerepel

                return "";
            }

            else if(!User.passwordCheck(password)){
                // jelszó vizsgálat
                // Jelszó hossza legalább 8 karakter, van benne 1-1 kis és nagybetű 1 szám, és 1 speciális karakter
                // + A jelszüban a speciális karakter nem lehet az első és az utolsó helyen
                return "";
            }

            else if(User.createUser(username, email, password, "vásárló", phone, surename, forename, 1)){
                return "Sikeres regisztráció!";
            }

            else{
                return "Sikertelen regisztráció";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
        
    }
    
    public static JSONObject login(String email, String password) {
        User u = User.login(email, password);
        String token = Token.createJwt(u);
        
        JSONObject obj = new JSONObject();
        obj.put("user", u.toString());
        obj.put("jwt", token);
        
        return obj;
    }
    
}
