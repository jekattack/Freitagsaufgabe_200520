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
}