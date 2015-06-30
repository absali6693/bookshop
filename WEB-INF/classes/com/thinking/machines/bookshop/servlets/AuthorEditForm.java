package com.thinking.machines.bookshop.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import com.thinking.machines.bookshop.dao.*;
public class AuthorEditForm extends HttpServlet
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
AuthorInterface authorInterface;
int x=0;
pw.println("<html><head><title>The Book Shop</title></head><body>");
pw.println("<center><h1>Author(Edit Module)</h1>");
pw.println("<form action=/bookshop/EditAuthor>");
pw.println("<select name='code' id='code'>");
while(x<authors.size())
{
authorInterface=authors.get(x);
pw.println("<option value='"+authorInterface.getCode()+"'>"+authorInterface.getName()+"</option>");
x++;
}
pw.println("<input type='submit' value='Edit Author'><br/>");
pw.println("<a href='/bookshop/index.html'>Home</a>");
pw.println("</form></select></body></html>");


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