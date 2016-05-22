<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>   
<form action="<c:url value="/meusdados/editar"/>" method="post">
    <c:if test="${usuario != null}">
        <input type="hidden" name="id_usuario" value="${usuario.id}">
    </c:if>
        
    <fieldset class="well">
        <div class="col-lg-12">
            <h3>Alterar dados do Usuário</h3>
            <br>
        </div>

        <div id="warning" class="col-lg-12 ${alert}">
            <c:if test="${not empty mensagens}">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>            

                <p>Existem <strong>${mensagens.size()}</strong> erro(s) a ser(em) corrigidos.</p>

            </c:if>
            <div class="col-lg-12">
                <p></p>
                <ul>
                    <c:forEach items="${mensagens}" var="msg">
                        <li>${msg}</li>
                        </c:forEach>
                </ul>
            </div>
        </div>        
        <div class="col-lg-6 form-space">
            <label for="">Nome</label>
            <input class="form-control" type="text" value="<c:if test="${usuario != null }">${usuario.nome}</c:if>" id="nome_usuario" name="nome_usuario"/>
        </div>
        <div class="col-lg-6 form-space">
                <label for="">Email</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                    <input class="form-control" type="text" disabled="disabled" value="<c:if test="${usuario != null }">${usuario.email}</c:if>" id="nome_usuario" name="email_usuario"/>
                </div>
        </div>
        <div class="col-lg-4 form-space">
                <label for="">Cargos </label>
                <input type="text" disabled="disabled" class="form-control" value="${usuario.cargo.nome}"/>
        </div>
        <div class="col-lg-4 form-space">
            <label for="">Unidades </label>
            <input type="text" disabled="disabled" value="${usuario.unidade.nome}" class="form-control"/>
        </div>    
        
        <div class="col-lg-4">
            <label for="acesso_id">Tipo de Permissão</label>
            <input type="text" disabled="disabled" value=" ${usuario.acesso.nome}" class="form-control"/>
        </div>  
                
<!--        <div class="col-lg-4 form-space">            
                    <label for="">Senha Antiga</label>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                    <input class="form-control" type="password" value="" id="senha_usuario" name="senha_antiga_usuario"/>
                </div>
        </div>        -->
        <div class="col-lg-4 form-space">
                <label for="">Nova Senha</label>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>                
                  <input class="form-control" type="password" value="" id="senha_usuario" name="senha_nova_usuario"/>
                </div>
        </div>
        <div class="col-lg-4 form-space">
                <label for="">Confirmar Nova Senha</label>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                  <input class="form-control" type="password" value="" id="confirmar_senha_usuario" name="confirmar_nova_senha_usuario"/>
                </div>
        </div>
        
<!--        <div class="col-lg-12 form-space">
            <label for="ativo_usuario">Ativo</label>
            <input type="checkbox" id="ativo_categoria" class="" <c:if test="${usuario.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
        </div>-->
        <div class="col-lg-12"><br><br></div>
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/"></c:url>" class="btn btn-default">Voltar</a>
            <button class="btn btn-default" type="submit" id="commit-usuario">Alterar</button>
        </div>
    </fieldset>
</form>
