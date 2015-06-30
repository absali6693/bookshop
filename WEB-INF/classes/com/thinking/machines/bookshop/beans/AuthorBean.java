package com.thinking.machines.bookshop.beans;
import java.io.*;
public class AuthorBean implements Serializable 
{
private int code=0;
private String name="";
private String city="";
public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;
}
public void setCity(String city)
{
this.city=city;
}

public int getCode()
{
return this.code;
}
public String getName()
{
return this.name;
}
public String getCity()
{
return this.city;
}
}