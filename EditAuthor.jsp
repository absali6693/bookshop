<jsp:useBean id='authorBean' class='com.thinking.machines.bookshop.beans.AuthorBean'
scope='request' />
<jsp:setProperty name='authorBean' property='*' />
<jsp:forward page='/EditAuthor' />