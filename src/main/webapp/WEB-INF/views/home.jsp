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
    <img src="/images/logo.png" width="100%" alt="logo do jogo">
</div>
<div align="center">
    <div style="width: 70%; background-color: #262630;">
        <h2 style="color: cornsilk;">Jogo educacional Híbrido
            desenvolvido para apoiar
            no ensino da disciplina
            de Gerência de Projetos de Software
            para estudantes da área de computação
            de nível superior</h2>
    </div>
</div>>
<div align="center">
    <div style="width: 80%; background-color: #262630;">
        <h1 style="color: hotpink;">O que é?</h1>>
        <div align="left" style="padding-right: 10%; padding-left: 10%; padding-bottom: 2%">
            <h4 style="color: cornsilk;">
                Trata-se de uma versão Híbrida do jogo analógico de tabuleiro
                PM Master (GQS, 2012) com as cartas de perguntas e respostas
                desenvolvidas em uma aplicação web digital.
                As perguntas são atualizadas conforme as versões
                mais recentes do guia PMBOK, referência do jogo.
            </h4>
        </div>

    </div>
</div>>

<div align="center">
    <div style="width: 80%; background-color: #262630;">
        <h1 style="color: hotpink;">Como preparar o jogo?</h1>>
        <div align="left" style="padding-left: 10%; padding-right: 10%; padding-bottom: 2%">
            <h4 style="color: cornsilk;">
                - O(A) professor(a) baixa, (botão "gerar tabuleiro" ao final desta página), quantos arquivos de tabuleiros precisar
                (um tabuleiro a cada 3 alunos) e imprime-os em folha de papel-cartão tamanho A2;<br><br>

                - Cada tabuleiro é único, portanto, baixe quantos arquivos forem necessários,
                pois apenas um arquivo impresso várias vezes, não funcionará conforme o esperado;<br><br>

                - Baixe as fichas de pontuação -botão "baixar fichas de pontuação" ao fim desta página - (poderá ser apenas um arquivo, impresso quantas vezes forem necessárias) e as imprima em papel-cartão em tamanho A4.<br><br>
                - Recorte as fichas de pontuação;<br><br>

                - Para marcar as posições dos jogadores no tabuleiro, são necessários peões de cores
                distintas, além de um dado para cada tabuleiro.<br><br>

                - Serão necessários no mínimo dois smartphones para jogar, mas de preferência,
                que cada jogador tenha o seu.<br><br>
                - Obs.: Faça impressões coloridas, tanto dos tabuleiros quanto das fichas de pontuação.
            </h4>
        </div>

    </div>
</div>

<div align="center" style="margin-top: 3%;">
    <div style="width: 80%; background-color: #262630;">
        <h1 style="color: hotpink;">Como jogar?</h1>>
        <div align="left" style="padding-left: 10%; padding-right: 10%;">
            <h4 style="color: cornsilk;">
                - As fichas de pontuação são dispostas agrupadas em frente ao tabuleiro;<br><br>
                - os jogadores posicionam seus peões no início da primeira linha do tabuleiro;<br><br>
                - Após decidirem a ordem dos jogadores: o primeiro joga o dado, movimenta
                o seu peão até a casa correspondente ao número, aponta seu smartphone para o QRCode
                e escolhe a Área de Conhecimento correspondente ao seu peão no tabuleiro;<br><br>
                - Ele lê em voz alta a carta gerada, a responde e, caso acerte a alternativa, ganha uma ficha
                de pontuação, caso erre, não ganha nada. Então, será a vez do próximo jogador.<br><br>
                - Se um outro jogador quiser ter acesso à carta que está aberta para o jogador atual,
                (o que é fortemente recomendado, para que todos revisem juntos os conteúdos do jogo),
                bastará apontar seu smartphone para o QRCode do tabuleiro, porém, a carta não estará liberada
                para a sua resposta, visto que estará aberta e liberada apenas para o jogador atual;<br><br>
                - Caso o jogador tenha fichas repetidas, poderá desafiar um jogador que possua
                alguma ficha inédita:<br><br>
                - então ele seguirá o jogo normalmente, dado, área de conhecimento, etc. Mas se acertar a resposta
                ganhará a ficha determinada, caso erre, o desafiado poderá escolher a ficha que desejar
                do desafiante.<br><br><br>
                - Ganha o jogo quem tiver ao menos uma ficha de todas as Áreas de Conhecimento de Gerência de Projetos,
                ou quem tiver o maior número de fichas não repetidas, caso decidam encerrar a partida.<br><br>
            </h4>
        </div>>

    </div>
</div>>

<div align="center" style="margin-top: 10%;">
    <form action="/tabuleiros/novo-tabuleiro.action?idUsuario=1" method="post">
        <button type="submit" class="btn-lg btn-dark"
                style="font-weight: bolder; color: hotpink;">
            <span style="white-space: nowrap;">gerar tabuleiro</span>
        </button>
    </form>
</div>
<div align="center" style="margin-top: 10%;">
    <form action="/fichas.action" method="get">
        <button type="submit" class="btn-lg btn-dark"
                style="font-weight: bolder; color: hotpink;">
            <span style="white-space: nowrap;">baixar Fichas de Pontuação</span>
        </button>
    </form>
</div>
<%@ include file="footer.jspf" %>
