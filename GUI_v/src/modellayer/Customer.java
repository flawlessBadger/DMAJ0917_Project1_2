package modellayer;

public class Customer {
    String name;
    String address;
    String phoneNumber;
    String email;
    double discount;

    public Customer(String name, String address, String phoneNumber, String email, double discount) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return
                "Name:         " + name +
                        "\nAddress:      " + address +
                        "\nPhone num.:   " + phoneNumber +
                        "\nEmail:        " + email +
                        "\nDiscount:     " + discount;
    }
}
