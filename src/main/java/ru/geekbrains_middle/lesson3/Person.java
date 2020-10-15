package ru.geekbrains_middle.lesson3;

public class Person {
    private String lastName, phone,email;

    public Person(String lastName, String phone, String email){
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
