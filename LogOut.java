import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;
public  class LogOut extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{ 
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession s = req.getSession() ;
		if(s!=null)
		{
			s.invalidate() ;
			out.println("<html><body>") ;
			out.println("You have logged out successful") ;
			out.println("<br>") ;
			out.println("<a href='index.html'>index</a>") ;
			out.println("</body></html>") ;
		}else {
			out.println("Please login ") ;}
	}
}
			
			