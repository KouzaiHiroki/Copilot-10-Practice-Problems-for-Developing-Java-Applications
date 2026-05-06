public class Person {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Person(int id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return id + ": " + name  + " / " + phone + " / " + email + " / " + address;
    }
}
