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
            <div class="col-lg-12 form-space">
                <form action="<c:url value="/relatorios"/>" method="post">
                    <div class="col-lg-12">
                        <div id="error" class="col-lg-12">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;Data Final tem que ser maior ou igual a Data Inicial.</span>
                        </div>
                        <h5>Para gerar um relatório EXCELL com outras datas selecione :</h5>
                    </div>
                    <input type="hidden" name="mais_vendidos" value="1">
                    <div class="col-lg-3 form-space">
                        <label>Data Início</label>
                        <input type="text" readonly="readonly" id="date-ini-mais-vendidos" class="datePicker form-control" name="date-ini-mais-vendidos">
                    </div>
                    <div class="col-lg-3 form-space">
                        <label>Data Final</label>
                        <input type="text" readonly="readonly" id="date-end-mais-vendidos" class="datePicker date-end form-control" name="date-end-mais-vendidos">
                    </div>  
                    <div class="col-lg-12 form-space">
                        <label>&nbsp;</label>
                        <button type="submit" name="gerar_excel" class="btn btn-default gerar_excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i>&nbsp;Excel</button>
                    </div>
                </form>                 
            </div>
        </div>
        <div class="col-lg-12">
            <center><h4>Funcionários que mais venderam em <fmt:formatDate pattern="dd/MM/yyyy" value="${tresMesesAtras}"/> a <fmt:formatDate pattern="dd/MM/yyyy" value="${hoje}"/> </h4></center>
            <div id="chart_02" style="width:100%"><center><img src="<c:url value="/resources/images/empty-area-chart.png"/>" alt=""></center></div>
            <div class="col-lg-12 form-space">
                <form action="<c:url value="/relatorios"/>" method="post">
                    <div class="col-lg-12">
                        <div id="error" class="col-lg-12">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <span><i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;Data Final tem que ser maior ou igual a Data Inicial.</span>
                        </div>
                        <h5>Para gerar um relatório EXCELL com outras datas selecione :</h5>
                    </div>
                    <input type="hidden" name="funcionarios_que_mais_venderam" value="1">
                    <div class="col-lg-3 form-space">
                        <label>Data Início</label>
                        <input type="text" readonly="readonly" id="date-ini-mais-vendidos-funcionarios" class="datePicker form-control" name="date-ini-mais-vendidos-funcionarios">
                    </div>
                    <div class="col-lg-3 form-space">
                        <label>Data Final</label>
                        <input type="text" readonly="readonly" id="date-end-mais-vendidos-funcionarios" class="datePicker date-end form-control" name="date-end-mais-vendidos-funcionarios">
                    </div>  
                    <div class="col-lg-12 form-space">
                        <label>&nbsp;</label>
                        <button type="submit" name="gerar_excel" class="btn btn-default gerar_excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i>&nbsp;Excel</button>
                    </div>
                </form>                 
            </div>
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
    }
</script>