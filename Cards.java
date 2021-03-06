import java.io.*;
import java.util.*;

public class Cards {

    private int numCards;

    public void setNumCards(int num) {
        this.numCards = num;
    }

    public int getNumCards() {
        return this.numCards;
    }

    public String populateCard(String name, int cardNumber, int roundNumber) {

        Converter converter = new Converter(Bingo.CSSLocation, Bingo.JSLocation);
        StringBuilder card = new StringBuilder();

        card.append("<!DOCTYPE html> <html>");
        card.append("<head> " + "<meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\">" + converter.cssToString()
                + converter.jsToString() + "</head>");
        card.append("<body><logo></logo>\n ");
        int a[] = new int[25];
        int y = 0, x = 0;

        // Table pop
        card.append("<table id=\"table\">");

        card.append("<tr>");
        String[] bingo = { "B", "I", "N", "G", "O" };
        for (int i = 0; i < 5; i++) {
            card.append("<th > <h1>" + bingo[i] + "</h1></th>");
        }
        card.append("</tr>");

        for (int row = 1; row <= 5; row++) {
            card.append("<tr>");
            for (int col = 1; col <= 5; col++) {

                if (row == 3 && col == 3) {
                    card.append("<td class=\" free\">");
                    // freeSpot

                    card.append("CAPCO</td>");
                    continue;
                }
                card.append("<td>");
                for (;;) {

                    switch (col) {

                        case 1:
                            // B
                            x = (int) (Math.random() * 15) + 1;
                            break;
                        case 2:
                            // I
                            x = (int) (Math.random() * 15) + 16;
                            break;
                        case 3:
                            // I
                            x = (int) (Math.random() * 15) + 31;
                            break;
                        case 4:

                            // G
                            x = (int) (Math.random() * 15) + 46;
                            break;
                        case 5:
                            // O
                            x = (int) (Math.random() * 15) + 61;
                            break;

                    }
                    // x = (int) (Math.random() * Bingo.numberRange) + 1;
                    if (contain(a, x) == false)
                        break;
                }
                a[y++] = x;
                if (x < 10) {
                    card.append("0" + x);
                } else {
                    card.append(x);
                }
                card.append("</td>");
            }
            card.append("</tr>");
            card.append("\n\n");
        }
        card.append("</table> <h3 id=\"cardHolder\"> CardHolder: " + name + "<h4 id=\"numround\">Round " + roundNumber
                + "</h4><h3> <p id=\"numcard\">" + cardNumber + "</p></body> </html>");

        return card.toString();
    }

    public void populateNCards(int numCards, ArrayList<Person> playerList) {
        for (int i = 0; i < numCards; i++) {
            String name = playerList.get(i).getName();
            int numPlayerCards = playerList.get(i).getNumCards();

            for (int j = 1; j <= numPlayerCards; j++) {
                String cardFile = name + " card" + j + ".html";
                File file = new File("./cards/" + cardFile);

                try {
                    file.createNewFile();
                    PrintWriter out = new PrintWriter("./cards/" + cardFile);
                    out.print(populateCard(name, j, Bingo.roundNumber));
                    file.setReadOnly();
                    System.out.println(cardFile);
                    out.close();
                }

                catch (Exception e) {
                    System.out.println(e);
                }

            }
        }

    }

    // Have all cards for player in a single html file
    public String populateCardv2(String name, int numCards, int roundNumber) {

        Converter converter = new Converter(Bingo.CSSLocation, Bingo.JSLocation);
        StringBuilder card = new StringBuilder();

        card.append("<!DOCTYPE html> <html>");
        card.append("<head> " + "<meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\">" + converter.cssToString()
                + converter.jsToString() + "</head>");
        card.append("<body><logo></logo> <h3 id=\"cardHolder\"> CardHolder: " + name + "<h4 id=\"numround\">Round "
                + roundNumber + "</h4>\n ");

        card.append("<cards id=\"cards\">");
        for (int count = 0; count < numCards; count++) {
            int a[] = new int[25];
            int y = 0, x = 0;

            // Table pop
            card.append("<card><table id=\"table\">");

            card.append("<tr>");
            String[] bingo = { "B", "I", "N", "G", "O" };
            for (int i = 0; i < 5; i++) {
                card.append("<th > <h1>" + bingo[i] + "</h1></th>");
            }
            card.append("</tr>");

            for (int row = 1; row <= 5; row++) {
                card.append("<tr>");
                for (int col = 1; col <= 5; col++) {

                    if (row == 3 && col == 3) {
                        card.append("<td class=\" free\">");
                        // freeSpot

                        card.append("CAPCO</td>");
                        continue;
                    }
                    card.append("<td>");
                    for (;;) {

                        switch (col) {

                            case 1:
                                // B
                                x = (int) (Math.random() * 15) + 1;
                                break;
                            case 2:
                                // I
                                x = (int) (Math.random() * 15) + 16;
                                break;
                            case 3:
                                // I
                                x = (int) (Math.random() * 15) + 31;
                                break;
                            case 4:

                                // G
                                x = (int) (Math.random() * 15) + 46;
                                break;
                            case 5:
                                // O
                                x = (int) (Math.random() * 15) + 61;
                                break;

                        }
                        // x = (int) (Math.random() * Bingo.numberRange) + 1;
                        if (contain(a, x) == false)
                            break;
                    }
                    a[y++] = x;
                    if (x < 10) {
                        card.append("0" + x);
                    } else {
                        card.append(x);
                    }
                    card.append("</td>");
                }
                card.append("</tr>");
                card.append("\n\n");
            }
            card.append("</table></card> </html>");
        }

        card.append("</cards></body> </html>");
        return card.toString();
    }

    public void populateNCardsV2(int numCards, ArrayList<Person> playerList) {
        for (int i = 0; i < numCards; i++) {
            String name = playerList.get(i).getName();
            int numPlayerCards = playerList.get(i).getNumCards();

            populateCardv2(name, numPlayerCards, Bingo.roundNumber);

            String cardFile = name + " card round " + Bingo.roundNumber + ".html";
            File file = new File("./cards/" + cardFile);

            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter("./cards/" + cardFile);
                out.print(populateCardv2(name, numPlayerCards, Bingo.roundNumber));
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
