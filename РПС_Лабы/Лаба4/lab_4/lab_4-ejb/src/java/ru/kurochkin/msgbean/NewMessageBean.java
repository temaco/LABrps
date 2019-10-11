/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurochkin.msgbean;

import com.kurochkin.bean.re.IDAOLog;
import com.kurochkin.bean.re.LogEntity;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
@MessageDriven(mappedName="jms/destination", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                                  propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Queue")
    })
public class NewMessageBean implements MessageListener {
    
    @EJB
    private IDAOLog log;
    
    @Resource
    private MessageDrivenContext mdc;

    public NewMessageBean() {
    }

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                log.add(new LogEntity(msg.getText()));
                Destination dst = msg.getJMSReplyTo();
                if (dst != null) {
                    sendMessage(dst, msg.getText());
                }
            } else if (inMessage instanceof ObjectMessage) {
                ObjectMessage objmsg = (ObjectMessage) inMessage;
                ObjMsg objMessage = (ObjMsg) objmsg.getObject();
                log.add(new LogEntity("Object: id - "+objMessage.id+
                        " content - "+objMessage.content ));
            } else {
                System.out.println(
                        "Message of wrong type: "
                        + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
    
    private void sendMessage(Destination destination, String msg) {
        try {
                    Connection connection = null;
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage message 
                = session.createTextMessage("ReplyTo: "+msg);
        producer.send(message);
        connection.close();
            
        } catch (Exception ex) {
            
        }
       
    }
    

    
}
