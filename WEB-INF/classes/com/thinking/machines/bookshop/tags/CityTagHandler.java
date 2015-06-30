package com.thinking.machines.bookshop.tags;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class CityTagHandler extends BodyTagSupport
{
private ArrayList<String> cities;
private int index;
public int doStartTag()
{
try
{
cities=new AuthorDAO().getCities();
}catch(DAOException daoException)
{
return super.SKIP_BODY;
}
setScriptingVariables();
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
index++;
if(index==cities.size())return super.SKIP_BODY;
setScriptingVariables();
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
public void reset()
{
index=0;
}
public void setScriptingVariables()
{
pageContext.setAttribute("serialNumber",new Integer(index+1));
pageContext.setAttribute("city",cities.get(index));
}
}