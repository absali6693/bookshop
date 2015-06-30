<%@taglib uri='/WEB-INF/tlds/mymy.tld' prefix='tmtags' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<script language='javascript' src='AuthorAddForm.js'></script>
<h1>Author (Edit Module) </h1>
<form action='/<%=com.thinking.machines.bookshop.common.GlobalResources.CONTEXT_NAME
%>/EditAuthor.jsp' onsubmit='return validateForm(this)'>
Select author
<tmtags:AuthorComboBox />
<br/>
<input type='submit' value='Edit'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />