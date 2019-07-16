package ir.viratech.pond_ms.login;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.role.Role;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.logic.RoleMgr;

@SuppressWarnings(SuppressWarningsOption.ALL)
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role sysadminRole = RoleMgr.getInstance().getByName(UserRole.SYSADMIN_ROLE);
        Role adminRole = RoleMgr.getInstance().getByName(UserRole.ADMIN_ROLE);
        Role agencyRole = RoleMgr.getInstance().getByName(UserRole.AGENCY_ROLE);
        Role normalUserRole = RoleMgr.getInstance().getByName(UserRole.NORM_USER_ROLE);
        Role proUserRole = RoleMgr.getInstance().getByName(UserRole.PRO_USER_ROLE);
        Role mobileRole = RoleMgr.getInstance().getByName(UserRole.MOBILE_ADMIN_ROLE);
        User currentUser = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        Set<UserRole> currentUserRoles = currentUser.getRoles();

        if (currentUserRoles.contains(sysadminRole))
            response.sendRedirect("/PondMS/admin/index.html");
        else if (currentUserRoles.contains(agencyRole))
            response.sendRedirect("/PondMS/agency/dashboard/index.html");
        else if (currentUserRoles.contains(normalUserRole) | currentUserRoles.contains(proUserRole))
            response.sendRedirect("http://justro.ir");
        else if (currentUserRoles.contains(mobileRole))
            doNothing();
        else if (currentUserRoles.contains(adminRole))
            response.sendRedirect("/PondMS/static/error-403.html");
        else
            response.sendRedirect("http://justro.ir");
    }

    private void doNothing() {

    }

}
