import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;
public class CbseSite extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
String rollNo = req.getParameter("ROLLNO") ;
res.setContentType("text/html") ;
int sum=0;
int Total ;
PrintWriter out = res.getWriter() ;
out.println("<html><body>") ;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","dev");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from student2 where ROLLNO="+rollNo) ;
			ResultSetMetaData rsmd=rs.getMetaData() ;
			out.println("<table bgColor='pink' border=1 width=200>") ;
		    out.println("<tr>") ;
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
			out.println("<th>"+rsmd.getColumnName(i)+"</th>") ;
			}
			//out.println("<th>Sum</th>");
			out.println("</tr>");
			while(rs.next())
			{
			out.println("<tr>") ;
			out.println("<td>"+rs.getString(1)+"</td>") ;
			out.println("<td>"+rs.getString(2)+"</td>") ;
			out.println("<td>"+rs.getInt(3)+"</td>") ;
			out.println("<td>"+rs.getInt(4)+"</td>") ;
			out.println("<td>"+rs.getInt(5)+"</td>") ;
			out.println("<td>"+rs.getInt(6)+"</td>") ;
			out.println("<td>"+rs.getInt(7)+"</td>") ;
			out.println("<td>"+rs.getInt(8)+"</td>") ;

 sum = rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8) ;
out.println("</td>") ;
out.println("</tr>") ;
}
}
catch(Exception e)
{
System.out.println(e) ;
}
out.println("<h3>"+"Total="+sum+"</h3>");
double percentage=(sum*100)/600 ;
out.println("<h3>"+"percentage="+percentage+"</h3>") ;
if(percentage>=60)
{
out.println("First Divison") ;
}
else if(percentage>=45)
{
out.println("Second Divison") ;
}
else if(percentage>=40)
{
out.println("Third Divison") ;
}
else
{
out.println("failed") ;
}
out.println("</body> </html>") ;
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request, response);
}
}
			
			