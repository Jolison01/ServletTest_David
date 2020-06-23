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

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();
        Collection<String[]> values = parameters.values();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>");
        writer.print("queryServlet");
        writer.print("</title>");
        writer.print("</head>");
        writer.print("<body>");

        // print out "hello pluto if parameter Map is empty
        if (parameters.isEmpty()) {
            writer.println("Hello pluto");
        } else {
            // print out all the values van the parameter
            for (String[] value : values) {
                for (String valuePart : value) {
                    writer.println(valuePart);
                }
            }
            writer.print("</body>");
            writer.print("</html>");

        }
    }

    }

