package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by danil on 11.06.2017.
 */
public class EmailSender {
    private static String host = "smtp.gmail.com";
    private static String starttls = "true";
    private static String auth = "true";
    private static String port = "587";
    private static String username = "danil1996.96mail@gmail.com";
    private static String password = "01470258da";


    public static void sendEmail(String to,String messageText){

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.starttls.enable", starttls);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);


        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Testing Subject");
            message.setText(messageText);

            Transport.send(message);

            System.out.println("Done");
        } catch (MessagingException mex){
            mex.printStackTrace();
        }

    }
}
