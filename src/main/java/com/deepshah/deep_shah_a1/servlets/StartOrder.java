package com.deepshah.deep_shah_a1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The servlet where the user makes selection of what kind of the pizza they want
 * to order, also it redirects to place order servlet.
 * 
 * @author Deep Shah
 */
public class StartOrder extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Start Your Order</title>");
            //link to the css file
            out.println("<link rel=\"stylesheet\" href='" + request.getContextPath() + "/CSS/main.css'  type= 'text/css'> ");
            // link to the google fonts
            out.println("<link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Salsa' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");

            //getting the current session
            HttpSession session = request.getSession();

            // if the parameters is not null then setting the attributes of the 
            // corresponding field to the session
            if (request.getParameter("name") != null && request.getParameter(("phone")) != null) {
                session.setAttribute("name", request.getParameter("name"));
                session.setAttribute("phone", request.getParameter(("phone")));
            }

            
            out.println(" <div class='title'>");
            
            //getting the name and phone from the session because when the user is redirected
            // to the error and comes back to this page the, the page will get the
            // values from session as the request.getParameter wont work
            out.println("<h1>Hi " + session.getAttribute("name") + ", Please Order Your Pizza here!</h1>");
            out.println("</div>");
            out.println("<div class='form'");
            
            out.println("<h2>Your phone number: " + session.getAttribute("phone") + "</h2><br><br>");
            
            out.println("<form action='PlaceOrder.do' method='POST'>"); //redirecting to PlaceOrder page using post
            
            // the drop down menu for selection of delivery or pickup
            out.println("Pick up or delivery <br>");    
            out.println("<select name='delivery'  class='ddl'>");
            out.println("<option value='true'>Delivery($2)</option>");
            out.println("<option value='false'>Pick Up</option>");
            out.println("</select><br><br>");
            
            // radio buttons for selection of size of pizza, small is checked
            // so that no exceptions are thrown (front-end validation), error page is used for
            // back end validation
            out.println("<input type='radio' name='size' value='Small' checked> Small(5$) ");
            out.println("<input type='radio' name='size' value='Medium'> Medium(7$) ");
            out.println("<input type='radio' name='size' value='Large'> Large(9$) <br><br>");
            
            // checkboxes for selection of toppings
            out.println("<input type='checkbox' name='toppings' value='Pepperoni'> Pepperoni (+$1)<br>");
            out.println("<input type='checkbox' name='toppings' value='Sausage'> Sausage (+$1)<br>");
            out.println("<input type='checkbox' name='toppings' value='Baby Spinach'> Baby Spinach (+$1)<br>");
            out.println("<input type='checkbox' name='toppings' value='Pepper'> Pepper (+$1)<br><br>");
            
            out.println("<input type='submit' value='Place Order'>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}
