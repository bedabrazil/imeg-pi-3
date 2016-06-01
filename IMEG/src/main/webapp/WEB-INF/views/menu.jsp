<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${usuario.acesso.nome == 'ADMIN' && usuario.unidade.matriz}">
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-product-hunt" aria-hidden="true"></i>
                &nbsp;Produtos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu1">
                <li><a href="<c:url value="/pedidos"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Pedidos</a></li>
                <li><a href="<c:url value="/produtos/novo"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Novo</a></li>
                <li><a href="<c:url value="/produtos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-archive" aria-hidden="true"></i>
                &nbsp;Categorias
                <span class="caret"></span>
            </button>        
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu2">
                <li><a href="<c:url value="/categorias/novo"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Novo</a></li>
                <li><a href="<c:url value="/categorias"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-building" aria-hidden="true"></i>
                &nbsp;Unidades
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu3">
                <li><a href="<c:url value="/unidades/novo"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Novo</a></li>    
                <li><a href="<c:url value="/unidades"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>    
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-users" aria-hidden="true"></i>
                &nbsp;Funcionários
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu4">
                <li><a href="<c:url value="/funcionarios/novo"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        </i>&nbsp;Novo</a></li>
                <li><a href="<c:url value="/funcionarios"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        </i>&nbsp;Listar</a></li>                                                        
            </ul>                                            
        </div>    
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-cog" aria-hidden="true"></i>
                &nbsp;Cargos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu5">
                <li><a href="<c:url value="/cargos/novo"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        </i>&nbsp;Novo</a></li>
                <li><a href="<c:url value="/cargos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        </i>&nbsp;Listar</a></li>                                                        
            </ul>                                            
        </div>
    </c:when>
    <c:when test="${usuario.acesso.nome == 'GERENTE' && usuario.unidade.matriz}">
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-product-hunt" aria-hidden="true"></i>
                &nbsp;Produtos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu1">
                <li><a href="<c:url value="/pedidos"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Pedidos</a></li>
                                <li><a href="<c:url value="/produtos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-archive" aria-hidden="true"></i>
                &nbsp;Categorias
                <span class="caret"></span>
            </button>        
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu2">
                
                <li><a href="<c:url value="/categorias"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-building" aria-hidden="true"></i>
                &nbsp;Unidades
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu3">
                   
                <li><a href="<c:url value="/unidades"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Listar</a></li>    
            </ul>
        </div>
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-users" aria-hidden="true"></i>
                &nbsp;Funcionários
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu4">
                
                <li><a href="<c:url value="/funcionarios"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        </i>&nbsp;Listar</a></li>                                                        
            </ul>                                            
        </div>    
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-cog" aria-hidden="true"></i>
                &nbsp;Cargos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu5">
                
                <li><a href="<c:url value="/cargos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        </i>&nbsp;Listar</a></li>                                                        
            </ul>                                            
        </div>
    </c:when>
    <c:when test="${usuario.acesso.nome == 'GERENTE'}">
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-product-hunt" aria-hidden="true"></i>
                &nbsp;Produtos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu1">
                
                <li><a href="<c:url value="/vender"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Vender</a></li>

                <li><a href="<c:url value="/vendidos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Vendidos</a></li>                        

            </ul>
        </div>
    </c:when>    
    <c:when test="${usuario.acesso.nome == 'VENDEDOR'}">
        <div class="dropdown navbar-form navbar-left">
            <button class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-product-hunt" aria-hidden="true"></i>
                &nbsp;Produtos
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="#dropdownMenu1">
                
                <li><a href="<c:url value="/vender"/>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
                        &nbsp;Vender</a></li>

                <li><a href="<c:url value="/vendidos"/>"><i class="fa fa-list-alt" aria-hidden="true"></i>
                        &nbsp;Vendidos</a></li>                        

            </ul>
        </div>        
    </c:when>
</c:choose>