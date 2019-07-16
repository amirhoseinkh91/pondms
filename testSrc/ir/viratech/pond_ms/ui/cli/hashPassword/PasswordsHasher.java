package ir.viratech.pond_ms.ui.cli.hashPassword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class PasswordsHasher {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();

        PasswordEncoder serverPasswordEncoder = (PasswordEncoder) ApplicationContextProvider.getInitializedApplicationContext().getBean("serverPasswordEncoder");;

        List<User> users = UserMgr.getInstance().list();
        for (User user : users) {
        	if(user.getAuthUser() == null)
        		continue;
            System.out.println("before update: " + user.getPassword());
            UserMgr.getInstance().updatePassword(user, "salam123", serverPasswordEncoder);
        }

        users = UserMgr.getInstance().list();
        System.out.println("after update");
        for (User user : users) {
            System.out.println("username: " + user.getUsername() + "\t" + "pass: " + user.getPassword());
        }
    }


}
