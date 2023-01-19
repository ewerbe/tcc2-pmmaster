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
<div align="center" style="margin-top: 3%;">
    <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">selecione a Área de Conhecimento</h1>
    <div style="background-color: #262630; margin-top: 10%; height: 10%; padding-top: 10%;" align="center">
        <a style="font-weight: bolder; color: hotpink; font-style: normal; height: 10%; font-size: 24px;"
           href="/jogadas/finalizar-partida.action?id=${idTabuleiro}">
            FINALIZAR PARTIDA
        </a>
    </div>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>INTEGRAÇÃO</h3>
        <a href="/cartas/jogada.action?JklrFqaC=1&&kTbrnMSw=${idTabuleiro}">
            <div  style="width: 40%; height: 10%; background-color: #c1bc24;"></div>
        </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>ESCOPO</h3>
    <a href="/cartas/jogada.action?JklrFqaC=2&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #F7841A;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>TEMPO</h3>
    <a href="/cartas/jogada.action?JklrFqaC=3&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #455FA3;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>CUSTOS</h3>
    <a href="/cartas/jogada.action?JklrFqaC=4&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #5B228C;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>QUALIDADE</h3>
    <a href="/cartas/jogada.action?JklrFqaC=5&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #F7DA33;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>RECURSOS</h3>
    <a href="/cartas/jogada.action?JklrFqaC=6&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #F73B3F;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>COMUNICAÇÃO</h3>
    <a href="/cartas/jogada.action?JklrFqaC=7&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #84ACA6;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>RISCOS</h3>
    <a href="/cartas/jogada.action?JklrFqaC=8&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #E08D66;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>AQUISIÇÕES</h3>
    <a href="/cartas/jogada.action?JklrFqaC=9&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #882920;"></div>
    </a>
</div>

<div align="center" style="margin-top: 10%; background-color: lightgray; padding-top: 3%; padding-bottom: 3%">
    <h3>STAKEHOLDERS</h3>
    <a href="/cartas/jogada.action?JklrFqaC=10&&kTbrnMSw=${idTabuleiro}">
        <div style="width: 40%; height: 10%; background-color: #737373;"></div>
    </a>
</div>

<%@ include file="footer.jspf" %>
