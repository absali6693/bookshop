package com.thinking.machines.bookshop.beans;
import java.io.*;
public class ErrorBean implements Serializable
{
private String message="";
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
}