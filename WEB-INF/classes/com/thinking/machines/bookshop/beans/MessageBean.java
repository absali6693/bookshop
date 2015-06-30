package com.thinking.machines.bookshop.beans;
import java.io.*;
public class MessageBean implements Serializable
{
private String message="";
private String path="";
public void setMessage(String message)
{
this.message=message;
}
public void setPath(String path)
{
this.path=path;
}
public String getMessage()
{
return this.message;
}
public String getPath()
{
return this.path;
}
}