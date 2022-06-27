package fr.epita.mob.datamodel;

public class Contact {
//    firstname, last_name, company_name, address, city, county, state, zip, phone1, phone, email
    private String firstname;
    private String lastname;
    private String companyname;
    private String address;
    private String city;
    private String county;
    private String state;
    private String zip;
    private String phone1;
    private String phone;
    private String email;

    public Contact(String string, String resultSetString, String setString, String s, String string1, String resultSetString1, String setString1, String s1, String string2, String resultSetString2){

    }

    public Contact() {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstName(String Firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Contact [" +
                "first_name=\"" + firstname + "\"" +
                ", last_name=\"" + lastname + "\"" +
                ", phone=\"" + phone + "\"" +
                ", email=\"" + email + "\"" +
                ", address=\"" + address + "\"" +
                ", state=\"" + state +"\""
                + ']';

    }
}
