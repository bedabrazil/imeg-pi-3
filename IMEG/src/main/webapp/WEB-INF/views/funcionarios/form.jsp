<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${funcionario == null}"><c:set var="action" value="/funcionarios/novo"/></c:when>
    <c:otherwise><c:set var="action" value="/funcionarios/editar?id=${funcionario.id}"/></c:otherwise>
</c:choose>    
<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>   

<form action="<c:url value="${action}"/>" method="post">
    <c:if test="${funcionario != null}">
        <input type="hidden" name="id_funcionario" value="${funcionario.id}">
    </c:if>
    <fieldset class="well">
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
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user-plus" aria-hidden="true"></i></span>
                <input class="form-control" placeholder="Nome" type="text" value="<c:if test="${funcionario != null }">${funcionario.nome}</c:if>" id="nome_funcionario" name="nome_funcionario"/>
            </div>
        </div>
        <div class="col-lg-6 form-space">
                <label for="">Email</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
                    <input class="form-control" placeholder="Email" type="text" value="<c:if test="${funcionario != null }">${funcionario.email}</c:if>" id="nome_funcionario" name="email_funcionario"/>
                </div>
        </div>
        <div class="col-lg-6 form-space">
                <label for="">Senha</label>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>                
                  <input class="form-control" placeholder="Senha" type="password" value="<c:if test="${funcionario != null }">${funcionario.senha}</c:if>" id="senha_funcionario" name="senha_funcionario"/>
                </div>
        </div>
            <div class="col-lg-6 form-space">
                <label for="">Confirmar Senha</label>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                  <input class="form-control" placeholder="Confirmar Senha" type="password" value="<c:if test="${funcionario != null }">${funcionario.senha}</c:if>" id="confirmar_senha_funcionario" name="confirmar_senha_funcionario"/>
                </div>
            </div>
        <div class="col-lg-3 form-space">
                <label for="">Cargos </label>
                <select name="cargo_id" class="form-control" >
                <c:choose>
                    <c:when test="${funcionario == null}">
                        <option value="0">Selecione um Cargo</option>
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value="${funcionario.cargo.id}"/>" <c:if test="${funcionario != null}">${cargo.nome}</c:if>><c:out value="${funcionario.cargo.nome}"/></option>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${cargos}" var="cargo">
                    <option value="${cargo.id}">${cargo.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Unidades </label>
            <select name="unidade_id" class="form-control" >
                <c:choose>
                    <c:when test="${funcionario == null}">
                        <option value="0">Selecione uma Unidade</option>
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value="${funcionario.unidade.id}"/>" <c:if test="${funcionario != null}">${funcionario.unidade.nome}</c:if>><c:out value="${funcionario.unidade.nome}"/></option>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${unidades}" var="unidade">
                    <option value="${unidade.id}">${unidade.nome}</option>
                </c:forEach>
            </select>
        </div>    
        <div class="col-lg-4 form-space">
            <label for="acesso_id">Permissão</label>
            <select name="acesso_id" class="form-control">
                <c:choose>
                    <c:when test="${funcionario == null}">
                        <option value="0">Selecione um tipo de permissão</option>
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value="${funcionario.acesso.id}"/>" <c:if test="${funcionario != null}">${funcionario.acesso.nome}</c:if>><c:out value="${funcionario.acesso.nome}"/></option>
                    </c:otherwise>
                </c:choose>                
                <c:forEach items="${acessos}" var="acesso">
                    <option value="${acesso.id}" <c:if test="${acesso.id == cargo.acesso.id}">selected="selected"</c:if> >${acesso.nome}</option>
                </c:forEach>
            </select>
        </div>  
        <div class="col-lg-12 form-space">
            <label for="ativo_funcionario">Ativo</label>
            <input type="checkbox" id="ativo_categoria" class="" <c:if test="${funcionario.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
        </div>
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/funcionarios"></c:url>" class="btn btn-default">Voltar</a>
            <button class="btn btn-default" type="submit" id="commit-funcionario">
            <c:choose>
                <c:when test="${funcionario != null}">Alterar</c:when>
                <c:otherwise>Salvar</c:otherwise>
            </c:choose>
            </button>
        </div>
    </fieldset>
</form>
