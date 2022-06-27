import beanClass.BeanClassConfiguration;
import fr.epita.mob.datamodel.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanClassConfiguration.class})

public class TestSPR3 {

    @Inject
    Contact myNewContact;

    @Test
    public void createContact(){
        System.out.println(myNewContact.getFirstname());
    }

}
