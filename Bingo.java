import java.io.*;
import java.util.*;
////import javax.mail.*; //must download the javamail api
//import javax.mail.internet.*;
import javax.activation.*;

/************************************
 * This is a random bingo game card creator. Try it and if you like it then like
 * my code.......
 ************************************/
public class Bingo {
    public static Cards cards;
    public static Players players;
    public static String fromEmail = "insertEmailHere@gmail.com";
    public static String nameListLocation = "./nameList.txt";
    public static String CSSLocation = "./src/bingo.css";
    public static String JSLocation = "./src/bingo.js";
    public static String host = "localhost";
    public static int numberRange = 75;
    // Get system properties
    public static Properties properties = System.getProperties();

    // Setup mail server
    public static void main(String[] args) {

        cards = new Cards();
        players = new Players(cards);

        cards.populateNCards(cards.getNumCards(), players.getPlayers());
        // sendEmail("jamar", "jamar.mitchell@capco.com", "attachment");
    }

    /*
     * public static void sendEmail(String name, String to, String attachment) { //
     * Setup mail server properties.setProperty("mail.smtp.host", host);
     * 
     * // Get the default Session object. Session session =
     * Session.getDefaultInstance(properties);
     * 
     * try { // Create a default MimeMessage object. MimeMessage message = new
     * MimeMessage(session);
     * 
     * // Set From: header field of the header. message.setFrom(new
     * InternetAddress(from));
     * 
     * // Set To: header field of the header.
     * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
     * 
     * // Set Subject: header field message.setSubject("Your Bingo Ticket!");
     * 
     * // Now set the actual message // message.setText("Hello "+name+" attached to
     * this email is your bingo ticket. // If you win You will need to respond to
     * this email. GoodLuck!"); // Send the actual HTML message, as big as you like
     * message.setContent("<h1>Hello " + name +
     * "</h1> <h2>attached to this email is your bingo ticket. If you win You will need to respond to this email. GoodLuck!  </h2>"
     * , "text/html");
     * 
     * // Send message Transport.send(message);
     * System.out.println("Sent message successfully...."); } catch
     * (MessagingException mex) { mex.printStackTrace(); } }
     */
}
