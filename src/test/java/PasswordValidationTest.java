import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    @Test
    void shouldReturnSecurityLevelGreen(){
        //Given
        String input = "P4ssw0rtSecur!ty";
        String[] expected = {"green", "", "", ""};
        //When
        String[] actual = PasswordValidation.check(input);
        //Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSecurityLevelYellow(){
        //Given
        String input = "P4ssw0rt";
        String[] expected = {"yellow", "Passwort ist zu kurz!", "", ""};
        //When
        String[] actual = PasswordValidation.check(input);
        //Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSecurityLevelRed(){
        //Given
        String input = "passwort";
        String[] expected = {"red", "Passwort ist zu kurz!", "Passwort enthält keine Zahlen/Sonderzeichen!", "Passwort enthält nur groß bzw. klein geschriebene Buchstaben!"};
        //When
        String[] actual = PasswordValidation.check(input);
        //Then
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldReturnSecurityLevelsForSeveralPasswords(){
        //Given
        String[] input = {"P4ssw0rtSecur!ty", "P4ssw0rt", "passwort"};
        String[][] expected = {{"P4ssw0rtSecur!ty", "green", "", "", ""}, {"P4ssw0rt", "yellow", "Passwort ist zu kurz!", "", ""}, {"passwort", "red", "Passwort ist zu kurz!", "Passwort enthält keine Zahlen/Sonderzeichen!", "Passwort enthält nur groß bzw. klein geschriebene Buchstaben!"}};
        //When
        String[][] actual = PasswordValidation.check(input);
        //Then
        assertArrayEquals(expected, actual);
    }

}