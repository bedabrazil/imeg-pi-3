<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<c:choose>
    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
</c:choose>

<div class="page-header">
    Olá <strong>${sessionScope.usuario.nome}</strong> <small>Seja Bem Vindo!</small>
</div>
<div id="warning" class="col-lg-12 ${alert}">
<c:if test="${sessionScope.success}">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</c:if>
${mensagem}
</div>            

<div class="panel panel-default">
    <div class="panel-heading"><h4><em class="glyphicon glyphicon-th-large"></em>&nbsp;Painel</h4></div>
  <div class="panel-body">
      <div class="col-lg-12 align-charts">
        <div class="col-lg-3 border-gray">
            <div id="chart-1" class="chart"></div>
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
