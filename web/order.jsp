<%-- Austin Edwards cs4010 hw4 11/29/2016 --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html" import="book.business.*, java.util.*"%>
<c:set var="cart" value="${Cart.getCart()}"/>
<!DOCTYPE html>
<html>
    <head>
        <title>HW4 - Austin Edwards</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>  
    </head>
    <body>
        <h1>Your Cart</h1>
        <form action="bookOrder" method="post">
        <table border="1">
            <tr class="header">
                <th>Cover</th>
                <th>Title</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Quantity</th>
                <th></th>
            </tr>
        </table>
            <c:forEach items="${cart}" var="book">
                    <input type="hidden" name="bookId" value="${book.getKey()}">
                    <table>
                        <tr>
                            <td><img src="${book.bookImg}" alt="${book.getTitle()}" height="150" width="100">
                            <td>${book.title}
                            <td><fmt:formatNumber type="currency" value="${book.getPrice()}"/></td>
                            <td><fmt:formatNumber type="currency" value="${book.getTotal()}"/></td>
                            <td><input type="text" size="5" name="quantity" value="${book.getQuantity()}"><input type="submit" name="update" value="Update">
                            <td><input type="submit" name="remove" value="Remove Item"/>
                        </tr>
                    </table>
                
            </c:forEach>
    <!--Give the user an option to return to the original page-->
    <button type="submit" name="goBack">Continue Shopping</button>
    <c:if test="${not emptyCart}">
        <br><button type="submit" name="checkout">Checkout</button>
    </c:if>
    </form>
    </body>
</html>
