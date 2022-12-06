
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jspf" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body style="background-color: darkgrey;">
<div align="center" style="margin-top: 3%;">
    <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">tabuleiro(s)</h1>
</div>
<div>
    <form action="/tabuleiros/novo-tabuleiro.action?idUsuario=1" method="post">
        <button type="submit" class="btn-lg btn-dark"
                style="font-weight: bolder; color: hotpink; margin-left: 71%;">
            <span style="white-space: nowrap;">gerar novo</span>
        </button>
    </form>
</div>
<div id="tableTabuleirosContainer" align="center;" style="margin: auto; width: 80%;">
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th scope="col" style="color: hotpink;">id</th>
            <th scope="col" style="color: hotpink; text-align: center;">arquivo PDF</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tabuleiro" items="${tabuleiros}">
            <input type="hidden" value="${tabuleiro.getId()}" name="idTabuleiroExclusao"
                   id="idTabuleiroExclusao"/>
            <tr>
                <th scope="row">${tabuleiro.getId()}</th>
                <td align="center">
                    <form method="post">
                        <input type="submit" class="btn btn-outline-info"
                               formaction="/tabuleiro/tabuleiro.action?id=${tabuleiro.getId()}" value="baixar arquivo pdf"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@ include file="footer.jspf" %>