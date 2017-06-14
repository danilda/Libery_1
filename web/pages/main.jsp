<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 08.06.2017
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="test">
                    <h3>

                        <%--<%!DAOLibery dao = new OracleDAO();%>--%>
                        <%--<%  Book book = new Book();--%>
                        <%--book.setName("Ведьмак(сборник)");--%>
                        <%--book.setAuthorId(4);--%>
                        <%--book.setContent(new File("C:\\Users\\danil\\IdeaProjects\\Libery_1\\resources\\Amber.pdf"));--%>
                        <%--book.setGenreId(4);--%>
                        <%--book.setImage(new File("C:\\Users\\danil\\IdeaProjects\\Libery_1\\resources\\Amber.jpeg"));--%>
                        <%--book.setPageCount(60);--%>
                        <%--book.setIsbn("****");--%>
                        <%--book.setPublisherId(2);--%>
                        <%--GregorianCalendar gr = new GregorianCalendar();--%>
                        <%--gr.set(Calendar.YEAR, 2016);--%>
                        <%--book.setPublishYear(gr);%>--%>
                        <%--<%=dao.insertBook(book)%>--%>

                    </h3>
                </div>
            </div>
        </div>
    </main>


