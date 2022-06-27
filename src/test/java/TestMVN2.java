import fr.epita.mob.datamodel.Contact;
import fr.epita.mob.services.data.ContactCSVDAO;

import java.util.List;

public class TestMVN2 {

    public static void main(String[] args) throws Exception{

        //given
        String filePath = ContactCSVDAO.class.getResource("/17-contacts.csv").toURI().getPath();
        ContactCSVDAO csvdao = new ContactCSVDAO(filePath);

        //when
        List<Contact> contactList = csvdao.readAll();
        csvdao.sort(contactList);

        if(!(contactList.get(0).getEmail().equals("lpaprocki@hotmail.com"))){
            throw new Exception("check not passed for TestMVN2");
        }
    }
}
