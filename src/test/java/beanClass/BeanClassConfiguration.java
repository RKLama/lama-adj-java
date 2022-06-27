package beanClass;

import fr.epita.mob.datamodel.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClassConfiguration {

    @Bean("firstBeanClass")
    public String display(){
        return "Hello from Spring.";
    }

    @Bean("myNewContact")
    public Contact myNewContact(){
        Contact myContact = new Contact();
        return myContact;
    }
}
