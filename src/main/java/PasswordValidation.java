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


public class PasswordValidation {
    public static String check(String input) {
        int securityLevelCounter = 0;
        char[] inputArr = input.toCharArray();

        boolean isLongEnough = PasswordValidation.checkLength(inputArr);
        boolean containsNumber = PasswordValidation.checkSpecialChars(inputArr);
        boolean containsUpperLowerCase = PasswordValidation.checkUpperLowerCase(inputArr);

        if(isLongEnough)securityLevelCounter++;
        if(containsNumber)securityLevelCounter++;
        if(containsUpperLowerCase)securityLevelCounter++;

        return checkSecurityLevel(securityLevelCounter);

    }

    public static String[][] check(String[] input){

        String[][] result = new String[input.length][2];

        for(int i=0; i < input.length; i++){
            result[i][0] = input[i];
            result[i][1] = PasswordValidation.check(input[i]);
        }

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
