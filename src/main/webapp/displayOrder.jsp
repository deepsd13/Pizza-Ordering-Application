<%-- 
    Document   : displayOrder, The class which displays the order details
    Created on : 19-Sep-2019, 6:00:46 PM
    Author     : Deep Shah
--%>

<%@page import="com.deepshah.deep_shah_a1.model.PizzaOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Salsa' rel='stylesheet'>

    </head>
    <body>
        <!-- getting the instance of PizzaOrder from the placeOrder page-->
        <% PizzaOrder pizza = (PizzaOrder) request.getAttribute("pizza");%>
        <div class="title">
            <!-- The title of the page with name and phone extracted from session-->
            <h1>Pizza order for <% out.print((String) session.getAttribute("name")
                    + ", " + (String) session.getAttribute("phone"));%> total  $
                    <%= pizza.getPrice()%></h1>
        </div>
        <div class="form">
            <!-- if the order is a delivery then the page will show the delivery time
                  else it wll show the pick up time
            -->
            <% if (pizza.isDelivery()) {%>
            <h2> Thanks for your order, your pizza will be delivered within 40 minutes, ENJOY! <hr></h2>
                <%} else {%>
            <h2> Thanks for your order, your pizza will be ready for pick up in 20 minutes, ENJOY! <hr></h2>
                <%}%>
            <h2> ORDER DETAILS: </h2> 
            <div id ="orderDetails">
                <!-- Printing the order details i.e the price, size and the toppings
                     of the order, if there are no toppings then None will be printed-->
                <h3> Order Amount: $<%=pizza.getPrice()%> </h3>
                <h3>Pizza Size: <%=pizza.getSize()%> </h3>
                
                <!-- getting all the toppings selected as an array-->
                <% String[] toppings = pizza.getToppings(); %>
                
                <h3> Toppings: </h3>
                <%if (toppings != null) {%>
                <ul>
                    <!-- printing every toppings in the form of a unordered list-->
                    <% for (int i = 0; i < toppings.length; i++) {;%>
                    <li><%=toppings[i]%></li>
                        <%}%>
                </ul>
                <%} else {%>
                <%out.print("None");%>
                <%}%>
            </div>
        </div>

    </body>
</html>