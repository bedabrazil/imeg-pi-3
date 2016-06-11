<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp" />
<div class="panel panel-default">
    <div class="panel-heading"><h3><i class="fa fa-building" aria-hidden="true"></i>&nbsp;Relatórios</h3></div>
    <div class="panel-body">  
        <%-- CONTEÚDO DE RELATORIOS/INDEX --%>
        <div class="col-lg-12">
            <center><h4>Os mais vendidos de <fmt:formatDate pattern="dd/MM/yyyy" value="${tresMesesAtras}"/> a <fmt:formatDate pattern="dd/MM/yyyy" value="${hoje}"/> </h4></center>
            <div id="chart_01" style="width:100%"><center><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></center></div>
        </div>
        <div class="col-lg-12">
            <center><h4>Funcionários que mais venderam em <fmt:formatDate pattern="dd/MM/yyyy" value="${tresMesesAtras}"/> a <fmt:formatDate pattern="dd/MM/yyyy" value="${hoje}"/> </h4></center>
            <div id="chart_02" style="width:100%"><center><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></center></div>

        </div>

        <div class="col-lg-12">
            <center><h4>Unidades que mais venderam em <fmt:formatDate pattern="dd/MM/yyyy" value="${tresMesesAtras}"/> a <fmt:formatDate pattern="dd/MM/yyyy" value="${hoje}"/> </h4></center>
            <div id="chart_03" style="width:100%"><center><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></center></div>
        </div>                    

        <div class="col-lg-12">
            <center><h4>Vendas Mensais </h4></center>
            <div id="chart_04" style="width:100%"><center><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></center></div>
        </div> 
                    
    </div>
</div>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />
<script type='text/javascript'>
    google.charts.setOnLoadCallback(desenharChartRelatorios);

    function desenharChartRelatorios() {
    <c:if test="${not empty relatorioTresMesesAtras}">
        var data10 = new google.visualization.DataTable();
        data10.addColumn('string', 'Unidades');
        data10.addColumn('number', 'Quantidade Vendida');
        data10.addRows([
        <c:forEach items="${relatorioTresMesesAtras}" var="item">
            ["${item.produto.nome}", ${item.qtdeVendida}],
        </c:forEach>
        ]);
        // Set chart options
        var options10 = {'title': 'Produtos mais vendidos', height: 400, backgroundColor: "#F5F5F5"};

        var Chart = new google.visualization.ColumnChart(document.getElementById('chart_01'));
        Chart.draw(data10, options10);
    </c:if>
    <c:if test="${not empty funcionariosQueMaisVenderam}">
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Funcionário');
        data.addColumn('number', 'Total Vendido');
        data.addRows([
        <c:forEach items="${funcionariosQueMaisVenderam}" var="item">
            ["${item.funcionario.nome}", ${item.qtdeVendida}],
        </c:forEach>
        ]);
        // Set chart options
        var options = {'title': 'Funcionarios que mais venderam de todas as unidades', height: 400, backgroundColor: "#F5F5F5"};

        var Chart = new google.visualization.PieChart(document.getElementById('chart_02'));
        Chart.draw(data, options);
    </c:if> 
    <c:if test="${not empty unidadesQueMaisVenderamUltimosTresMeses}">
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Unidade');
        data.addColumn('number', 'Total Vendido');
        data.addRows([
        <c:forEach items="${unidadesQueMaisVenderamUltimosTresMeses}" var="item">
            ["${item.unidade.nome}", ${item.totalValorVenda}],
        </c:forEach>
        ]);
        // Set chart options
        var options = {pieHole: 0.4, 'title': 'Unidades que mais venderam', height: 400, backgroundColor: "#F5F5F5"};

        var Chart = new google.visualization.PieChart(document.getElementById('chart_03'));
        Chart.draw(data, options);        
        
    </c:if>
    <c:if test="${not empty faturamentoTotalDaMatriz}">
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Mês');
        data.addColumn('number', 'Valor Vendido');
        data.addColumn('number', 'Quantidade Vendida')
        data.addRows([
        <c:forEach items="${faturamentoTotalDaMatriz}" var="item">
            ["${item.mes}", ${item.totalValorVenda}, ${item.qtdeVendida}],
        </c:forEach>
        ]);
        // Set chart options
        var options = {
                        legend: { position: 'bottom' },
                         curveType: 'function', 
                        'title': 'Vendas Mensais', height: 400, backgroundColor: "#F5F5F5"};

        var Chart = new google.visualization.LineChart(document.getElementById('chart_04'));
        Chart.draw(data, options);        
    </c:if>
    }
</script>