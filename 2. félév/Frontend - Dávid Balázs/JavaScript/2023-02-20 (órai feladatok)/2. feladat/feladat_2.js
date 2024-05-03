function getFormValue()
{
    event.preventDefault();

  var myForm=document.getElementById("form1");
  for (var i=0;i<myForm.length;i++)
  {
   if (myForm.elements[i].value!='Submit')
    {  
      console.log(myForm.elements[i].value);
     }  
   }
}