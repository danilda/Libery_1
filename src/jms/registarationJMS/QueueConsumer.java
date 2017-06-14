package jms.registarationJMS;

import javax.jms.*;

/**
 * Created by danil on 11.06.2017.
 */
public class QueueConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try{
            TextMessage msg=(TextMessage)message;
            System.out.println("following message is received:"+msg.getText());
        }catch(JMSException e){System.out.println(e);}
    }


}
