import org.json.simple.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="database", urlPatterns = "/db")
public class ServletGet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] OuterTempCol = request.getParameterValues("select");
        List<String> innerTempCol = Arrays.asList(OuterTempCol[0].split(","));
        ArrayList<String> col = new ArrayList(innerTempCol);
        String table = request.getParameter("from");
        ReadFromDB reader = new ReadFromDB();
        JSONObject result = reader.read(col , ""+table);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();

    }

}
