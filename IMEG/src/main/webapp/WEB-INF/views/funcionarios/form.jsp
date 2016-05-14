<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${funcionario == null}"><c:set var="action" value="novofuncionario"/></c:when>
    <c:otherwise><c:set var="action" value="alterarfuncionario?id=${funcionario.id}"/></c:otherwise>
</c:choose>    
<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>   

<form action="${action}" method="post">
    <fieldset class="well">
        <div class="col-lg-12">
                <p></p>
                <ul>
                    <c:forEach items="${mensagens}" var="msg">
                        <li>${msg}</li>
                        </c:forEach>
                </ul>
            </div>        
        <div class="col-lg-6 form-space">
            <label for="">Nome do Funcionário</label>
            <input class="form-control" type="text" id="nome-funcionario" name="nome-funcionario"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Cargos </label>
            <select name="cargo-id" class="form-control" >
                <option value="">Selecione um Cargo</option>
                <c:forEach items="${cargos}">
                    <option value="${cargo.id}">${cargo.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Unidades </label>
            <select name="unidade-id" class="form-control" >
                <option value="">Selecione um Unidade</option>
                <c:forEach items="${unidades}">
                <option value="${unidade.id}">${unidade.nome}</option>
                </c:forEach>
            </select>
        </div>    
        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-funcionario"/>
            <a href="<c:url value="funcionarios"></c:url>" class="btn btn-default">Voltar</a>
            <button class="btn btn-default" type="submit" id="commit-cargo">
                <c:choose>
                    <c:when test="${funcionario != null}">Alterar</c:when>
                    <c:otherwise>Salvar</c:otherwise>
                </c:choose>
            </button>
        </div>
    </fieldset>
</form>