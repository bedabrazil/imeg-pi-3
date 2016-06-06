<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>

<jsp:include page="../header.jsp" />
<c:if test="${!usuario.unidade.matriz}">
    <div class="col-lg-6 col-lg-offset-3">
        <form action="<c:url value="/dashboard"/>" method="get">
            <label>Faça uma busca:</label>
            <div class="input-group pull-right">
                <input type="text" class="form-control" placeholder="Digite um nome de produto" name="search" id="search">
                <span class="input-group-btn">
                    <button class="btn btn-primary btn-block btn-search" type="submit">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </span>   
            </div>
        </form>
    </div>
    <div class="col-lg-12 form-space"></div>
    <c:if test="${msg_error}">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="alert alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                Não há produtos com o nome <strong>${search}</strong>
            </div>

        </div>    
    </c:if>            
</c:if>
<c:choose>
    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
</c:choose>
<c:choose>
    <c:when test="${empty produtos}">


        <div id="warning" class="col-lg-12 ${alert}">
            <c:if test="${sessionScope.success}">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </c:if>
            ${mensagem}
        </div>            

        <c:if test="${not empty usuario}">
            <div id="area-unidade" class="unidade col-lg-12"> 
                <div class="col-lg-12">
                    <h1 class="unidade"><c:choose><c:when test="${usuario.unidade.matriz}">
                                Matriz
                            </c:when>                                    
                            <c:otherwise>Filial</c:otherwise>
                        </c:choose></h1></div>
                <div class="col-lg-3 well"> 
                    <h5>Unidade</h5>
                    <i class="fa fa-building" aria-hidden="true"></i>&nbsp; <strong>${usuario.unidade.nome}&nbsp;-&nbsp;${usuario.unidade.estado.nome}</strong> 
                </div>
                <div class="col-lg-3 well">
                    <h5>Usuário</h5>
                    <i class="fa fa-user" aria-hidden="true"></i>&nbsp <strong>${usuario.nome}</strong>
                </div>
                <div class="col-lg-3 well">
                    <h5>Cargo</h5>
                    <i class="fa fa-cog" aria-hidden="true"></i>&nbsp; <strong>${usuario.cargo.nome}</strong>
                </div>
                <div class="col-lg-3 well">    
                    <h5>Acesso</h5>
                    <i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp; <strong>${usuario.acesso.nome}</strong>
                </div>                            
            </div>


        </div>
    </c:if>
    <div class="panel panel-default">
        <div class="panel-heading"><h4><em class="glyphicon glyphicon-th-large"></em>&nbsp;Painel</h4></div>
        <div class="panel-body">
            <div class="col-lg-12 table-responsive">

                <table id="chart" style="width:100%;" class="table">
                    <tbody>
                              <tr>
                                  <td>
                                      <table class="table">                    
                                          <thead>
                                          <th colspan="2">Produtos mais vendidos dos últimos 7 dias</th>
                                          </thead>
                                          <tbody>
                                              <tr>
                                                  <td style="width:50%;" id="chart_1"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                                  <td style="width:50%;" id="chart_2"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                              </tr>
                                          </tbody>
                                      </table>
                                  </td>
                              </tr>
                        <c:if test="${usuario.unidade.matriz}">
                            <tr>
                                <td>
                                    <table class="table">                    
                                        <thead>
                                        <th colspan="2">Produtos com Baixo Estoque dos últimos 7 dias</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:50%;" id="chart_3"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                                <td style="width:50%;" id="chart_4"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr> 
                        </c:if>
                        <c:if test="${usuario.unidade.matriz}">
                            <tr>
                                <td>
                                    <table class="table">                    
                                        <thead>
                                        <th  colspan="2">Unidades que mais venderam nos últimos 7 dias</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:50%;" id="chart_5"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                                <td style="width:50%;" id="chart_6"><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>  
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>    

</c:when>
<c:otherwise>
    <div id="requests"  class="col-lg-12">
        <c:forEach items="${produtos}" var="produto">

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
    </div>

</c:otherwise>
</c:choose>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />
