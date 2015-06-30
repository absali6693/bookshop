package com.thinking.machines.bookshop.tags;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorComboBoxTagHandler extends TagSupport
{
public int doStartTag()
{
try
{
ArrayList<AuthorInterface> authors;
try{
authors=new AuthorDAO().get();
}catch(DAOException daoException)
{
authors=new ArrayList<AuthorInterface>();
}
JspWriter jspWriter=pageContext.getOut();
jspWriter.write("<select id='code' name='code'>");
int x=0;
while(x<authors.size())
{
jspWriter.write("<option value='"+authors.get(x).getCode()+"'>"+authors.get(x).getName()+"</option>");
x++;
}
jspWriter.write("</select>");
}catch(Exception exception)
{
System.out.println(exception);
}
return super.EVAL_BODY_INCLUDE;
}
public int toEndTag()
{
return super.EVAL_PAGE;
}
}