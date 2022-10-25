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
<form id="cadastroCarta">
    <div align="center" style="margin-top: 3%;">
        <c:choose>
            <c:when test="${cartaEditar != null}">
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">editar carta</h1>
                <input type="hidden" id="idCarta" name="idCarta" value="${cartaEditar.getId()}"
            </c:when>
            <c:otherwise>
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">nova carta</h1>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="formContainer" style="width: 500px; margin: auto;">
        <div class="mb-3" align="left">
            <label for="perguntaCarta" class="form-label" style="color: #262630;
                   font-weight: bold;">pergunta</label>
            <input type="text" class="form-control bg-dark" id="perguntaCarta" name="perguntaCarta"
                   value="${cartaEditar.getPergunta()}"
                   placeholder="insira aqui a pergunta da carta" style="color: antiquewhite; align-content: space-around;"
                   required>
        </div>
        <div class="mb-3" align="left">
            <label for="alternativa_A_carta" class="form-label" style="color: #262630;
                   font-weight: bold;">alternativa A</label>
            <input type="text" class="form-control bg-dark" id="alternativa_A_carta" name="alternativa_A_carta"
                   value="${cartaEditar.getAltern_A()}"
                   placeholder="insira aqui a alternativa A" style="color: antiquewhite;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="alternativa_B_carta" class="form-label" style="color: #262630;
                   font-weight: bold;">alternativa B</label>
            <input type="text" class="form-control bg-dark" id="alternativa_B_carta" name="alternativa_B_carta"
                   value="${cartaEditar.getAltern_B()}"
                   placeholder="insira aqui a alternativa B" style="color: antiquewhite;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="alternativa_C_carta" class="form-label" style="color: #262630;
                   font-weight: bold;">alternativa C</label>
            <input type="text" class="form-control bg-dark" id="alternativa_C_carta" name="alternativa_C_carta"
                   value="${cartaEditar.getAltern_C()}"
                   placeholder="insira aqui a alternativa C" style="color: antiquewhite;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="alternativa_D_carta" class="form-label" style="color: #262630;
                   font-weight: bold;">alternativa D</label>
            <input type="text" class="form-control bg-dark" id="alternativa_D_carta" name="alternativa_D_carta"
                   value="${cartaEditar.getAltern_D()}"
                   placeholder="insira aqui a alternativa D" style="color: antiquewhite;"
                   required>
        </div>


        <div class="mb-3" align="left">
            <label for="alternativa_correta_carta" class="form-label" style="color: #262630;
                   font-weight: bold;">alternativa correta</label>
            <select class="form-control bg-dark" id="alternativa_correta_carta" name="alternativa_correta_carta"
                    value="${carta.getAltern_correta()}"
                    required style="color: cornsilk;">
                <c:forEach var="alternativa" items="${alternativas}">
                    <c:choose>
                        <c:when test="${carta.getAltern_correta() != null}">
                            <c:if test="${carta.getAltern_correta() == alternativa}">
                                <option value="${carta.getAltern_correta()}" selected>${alternativa}</option>
                            </c:if>
                            <option value="${alternativa}">${alternativa}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${alternativa}">${alternativa}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>


        <div class="mb-3" align="left">
            <c:choose>
                <c:when test="${cartaEditar != null && cartaEditar.getAtiva()}">
                    <input class="form-check-input" type="checkbox" id="checkCartaAtiva"
                           name="checkCartaAtiva" checked>
                </c:when>
                <c:otherwise>
                    <input class="form-check-input" type="checkbox" id="checkCartaAtiva"
                           name="checkCartaAtiva">
                </c:otherwise>
            </c:choose>
            <label class="form-check-label" for="checkCartaAtiva" style="color: #262630;
                   font-weight: bold;">
                ativa
            </label>
        </div>
        <div align="left">
            <button type="button" class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacao">
                salvar
            </button>
            <c:if test="${cartaEditar != null}">
                <button type="button" class="btn btn-outline-danger btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacao">
                    excluir
                </button>
                <input type="submit" class="btn btn-dark" data-bs-dismiss="modal"
                       formaction="/cartas.action?idUsu=${usuario.getId()}" value="cancelar" formmethod="get" style="margin-left: 30%;"/>
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
                               formaction="/carta/salvar-carta.action?idUsu=${usuario.getId()}" formmethod="post" value="salvar"/>
                        <c:if test="${cartaEditar != null}">
                            <input type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal"
                                   formaction="/carta/excluir-carta.action?idUsu=${usuario.getId()}" value="excluir" formmethod="post">
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