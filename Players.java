import java.io.*;
import java.util.*;

public class Players {

    private ArrayList<Person> playerList;

    public Players(Cards cards) {
        this.playerList = new ArrayList<Person>();
        populatePlayers(cards);
    }

    public void addPlayer(Person person) {
        this.playerList.add(person);
    }

    public ArrayList<Person> getPlayers() {
        return this.playerList;
    }

    public int getSize() {
        return this.playerList.size();
    }

    public ArrayList<Person> populatePlayers(Cards cards) {

        File file = new File(Bingo.nameListLocation);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            String[] details;
            String name;
            String email;
            int numCards;
            Person person = new Person("error", 1);

            while ((line = br.readLine()) != null) {

                details = line.split(" ");
                if (details.length > 4 || details.length < 3)
                    throw new Exception("too few or too many arguments in nameList.txt.");
                else if (details.length == 3) {
                    name = details[0] + " " + details[1];
                    numCards = Integer.parseInt(details[2]);
                    person = new Person(name, numCards);
                }

                else if (details.length == 4) {
                    name = details[0] + " " + details[1];
                    email = details[2];
                    numCards = Integer.parseInt(details[3]);
                    person = new Person(name, numCards, email);
                }
                addPlayer(person);

            }
            cards.setNumCards(playerList.size());

            br.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return this.playerList;
    }
}
