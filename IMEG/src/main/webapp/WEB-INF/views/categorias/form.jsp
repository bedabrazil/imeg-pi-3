<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="categorias" method="post">
    <c:if test="${categoria != null}">
    <input type="hidden" name="id_categoria" value="${categoria.getId()}">
    </c:if>
    <fieldset class="well">
        <div class="col-lg-12 <c:if test="${sessionScope.error}">errors</c:if>"><c:if test="${sessionScope.error}"> ${msg}</c:if></div>
        <div class="col-lg-6 form-space">
            <label for="">Nome da Categoria</label>
            <input class="form-control" type="text" value="<c:if test="${categoria != null }">${categoria.getNome()}</c:if>" id="nome_categoria" name="nome_categoria"/>
        </div>
        <div class="col-lg-12 form-space">
            <label for="ativo_categoria">Ativo</label>
            <input type="checkbox" id="ativo_categoria" class="" <c:if test="${categoria.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
        </div>
        <div class="col-lg-12 form-space">
                        <button class="btn btn-button" type="submit" id="commit-categoria"><c:choose><c:when test="${categoria != null}">Alterar</c:when><c:otherwise>Salvar</c:otherwise></c:choose></button>
        </div>
    </fieldset>
</form>