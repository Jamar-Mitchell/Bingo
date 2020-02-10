import java.io.*;
import java.util.*;
import javax.mail.*; //must download the javamail api
import javax.mail.internet.*;
import javax.activation.*;

/************************************
 * Simpy write down the names of the people bingo cards need to be generated for
 * in the namesList.txt file, then run this file. All the bingo cards will be
 * generated in the "cards" folder. You may change the settings below to modify
 * it to your preference Enjoy! -Sincerley Jamar :)
 ************************************/
public class Bingo {
    public static Cards cards;
    public static Players players;
    public static String fromEmail = "insertEmailHere@gmail.com";
    public static String nameListLocation = "./nameList.txt";
    public static String CSSLocation = "./src/bingo.css";
    public static String JSLocation = "./src/bingo.js";
    public static String host = "localhost";
    public static int numberRange = 25;

    // Setup mail server
    public static void main(String[] args) {

        cards = new Cards();
        players = new Players(cards);

        cards.populateNCards(cards.getNumCards(), players.getPlayers());
        bingoNumberGenerator(numberRange, 30);
        // sendEmail("jamar", "jamar.mitchell@capco.com", "attachment");
    }

    public static void bingoNumberGenerator(int range, int amount) {
        String[] letterArray = { "B", "I", "N", "G", "O" };
        HashSet<String> set = new HashSet<String>();
        StringBuilder sb;
        File file = new File("./bingoNumbers.txt");

        System.out.println("____________________________\nBelow are the game numbers\n____________________________");
        for (int i = 0; i < amount; i++) {
            int letterIndex = 0;
            int number = 0;
            sb = new StringBuilder();

            for (;;) {
                letterIndex = (int) (Math.random() * letterArray.length);
                sb.append(letterArray[letterIndex]);

                String letter = letterArray[letterIndex];

                switch (letter) {

                case "B":
                    // B
                    number = (int) (Math.random() * 15) + 1;
                    break;
                case "I":
                    // I
                    number = (int) (Math.random() * 15) + 16;
                    break;
                case "N":
                    // I
                    number = (int) (Math.random() * 15) + 31;
                    break;
                case "G":

                    // G
                    number = (int) (Math.random() * 15) + 46;
                    break;
                case "O":
                    // O
                    number = (int) (Math.random() * 15) + 61;
                    break;

                }

                sb.append(number);
                if (set.contains(sb.toString()) == false) {
                    set.add(sb.toString());
                    System.out.println(sb.toString());
                    break;
                } else {
                    sb = new StringBuilder();
                }

            }
        }

    }

    public static void sendEmail(String name, String to, String attachment) {

        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", Bingo.host);
        properties.setProperty("mail.user", "myuser");
        properties.setProperty("mail.password", "mypwd");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(Bingo.fromEmail));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
