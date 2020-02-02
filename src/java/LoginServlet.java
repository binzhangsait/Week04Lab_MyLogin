/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 798419
 */
public class LoginServlet extends HttpServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("GET in login.jsp");

        String submit = request.getParameter("submit");
        if (submit == null) {
            System.out.println("logout ====== null");
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            HttpSession hs = request.getSession();
            User u = (User) hs.getAttribute("user");
            String username = u.getUsername();
            request.setAttribute("username", username);
            hs.removeAttribute("user");
            request.getServletContext().getRequestDispatcher("login").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("POST in login.jsp");

        String username = request.getParameter("user");
        String password = request.getParameter("password");
        AccountService as = new AccountService();
        User login = as.login(username, password);
        if (login != null) {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            HttpSession hs = request.getSession();
            hs.setAttribute("user", u);
            response.sendRedirect("/Week04Lab_MyLogin/home");
        }else{
            request.setAttribute("error", "Invalid user or password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
