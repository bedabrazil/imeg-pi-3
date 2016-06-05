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
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(desenharChartMaisVendidos);
//      google.charts.setOnLoadCallback(drawChart);
//      google.charts.setOnLoadCallback(drawChart);
//      google.charts.setOnLoadCallback(drawChart);
//      
//
//      // Callback that creates and populates a data table,
//      // instantiates the pie chart, passes in the data and
//      // draws it.
//      function drawChart() {
//
//        // Create the data table.
//        var data = new google.visualization.DataTable();
//        data.addColumn('string', 'Topping');
//        data.addColumn('number', 'Slices');
//        data.addRows([  
//          ['Mushrooms', 3],
//          ['Onions', 1],
//          ['Olives', 1],
//          ['Zucchini', 1],
//          ['Pepperoni', 2]
//        ]);
//
//        // Set chart options
//        var options = {'title':'How Much Pizza I Ate Last Night',
//                       'min-width':400,
//                       'min-height':600};
//
//        // Instantiate and draw our chart, passing in some options.
//        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
//        chart.draw(data, options);
//      }
    </script>                    
            <script type="text/javascript">
                tinymce.init({ selector:'textarea' });
            </script>            
        </body>
    </html>