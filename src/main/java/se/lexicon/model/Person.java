package se.lexicon.model;

import se.lexicon.util.Validation;

import java.util.Objects;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private AppUser credentials;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, String email) {
        this(firstName, lastName, email);
        this.id = id;
    }

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("firstName is null");
        Validation.checkStringNotNull.andThen(Validation.checkNotEmpty).andThen(Validation.checkMaxLength20).accept(firstName, "FirstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        //if (lastName == null) throw new IllegalArgumentException("lastName is null");
        Validation.checkStringNotNull.accept(lastName, "lastName");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email is null");
        Validation.checkStringNotNull.accept(email, "email");
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}