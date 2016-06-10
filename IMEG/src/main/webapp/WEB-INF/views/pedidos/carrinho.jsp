<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>
<c:choose>
    <c:when test="${not empty carrinho}">
        <c:choose>
            <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
        </c:choose>        
        <div class="panel panel-default">
            <div class="panel-heading"><h3><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Carrinho</h3> <span>Clique em finalizar compra para efetuar o seu pedido.</span></div>
            <div class="panel-body"> 
                <div class="col-lg-12">
                    <div id="warning" class="col-lg-12 ${alert}">
                        <c:if test="${sessionScope.success}">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            ${mensagem}
                        </c:if>
                    </div>
                </div>
                <div id="carrinho" class="col-lg-12 table-reposnsive">
                    <table class="table table-hover">
                        <thead>
                        <th style="width:35%;">Produto</th>
                        <th style="width:15%;">Preço Unitário</th>
                        <th style="width:10%">Quantidade</th>
                        <th style="width:42%">Subtotal</th>
                        <th style="width:8%;">Excluir</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${carrinho}" var="hash">
                                <c:set var="total" value="${total + (hash.key.precoVenda * hash.value)}" />
                                <tr>
                                    <td>
                                        <div class="col-lg-12"> 
                                            <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>&nbsp;
                                            <strong>${hash.key.nome}</strong>
                                            <p>SKU: ${hash.key.id}<br>Estoque: ${hash.key.saldo}</p>
                                            </div>
                                        </td>
                                        <td class="sub-total"><fmt:formatNumber value="${hash.key.precoVenda}" type="currency"/></td>
                                    <td>
                                        <div class="col-lg-12"> 
                                            <form enctype="application/x-www-form-urlencoded" action="<c:url value="/carrinho"/>" method="post">
                                                <input type="hidden" name="id_produto" value="${hash.key.id}">
                                                <input type="hidden" name="atualizar_produto" value="1">
                                                <input min="0" class="form-control" type="number" max="${hash.key.saldo}" name="qtd_produto" value="${hash.value}" >
                                                <button type="submit" class="atualizar-produto-carrinho btn btn-default">&nbsp;<i class="fa fa-refresh" aria-hidden="true"></i>&nbsp;</button>
                                            </form>
                                        </div>
                                    </td>
                                    <td class="sub-total"><fmt:formatNumber value="${hash.value * hash.key.precoVenda}" type="currency"/></td>
                                    <td>
                                        <form enctype="application/x-www-form-urlencoded" action="<c:url value="/carrinho"/>" enctype="" method="post">
                                            <input type="hidden" name="id_produto" value="${hash.key.id}">
                                            <input type="hidden" name="remover_produto" value="1">
                                            <button type="submit" class="remover-produto-carrinho">&nbsp;<i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="5" style="text-align: right;width: 70%">Total: <strong class="sub-total total"><fmt:formatNumber value="${total}" type="currency"/></strong></td>
                            </tr>
                        </tbody>
                    </table>    
                    <div class="col-lg-12">
                        <div class="col-lg-9">
                        <a href="<c:url value="/vender"/>" class="btn btn-default continuar-venda">Continuar Vendendo</a>
                        </div>
                        <div class="col-lg-3">
                            <form class="finalizar-compra" action="<c:url value="/carrinho"/>" method="post" enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="finalizar" value="1">
                                <input type="submit" name="commit" class="btn btn-default" value="Finalizar Compra">
                            </form>                                
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </c:when>
    <c:otherwise>
        <div class="col-lg-12 pedido-sucesso">
            <h1>Não há produtos no carrinho</h1>
            <a href="<c:url value="/vender"/>" class="btn btn-default">Ir as vendas</a>
        </div>

    </c:otherwise>
</c:choose>
