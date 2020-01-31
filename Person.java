import java.io.*;
import java.util.*;
////import javax.mail.*; //must download the javamail api
//import javax.mail.internet.*;
import javax.activation.*;

public class Person {

    private String name;
    private String email;
    private TreeSet<Integer> numbers;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }

    public TreeSet<Integer> getNumbers() {
        return this.numbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
