import java.util.*;

public class Person {

    private String name;
    private String email;
    private TreeSet<Integer> numbers;
    private int numCards;

    public Person(String name, int numCards) {
        this.name = name;
        this.numCards = numCards;
    }

    public Person(String name, int numCards, String email) {
        this.name = name;
        this.email = email;
        this.numCards = numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public int getNumCards() {
        return this.numCards;
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

    public void addBingoNumber(int number) {
        this.numbers.add(number);
    }

    public TreeSet<Integer> getBingoNumbers() {
        return this.numbers;
    }
}
