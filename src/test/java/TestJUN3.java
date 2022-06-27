import fr.epita.mob.datamodel.Contact;
import fr.epita.mob.services.data.ContactCSVDAO;
import fr.epita.mob.services.exceptions.UnableToLoadContactsException;
import org.junit.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class TestJUN3 {

    private static ContactCSVDAO contactCSV;
    private static List<Contact> contactList;

    @BeforeClass
    public static void BeforeClass() throws URISyntaxException {
        String filepath = ContactCSVDAO.class.getResource("/17-contacts.csv").toURI().getPath();
        contactCSV = new ContactCSVDAO(filepath);
    }

    @Before
    public void Before() throws UnableToLoadContactsException {
//        System.out.println("Before");
        contactList = contactCSV.readAll();
    }

    @Test
    public void Test1(){
        System.out.println("Test 1");
    }

    @Test
    public void Test2(){
        System.out.println("Test 2");
    }

    @After
    public void After(){
//        System.out.println("After");
        for (Contact c: contactList) {
            // to display all the list in Contact
            System.out.println(c);
        }
    }

    @AfterClass
    public static void AfterClass(){
//        System.out.println("After Class");
        // to make the list empty
        contactList.clear();
    }

    public void checktheList(){
        //Given
        List<String> expectedList = Arrays.asList("Lenna","Donette","Mitsue","Leota","Sage","Abel","Kiley","Graciela","Mattie","Gladys","Yuki", "Fletcher", "Bette", "Veronika", "Willard", "Maryann", "Alisha");
        //When

    }

}
