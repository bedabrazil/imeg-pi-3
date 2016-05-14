<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty funcionarios}">
    <c:choose>
        <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
    </c:choose>
<div class="col-lg-12">
    <h3>Funcionarios</h3>
    <a href="<c:url value="/funcionarios/novo"></c:url>">Novo Funcionário</a>
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
            <th>Nome</th>
            <th>Cargo</th>
            <th>Unidade</th>
            <th>Email</th>
            <th>Ações</th>
        </thead>
        <tbody>
        <c:forEach items="${funcionarios}" var="funcionario">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${funcionario.isStatus()}">
                            <em data-toggle="tooltip" data-placement="top" title="Ativado" class="active-elem-table glyphicon glyphicon glyphicon-ok-circle"></em>
                        </c:when>
                        <c:otherwise>
                            <em data-toggle="tooltip" data-placement="top" title="Desativado" class="active-elem-table glyphicon glyphicon-remove-circle color-elem-table-deactive"></em> 
                        </c:otherwise></c:choose>
                </td>

                <td>${funcionario.nome}</td>
                <td>${funcionario.cargo.nome}</td>
                <td>${funcionario.unidade.nome}</td>
                <td>${funcionario.email}</td>
                <td><a href="<c:url value="/funcionarios/editar?id=${funcionario.id}"></c:url>">Editar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>