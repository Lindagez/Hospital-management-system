
package Controller;

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
       int  i;
        String f;
        String l;
        String p;
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
             int  id = Integer.parseInt(request.getParameter("id"));
           // String fname = request.getParameter("fname");
           // String lname = request.getParameter("lname");
           
            String pass = request.getParameter("password");
            
            Connection con = DatabaseConnection.initializeDatabase();

            String s = "select *from recp";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                    i=Integer.parseInt(rs.getString( 1));
                   // f=rs.getString(2);
                    //l=rs.getString( 3);
                    p=rs.getString( 4);
            }
            if (id==i &&pass.equals(p)) 
            {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Login Successfully..!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
                //rd.forward(request, response);
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('you are not allowed by admin');");
                pw.println("window.location.href = \"index.jsp\";");
                pw.println("</script>");
                // RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                // rd.include(request, response);
            }
        } catch (Exception e) {

        }

    }

}
