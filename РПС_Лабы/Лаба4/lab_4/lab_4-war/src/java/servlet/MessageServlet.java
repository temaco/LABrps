/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import ru.kurochkin.msgbean.ObjMsg;
/**
 *
 * @author mikhail
 */
public class MessageServlet extends HttpServlet {



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = request.getParameter("msg");
        String rpl = request.getParameter("replyto");
        String objMsg = request.getParameter("objmsg");
        if (action.equals("Send")) {
            if (objMsg != null) {
                sendObjectMessage(message);
            } else {
                sendMessage(message, rpl != null);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        RequestDispatcher rd = request.getRequestDispatcher( "index.jsp"); 
        rd.forward(request, response); 
    }
    
    private void sendMessage(String msg, boolean replyTo) {
            try {
        Connection connection = null;
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("jms/destination");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage message 
                = session.createTextMessage(msg);
        if (replyTo) {
            message.setJMSReplyTo(destination);
        }
        producer.send(message);connection.close();} 
    catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }

    private void sendObjectMessage(String msg) {
            try {
        Connection connection = null;
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("jms/destination");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        Random r = new Random();
        ObjectMessage message 
                = session.createObjectMessage(
                new ObjMsg(r.nextInt(100), msg));
        producer.send(message);connection.close();} 
    catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
   

}
