import java.io.*;
import java.util.*;
////import javax.mail.*; //must download the javamail api
//import javax.mail.internet.*;
import javax.activation.*;

/************************************
 * This is a random bingo game card creator. Try it and if you like it then like
 * my code.......
 ************************************/
public class Players {

    private ArrayList<Person> playerList;
    private String nameLocation;

    public Players(String nameLocation, Cards cards) {
        this.playerList = new ArrayList<Person>();
        this.nameLocation = nameLocation;
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

        File file = new File(nameLocation);

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
