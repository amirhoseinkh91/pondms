package ir.viratech.socket_server;

import java.io.IOException;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.eclipse.jetty.util.ConcurrentHashSet;

import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

@ServerEndpoint(value = "/api/chat/{from}/{to}", encoders = MessageTextEncoder.class)
public class ChatEndPoint {

    private static Set<Session> sessions = new ConcurrentHashSet<>();

    @OnMessage
    public void OnMessage(Session session, String message, @PathParam("to") String to) {
        // message received
        final String username = (String) session.getUserProperties().get("username");
        Message m = new Message(username, message);
        for (Session s : sessions) {
            String uName = (String) s.getUserProperties().get("username");
            if (uName.equals(to)) {
                try {
                    if (s.isOpen())
                        s.getBasicRemote().sendObject(m);
                    else
                        session.getBasicRemote().sendText(to + " is not online.");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (EncodeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnOpen
    public void open(Session session, @PathParam("from") String username) {
        // connection opened
        User user = UserMgr.getInstance().getByUsername(username);
        System.out.println("current user is : " + user.getUsername() + " " + user.getExtuid());
        sessions.add(session);
        session.getUserProperties().put("username", username);
    }

    @OnError
    public void error(Session session, Throwable error) {
        // connection Error
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessions.remove(session);
    }


    @OnClose
    public void close(Session session, CloseReason reason) {
        // connection closed
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessions.remove(session);
    }

}
