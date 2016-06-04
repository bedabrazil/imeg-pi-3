<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- CONTEÚDO DE PRODUTOS/INDEX --%>
<div class="panel panel-default">
    <div class="panel-heading"><h3><i class="fa fa-product-hunt" aria-hidden="true"></i>&nbsp;Produtos Vendidos</h3></div>
    <div class="panel-body">  
        <c:choose>
            <c:when test="${not empty itensSaida}">
                <c:choose>
                    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
                </c:choose>

                <div class="col-lg-12">
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
                        <th style="width:3%;">Status</th>
                        <th style="width:20%;">Nome do Produto</th>
                        <th style="width:18%;">Vendedor</th>
                        <th style="width:12%;">Tipo de Acesso</th>
                        <th style="width:10%;">Quantidade Vendida</th>
                        <th style="width:12%;">Preço de Venda</th>
                        <th style="width:20%">Total da Venda</th>
                        <th style="width:12%">Data da transação</th>
                        
                        </thead>
                        <tbody>
                            <c:forEach items="${itensSaida}" var="itens">
                                <tr>
                                    <td>
                                        <c:choose>
                                            <c:when test="${itens.produto.isStatus()}">
                                                <em data-toggle="tooltip" data-placement="top" title="Ativado" class="active-elem-table glyphicon glyphicon glyphicon-ok-circle"></em>
                                            </c:when>
                                            <c:otherwise>
                                                <em data-toggle="tooltip" data-placement="top" title="Desativado" class="active-elem-table glyphicon glyphicon-remove-circle color-elem-table-deactive"></em> 
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${itens.produto.nome}</td>
                                    <td>${itens.funcionario.nome}</td>
                                    <td>${itens.funcionario.acesso.nome}</td>
                                    <td>${itens.qtdeProdutos}</td>
                                    <td><fmt:formatNumber value="${itens.produto.precoVenda}" type="currency"/></td>                                    
                                    <td class="sub-total"><fmt:formatNumber type="currency" value="${itens.qtdeProdutos * itens.precoVenda}"/></td>
                                    <td><fmt:formatDate type="date" value="${itens.dataTransacao}"/></td>
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>    
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-lg-12">Não há produtos vendidos.</div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />