<%-- 
    Document   : header
    Created on : Apr 30, 2016, 9:42:57 PM
    Author     : marcio.soares <marcio@mail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Distribuidora IMEG Cosméticos</title>
            <meta charset="utf-8"/>
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
            <link rel='shortcut icon' type='image/x-icon' href="<c:url value='/favicon.ico'/>" />
            <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
            <link rel="apple-touch-icon" href="<c:url value='/apple-touch-icon.png'/>"/>
            <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
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
                              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                              </button>
                                <a class="navbar-brand logo" href="home"><img src="<c:url value='/resources/images/logo.png'></c:url>" alt=""/></a>
                            </div>
                        </div><!-- /.container-fluid -->
                    </nav> 
