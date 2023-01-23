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
                font-size: 460%;">áreas de conhecimento</h1>
</div>
<div id="tableAreasConhecimentoContainer" align="center;" style="margin: auto; width: 80%;">
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th scope="col" style="color: hotpink;">id</th>
            <th scope="col" style="color: hotpink;">descrição</th>
            <th scope="col" style="color: hotpink; text-align: center;">ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="areaConhecimento" items="${areasConhecimento}">
            <input type="hidden" value="${areaConhecimento.getId()}" name="idAreaConhecimentoExclusao"
                   id="idAreaConhecimentoExclusao"/>
            <tr>
                <th scope="row">${areaConhecimento.getId()}</th>
                <td>
                    ${areaConhecimento.getDescricao()}
                </td>
                <td align="center">
                    <a style="font-weight: bolder; color: hotpink; font-style: normal"
                       href="/areas-conhecimento/cartas-area-conhecimento.action?id=${areaConhecimento.getId()}">
                        ver cartas
                    </a>
                </td>
            </tr>
            <%--modal de confirmacao da exclusao--%>
            </div>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@ include file="footer.jspf" %>