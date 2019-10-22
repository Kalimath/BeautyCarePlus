package domain.model.personal;

import domain.model.cure.ExcellPlusCure;
import domain.model.debug.DomainException;
import domain.model.health.HealthOverview;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Client implements Serializable {
    private String name, email, phone, comment;
    private LocalDate birthDate;

    public Client(){
    }

    public Client(String name, String email, String phone, LocalDate birthDate){
        this();
        setName(name);
        setEmail(email);
        setPhone(phone);
        setBirthDate(birthDate);
    }

    public void setName(String name) {
        if(name.isEmpty()||name.trim().equals("")){
            throw new DomainException("naam is niet geldig");
        }else{
            this.name = name;
        }
    }

    public void setEmail(String email) {
       if(email.isEmpty()||email.trim().equals("")){
           throw new DomainException("email is niet geldig");
       }else{
           this.email = email;
       }
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public void setBirthDate(int day, int year, int month) {
        try {
            this.birthDate = LocalDate.of(year,month,day);
        }catch (Exception e){
            throw new IllegalArgumentException("datum is niet geldig");
        }
    }

    public void setPhone(String phone) {
        if(phone.isEmpty()||phone.trim().equals("")){
            throw new DomainException("telefoonnummer is niet geldig");
        }else{
            this.phone = phone;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }
    public String getBirthDateString() {
        /*Format f = new SimpleDateFormat("dd/MM/yy");
        String strDate = f.format(this.birthDate);*/
        return birthDate.toString();
    }

    public String getPhone() {
        return phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment.isEmpty()||comment.trim().equals("")){
            this.comment = "geen";
        }else{
            this.comment = comment;
        }
    }


    /*@Override
    public String toString() {
        return this.getName()+"\n"
               +this.email+"\n"
                +this.getBirthDateString()+"\n"
                +this.phone+"\n"
                +this.address.toString();
    }*/

}
