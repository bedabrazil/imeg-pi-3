<%-- 
    Document   : header
    Created on : Apr 30, 2016, 9:42:57 PM
    Author     : marcio.soares <marcio@mail.com>
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title><c:choose><c:when test="${not empty usuario }">${usuario.unidade.nome}</c:when><c:otherwise> Distribuidora IMEG Cosméticos</c:otherwise></c:choose></title>
                <meta charset="utf-8"/>
                <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
                    <link rel='shortcut icon' type='image/x-icon' href="<c:url value='/favicon.ico'/>" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="apple-touch-icon" href="<c:url value='/apple-touch-icon.png'/>"/>
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>"/>
        <script src="<c:url value='/resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js'/>"></script>           
    </head>
    <body>
        <div class="container">
            <div class="row">     
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-navbar-collapse" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand logo" href="<c:url value="/"/>"><img src="<c:url value='/resources/img/logo.png'></c:url>" alt=""/></a>
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-navbar-collapse">
                            <c:if test="${sessionScope.usuario != null}">
                                <ul class="nav navbar-nav">
                                    <li class="">
                                        <a href="<c:url value="/dashboard"/>"><em class="glyphicon glyphicon-th-large"></em>&nbsp;Painel <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li>
                                        <jsp:include page="menu.jsp" />
                                    </li>
                                    <li>
                                        <div class="dropdown navbar-form navbar-right">
                                            <a href="<c:url value="/vendas"/>" class="btn btn-default sale"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;<span class="badge">${carrinho.size()}</span> </a>
                                        </div>
                                    </li>
                                </ul>
                            </c:if>
                            <c:choose>
                                <c:when test="${sessionScope.usuario == null}">
                                    <form class="navbar-form navbar-right" action="<c:url value="/login"/>" method="post" role="form" enctype="application/x-www-form-urlencoded">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Email" name="email_funcionario">
                                            <input type="password" class="form-control" placeholder="Senha" name="senha_funcionario">
                                        </div>
                                        <button type="submit" class="btn btn-default">Entrar</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <div class="dropdown navbar-form navbar-right">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa fa-bars" aria-hidden="true"></i>
                                            &nbsp;Menu
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="#dropdownMenu1">
                                            <li class="dropdown-header">&nbsp;<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Usuário</li>
                                            <li><a href="<c:url value="/meusdados/editar"/>"><span class="glyphicon glyphicon-edit"></span>&nbsp;Meus dados</a></li>
                                            <!--<li><a href="javascript:void(0)">Configurações</a></li>-->
                                            <li role="separator" class="divider"></li>
                                            <li><a href="<c:url value="/logout"/>"><em class="glyphicon glyphicon-off"></em>&nbsp;Sair</a></li>
                                        </ul>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>


                    <div class="page-header">
                        <c:if test="${not empty usuario}">
                            <p>Unidade: <strong>${usuario.unidade.nome}</strong> / ${usuario.unidade.estado.nome} <c:if test="${usuario.unidade.matriz}"> - Matriz</c:if></p>
                            <p>Usuário: <strong>${usuario.nome}</strong></p>
                        </c:if>
                    </div>
