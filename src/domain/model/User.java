package domain.model;

import domain.model.debug.DomainException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class User{
    private String email,password,firstName,lastName;
    private Role role;
    private int userId;

    public User() {
    }

    public User(int userid, String firstName, String lastName, String email, String password, Role role){
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setUserId(userid);
        setRole(role);
    }

    public User(String email, String pswd, String name, String surname, Role role) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setUseridUnique();
        setRole(role);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if(userId ==0){
            throw new IllegalArgumentException("user-id is empty");
        }else{
            this.userId = userId;
        }

    }

    public void setUseridUnique(){
        this.userId = new Random().nextInt(8000);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.contains("@")&&email.contains(".")){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Email is invalid");
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.equals("")){
            throw new IllegalArgumentException("Password is empty");
        }else if(password.length()<8){
            throw new IllegalArgumentException("Password is too short");
        }else{
            this.password = password;
        }
    }

    public void setPasswordHashed(String password){
        if(password.equals("")){
            throw new IllegalArgumentException("Password is empty");
        }else if(password.length()<8){
            throw new IllegalArgumentException("Password is too short");
        }else{
            this.password =  hashPassword(password);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.isEmpty()){
            throw new IllegalArgumentException("firstName is invalid");
        }else{
            this.firstName = firstName;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("lastName is invalid");
        }else{
            this.lastName = lastName;
        }

    }

    private String hashPassword(String password) {
        try {
            //create MessageDigest
            MessageDigest crypt = MessageDigest.getInstance("SHA-512");
            //reset
            crypt.reset();
            //update
            byte[] passwordBytes = password.getBytes("UTF-8");
            crypt.update(passwordBytes);
            //digest
            byte[] digest = crypt.digest();
            //convert to String
            BigInteger digestAsBigInteger = new BigInteger(1, digest);
            //return hashed password
            return digestAsBigInteger.toString(16);
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException nsae){
            throw new DomainException(nsae.getMessage());
        }
    }

    public boolean isPasswordCorrect(String password){
        String hashed ="";
        try{
            if(password!=null) hashed = hashPassword(password);
        }catch (DomainException de){
            throw new DomainException(de.getMessage());
        }
        boolean res= false;
        if(this.password.equals(hashed)){
            res = true;
        }
        return res;
    }

    public String getRole() {
        return role.getRoleName();
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
