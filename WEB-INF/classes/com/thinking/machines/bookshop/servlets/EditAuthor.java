package com.thinking.machines.bookshop.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import com.thinking.machines.bookshop.dao.*;
public class EditAuthor extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
int code=Integer.parseInt(request.getParameter("code").trim());
System.out.println("Code :"+code);
AuthorDAOInterface authorDAOInterface=new AuthorDAO();
AuthorInterface authorInterface;
authorInterface=authorDAOInterface.get(code);
pw.println("<html><head><title>The Book Shop</title></head><body>");
pw.println("<center><h1>Author(Add Module)</h1>");
pw.println("<form action=/bookshop/UpdateAuthor >");
pw.println("<input type='hidden' name='code' id='code' value='"+code+"'>");
pw.println("Name<input type='text' id='name' name='name' value='"+authorInterface.getName()+"' maxlength=50 size=51><br/>");
pw.println("City<input type='text' id='city' name='city' value='"+authorInterface.getCity()+"' maxlength=50 size=51><br/>");
pw.println("<input type='submit' value='Update Author'><br/>");
pw.println("<a href='/bookshop/index.html'>Home</a>");
pw.println("</form>");
pw.println("</center></body></html>");

}catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}