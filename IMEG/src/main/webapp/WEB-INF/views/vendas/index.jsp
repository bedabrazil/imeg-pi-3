<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- CONTEÚDO DE PRODUTOS/COMPRAR --%>

<div id="requests" class="col-lg-12">
    <div class="col-lg-12">
    <h3><i class="fa fa-product-hunt" aria-hidden="true"></i>&nbsp;Venda de Produtos</h3>
    <p>Escolha seus produtos e insira no carrinho.</p></div>
    <c:choose>
        <c:when test="${not empty produtos}">
            <c:forEach items="${produtos}" var="produto" >
                <div class="col-lg-3">
                    <div class="col-lg-12 row-requests">
                        <div class="col-lg-12">
                            <h4>${produto.nome}</h4>
                            <strong>SKU: <span>#${produto.id}</span></strong>
                            <strong><fmt:formatNumber value="${produto.getPrecoVenda()}" type="currency"/></strong>
                            <p>No estoque: ${produto.saldo} peças</p>
                        </div>
                        <div class="col-lg-12 descricao">
                            <p>${produto.descricaoCurta}</p>
                        </div>
                            <form action="<c:url value="/vender"/>" method="post"  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="id_produto" value="${produto.id}">
                                <div class="col-lg-12 col-lg-offset-1">
                                    <button type="submit" name="commit" class="btn btn-button"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Vender</button>
                                    <input type="number" min="1" max="${produto.saldo}" value="1" name="quantidade_produto" id="add_product" placeholder="qtd" class="number form-control" maxlength="3">
                                </div>
                            </form>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            NÃO HÁ PRODUTOS
        </c:otherwise>
    </c:choose>
</div>
<div class="col-lg-12">
    <div>SALDOS DE ESTOQUE</div>
</div>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />