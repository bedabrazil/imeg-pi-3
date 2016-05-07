<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${categorias.size() > 0}">
<div class="col-lg-12 table-reposnsive">
    <table class="table table-hover">
        <thead>
            <th></th>
            <th>Nome</th>
            <th>Editar</th>
        </thead>
        <tbody>
        <c:forEach items="${categorias}" var="categoria">
            <tr>
                <td><em class="active-elem-table glyphicon <c:choose><c:when test="${categoria.isStatus()}">glyphicon glyphicon-ok-circle </c:when><c:otherwise>glyphicon-remove-circle color-elem-table-deactive </c:otherwise></c:choose>"></em></td>
                <td>${categoria.getNome()}</td>
                <td><a href="<c:url value="?id=${categoria.getId()}"></c:url>">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>