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
            <div class="col-lg-12">
                
            </div>
        </div>

        
    </div>
</div>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />
