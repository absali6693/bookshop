package com.thinking.machines.bookshop.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.bookshop.beans.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import com.thinking.machines.bookshop.dao.*;
public class AddAuthor extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
AuthorBean authorBean=(AuthorBean)request.getAttribute("authorBean");
AuthorInterface authorInterface;
authorInterface=new Author();
authorInterface.setName(authorBean.getName());
authorInterface.setCity(authorBean.getCity());
AuthorDAOInterface authorDAOInterface=new AuthorDAO();
RequestDispatcher requestDispatcher;
try
{
authorDAOInterface.add(authorInterface);
authorBean.setCode(authorInterface.getCode());
MessageBean messageBean=new MessageBean();
messageBean.setMessage("Author Added");
messageBean.setPath("AuthorAddForm.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/AuthorAddForm.jsp");
requestDispatcher.forward(request,response);
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