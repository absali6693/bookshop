<%@taglib uri='/WEB-INF/tlds/mymy.tld' prefix='tmtags' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<script language='javascript'>
function updateAuthorsList()
{
document.getElementById("cityComboBoxForm").submit();
}
</script>
<h1>Author (List Module) </h1>
<form id='cityComboBoxForm' action='/<%=com.thinking.machines.bookshop.common.GlobalResources.CONTEXT_NAME%>/ListOfAuthors.jsp'>
From which city
<select id='city' name='city' onchange='updateAuthorsList()'>
<option value=''>&lt;All&gt;</option>
<tmtags:City>
<option value='<%=city%>' <%=(city.equals(request.getParameter("city"))?"selected":"")%>><%=city%></option>
</tmtags:City>
</select>
</form>
<br/>
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
<tmtags:Author city='${param.city}'>
<tr>
<td><%=serialNumber%></td>
<td><%=code%></td>
<td><%=name%></td>
<td><%=city%></td>
</tr>
</tmtags:Author>
</tbody>
</table>
<jsp:include page='/MasterPageBottomSection.jsp' />