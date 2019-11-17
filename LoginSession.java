import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;
public  class LoginSession extends HttpServlet
{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{ 
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
//		ServletContext res1 = getServletContext() ;
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","dev");
			Statement s=c.createStatement();
			ResultSet rs = s.executeQuery( "select * from student1 where name = '"+name+"' and password='"+pass+"' ");
			if(rs.next())
			{
			HttpSession se = req.getSession();
			se.setAttribute("name",name);
			se.setAttribute("pass",pass);
		    out.println("User is valid"+" "+se.isNew()) ;
			out.println("<br>") ;
			out.println("<br>") ;
			//out.println("<a href='demo'>demoServlet</a>") ;
	
	       RequestDispatcher res1=req.getRequestDispatcher("index.html") ;
		   res1.include(req,res);
			out.println("<a href='log'>LogOut</a>") ;
			}
			else
			{
			out.println("user is invalid ") ;
			 res.sendRedirect("error") ;
			out.println("<br> ") ;
			}
		}
catch(Exception e)
{
out.println(e) ;
}
out.println("</body></html>") ;
}
}
			
			