<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ToDo App</title>
    <link href="style01.css" rel="stylesheet" type="text/css">
</head>


    <body>
    <h1> Todo Web App </h1>
    <img src="check.png" alt="check mark" style="width:40px;height:40px;">
    <br/>
    <br/>

    <br/>
    <div class = 'form'>
        <form name = "myForm" method = "post" action = "HelloServlet" >
            <table>
                <tbody>

                <tr>
                    <td>Enter ToDo</td>
                    <td><input type = "text" name = "task" value = "" size = "50" /> </td>
                </tr>

            </table>
            <input type = "reset" value="Clear D:" name = "Clear"/>
            <input type = "submit" value="Submit :D " name = "Submit"/>
        </form>
    </div>




    <br/>
    <div class = 'form'>
        <form name = "delForm" method = "post" action = "DelServlet" >
            <table>
                <tbody>

                <tr>
                    <td>Delete ToDo</td>
                    <td><input type = "text" name = "task" value = "" size = "50" /> </td>
                </tr>

            </table>
            <input type = "reset" value="Clear D:" name = "Clear"/>
            <input type = "submit" value="Submit :D " name = "Submit"/>
        </form>
    </div>
    <br/>
    <br/>
    <div class = 'form'>
        <form name = "showForm" method = "post" action = "ShowServlet" >
            <input type = "submit" value="Show Todo List " name = "Submit"  size = "100"/>
        </form>
    </div>



</body>
</html>