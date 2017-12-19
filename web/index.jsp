<%-- Austin Edwards cs4010 hw4 11/29/2016 --%>

<%@ page language="java" contentType="text/html" import="book.business.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="bookList" value="${BookList.getAllBooks()}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>HW4 - Austin Edwards</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
    </head>
    <body>
        <!--Book Form-->
        <h1> Book Order Form </h1>
        <section>
        <table border="1">
            <tr class="header">
                <th>Cover</th>
                <th>Title</th>
                <th>Price</th>
                <th></th>
            </tr>
        </table>
            <c:forEach items="${bookList}" var="book" >
                <form action="bookOrder" method="post">
                    <input type="hidden" name="bookId" value="${book.getKey()}">
                    <table border="1">
                        <tr>
                            <td><img src="${book.value.bookImg}" alt="${book.value.title}" height="150" width="100">
                            <td>${book.value.title}
                            <td><fmt:formatNumber type="currency" value="${book.value.price}"/></td>
                            <td><input type="submit" name="add" value="Add to Cart"/>
                        </tr>
                    </table>
                </form>
            </c:forEach>
        </section>
    </body>
</html>