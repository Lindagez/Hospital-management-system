
package Controller;

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.RequestDispatcher;


@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {

    private int i;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            

            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            
            String gender = request.getParameter("gender");
            String mobile = request.getParameter("Mobile");
            String email= request.getParameter("email");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String qualification = request.getParameter("qualifaction");
             String password = request.getParameter("password");
            
          
          

            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement pst = con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, id);
            pst.setString(2, fname);
            pst.setString(3, lname);
             pst.setString(4,gender );
            pst.setString(5, mobile);
            pst.setString(6, email);
            pst.setString(7, age);
            pst.setString(8, address);
            pst.setString(9, qualification);
             pst.setString(10, password);
          
      
     
                     

            i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Login Successfully..!');");
                pw.println("window.location.href = \"AdminHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
                //rd.forward(request, response);
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Incorrect Data..!');");
                pw.println("window.location.href = \"addpatient.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("addpatient.jsp");
                //rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
