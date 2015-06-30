<jsp:include page='/MasterPageTopSection.jsp' />
<script language='javascript' src='AuthorAddForm.js'></script>
<h1>Author (Add Module) </h1>
<jsp:useBean id='errorBean' class='com.thinking.machines.bookshop.beans.ErrorBean' scope='request' />
<jsp:useBean id='authorBean' class='com.thinking.machines.bookshop.beans.AuthorBean' scope='request' />
<jsp:getProperty name='errorBean' property='message' />
<form action='/<%=com.thinking.machines.bookshop.common.GlobalResources.CONTEXT_NAME%>/AddAuthor.jsp' onsubmit='return validateForm(this)'>
Name 
<input type='text' name='name' id='name' maxlength='50' size='51' value='<%=authorBean.getName()%>'>
<br/>
City
<input type='text' name='city' id='city' maxlength='50' size='51' value='<%=authorBean.getCity()%>'>
<br/>
<input type='submit' value='Add'> 
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />