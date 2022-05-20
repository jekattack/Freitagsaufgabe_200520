/*
* Das Passwort sollte 3 Bedingungen erfüllen:
* 1) Es sollte mind. 10 Zeichen lang sein
* 2) Es sollte mind. eine Zahl enthalten
* 3) Es sollte Groß- & Kleinschreibung enthalten
*
* Sind 3 Bedingungen erfüllt, wird Security-Level "green" zurückgegeben.
* Ist eine Bedingung erfüllt, wird Security-Level "yellow" zurückgegeben.
* Ist keine Bedingung erfüllt, wird Security-Level "red" zurückgegeben.
* * */


import java.util.Arrays;

public class PasswordValidation {
    public static String[] check(String input) {
        int securityLevelCounter = 3;
        char[] inputArr = input.toCharArray();
        String[] checkResult = new String[4];
        Arrays.fill(checkResult, "");

        boolean isLongEnough = PasswordValidation.checkLength(inputArr);
        boolean containsNumber = PasswordValidation.checkSpecialChars(inputArr);
        boolean containsUpperLowerCase = PasswordValidation.checkUpperLowerCase(inputArr);

        if(!isLongEnough){
            securityLevelCounter--;
            checkResult[1] = "Passwort ist zu kurz!";
        }
        if(!containsNumber){
            securityLevelCounter--;
            checkResult[2] = "Passwort enthält keine Zahlen/Sonderzeichen!";
        }
        if(!containsUpperLowerCase){
            securityLevelCounter--;
            checkResult[3] = "Passwort enthält nur groß bzw. klein geschriebene Buchstaben!";
        }

         checkResult[0] = checkSecurityLevel(securityLevelCounter);

        return checkResult;
    }

    public static String[][] check(String[] input){

        String[][] result = new String[input.length][5];

        for(int i=0; i < input.length; i++){
            result[i][0] = input[i];
            String[] checkResult = PasswordValidation.check(input[i]);
            for (int j = 0; j < checkResult.length; j++){
                result[i][1+j] = checkResult[j];
            }
        }
        System.out.println(result[0][0]);

        return result;

    }

    private static boolean checkLength(char[] inputArr){
        if (inputArr.length >= 10) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkSpecialChars(char[] inputArr){
        for(int i = 0; i < inputArr.length; i++){
            if(!Character.isLetter(inputArr[i])){
                return true;
            }
        }
        return false;
    }

    private static boolean checkUpperLowerCase(char[] inputArr){
        boolean containsUppercase = false;
        boolean containsLowercase = false;

        for(int i = 0; i < inputArr.length; i++){
            if(Character.isUpperCase(inputArr[i])){
                containsUppercase = true;
            } else {
                containsLowercase = true;
            }
        }

        if (containsUppercase && containsLowercase) {
            return true;
        } else {
            return false;
        }
    }

    private static String checkSecurityLevel(int securityLevelCounter){
        switch (securityLevelCounter){
            case 0:
                return "red";
            case 1:
                return "yellow";
            case 2:
                return "yellow";
            case 3:
                return "green";
            default:
                return "Error!";
        }
    }
}
