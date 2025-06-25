
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
<title> Studen Registration Form </title>
  <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form  modelAttribute="student" action="processform" method="POST">
FIRST NAME: <form:input path="firstName"/>
<form:errors path="firstName" cssClass="error" />
<br><br>
LAST NAME: <form:input path="lastName"/>
   <form:errors path="lastName" cssClass="error" />
<br><br>
Country:
<form:select path="country">
<form:option value="Brazil" label="Brazil"/>
<form:option value="France" label="France"/>
<form:option value="Germany" label="Germany "/>
<form:option value="India" label="India "/>
</form:select>
<br><br>
NumberRange: <form:input path="numberRange"/>
<form:errors path="numberRange" cssClass="error" />
<br><br>
PostalCode: <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error" />
<br><br>
Gender:
<form:radiobutton path="gender" value="Male" /> Male
<form:radiobutton path="gender" value="Female" /> Female
<form:radiobutton path="gender" value="Other" /> Other
<form:errors path="gender" cssClass="error" />
<br><br>
Hobbies:
<form:checkbox path="hobbies" value="Reading" /> Reading
<form:checkbox path="hobbies" value="Traveling" /> Traveling
<form:checkbox path="hobbies" value="Gaming" /> Gaming
<form:checkbox path="hobbies" value="Music" /> Music
<form:errors path="hobbies" cssClass="error" />
<br><br>
Course Code: <form:input path="courseCode"/>
 <form:errors path="courseCode"/><br><br>
<input type="submit"  value="Submit"/>
</form:form>
</body>

</html>