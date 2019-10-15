package com.deepshah.deep_shah_a1.servlets;

import com.deepshah.deep_shah_a1.model.PizzaOrder;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The servlet which will create an instance of PizzaOrder and forwards it to
 * the displayOrder Page
 * 
 * @author Deep Shah
 */
public class PlaceOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting the current session and the values of name and phone
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String phone = (String) session.getAttribute("phone");
        
        //getting the selections user made in the StartOrder servlet
        String[] toppings = request.getParameterValues("toppings");
        String size = request.getParameter("size");
        String delivery = request.getParameter("delivery");
        boolean del = Boolean.parseBoolean(delivery);

        //creating an instance of pizzaorder setting its values as per the user's
        //selection
        PizzaOrder pizza = new PizzaOrder();
        pizza.setSize(size);
        pizza.setToppings(toppings);
        pizza.setDelivery(del);

        //forwading the instance of PizzaOrder to displayOrder page
        request.setAttribute("pizza", pizza);
        RequestDispatcher rd = request.getRequestDispatcher("displayOrder.jsp");
        rd.forward(request, response);

    }

}
