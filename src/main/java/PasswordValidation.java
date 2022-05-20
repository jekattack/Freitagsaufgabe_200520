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

        System.out.println("Test für folgendes Passwort: \n" + input);

        //Ist länger als 10 Zeichen? -->
        boolean isLongEnough = false;
        if (inputArr.length >= 10) {
            isLongEnough = true;
            securityLevelCounter++;
        } else {
            System.out.println("Dein Passwort ist nicht lang genug");
        }

        //Enthält Zahl? -->

        boolean containsNumber = false;
        for(int i = 0; i < inputArr.length; i++){
            if(!Character.isLetter(inputArr[i])){
                containsNumber = true;
            }
        }
        if (containsNumber) {
            securityLevelCounter++;
        } else {
            System.out.println("Ergänze mind. eine Zahl und/oder Sonderzeichen");
        }


        //Enthält Groß- & Kleinschreibung? -->
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
            securityLevelCounter++;
        }
        else {
            System.out.println("Ergänze Groß- bzw. Kleinschreibung");
        }

        System.out.println("_____________________");

        //Ausgabe Security-Level

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
