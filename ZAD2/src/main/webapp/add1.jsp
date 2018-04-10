    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <!Doctype html Public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
        <title>Rejestracja</title>
        </head>
        <body>
        <form action="add" method="post">
        <label>Username: <input type="text" id="uesrname" name="username"></label><br>
        <label>Password: <input type="password" id="password" name="password"></label><br>
            <label>Confirm password<input type="password" id="confpass" name="confpass">Haslo musi byc takie samo</label><br>
            <label>E-mail: <input type="text" id="email" name="email"></label><br>

        <input type="submit" value="wyslij">
        </form>
        </body>
        </html>