<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<c:choose>
    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
</c:choose>


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

        <div class="col-lg-12 align-charts">

            <div class="col-lg-3 border-gray">
                <div id="chart-1" class="chart table-responsive">
                    <c:choose>
                        <c:when test="${not empty maisVendidos}">
                            <table class="table table-hover">
                                <thead>
                                    <th colspan="2">Produtos Mais Vendidos</th>
                                </thead>
                                <tbody>
                                    <c:forEach items="${maisVendidos}" var="maisVendidos">
                                        <tr>
                                            <td>${maisVendidos.qtdeVendida}</td>
                                            <td>${maisVendidos.produto.nome}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <form action="<c:url value="/dashboard"/>" method="post">
                                <input type="hidden" name="mais_vendidos" value="1">
                                <div class="col-lg-6">
                                    <label>Data Início</label>
                                    <input type="text" readonly="readonly" id="date-ini-mais-vendidos" class="datePicker form-control" name="data-ini">
                                </div>
                                <div class="col-lg-6">
                                    <label>Data Final</label>
                                    <input type="text" readonly="readonly" id="date-end-mais-vendidos" class="datePicker date-end form-control" name="data-end">
                                </div>  
                            </form>
                        </c:when>
                        <c:otherwise>NA HA RELATORIO</c:otherwise>
                    </c:choose>
                </div>                        
            </div>

            <div class="col-lg-3 border-gray">
                <div id="chart-2" class="chart"></div>
            </div>

            <div class="col-lg-3 border-gray">
                <div id="chart-3" class="chart"></div>          
            </div>

            <div class="col-lg-3 border-gray">
                <div id="chart-3" class="chart"></div>          
            </div> 

        </div>
    </div>

</div>    
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />
