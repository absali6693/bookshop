function validateForm(frm)
{
var name=frm.name.value.trim();
if(name.length==0)
{
alert('Name required');
frm.name.focus();
return false;
}
var city=frm.city.value.trim();
if(city.length==0)
{
alert('City required');
frm.city.focus();
return false;
}
return true;
}