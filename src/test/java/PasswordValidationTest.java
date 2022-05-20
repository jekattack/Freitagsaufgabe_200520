import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    @Test
    void shouldReturnSecurityLevelGreen(){
        //Given
        String input = "P4ssw0rtSecur!ty";
        String expected = "green";
        //When
        String actual = PasswordValidation.check(input);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSecurityLevelYellow(){
        //Given
        String input = "P4ssw0rt";
        String expected = "yellow";
        //When
        String actual = PasswordValidation.check(input);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSecurityLevelRed(){
        //Given
        String input = "passwort";
        String expected = "red";
        //When
        String actual = PasswordValidation.check(input);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    void shouldReturnSecurityLevelsForSeveralPasswords(){
        //Given
        String[] input = {"P4ssw0rtSecur!ty", "P4ssw0rt", "passwort"};
        String[][] expected = {{"P4ssw0rtSecur!ty", "green"}, {"P4ssw0rt", "yellow"}, {"passwort", "red"}};
        //When
        String[][] actual = PasswordValidation.check(input);
        //Then
        assertArrayEquals(expected, actual);
    }

}