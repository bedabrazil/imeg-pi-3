<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="cargos" method="post">
    <c:if test="${cargo != null}">
    <input type="hidden" name="id_cargo" value="${cargo.getId()}">
    </c:if>
    <fieldset class="well">
        <div id="warning" class="col-lg-12 <c:choose><c:when test="${sessionScope.error}">alert alert-danger</c:when><c:when test="${sessionScope.success}">alert alert-success</c:when></c:choose>"><c:choose><c:when test="${sessionScope.error}">${msg_error}</c:when><c:when test="${sessionScope.success}">${msg_success}</c:when></c:choose></div>
        <div class="col-lg-6 form-space">
            <label for="">Nome do Cargo</label>
            <input class="form-control" type="text" value="<c:if test="${cargo != null }">${cargo.getNome()}</c:if>" id="nome_cargo" name="nome_cargo"/>
        </div>
        <div class="col-lg-12 form-space">
            <label for="ativo_cargo">Ativo</label>
            <input type="checkbox" id="ativo_cargo" class="" <c:if test="${cargo.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
        </div>
        <div class="col-lg-12 form-space">
                        <button class="btn btn-button" type="submit" id="commit-cargo"><c:choose><c:when test="${cargo != null}">Alterar</c:when><c:otherwise>Salvar</c:otherwise></c:choose></button>
        </div>
    </fieldset>
</form>