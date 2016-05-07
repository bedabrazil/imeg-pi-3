<%-- 
    Document   : header
    Created on : Apr 30, 2016, 9:42:57 PM
    Author     : marcio.soares <marcio@mail.com>
--%>

<!DOCTYPE html>
    <html>
        <head>
            <title>Distribuidora IMEG Cosméticos</title>
            <meta charset="utf-8"/>
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
            <link rel='shortcut icon' type='image/x-icon' href='favicon.ico' />
            <meta name="viewport" content="width=device-width, initial-scale=1"/>
            <link rel="apple-touch-icon" href="apple-touch-icon.png"/>
            <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
            <link rel="stylesheet" href="resources/css/main.css"/>
            <script src="resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>           
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
                          <a class="navbar-brand logo" href="home"><img src="resources/img/logo.png" alt=""/></a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-navbar-collapse">
                          <ul class="nav navbar-nav">
                            <li class=""><a href="#">Relatórios <span class="sr-only">(current)</span></a></li>
                            <li class="dropdown">
                              <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
                              <ul class="dropdown-menu">
                                <li><a href="categorias">Categorias</a></li>
                                <li><a href="unidades">Unidades</a></li>
                                <li><a href="produtos">Produtos</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="funcionarios">Funcionários</a></li>
                                <li><a href="cargos">Cargos</a></li>
                                <li role="separator" class="divider"></li>
                              </ul>
                            </li>
                          </ul>
                          <form class="navbar-form navbar-right" action="login" method="post" role="form">
                            <div class="form-group">
                              <input type="text" class="form-control" placeholder="Email">
                              <input type="password" class="form-control" placeholder="Senha">
                            </div>

                            <button type="submit" class="btn btn-default">Entrar</button>
                          </form>                              
                          </ul>
                        </div><!-- /.navbar-collapse -->
                      </div><!-- /.container-fluid -->
                    </nav>
