<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div style="position: relative;">
        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 1}">
                    <img src="/images/integracao.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 1}">
                    <img src="/images/integracao.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 2}">
                    <img src="/images/escopo.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 2}">
                    <img src="/images/escopo.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>


        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 3}">
                    <img src="/images/tempo.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 3}">
                    <img src="/images/tempo.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 4}">
                    <img src="/images/custos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 4}">
                    <img src="/images/custos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 5}">
                    <img src="/images/qualidade.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 5}">
                    <img src="/images/qualidade.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 6}">
                    <img src="/images/recursos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 6}">
                    <img src="/images/recursos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 7}">
                    <img src="/images/comunicacao.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 7}">
                    <img src="/images/comunicacao.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 8}">
                    <img src="/images/riscos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 8}">
                    <img src="/images/riscos.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>

            <c:choose>
                <c:when test="${jogadaAtual!=null}">
                    <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 9}">
                        <img src="/images/aquisicoes.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:if test="${carta.getAreaConhecimento().getId() == 9}">
                        <img src="/images/aquisicoes.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                    </c:if>
                </c:otherwise>
            </c:choose>

        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <c:if test="${jogadaAtual.getIdCarta().getAreaConhecimento().getId() == 10}">
                    <img src="/images/stakeholders.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:when>
            <c:otherwise>
                <c:if test="${carta.getAreaConhecimento().getId() == 10}">
                    <img src="/images/stakeholders.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                </c:if>
            </c:otherwise>
        </c:choose>


        <%--PERGUNTAS E RESPOSTAS--%>
        <c:choose>
            <c:when test="${jogadaAtual!=null}">
                <h3 style="position: absolute; color: black; top: 20%; margin-left: 32%;">
                    ${jogadaAtual.getIdCarta().getAreaConhecimento().getDescricao()}
                </h3>
            </c:when>
            <c:otherwise>
                <h3 style="position: absolute; color: black; top: 20%; margin-left: 32%;">
                        ${carta.getAreaConhecimento().getDescricao()}
                </h3>
            </c:otherwise>
        </c:choose>


        <div style="position: absolute; top: 26%; left: 15%; width: 300px;
                        alignment: center; padding-left: 3%; padding-right: 5%;">
            <c:choose>
                <c:when test="${jogadaAtual!=null}">
                    <div>
                        <strong>Pergunta:</strong> ${jogadaAtual.getIdCarta().getPergunta()}
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <strong>Pergunta:</strong> ${carta.getPergunta()}
                    </div>
                </c:otherwise>
            </c:choose>


            <c:choose>
                <c:when test="${fecharAlternativas!=null}">
                    <c:choose>
                        <c:when test="${fecharAlternativas}">
                        <div style="margin-top: 5%;">
                            <strong>(A)</strong> ${jogadaAtual.getIdCarta().getAltern_A()}
                        </div>
                        <div style="margin-top: 5%;">
                            <strong>(B)</strong> ${jogadaAtual.getIdCarta().getAltern_B()}
                        </div>
                        <div style="margin-top: 5%">
                            <strong>(C)</strong> ${jogadaAtual.getIdCarta().getAltern_C()}
                        </div>
                        <div style="margin-top: 5%;">
                            <strong>(D)</strong> ${jogadaAtual.getIdCarta().getAltern_D()}
                        </div>
<%--                        <div style="background-color: #262630" align="center">--%>
<%--                            <a style="font-weight: bolder; color: hotpink; font-style: normal"--%>
<%--                               href="/">--%>
<%--                                OK--%>
<%--                            </a>--%>
<%--                        </div>--%>
            <div style="background-color: #262630">
                <button style="font-weight: bolder; color: hotpink; font-style: normal" onclick="fecharAba()">
                    OK
                </button>
            </div>
                    </div>
                    </c:when>
                    <c:otherwise>
                        <a href="/jogadas/jogada.action?id=${jogadaAtual.getId()}&&oPtujCRT=1">
                            <div style="margin-top: 5%;" >
                                <strong>(A)</strong> ${jogadaAtual.getIdCarta().getAltern_A()}
                            </div>
                        </a>

                        <a href="/jogadas/jogada.action?id=${jogadaAtual.getId()}&&oPtujCRT=2">
                            <div style="margin-top: 5%;" >
                                <strong>(B)</strong> ${jogadaAtual.getIdCarta().getAltern_B()}
                            </div>
                        </a>

                        <a href="/jogadas/jogada.action?id=${jogadaAtual.getId()}&&oPtujCRT=3">
                            <div style="margin-top: 5%" >
                                <strong>(C)</strong> ${jogadaAtual.getIdCarta().getAltern_C()}
                            </div>
                        </a>

                        <a  href="/jogadas/jogada.action?id=${jogadaAtual.getId()}&&oPtujCRT=4">
                            <div style="margin-top: 5%;">
                                <strong>(D)</strong> ${jogadaAtual.getIdCarta().getAltern_D()}
                            </div>
                        </a>

                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                            <div style="margin-top: 5%;">
                                <strong>(A)</strong> ${carta.getAltern_A()}
                            </div>
                            <div style="margin-top: 5%;">
                                <strong>(B)</strong> ${carta.getAltern_B()}
                            </div>
                            <div style="margin-top: 5%">
                                <strong>(C)</strong> ${carta.getAltern_C()}
                            </div>
                            <div style="margin-top: 5%;">
                                <strong>(D)</strong> ${carta.getAltern_D()}
                            </div>
                            <div style="background-color: #262630">
                                <a style="font-weight: bolder; color: hotpink; font-style: normal"
                                   href="/">
                                    OK
                                </a>
                            </div>
                        </div>
                </c:otherwise>
            </c:choose>
    </div>
</body>
<script>
    function fecharAba(){
        window.close()
    }
</script>