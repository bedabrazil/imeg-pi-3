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

        <div id="charts" class="col-lg-12">

            <div class="col-lg-6">
                <script type="text/javascript">
                    <c:choose>
                        <c:when test="${not empty maisVendidos}">
                            function desenharChartMaisVendidos() {
                                // Create the data table.
                                var data = new google.visualization.DataTable();
                                data.addColumn('string', 'Topping');
                                data.addColumn('number', 'Vendidos');
                                data.addRows([
                                    <c:forEach items="${maisVendidos}" var="item">
                                    ["${item.produto.nome}", ${item.qtdeVendida}],
                                    </c:forEach>
                                ]);


                                // Set chart options
                                var options = {'title': 'Produtos Mais Vendidos',
                                    'width': 400,
                                    'height': 400};

                                // Instantiate and draw our chart, passing in some options.
                                var chart = new google.visualization.BarChart(document.getElementById('chart_div_1'));
                                chart.draw(data, options);
                            }
                        </c:when>
                    </c:choose>
                    </script>
                    <div id="chart_div_1" class="chart table-responsive">
                        <c:choose>
                            <c:when test="${not empty maisVendidos}">
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

                <div class="col-lg-6">

                </div>

                <div class="col-lg-4">
                </div>

                <div class="col-lg-4">

                </div> 
            </div>
        </div>
    </div>    
    <%-- RODAPÉ DO HTML --%>
    <jsp:include page="../footer.jsp" />
