////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User test;

    @Before
    public void beforeTest() {
        test = new User("112233","Sandro","Sampei",LocalDate.of(1970, 6, 11));
    }

    @Test
    public void idTest() {
        assertEquals("112233",test.getID());
    }

    @Test
    public void nameTest() {
        assertEquals("Sandro",test.getName());
    }

    @Test
    public void surnameTest() {
        assertEquals("Sampei",test.getSurname());
    }

    @Test
    public void dateTest() {
        assertEquals(LocalDate.of(1970, 6, 11),test.getBirthday());
    }
}
