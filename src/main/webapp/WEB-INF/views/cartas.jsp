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
                font-size: 460%;">cartas</h1>
</div>
<div>
    <form action="/cadastro-carta.action" method="get">
        <button type="submit" class="btn-lg btn-dark"
                style="font-weight: bolder; color: hotpink; margin-left: 71%;">
            <span style="white-space: nowrap;">nova <i class="bi bi-plus-circle"></i></span>
        </button>
    </form>
</div>
<div id="tableCartasContainer" align="center;" style="margin: auto; width: 80%;">
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th scope="col" style="color: hotpink;">id</th>
            <th scope="col" style="color: hotpink;">pergunta</th>
            <th scope="col" style="color: hotpink;">status</th>
            <th scope="col" style="color: hotpink; text-align: center;">ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="carta" items="${cartas}">
            <input type="hidden" value="${carta.getId()}" name="idCartaExclusao"
                   id="idCartaExclusao"/>
            <tr>
                <th scope="row">${carta.getId()}</th>
                <th scope="row">${carta.getPergunta()}</th>
<%--                <td>${usuario.getEmail()}</td>--%>
                <td>
                    <c:if test="${carta.getAtiva()}">
                        ativa
                    </c:if>
                    <c:if test="${!carta.getAtiva()}">
                        inativa
                    </c:if>
                </td>
                <td align="center">
                    <form method="post">
                        <input type="submit" class="btn btn-outline-info"
                               formaction="/carta/editar-carta.action?id=${carta.getId()}" value="editar"/>
                            <%--                                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"--%>
                            <%--                                        data-bs-target="#modalConfirmacaoExclusaoColaborador">--%>
                            <%--                                    excluir--%>
                            <%--                                </button>--%>
                    </form>
                </td>
            </tr>
            <%--modal de confirmacao da exclusao--%>
            <div class="modal fade" id="modalConfirmacaoExclusaoCarta" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="1"
                 aria-labelledby="modalConfirmacaoExclusaoCartaLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-dark" style="color: hotpink;" >
                            <h5 class="modal-title"id="modalConfirmacaoCartaLabel">confirme as alterações</h5>
                            <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body bg-dark" style="color: antiquewhite;">
                            deseja excluir este cadastro?
                        </div>
                        <div class="modal-footer bg-dark">
                            <form action="/carta/excluir-carta.action?id=${carta.getId()}" method="post">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                    cancelar
                                </button>
                                <input type="submit" class="btn btn-outline-danger"
                                       value="excluir"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@ include file="footer.jspf" %>