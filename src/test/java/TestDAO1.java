import beanClass.BeanClassConfiguration;
import fr.epita.mob.datamodel.Contact;
import fr.epita.mob.services.data.ContactCSVDAO;
import fr.epita.mob.services.exceptions.UnableToLoadContactsException;
import fr.epita.mob.services.jdbc.ContactJDBCDAO;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanClassConfiguration.class})
public class TestDAO1 {


    static {
        System.setProperty("conf.file", "src/test/resources/conf.properties");
    }

    @Inject
    @Named("db.mainDatasource")
    DataSource ds;
    @Inject
    @Named("services.dao.contactJDBCDAO")
    ContactJDBCDAO jdbc;
    @Inject
    @Named("services.dao.contactCSVDAO")
    static
    ContactCSVDAO dao;


    private static String filePath;
    private static List<Contact> contacts;

    @BeforeAll
    public static void beforeClass() throws Exception {
        filePath = ContactCSVDAO.class.getResource("/17-contacts.csv").toURI().getPath();

    }

    @AfterAll
    public static void afterClass() {
        contacts.clear();
    }

    @BeforeEach
    public void initialize() throws SQLException, UnableToLoadContactsException, URISyntaxException {
        Connection cnt = this.ds.getConnection();
        PreparedStatement preparedStatement = cnt.prepareStatement("CREATE TABLE IF NOT EXISTS CONTACT (first_name VARCHAR(255), last_name VARCHAR(255), company_name VARCHAR(255), address VARCHAR(255), city VARCHAR(255), county VARCHAR(255), states VARCHAR(255),  phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255))");
        preparedStatement.execute();

        dao = new ContactCSVDAO(filePath);
        contacts = dao.readAll();
    }

    @Test
    public void testcreate() throws SQLException {
        for (Contact contact : contacts) {
            this.jdbc.create(contact);
            // System.out.println(contact);
        }

    }


    @Test
    public void testsearch() throws SQLException {
        String name = this.jdbc.search("Abel");
        System.out.println(name);
    }
}