// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages': ['corechart']});

if (document.getElementById('chart_div_1') && document.getElementById('chart_div_2')) {
// Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(desenharChartMaisVendidos);
}
if (document.getElementById('chart_div_3') && document.getElementById('chart_div_4')) {
    google.charts.setOnLoadCallback(desenharChartEstoqueBaixo);
}

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
