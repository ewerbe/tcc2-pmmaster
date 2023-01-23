<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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

<div style="margin-top: 5%;">
    <form action="/login/logar.action" method="post">
        <div align="center">
            <div style="width: 40%; background-color: #262630; padding: 6%;">
                <div style="margin-top: 4%;">
                    <label for="login" style="color: hotpink;">login</label>>
                    <input type="text" id="login" name="login">
                </div>
               <div style="margin-top: 4%;">
                   <label for="senha" style="color: hotpink;">senha</label>
                   <input type="password" id="senha" name="senha">
               </div>
                <div align="center" style="margin-top: 5%;">
                    <button type="submit" class="btn-lg btn-outline-light"
                            style="font-weight: bolder; color: hotpink;">
                        <span style="white-space: nowrap;">logar</span>
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<%@ include file="footer.jspf" %>
