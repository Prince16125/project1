import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;
public class AddStudent extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
String ROLLNO = req.getParameter("rollNo") ;
String NAME = req.getParameter("name") ;
String MATH= req.getParameter("math") ;
String HINDI = req.getParameter("hindi") ;
String ENGLISH = req.getParameter("eng") ;
String SCIENCE = req.getParameter("science") ;             
String PHYSICS = req.getParameter("physics") ;
String BIOLOGY = req.getParameter("biology") ;



res.setContentType("text/html") ;
PrintWriter out = res.getWriter() ;
out.println("<html><body>") ;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","dev");
			Statement s=c.createStatement();
			//ResultSet rs=s.executeQuery("select * from student2") ;
			PreparedStatement ps=c.prepareStatement("insert into student2 values(?,?,?,?,?,?,?,?)");  
			//ResultSetMetaData rsmd=rs.getMetaData() ;
		
			ps.setString(1,ROLLNO);
			ps.setString(2,NAME);
			ps.setString(3,MATH);
			ps.setString(4,HINDI);
			ps.setString(5,ENGLISH);
			ps.setString(6,SCIENCE);
			ps.setString(7,PHYSICS);
			ps.setString(8,BIOLOGY);

 //String z = ps.getInt(3)+ps.getInt(4)+ps.getInt(5)+ps.getInt(6)+ps.getInt(7)+ps.getInt(8) ;
int z = ps.executeUpdate();  

}
catch(Exception e)
{
System.out.println(e) ;
}
out.println("<Successfully Record Added>") ;
out.println("</body> </html>") ;
}		
}