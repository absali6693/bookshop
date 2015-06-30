package com.thinking.machines.bookshop.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import com.thinking.machines.bookshop.dao.*;
public class DeleteAuthor extends HttpServlet
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
try
{
authorDAOInterface.remove(code);
pw.println("<html><head><title>The Book Shop</title></head><body>");
pw.println("<center><h1>Author(Delete Module)</h1>");
pw.println("Data Deleted<br/>");
pw.println("<form action='/bookshop/AuthorDeleteForm.html'>");
pw.println("<input type='submit' value='Ok'></form>");
pw.println("<br/><a href='/bookshop/index.html'>Home</a>");
pw.println("</center></body></html>");
}catch(DAOException daoException)
{
pw.println("<html><head><title>The Book Shop</title></head><body>");
pw.println("<center><h1>Author(Delete Module)</h1>");
pw.println(daoException.getMessage()+"<br/>");
pw.println("<form action='/bookshop/AuthorDeleteForm.html'>");
pw.println("<input type='submit' value='Ok'></form>");
pw.println("<br/><a href='/bookshop/index.html'>Home</a>");
pw.println("</center></body></html>");
}
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