<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
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
<c:choose>
    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
</c:choose>
<c:choose>
    <c:when test="${empty produtos}">
        <c:choose>
            <c:when test="${not empty maisVendidos}">


                <script type="text/javascript">
                    function desenharChartMaisVendidos() {
                        // Create the data table.
                        var data = new google.visualization.DataTable();
                        data.addColumn('string', 'Produtos');
                        data.addColumn('number', 'Vendidos');
                        data.addRows([
                    <c:forEach items="${maisVendidos}" var="item">
                            ["${item.produto.nome}", ${item.qtdeVendida}],
                    </c:forEach>
                        ]);


                        // Set chart options
                        var options = {'title': 'Produtos Mais Vendidos', height: 300, backgroundColor: "#F5F5F5"};

                        // Instantiate and draw our chart, passing in some options.
                        var pieChart = new google.visualization.PieChart(document.getElementById('chart_div_1'));
                        pieChart.draw(data, options);
                        var columnChart = new google.visualization.ColumnChart(document.getElementById('chart_div_2'));
                        columnChart.draw(data, options);

                    }
                </script>

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
                    <div id="carouselChart"  class="carousel slide" data-ride="carousel">
                        <!--            <ol class="carousel-indicators">
                                        <li data-target="#carouselChart" data-slide-to="0" class="active"></li>
                                        <li data-target="#carouselChart" data-slide-to="1"></li>
                                        <li data-target="#carouselChart" data-slide-to="2"></li>
                                    </ol>            -->
                        <div id="charts" class="col-lg-10 carousel-inner" role="listbox">
                            <div class="col-lg-12 item active chart">
                                <div class="container">
                                    <div class="carousel-caption">   </div>                 
                                    <div class="col-lg-5">
                                        <div id="chart_div_1" class=" col-lg-12 well">
                                            <c:choose>
                                                <c:when test="${empty maisVendidos}">
                                                    <p>NA HÁ DADOS</p>
                                                </c:when>
                                            </c:choose>
                                        </div>         

                                    </div>

                                    <div class="col-lg-5">
                                        <div id="chart_div_2" class=" col-lg-12 well">
                                            <c:choose>
                                                <c:when test="${empty maisVendidos}">
                                                    <p>NA HÁ DADOS</p>
                                                </c:when>
                                            </c:choose>
                                        </div>

                                    </div>
                                    <c:if test="${not empty maisVendidos}">
                                        <div class="col-lg-10 well">

                                            <form action="<c:url value="/dashboard"/>" method="post">
                                                <div class="col-lg-12">
                                                    <div id="error" class="col-lg-12">
                                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                        <span><i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;Data Final tem que ser maior ou igual a Data Inicial.</span>
                                                    </div>
                                                    <h5>Para gerar um relatório dos Mais Vendidos selecione entre datas:</h5>
                                                </div>
                                                <input type="hidden" name="mais_vendidos" value="1">
                                                <div class="col-lg-6 form-space">
                                                    <label>Data Início</label>
                                                    <input type="text" readonly="readonly" id="date-ini-mais-vendidos" class="datePicker form-control" name="date-ini-mais-vendidos">
                                                </div>
                                                <div class="col-lg-6 form-space">
                                                    <label>Data Final</label>
                                                    <input type="text" readonly="readonly" id="date-end-mais-vendidos" class="datePicker date-end form-control" name="date-end-mais-vendidos">
                                                </div>  
                                                <div class="col-lg-6 form-space">
                                                    <button type="submit" name="gerar_excel" class="btn btn-default gerar_excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i>&nbsp;Excel</button>
                                                    <button type="submit" class="btn btn-default gerar_pdf" name="gerar_pdf"><i class="fa fa-file-pdf-o" aria-hidden="true"></i>&nbsp;PDF</button>                      
                                                </div>
                                            </form>                            
                                        </div> 
                                    </c:if>
                                </div>
                            </div>
                            <div class="col-lg-4 item chart">
                                <div class="container">
                                    <div class="carousel-caption"></div>                    
                                </div>
                            </div>

                            <div class="col-lg-4 item chart">
                                <div class="container">
                                    <div class="carousel-caption"></div>                    
                                </div>
                            </div> 
                        </div>
                        <a class="left carousel-control" href="#carouselChart" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Anterior</span>
                        </a>
                        <a class="right carousel-control" href="#carouselChart" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Próximo</span>
                        </a>            
                    </div>
                </div>
            </div>    
        </c:when>
    </c:choose>        
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
