<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${cargos.size() > 0}">
<div class="col-lg-12 table-reposnsive">
    <table class="table table-hover">
        <thead>
            <th></th>
            <th>Nome</th>
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
                <td><a href="<c:url value="?id=${cargo.getId()}"></c:url>">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>