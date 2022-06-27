import beanClass.BeanClassConfiguration;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;

//Tells JUNIT we need spring to start the application
@ExtendWith(SpringExtension.class)
//Where to find the class configuration
@ContextConfiguration(classes = {BeanClassConfiguration.class})

public class TestSPR2 {

    @Inject
    @Named("firstBeanClass")
    String hello;

    @Test
    public void saySomething(){
        System.out.println(hello);
    }

}
