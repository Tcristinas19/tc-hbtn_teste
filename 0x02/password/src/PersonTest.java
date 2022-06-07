import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    Person person;

    @BeforeAll
    void setup(){
        person = new Person();
    }

    @ParameterizedTest(name = "username = {0}")
    @ValueSource(strings = {"Paul McCartney2" , "Neil@Arms"})
        void check_user_valid(String username){
        person.setUsername(username);

        assertTrue(person.checkUser());
    }

    @ParameterizedTest(name = "username = {0}")
    @ValueSource(strings = {"Paul#McCartney" , "Neil@Arms" })
        void check_user_not_valid(String username){
        person.setUsername(username);

        assertFalse(person.checkUser());
    }

    @ParameterizedTest(name = "password = {0}")
    @ValueSource(strings = { "123456789" , "#$%1234" })
        void does_not_have_letters(String password){
        person.setPassword(password);

        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "password = {0}")
    @ValueSource(strings = { "Abcabcdefgh@" , "#hbtn@%tc" })
        void does_not_have_numbers(String password){
        person.setPassword(password);

        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "password = {0}")
    @ValueSource(strings = { "Abc@123" , "12$@hbt" })
        void does_not_have_eight_chars(String password){
        person.setPassword(password);

        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "password = {0}")
    @ValueSource(strings = { "abC123456$" , "Hbtn@1234" , "Betty@1#2" , "Hbtn@123" })
        void check_password_valid(String password){
        person.setPassword(password);

        assertTrue(person.checkPassword());
    }
}