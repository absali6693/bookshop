<jsp:include page='/MasterPageTopSection.jsp'/>
<h1>Notification</h1>
<jsp:useBean id='messageBean' class='com.thinking.machines.bookshop.beans.MessageBean' scope='request'/>
<jsp:getProperty name='messageBean' property='message'/>
<form action='/<%=com.thinking.machines.bookshop.common.GlobalResources.CONTEXT_NAME%>/<%=messageBean.getPath()%>'>
<input type='submit' value='Ok'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />