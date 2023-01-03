<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>

    <div style="position: relative;">
<%--        <img src="/images/carta-teste.png" alt="carta do jogo pmmaster híbrido" width="1920px" height="1080px" style="width: 100%; height: auto;">--%>
<%--        <div align="center" style="width: 250px; height: 350px; position: absolute;">--%>
            <img src="/images/carta-teste.png" alt="carta do jogo pmmaster híbrido" width="100%;">
                <h3 style="position: absolute; color: black; top: 20%; margin-left: 41%;">
                    ${carta.getAreaConhecimento().getDescricao()}
<%--                      INTEGRAÇÃO--%>
                </h3>
                <div style="position: absolute; top: 30%; left: 35%; width: 380px;">
                    <div style="margin-top: 2%;" href="/carta-resposta.action...">
                        <strong>Pergunta:</strong> ${carta.getPergunta()}
                    </div>
                    <div style="margin-top: 3%;" href="/carta-resposta.action...">
                        <strong>(A)</strong> ${carta.getAltern_A()}
                    </div>
                    <div style="margin-top: 3%;" href="/carta-resposta.action...">
                        <strong>(B)</strong> ${carta.getAltern_B()}
                    </div>
                    <div style="margin-top: 3%" href="/carta-resposta.action...">
                        <strong>(C)</strong> ${carta.getAltern_C()}
                    </div>
                    <div style="margin-top: 3%;" href="/carta-resposta.action...">
                        <strong>(D)</strong> ${carta.getAltern_D()}
                    </div>

                </div>
<%--            <div style="top: 40%; left: 30%;">${carta.getPergunta()}</div>--%>
<%--            <div style="position: absolute;">--%>
<%--                <p>${carta.getAltern_A()}</p>--%>
<%--            </div>--%>
<%--            <div style="position: absolute;">--%>
<%--                <p>${carta.getAltern_B()}</p>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>


<%--<div class="card bg-dark text-white">--%>
<%--    <img src="/images/carta-teste.png" class="card-img" alt="fundo para carta do jogo pmmaster híbrido">--%>
<%--    <div class="card-img-overlay">--%>
<%--        <h5 class="card-title">Card title</h5>--%>
<%--        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>--%>
<%--        <p class="card-text">Last updated 3 mins ago</p>--%>
<%--    </div>--%>
<%--</div>--%>

    <%--<div align="center" style="margin-top: 3%;">--%>
<%--    <h1 style="color: grey; font-weight: bold;--%>
<%--                font-size: 460%;">cartas</h1>--%>
<%--</div>--%>
</body>