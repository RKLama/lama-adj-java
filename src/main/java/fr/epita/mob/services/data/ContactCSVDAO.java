package fr.epita.mob.services.data;

import fr.epita.mob.datamodel.Contact;
import fr.epita.mob.services.exceptions.UnableToLoadContactsException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactCSVDAO {

    private final String location;

    public ContactCSVDAO(String location){
        this.location = location;
    }

    public List<Contact> readAll() throws UnableToLoadContactsException {
        File file = new File(location);
        List<String> rawStringList = null;
        try {
            rawStringList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("file not found in location"+file.toString());
            throw new UnableToLoadContactsException(e);
        }

        //remove the header line
        rawStringList.remove(0);

        List<Contact> contactList = new ArrayList<>();
        for (String row : rawStringList) {
            String[] parts = row.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String email = parts[10];
            String phoneNumber = parts[9];
            String state = parts[6];

            Contact contact = new Contact();
            contact.setState(state);
            contactList.add(contact);
        }
        return contactList;
    }

    public void sort(List<Contact> contactList){
//        Collections.sort(contactModelList, new Comparator<ContactModel>() {
//            @Override
//            public int compare(ContactModel o1, ContactModel o2) {
//                return o1.getState().compareTo(o2.getState());
//            }
//        });
        Collections.sort(contactList, (contact1, contact2) -> {
            return contact1.getState().compareTo(contact2.getState());
        });
//        Collections.sort(contactModelList, Comparator.comparing(ContactModel::getState, (state1, state2) -> state2.compareTo(state1)));
    }

}
