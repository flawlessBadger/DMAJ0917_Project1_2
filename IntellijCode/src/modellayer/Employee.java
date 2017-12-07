package modellayer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Employee {
    //    private String accountName;
    private String name;
    private String address;
    private byte[] hashPassword;
    private int accessLevel;

    public Employee(String name, String address, int accessLevel, String password) {
//        this.accountName = accountName;
        this.name = name;
        this.address = address;
        this.accessLevel = accessLevel;
        try {
            hashPassword = MessageDigest.getInstance("MD5").digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        return Arrays.equals(hashPassword, MessageDigest.getInstance("MD5").digest(password.getBytes()));
    }


    //getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAccessLevel() {
        return accessLevel;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setPassword(String password) {
        try {
            hashPassword = MessageDigest.getInstance("MD5").digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return
                "Name:         " + name +
                        "\nAddress:      " + address +
                        "\nAccess level: " + accessLevel;
    }


}
