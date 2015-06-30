package com.thinking.machines.bookshop.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import com.thinking.machines.bookshop.dao.*;
public class ListOfAuthors extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
ArrayList<AuthorInterface> authors;
try
{
AuthorDAOInterface authorDAOInterface=new AuthorDAO();
authors=authorDAOInterface.get();
}catch(DAOException daoException)
{
authors=new ArrayList<AuthorInterface>();
}
pw.println("<html><head><title>The Book Shop</title></head><body>");
pw.println("<center><h1>Author(List Module)</h1>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th>S.No.</th>");
pw.println("<th>Name</th>");
pw.println("<th>City</th>");
pw.println("</tr>");
pw.println("</thead>");
AuthorInterface authorInterface;
int x=0;
pw.println("<tbody>");
while(x<authors.size())
{
authorInterface=authors.get(x);
pw.println("<tr>");
pw.println("<td>"+(x+1)+"</td>");
pw.println("<td>"+authorInterface.getName()+"</td>");
pw.println("<td>"+authorInterface.getCity()+"</td>");
pw.println("</tr>");
x++;
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("<a href='/bookshop/index.html'>Home</a>");
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