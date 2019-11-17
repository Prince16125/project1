import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;
import java.sql.* ;
public class AllStudent extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
//String rollNo = req.getParameter("ROLLNO") ;
res.setContentType("text/html") ;
PrintWriter out = res.getWriter() ;
out.println("<html><body>") ;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","dev");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from student2") ;
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

out.println("</td>") ;
out.println("</tr>") ;
}
}
catch(Exception e)
{
System.out.println(e) ;
}

//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
  //  doPost(request, response);
}
}
			
			