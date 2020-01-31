import java.io.*;
import java.util.*;
////import javax.mail.*; //must download the javamail api
//import javax.mail.internet.*;
import javax.activation.*;

/************************************
 * This is a random bingo game card creator. Try it and if you like it then like
 * my code.......
 ************************************/
public class Cards {

    private int numCards;

    public void setNumCards(int num) {
        this.numCards = num;
    }

    public int getNumCards() {
        return this.numCards;
    }

    public String populateCard(String name) {

        Converter converter = new Converter(Bingo.CSSLocation, Bingo.JSLocation);
        StringBuilder card = new StringBuilder();

        card.append("<!DOCTYPE html> <html>");
        card.append("<head> " + converter.cssToString() + converter.jsToString() + "</head>");
        card.append("<body><h1>Capco Bingo</h1>\n ");
        int a[] = new int[25];
        int y = 0, x = 0;

        // Table pop
        card.append("<table>");
        for (int i = 1; i <= 5; i++) {
            card.append("<tr>");
            for (int j = 1; j <= 5; j++) {
                card.append("<th>");
                for (;;) {
                    x = (int) (Math.random() * 75) + 1;
                    if (contain(a, x) == false)
                        break;
                }
                a[y++] = x;
                if (x < 10) {
                    card.append("0" + x);
                } else {
                    card.append(x);
                }
                card.append("</th>");
            }
            card.append("</tr>");
            card.append("\n\n");
        }
        card.append("</table> <h3> CardHolder: " + name + "<h3> </body> </html>");

        return card.toString();
    }

    public void populateNCards(int numCards, ArrayList<Person> playerList) {
        for (int i = 0; i < numCards; i++) {
            String name = playerList.get(i).getName();
            String cardFile = name + "_card.html";
            File file = new File("./cards/" + cardFile);

            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter("./cards/" + cardFile);
                out.print(populateCard(name));
                file.setReadOnly();
                System.out.println(cardFile);
                out.close();
            }

            catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static boolean contain(int a[], int x) {
        boolean res = false;
        for (int i = 0; i < a.length; i++)
            if (a[i] == x)
                res = true;
        return res;
    }
}
