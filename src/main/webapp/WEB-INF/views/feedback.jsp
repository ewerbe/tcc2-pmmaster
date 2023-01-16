<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="background-color: darkgrey">

<div style="margin-top: 20%; padding-left: 10%; padding-right: 10%;">

    <c:choose>
        <c:when test="${resultado}">
            <div>
                <h3 style="color: black; top: 20%; margin-left: 32%;">
                        Resposta CERTA!
                </h3>
                <p>Pegue sua ficha de pontuação da Área de Conhecimento<br>
                    e dê OK para o(a) próximo(a) jogador(a),
                    ou finalize a partida.
                </p>>
                <div style="background-color: #262630">
                    <a style="font-weight: bolder; color: hotpink; font-style: normal"
                     href="/jogadas/fechar-jogada.action?id=${jogadaAtual.getId()}">
                     OK
                    </a>
                </div>
                <div style="background-color: #262630; margin-top: 10%;">
                    <a style="font-weight: bolder; color: hotpink; font-style: normal"
                       href="/jogadas/finalizar-partida.action?id=${jogadaAtual.getId()}">
                        FINALIZAR PARTIDA
                    </a>
                </div>
            </div>
        </c:when>

        <c:otherwise>
            <div align="center">
                <h3 style="color: hotpink;">
                    Resposta ERRADA!
                </h3>
                <h4>
                    <strong>pergunta:</strong>
                    ${jogadaAtual.getIdCarta().getPergunta()}
                </h4>
                <h5>
                    <strong>alternativa correta:</strong>
                    <c:if test="${fn:contains(jogadaAtual.getIdCarta().getAltern_correta(), 'A')}">
                            ${jogadaAtual.getIdCarta().getAltern_A()}
                    </c:if>
                    <c:if test="${fn:contains(jogadaAtual.getIdCarta().getAltern_correta(), 'B')}">
                        ${jogadaAtual.getIdCarta().getAltern_B()}
                    </c:if>
                    <c:if test="${fn:contains(jogadaAtual.getIdCarta().getAltern_correta(), 'C')}">
                        ${jogadaAtual.getIdCarta().getAltern_C()}
                    </c:if>

                    <c:if test="${fn:contains(jogadaAtual.getIdCarta().getAltern_correta(), 'D')}">
                        ${jogadaAtual.getIdCarta().getAltern_D()}
                    </c:if>
                </h5>

                <p>Dê OK para o(a) próximo(a) jogador(a) ou finalize a partida.
                </p>
                <div style="background-color: #262630" align="center">
                    <a style="font-weight: bolder; color: hotpink; font-style: normal"
                       href="/jogadas/fechar-jogada.action?id=${jogadaAtual.getId()}">
                        OK
                    </a>
                </div>
                <div style="background-color: #262630; margin-top: 10%;" align="center">
                    <a style="font-weight: bolder; color: hotpink; font-style: normal;"
                       href="/jogadas/finalizar-partida.action?id=${jogadaAtual.getId()}">
                        FINALIZAR PARTIDA
                    </a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>

</div>

</body>