package com.thinking.machines.bookshop.tags;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class AuthorTagHandlerTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData tagData)
{
VariableInfo[] variableInfo=new VariableInfo[4];
variableInfo[0]=new VariableInfo("serialNumber","java.lang.Integer",true,VariableInfo.NESTED);
variableInfo[1]=new VariableInfo("code","java.lang.Integer",true,VariableInfo.NESTED);
variableInfo[2]=new VariableInfo("name","java.lang.String",true,VariableInfo.NESTED);
variableInfo[3]=new VariableInfo("city","java.lang.String",true,VariableInfo.NESTED);
return variableInfo;
}
}