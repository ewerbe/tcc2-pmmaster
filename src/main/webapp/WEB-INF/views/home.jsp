<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
<div align="center">
<%--    <h1 style="color: grey; font-weight: bold;--%>
<%--                font-size: 460%;">ProjectManagerMaster HÍBRIDO</h1>--%>
    <img src="/images/logo.png" width="100%" alt="logo do jogo">
</div>
<div align="center" style="margin-top: 10%;">
    <form action="/tabuleiros/novo-tabuleiro.action?idUsuario=1" method="post">
        <button type="submit" class="btn-lg btn-dark"
                style="font-weight: bolder; color: hotpink;">
            <span style="white-space: nowrap;">gerar tabuleiro</span>
        </button>
    </form>
</div>
<%@ include file="footer.jspf" %>
