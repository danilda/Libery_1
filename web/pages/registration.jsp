<%@ page import="jms.registarationJMS.JMSSender" %>
<%@ page import="email.EmailSender" %><%--
    Document   : registration
    Created on : Jun 9, 2017, 6:20:17 PM
    Author     : dach1016
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="styles/style_registration.css">
    <main class="container-fluid main midle">
        <form class="form-inline reg_form midle" role="form">
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email">
            </div> <br>
            <div class="form-group">
                <label for="exampleInputPassword1">Пароль</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div><br>
            <div class="form-group">
                <label for="exampleInputPassword2">Подтвердите пароль</label>
                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Confirm Password">
            </div><br>
            <button type="submit" class="btn btn-success">Зарегестрировать</button>
        </form>
    </main>
