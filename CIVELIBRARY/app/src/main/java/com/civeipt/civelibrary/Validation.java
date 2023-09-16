package com.civeipt.civelibrary;

import java.util.regex.*;

public class Validation {
    Boolean hasUpper=false, hasLower=false;
    Boolean hasDigit=false, hasSpecial=false, hasChar=false;
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

    Boolean isValidPassword(String password){
        for (int i=0; i<password.length(); i++){
            if (Character.isUpperCase(password.charAt(i))){
                hasUpper=true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                hasLower=true;
            }
            if (Character.isDigit(password.charAt(i))){
                hasDigit=true;
            }
            if (!Character.isUpperCase(password.charAt(i)) && !Character.isLowerCase(password.charAt(i)) && !Character.isDigit(password.charAt(i))){
                hasSpecial=true;
            }
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial && (password.length()>7 && password.length()<16)){
            return true;
        }else return (hasUpper || hasLower || hasDigit) && hasSpecial && (password.length() > 5 && password.length() < 16);
    }

    Boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    Boolean phone_no_validation(String phone_no){
        int Dig_counter=0;
        for(int i=0; i<phone_no.length(); i++){
            if(i>0){
                if(Character.isDigit(phone_no.charAt(i))){
                    Dig_counter++;
                    if(Dig_counter==12){
                        hasDigit=true;
                    }
                }
            }
            if(i==0){
                if(phone_no.charAt(i)=='+'){
                    hasSpecial=true;
                }
            }
        }

        return hasDigit && hasSpecial;

    }

    Boolean reg_no_Validation(String reg_no){
        int dig_counter=0, hp_counter=0;
        for(int i=0; i<reg_no.length(); i++){
            if(i==0 && !Character.isDigit(reg_no.charAt(0))){
                hasChar=true;
            }
            if(i>0 && i<3){
                if(Character.isDigit(reg_no.charAt(i))){
                    dig_counter++;
                }
            }
            if(i==3 || i==6){
                if(reg_no.charAt(i)=='-'){
                    hp_counter++;
                }
            }
            if(i>3 && i<6){
                if(Character.isDigit(reg_no.charAt(i))){
                    dig_counter++;
                }

            }
            if(i>6 && i<12){
                if(Character.isDigit(reg_no.charAt(i))){
                    dig_counter++;
                }

            }
        }

        return hasChar && dig_counter == 9 && hp_counter == 2 && reg_no.length() == 12;
    }

}
