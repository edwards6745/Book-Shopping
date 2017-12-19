<%-- Austin Edwards cs4010 hw4 11/29/2016 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html" import="book.business.*, java.util.*"%>
<c:set var="booklist" value="${Cart.getCart()}"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HW4 - Austin Edwards</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>  
    </head>
    <body>
        <h1>Thanks for your order</h1>
        <table>
            <tr>
                <td colspan="2">Here is the information that you entered:</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>${user.lastName}</td>
            </tr>
        </table>
        <br>
        <table border="1">
            <tr class="header">
                <th>Cover</th>
                <th>Title</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Quantity</th>
            </tr>
        </table>
            <c:forEach items="${booklist}" var="book">
                    <table>
                        <tr>
                            <td><img src="${book.bookImg}" alt="${book.getTitle()}" height="150" width="100">
                            <td>${book.title}
                            <td><fmt:formatNumber type="currency" value="${book.price}"/></td>
                            <td><fmt:formatNumber type="currency" value="${book.getTotal()}"/></td>
                            <td>${book.getQuantity()}
                        </tr>
                    </table>
            </c:forEach>
        <table>
            <td>
            <th>Total</th>
            <td></td>
            <td>$${cart.totalPrice()}</td>
            <td></td>
        </table>
        <form action="bookOrder" method="post">
            <p>To order another book, click on the button below.
            <br><input type="submit" name="goHome" value="Return">
        </form>
    </body>
</html>
