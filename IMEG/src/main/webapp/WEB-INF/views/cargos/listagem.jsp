<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${cargos.size() > 0}">
<div class="col-lg-12">
    <h3>Cargos</h3>
    <a href="<c:url value="novocargo"></c:url>">Novo Cargo</a>
    <br>
    <div id="warning" class="col-lg-12 <c:choose><c:when test="${sessionScope.success}">alert alert-success</c:when></c:choose>"><c:choose><c:when test="${sessionScope.success}">${msg_success}</c:when></c:choose></div>
</div>
<div class="col-lg-12 table-reposnsive">
    <table class="table table-hover">
        <thead>
            <th></th>
            <th>Nome</th>
            <th>Permissão</th>
            <th>Ações</th>            
        </thead>
        <tbody>
        <c:forEach items="${cargos}" var="cargo">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${cargo.isStatus()}">
                            <em data-toggle="tooltip" data-placement="top" title="Ativado" class="active-elem-table glyphicon glyphicon glyphicon-ok-circle"></em>
                        </c:when>
                        <c:otherwise>
                            <em data-toggle="tooltip" data-placement="top" title="Desativado" class="active-elem-table glyphicon glyphicon-remove-circle color-elem-table-deactive"></em> 
                        </c:otherwise></c:choose></td>
                <td>${cargo.getNome()}</td>
                <td>${cargo.getAcesso().getNome()}</td>
                <td><a href="<c:url value="alterarcargo?id=${cargo.getId()}"></c:url>">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>