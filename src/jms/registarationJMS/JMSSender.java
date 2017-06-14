package jms.registarationJMS;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by danil on 11.06.2017.
 *
 */
public class JMSSender {

    public static void sendMessage(String messageText){
        try {
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("JMSLiberyCF");
            QueueConnection con = f.createQueueConnection();
            con.start();
            //2) create queue session
            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) get the Queue object
            Queue t = (Queue) ctx.lookup("JMSLiberyQueue");
            //4)create QueueSender object
            QueueSender sender = ses.createSender(t);

            //5) create TextMessage object
            TextMessage msg = ses.createTextMessage();
            //6) write message
            msg.setText(messageText);
            //7) send message
            sender.send(msg);
            //8) connection close
            con.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
