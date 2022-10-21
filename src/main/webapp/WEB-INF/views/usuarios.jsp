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
                font-size: 460%;">usuários(as)</h1>
</div>
<div id="tableUsuariosContainer" align="center;" style="margin: auto; width: 80%;">
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th scope="col" style="color: hotpink;">nome</th>
            <th scope="col" style="color: hotpink;">e-mail</th>
            <th scope="col" style="color: hotpink;">status</th>
            <th scope="col" style="color: hotpink; text-align: center;">ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${usuarios}">
            <input type="hidden" value="${usuario.getId()}" name="idUsuarioExclusao"
                   id="idUsuarioExclusao"/>
            <tr>
                <th scope="row">${usuario.getNome()}</th>
                <td>${usuario.getEmail()}</td>
                <td>
                    <c:if test="${usuario.getAtivo()}">
                        ativo(a)
                    </c:if>
                    <c:if test="${!usuario.getAtivo()}">
                        inativo(a)
                    </c:if>
                </td>
                <td align="center">
                    <form method="post">
                        <input type="submit" class="btn btn-outline-info"
                               formaction="/usuario/editar-usuario.action?id=${usuario.getId()}" value="editar"/>
                            <%--                                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"--%>
                            <%--                                        data-bs-target="#modalConfirmacaoExclusaoColaborador">--%>
                            <%--                                    excluir--%>
                            <%--                                </button>--%>
                    </form>
                </td>
            </tr>
            <%--modal de confirmacao da exclusao--%>
            <div class="modal fade" id="modalConfirmacaoExclusaoUsuario" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="1"
                 aria-labelledby="modalConfirmacaoExclusaoUsuarioLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-dark" style="color: hotpink;" >
                            <h5 class="modal-title"id="modalConfirmacaoExclusaoUsuarioLabel">confirme as alterações</h5>
                            <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body bg-dark" style="color: antiquewhite;">
                            deseja excluir este cadastro?
                        </div>
                        <div class="modal-footer bg-dark">
                            <form action="/usuario/excluir-usuario.action?id=${usuario.getId()}" method="post">
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