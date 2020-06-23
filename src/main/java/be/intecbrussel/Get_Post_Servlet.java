package be.intecbrussel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;


@WebServlet("/Get")
public class Get_Post_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Get-It_Post-It</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<h2>Ge-It and Post-It</h2><br>");
        writer.print("<form action='post' action=\"Go back\">");
        writer.print("<label for=\"fname\"> what is your name?</label>");
        writer.print("<input type=\"text\" placeholder=\"ClientName\" value='Wilson' required>");
        writer.print("<input type=\"submit\" value=\"submit>");
        writer.print("</form>");
        writer.print("</body>");
        writer.print("</html>");
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();
        Collection<String[]> values = parameters.values();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Get-It_Post-It</title");
        writer.println("</head>");
        writer.println("<body>");
       //Print out "Unknown_user" when form is empty
        if (parameters.isEmpty()){
            writer.println("Unknown_user");
        }
        else {
            for (String[] value : values) {
                for (String valuePart : value) {
                    writer.println(valuePart);
                }
            }
        }
        writer.println("<button type=\"submit\">Go back</button>");
        writer.println("</body>");
        writer.println("</html>");


        writer.close();

    }
}
