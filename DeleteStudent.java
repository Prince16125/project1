import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;public class DeleteStudent extends HttpServlet
{
	//String rollNo ;
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
res.setContentType("text/html") ;
PrintWriter out = res.getWriter() ;
out.println("<html><body>") ;
 String ROLLNO = req.getParameter("ROLLNO") ; 
/*String NAME = req.getParameter("NAME") ;
String MATH= req.getParameter("MATH") ;
String HINDI = req.getParameter("HINDI") ;
String ENGLISH = req.getParameter("ENGLISH") ;
String SCIENCE = req.getParameter("SCIENCE") ;             
String PHYSICS = req.getParameter("PHYSICS") ;
String BIOLOGY = req.getParameter("BIOLOGY") ;*/


try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","dev");
			Statement s=c.createStatement();
  s.executeUpdate("delete from student2 where ROLLNO= "+ROLLNO+" " );  
}
catch(Exception e)
{
System.out.println(e) ;
}
out.println("Successfully Record Deleted") ;
out.println("</body> </html>") ;
}	
}	
