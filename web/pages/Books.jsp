
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="styles/style_main.css">
<main class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 search_div">
            <form class="form-inline mid search_form" role="form">
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail2">Поиск</label>
                    <input type="text" class="form-control" id="exampleInputEmail2" placeholder="Search" name="search">
                </div>
                <button type="submit" class="btn btn-info">Найти</button>
                <select class="form-control">
                    <option>Название</option>
                    <option>Автор</option>
                    <option>Год</option>
                    <option>Жанр</option>
                    <option>Язык</option>
                </select>
            </form>
        </div>
    </div>
    <div class="row">
        <%@include file="/WEB-INF/jspf/LeftColomn.jspf"%>
        <div class="col-md-7 col-lg-7 coloms">
            <%%>
        </div>
    </div>
</main>