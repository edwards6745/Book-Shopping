<%-- Austin Edwards cs4010 hw4 11/29/2016 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>HW4 - Austin Edwards</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    
    <form action="bookOrder" method="post">
        <input type="hidden" name="action" value="add">
        <c:if test="${not newUser}">
        <h1>Sign In</h1>
        <p><i>${message}</i></p>
        <table>
            <tr>
                <td>Email:
                <td><input type="email" name="email" value="${user.email}" required><br>
            </tr>
            <tr>
                <td><label>Password:</label>
                <td><input type="text" name="password" value="${user.password}" required><br>       
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="signin">
            </tr>
        </table>
        </c:if>
        <c:if test="${newUser}">
            <h1>New User Registration</h1>
            <table>
                <tr>
                    <td>Email:
                    <td><input type="email" name="email" value="${user.email}" required>
                </tr>
                <tr>
                    <td>Password:
                    <td><input type="text" name="password" value="${user.password}" required>
                </tr>
                <tr>
                    <td>First Name:
                    <td><input type="text" name="firstName" value="${user.firstName}" required>
                </tr>
                <tr>
                    <td>Last Name:
                    <td><input type="text" name="lastName" value="${user.lastName}" required>
                </tr>
                <tr>
                <td colspan="2"><input type="submit" name="addUser">
                </tr>
            </table>
        </c:if>
    </form>
</body>
</html>
