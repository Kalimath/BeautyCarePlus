package domain.model.personal;

import java.io.Serializable;

public class Address implements Serializable {
    private int zip;
    private String place,number,street;
    public Address() {
    }

    public Address(int zip, String place, String number, String street) {
        setZip(zip);
        setPlace(place);
        setStreet(street);
        setNumber(number);
    }

    public void setZip(int zip) {
        if(Integer.toString(zip).length()==4) {
            this.zip = zip;
        }else{
            throw new IllegalArgumentException("postcode is niet geldig");
        }
    }

    public void setPlace(String place) {
        if(!place.equals("")||!place.trim().isEmpty()){
            this.place = place.trim().substring(0, 1).toUpperCase() + place.trim().substring(1);
        }else{
            throw new IllegalArgumentException("plaats is ongeldig");
        }

    }

    public void setNumber(String number) {
        if(number.length()>0) {
            this.number = number.trim().toUpperCase();
        }else{
            throw new IllegalArgumentException("huisnummer is niet geldig");
        }

    }

    public void setStreet(String street) {
        if(!street.equals("")||!street.trim().isEmpty()){
            this.street = street.trim().substring(0, 1).toUpperCase() + street.trim().substring(1);
        }else{
            throw new IllegalArgumentException("straat is niet geldig");
        }
    }

    public int getZip() {
        return zip;
    }

    public String getPlace() {
        return place;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return this.getStreet()+" "+this.number+'\n'+
                this.zip+" "+this.place;
    }
}
