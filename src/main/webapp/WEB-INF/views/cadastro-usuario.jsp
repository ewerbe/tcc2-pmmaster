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
<form id="cadastroUsuario">
    <div align="center" style="margin-top: 3%;">
        <c:choose>
            <c:when test="${usuarioEditar != null}">
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">editar usuario(a)</h1>
                <input type="hidden" id="idUsuario" name="idUsuario" value="${usuarioEditar.getId()}"
            </c:when>
            <c:otherwise>
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">novo(a) usuário(a)</h1>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="formContainer" style="width: 500px; margin: auto;">
        <div class="mb-3" align="left">
            <label for="nomeUsuario" class="form-label" style="color: #262630;
                   font-weight: bold;">nome</label>
            <input type="text" class="form-control bg-dark" id="nomeUsuario" name="nomeUsuario"
                   value="${usuarioEditar.getNome()}"
                   placeholder="nome do(a) usuário(a)" style="color: antiquewhite; align-content: space-around;"
                   required>
        </div>
        <div class="mb-3" align="left">
            <label for="emailUsuario" class="form-label" style="color: #262630;
                   font-weight: bold;">e-mail</label>
            <input type="email" class="form-control bg-dark" id="emailUsuario" name="emailUsuario"
                   value="${usuarioEditar.getEmail()}"
                   placeholder="e-mail do(a) usuário(a)" style="color: antiquewhite;"
                   required>
        </div>
        <div class="mb-3" align="left">
            <label for="senhaUsuario" class="form-label" style="color: #262630;
                    font-weight: bold;">senha</label>
            <input type="password" class="form-control bg-dark" id="senhaUsuario" name="senhaUsuario"
                   value="${usuarioEditar.getSenha()}"
                   placeholder="senha do(a) usuário(a)" style="color: antiquewhite;"
                   required>
        </div>
        <div class="mb-3" align="left">
            <c:choose>
                <c:when test="${usuarioEditar != null && usuarioEditar.getAtivo()}">
                    <input class="form-check-input" type="checkbox" id="checkUsuarioAtivo"
                           name="checkUsuarioAtivo" checked>
                </c:when>
                <c:otherwise>
                    <input class="form-check-input" type="checkbox" id="checkUsuarioAtivo"
                           name="checkUsuarioAtivo">
                </c:otherwise>
            </c:choose>
            <label class="form-check-label" for="checkUsuarioAtivo" style="color: #262630;
                   font-weight: bold;">
                ativo(a)
            </label>
        </div>
        <div align="left">
            <button type="button" class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacao">
                salvar
            </button>
            <c:if test="${usuarioEditar != null}">
                <button type="button" class="btn btn-outline-danger btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacao">
                    excluir
                </button>
                <input type="submit" class="btn btn-dark" data-bs-dismiss="modal"
                       formaction="/usuarios.action?idUsu=${usuario.getId()}" value="cancelar" formmethod="get" style="margin-left: 30%;"/>
            </c:if>
        </div>



        <!-- Modal de confirmação de cadastro-->
        <div class="modal fade" id="modalConfirmacao" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-dark" style="color: hotpink;" >
                        <h5 class="modal-title"id="modalConfirmacaoLabel">confirme as alterações</h5>
                        <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body bg-dark" style="color: antiquewhite;" align="left">
                        deseja salvar estas alterações?
                    </div>
                    <div class="modal-footer bg-dark">
                        <input type="submit" class="btn btn-outline-light" data-bs-dismiss="modal"
                               formaction="/usuario/salvar-usuario.action?idUsu=${usuario.getId()}" formmethod="post" value="salvar"/>
                        <c:if test="${usuarioEditar != null}">
                            <input type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal"
                                   formaction="/usuario/excluir-usuario.action?idUsu=${usuario.getId()}" value="excluir" formmethod="post">
                        </c:if>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</body>
<%@ include file="footer.jspf" %>