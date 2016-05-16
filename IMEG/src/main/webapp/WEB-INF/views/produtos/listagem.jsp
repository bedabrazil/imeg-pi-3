<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty produtos}">
    <c:choose>
        <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
    </c:choose>
<div class="col-lg-12">
    <h3>Produtos</h3>
    <a href="<c:url value="/produtos/novo"></c:url>">Novo Produto no Catálogo</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; <a href="<c:url value="/produtos/venda"></c:url>">Registrar venda de Produtos</a>
    <br>
    <div id="warning" class="col-lg-12 ${alert}">
        <c:if test="${sessionScope.success}">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </c:if>
        ${mensagem}
    </div>
</div>
<div class="col-lg-12 table-reposnsive">
    <table class="table table-hover">
        <thead>
            <th></th>
            <th>Nome</th>
            <th>Quantidade Mínima</th>
            <th>Quantidade Máxima</th>
            <th></th>
            <th>Ações</th>
            <th></th>
        </thead>
        <tbody>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${produto.isStatus()}">
                            <em data-toggle="tooltip" data-placement="top" title="Ativado" class="active-elem-table glyphicon glyphicon glyphicon-ok-circle"></em>
                        </c:when>
                        <c:otherwise>
                            <em data-toggle="tooltip" data-placement="top" title="Desativado" class="active-elem-table glyphicon glyphicon-remove-circle color-elem-table-deactive"></em> 
                        </c:otherwise></c:choose></td>
                <td>${produto.nome}</td>
                <td>${produto.qtdeMin}</td>
                <td>${produto.qtdeMax}</td>
                <td><a href="<c:url value="/produtos/editar?id=${produto.id}"></c:url>">Editar</a></td>
                <td><a href="<c:url value="/produtos/inserir?id=${produto.id}"></c:url>">Inserir Produto</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>