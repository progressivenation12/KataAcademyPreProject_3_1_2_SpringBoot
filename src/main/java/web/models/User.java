package web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Field not be empty!")
    @Size(min = 2, max = 25, message = "Firstname should be between 2 and 25 char!")
    @Column(name = "firstName")
    private String firstName;
    @NotBlank(message = "Field not be empty!")
    @Size(min = 2, max = 25, message = "Firstname should be between 2 and 25 char!")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "Field not be empty!")
    @Min(value = 0, message = "The age must not be less than 0!")
    @Max(value = 150, message = "The age should not be more than 155!")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
