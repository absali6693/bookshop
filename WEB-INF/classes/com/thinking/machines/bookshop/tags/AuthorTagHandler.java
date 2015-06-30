package com.thinking.machines.bookshop.tags;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorTagHandler extends BodyTagSupport
{
private ArrayList<AuthorInterface> authors;
private int index;
private int code=0;
private String city="";
private int fromRecordNumber;
private int uptoRecordNumber;
String orderBy;
public void setOrderBy(String orderBy)
{ 
this.orderBy=orderBy;
}
public String getOrderBy()
{
return this.orderBy;
}
public void setFromRecordNumber(int fromRecordNumber)
{ 
this.fromRecordNumber=fromRecordNumber;
}
public int getFromRecordNumber()
{
return this.fromRecordNumber;
}
public void setUptoRecordNumber(int uptoRecordNumber)
{ 
this.uptoRecordNumber=uptoRecordNumber;
}
public int getUptoRecordNumber()
{
return this.uptoRecordNumber;
}

public void setCode(int code)
{
this.code=code;
}
public void setCity(String city)
{
this.city=city;
}
public int getCode()
{
return this.code;
}
public String getCity()
{
return this.city;
}
public int doStartTag()
{
try
{ 
if(code==0 && (city==null || city.trim().length()==0))
{ 
authors=new AuthorDAO().getByRecordNumber(fromRecordNumber,uptoRecordNumber,orderBy);
} 
else
{ 
if(code!=0)
{
AuthorInterface authorInterface=new AuthorDAO().get(code);
authors=new ArrayList<AuthorInterface>();
authors.add(authorInterface);
}
 else
{ 
if(city!=null && city.trim().length()>0)
{ authors=new AuthorDAO().getByCity(city);
}
}
}
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
if(index==authors.size()) return super.SKIP_BODY;
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
this.fromRecordNumber=0;
this.uptoRecordNumber=0;
this.orderBy=null;
this.authors=null;
this.index=0;
this.code=0;
this.city=null;
}

public void setScriptingVariables()
{
AuthorInterface authorInterface=authors.get(index);
pageContext.setAttribute("serialNumber",new Integer(index+1));
pageContext.setAttribute("code",new Integer(authorInterface.getCode()));
pageContext.setAttribute("name",authorInterface.getName());
pageContext.setAttribute("city",authorInterface.getCity());
}
}