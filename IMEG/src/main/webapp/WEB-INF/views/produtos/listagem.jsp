<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>
 <c:choose>
        <c:when test="${not empty produtos}">
    <c:choose>
        <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
    </c:choose>

    <div class="col-lg-12">
        <c:if test="${usuario.unidade.matriz}">
            <a href="<c:url value="/produtos/novo"></c:url>"><i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Novo Produto no Catálogo</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        </c:if>
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
                    <th style="width:5%;">Status</th>
                    <th style="width:15%;">Nome</th>
                    <th style="width:5%;">Qtd Mínima</th>
                    <th style="width:5%;">Qtd Máxima</th>
                    <th style="width:8%;">Preço de Custo</th>
                    <th style="width:8%;">Preço de Venda</th>
                    <th style="width:36%;">Descrição Curta</th>
                    <th style="width:8%;">Saldo</th>
                    <th style="width:10%;">Ações</th>
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
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${produto.nome}</td>
                                <td>${produto.qtdeMin}</td>
                                <td>${produto.qtdeMax}</td>
                                <td><fmt:formatNumber value="${produto.precoCusto}" type="currency"/></td>
                                <td><fmt:formatNumber value="${produto.precoVenda}" type="currency"/></td>
                                <td>${produto.descricaoCurta}</td>
                                <td>${produto.saldo}</td>
                                <c:if test="${not empty usuario && usuario.unidade.matriz}">
                                    <td><center><a href="<c:url value="/produtos/editar?id=${produto.id}"></c:url>"><i data-toggle="tooltip" data-placement="top" title="Editar" class="active-elem-table fa fa-pencil-square-o" aria-hidden="true"></i></a>&nbsp; <a href="<c:url value="/produtos/inserir?id=${produto.id}"></c:url>"><i  data-toggle="tooltip" data-placement="top" title="Inserir Produto no Estoque" class="active-elem-table fa fa-plus-square" aria-hidden="true"></i></a></center></td></c:if>
                                </tr>
                    </c:forEach>
                    </tbody>
                </table>    
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-lg-12">Não há produtos</div>
        </c:otherwise>
    </c:choose>
