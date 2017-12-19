//Austin Edwards cs4010 hw4 11/29/2016

package book.order;
import book.business.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

//BookOrderServlet to send and receive data from server
public class BookOrderServlet extends HttpServlet {


    @Override
    //Post method to get data from form securely
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) 
                          throws ServletException, IOException {        
        
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        
        //Set all attributes from buttons
        String url = "/index.jsp";
        String action = request.getParameter("action");
        String add = request.getParameter("add");
        String remove = request.getParameter("remove");
        String update = request.getParameter("update");
        String goBack = request.getParameter("goBack");
        String goHome = request.getParameter("goHome");
        String checkout = request.getParameter("checkout");
        String signin = request.getParameter("signin");
        String addUser = request.getParameter("addUser");
        String bookId = request.getParameter("bookId");
        String quantity = request.getParameter("quantity");
        
        //Initialize other variables
        String message = "";
        boolean newUser = false;
        boolean emptyCart = false;
        double total;
        
        //Create objects
        Cart cart = (Cart) session.getAttribute("cart");
        User user = null;
        
        // handle the user signing in
        if (signin != null) {
            // get parameters from the request
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            user = new User(email, password);
            //check if the user exists in the database
            if (UserDB.userExists(user.getEmail())) {
                    //check if the password that was entered matches the user in the database
                    if(UserDB.correctLogin(user.getEmail(), user.getPassword())) {
                        user = UserDB.selectUser(email);
                        session.setAttribute("user", user);
                        url = "/thanks.jsp";
                    }
                    else {
                        message = "The password does not match. Please try again.";
                        request.setAttribute("message", message);
                        url = "/signin.jsp";
                    }
            }
            //the user doesn't exist, allow the user to enter a new one
            else {
                newUser = true;
                request.setAttribute("newUser", newUser);
                url = "/signin.jsp";
            }
        }
        
        //handle the addUser request, adding the new user to the database
        if(addUser != null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            user = new User(email, password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            UserDB.insert(user);
            session.setAttribute("user", user);
            url = "/thanks.jsp";
        }
        
        //handle the adding of items to the cart
        if(add != null) {
            if(cart == null) {
                cart = new Cart();
            }
            if(cart.contains(Integer.parseInt(bookId))) {
                cart.addOneQuantity(Integer.parseInt(bookId));
            }
            else {
                cart.addToCart(Integer.parseInt(bookId));
            }
            url = "/order.jsp";
        }
        
        //handle the removing of items from the cart
        if(remove != null) {
            cart.removeFromCart(Integer.parseInt(bookId));
            //check if the cart is empty
            if(cart.cartSize() == 0) {
                emptyCart = true;
            }
            else {
                emptyCart = false;
            }
            request.setAttribute("emptyCart", emptyCart);
            url = "/order.jsp";
        }
        
        if(update != null) {
            cart.updateCart(Integer.parseInt(quantity), Integer.parseInt(bookId));
            url = "/order.jsp";
        }
        
        session.setAttribute("cart", cart);
        
        //This is if when the user clicks Return on the thank you page
        if(goHome != null) {
            cart.clearCart();
            session.invalidate();
            url = "/index.jsp";
        }
        
        //for when the user clicks 'Continue Shopping' when they are at the cart
        if(goBack != null) {
            session.invalidate();
            response.sendRedirect("./index.jsp");
        }
        //for when the user clicks 'Checkout'
        else if(checkout != null) {
            total = cart.totalPrice();
            response.sendRedirect("./signin.jsp");
        }
        //send the data to the servlet
        else {
            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        }
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }
    
}
