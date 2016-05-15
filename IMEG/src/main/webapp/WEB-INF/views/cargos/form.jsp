<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${cargo == null}"><c:set var="action" value="/cargos/novo"/></c:when>
    <c:otherwise><c:set var="action" value="/cargos/editar?id=${cargo.id}"/></c:otherwise>
</c:choose>    
<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>    


<form action="<c:url value="${action}"/>" method="post">
    <c:if test="${cargo != null}">
        <input type="hidden" name="id_cargo" value="${cargo.id}">
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
            <label for="">Nome do Cargo</label>
            <input class="form-control" type="text" value="<c:if test="${cargo != null }">${cargo.nome}</c:if>" id="nome_cargo" name="nome_cargo"/>
            </div>

            <div class="col-lg-12 form-space">
                <label for="ativo_cargo">Ativo</label>
                <input type="checkbox" id="ativo_cargo" class="" <c:if test="${cargo.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
            </div>
            <div class="col-lg-12 form-space">
                <a href="<c:url value="/cargos"></c:url>" class="btn btn-default">Voltar</a>
                <button class="btn btn-default" type="submit" id="commit-cargo">
                <c:choose><c:when test="${cargo != null}">Alterar</c:when>
                    <c:otherwise>Salvar</c:otherwise>
                </c:choose>
            </button>
        </div>
    </fieldset>
</form>