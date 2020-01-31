import java.io.*;
import java.util.*;
////import javax.mail.*; //must download the javamail api
//import javax.mail.internet.*;
import javax.activation.*;

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

            String name;
            while ((name = br.readLine()) != null) {

                Person person = new Person(name);
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
