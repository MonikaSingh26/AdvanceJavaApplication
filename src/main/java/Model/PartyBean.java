package Model;

public class PartyBean {
    int partyId;
    String firstName;
    String lastName;
    String address;
    String city;
    int zip;
    String state;
    String country;
    int phone;

    public PartyBean(int partyId, String firstName, String lastName, String address, String city, int zip, String state, String country, int phone) {
        this.partyId = partyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
    }

    public PartyBean() {
    }

    public int getPartyId() {

        return partyId;
    }
    public void setPartyId(int partyId) {

        this.partyId = partyId;
    }


    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }


    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
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


    public int getZip() {

        return zip;
    }
    public void setZip(int zip) {

        this.zip = zip;
    }


    public String getState() {

        return state;
    }
    public void setState(String state) {

        this.state = state;
    }


    public String getCountry() {

        return country;
    }
    public void setCountry(String country) {

        this.country = country;
    }


    public int getPhone() {

        return phone;
    }
    public void setPhone(int phone) {

        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PartyBean{" +
                "partyId=" + partyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", phone=" + phone +
                '}';
    }
}
