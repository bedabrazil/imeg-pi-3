<%-- 
    Document   : footer
    Created on : Apr 30, 2016, 9:45:26 PM
    Author     : marcio.soares <marcio@mail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
            </div>
            <footer id="footer">
              <div class="container">
                <p class="text-muted"><i class="glyphicon glyphicon-registration-mark"></i> IMEG Cosm&eacute;ticos</p>
              </div>
            </footer>
            <script src="<c:url value='/resources/js/vendor/jquery-1.12.4.min.js'></c:url>" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/vendor/bootstrap.min.js'></c:url>" type="text/javascript"></script>
            <script src="<c:url value="/resources/js/vendor/jquery.maskMoney.min.js"/>" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/vendor/tinymce/tinymce.min.js'></c:url>" type="text/javascript"></script>            
            <script src="<c:url value="/resources/js/vendor/jquery-ui.min.js"/>" type="text/javascript"></script>
            <script src="<c:url value="/resources/js/vendor/datepicker-pt-BR.js"/>" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/main.js'></c:url>" type="text/javascript"></script>
            <script src="<c:url value="/resources/js/vendor/google-chart.js"/>" type="text/javascript"></script>
            <script type="text/javascript">
                tinymce.init({ selector:'textarea' });
            </script>            
<script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(desenharChart);

            function desenharChart() {
            <c:if test="${not empty maisVendidos}">
                // Create the data table.
                var data1 = new google.visualization.DataTable();
                data1.addColumn('string', 'Produtos');
                data1.addColumn('number', 'Vendidos');
                data1.addRows([
                <c:forEach items="${maisVendidos}" var="item">
                    ["${item.produto.nome}", ${item.qtdeVendida}],
                </c:forEach>
                ]);
                // Set chart options
                var options1 = {'title': 'Produtos mais vendidos', height: 300, backgroundColor: "#F5F5F5"};

                // Instantiate and draw our chart, passing in some options.
                var pieChart1 = new google.visualization.PieChart(document.getElementById('chart_div_1'));
                pieChart1.draw(data1, options1);
                var columnChart1 = new google.visualization.ColumnChart(document.getElementById('chart_div_2'));
                columnChart1.draw(data1, options1);
            </c:if>
            <c:if test="${not empty estoqueBaixo}">
                var data2 = new google.visualization.DataTable();
                data2.addColumn('string', 'Produtos');
                data2.addColumn('number', 'Saldo');
                data2.addRows([
                <c:forEach items="${estoqueBaixo}" var="estoque">
                    ["${estoque.getProduto().nome}", ${estoque.getQuantidade()}],
                </c:forEach>
                ]);
                // Set chart options
                var options2 = {'title': 'Produtos Baixo Estoque', height: 300, backgroundColor: "#F5F5F5"};

                // Instantiate and draw our chart, passing in some options.
                var pieChart2 = new google.visualization.PieChart(document.getElementById('chart_div_3'));
                pieChart2.draw(data2, options2);
                var columnChart2 = new google.visualization.ColumnChart(document.getElementById('chart_div_4'));
                columnChart2.draw(data2, options2);
            </c:if>
            }



        </script>            
        </body>
    </html>