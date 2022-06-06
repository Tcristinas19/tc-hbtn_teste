import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person person;

    @BeforeEach
        void setup() {
        person = new Person("Paul", "McCartney", new Date(2000),
                true, true, true);
    }

        @Test
            void show_full_name(){
                assertEquals("Paul McCartney", person.fullname());
        }

        @Test
            void test_calculateYearlySalary(){
                person.setSalary(1200);

                assertEquals(14400, person.calculateYearlySalary());
        }

        @Test
            void person_is_MEI(){
                person.setBirthdate(new Date(2000));
                person.setSalary(1200);
                person.setAnotherCompanyOwner(false);
                person.setPensioner(false);
                person.setPublicServer(false);

                assertTrue(person.isMEI());
        }

        @Test
            void person_is_not_MEI(){
                person.setPensioner(true);

                assertFalse(person.isMEI());
        }
}