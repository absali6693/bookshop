<%@taglib uri='/WEB-INF/tlds/mymy.tld' prefix='tmtags'%>
<jsp:include page='/MasterPageTopSection.jsp' />

<%
int authorFromRecordNumber=1;
int authorUptoRecordNumber=1;
int authorPageSize=5;
int authorPageNumber=1;
if(request.getParameter("authorPageSize")!=null)
{ 
authorPageSize=Integer.parseInt(request.getParameter("authorPageSize"));
} 
if(request.getParameter("authorPageNumber")!=null)
{ 
authorPageNumber=Integer.parseInt(request.getParameter("authorPageNumber"));
} 
authorFromRecordNumber=(authorPageNumber-1)*authorPageSize+1;
authorUptoRecordNumber=authorPageNumber*authorPageSize;
%>
<script language='javascript'>
function updateAuthorPageSize()
{
authorFromRecordNumber=authorPageSize.value*(authorPageNumber.value-1)+1;
authorUptoRecordNumber=authorPageNumber.value*authorPageSize.value;
authorPageSize = document.getElementById("authorPageSizeComboBox").value;
if(authorPageSize==1){
document.getElementById("authorPageSize").value = authorPageSize;
document.getElementById("authorPageNumber").value =parseInt((authorFromRecordNumber/authorPageSize)) ;
document.getElementById("authorPaginationForm").submit();
}
var i=0;
for(i=authorFromRecordNumber;i<=authorUptoRecordNumber;i++)
{
if(i%authorPageSize==0) break;
}
authorPageNumber=parseInt((authorFromRecordNumber/authorPageSize)+1);
if(i>authorUptoRecordNumber || (i-authorFromRecordNumber+1)==authorPageSize ||(i-authorFromRecordNumber+1)>=(authorUptoRecordNumber-i)||authorPageSize<=(authorUptoRecordNumber-i));
else	authorPageNumber+=1;
document.getElementById("authorPageSize").value = authorPageSize;
document.getElementById("authorPageNumber").value = authorPageNumber;
document.getElementById("authorPaginationForm").submit();
}
function updateAuthorPageNumber(x)
{
authorPageNumber=x;
document.getElementById("authorPageNumber").value = authorPageNumber;
document.getElementById("authorPaginationForm").submit();
}


</script>
<h1>Author (List Module) </h1>
<h4>Page Number <%=authorPageNumber%></h4>
 Number of entries on a Page &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <select name="authorPageSizeComboBox" id="authorPageSizeComboBox" onchange="updateAuthorPageSize()">
<option value=""></option>
<%
for(int i=1;i<=100;i++){
if(authorPageSize!=i)
{
out.println("<option value='"+i+"'>"+i+"</option>");
}
else{
out.println("<option value='"+i+"' selected>"+i+"</option>");
}
}
%>
</select> 


<table border='1'>
<thead>
<tr>
<th>S.No.</th>
<th>Code</th>
<th>Name</th>
<th>City</th>
</tr>
</thead>
<tbody>
<tmtags:Author fromRecordNumber='<%=authorFromRecordNumber%>' uptoRecordNumber='<%=authorUptoRecordNumber%>' orderBy='code'>
<tr>
<td><%=serialNumber%></td>
<td><%=code%></td>
<td><%=name%></td>
<td><%=city%></td>
</tr>
</tmtags:Author>
</tbody>
</table>
<%
long authorPageNumberOfLinks=5;
long authorPageNumberFrom=authorPageNumber-(authorPageNumber%5)+1;
if((authorPageNumber%5)==0)
{
authorPageNumberFrom-=authorPageNumberOfLinks;
}

long authorPageNumberUpto=authorPageNumberFrom+authorPageNumberOfLinks-1;
long authorPageNumberPreviousValue=authorPageNumberFrom-1;
long authorPageNumberNextValue=authorPageNumberUpto+1;
long totalRecords=0;
try{
totalRecords=new com.thinking.machines.bookshop.dao.AuthorDAO().getCount();
}catch(com.thinking.machines.bookshop.dao.exceptions.DAOException daoException)
{
}
long totalPages=totalRecords/authorPageSize;
if(totalRecords%authorPageSize!=0)totalPages++;
if(totalPages<authorPageNumberUpto)authorPageNumberUpto=totalPages;
if(authorPageNumberFrom!=1)
{
out.println("<a href='javascript:updateAuthorPageNumber("+authorPageNumberPreviousValue+")'>Prev</a>&nbsp;&nbsp;&nbsp;");
}
for(long x=authorPageNumberFrom;x<=authorPageNumberUpto;x++)
{
if(authorPageNumber!=x)
{
out.println("<a href='javascript:updateAuthorPageNumber("+x+")'>"+x+"</a>&nbsp;&nbsp;&nbsp;");
}
else{
out.println(x+"&nbsp;&nbsp;&nbsp;");
}
}

if(authorPageNumberUpto<totalPages)
{
out.println("<a href='javascript:updateAuthorPageNumber("+authorPageNumberNextValue+")'>Next</a>&nbsp;&nbsp;&nbsp;");
}
%>
<form action='/bookshop/test.jsp' id='authorPaginationForm'>
<input type='hidden' id='authorPageSize' name='authorPageSize' value='<%=authorPageSize%>'>
<input type='hidden' id='authorPageNumber' name='authorPageNumber' value='<%=authorPageNumber%>'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />