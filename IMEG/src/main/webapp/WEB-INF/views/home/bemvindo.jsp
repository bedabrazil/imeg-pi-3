<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<c:choose>
    <c:when test="${sessionScope.success}"><c:set var="mensagem" value="${msg_success}"/><c:set var="alert"  value="alert alert-success"/></c:when>
</c:choose>

<div class="page-header">
    Olá <strong>${sessionScope.usuario.nome},</strong> <small>Seja Bem Vindo!</small>
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
            <div id="chart-1" class="chart">
                <c:choose>
                    <c:when test="${not empty maisVendidos}">
                <table class="table table-hover">
                    <tbody>
                        <c:forEach items="${maisVendidos}" var="maisVendidos">
                            <tr>
                                <td>${maisVendidos.qtdeVendida}</td>
                                <td>${maisVendidos.produto.nome}</td>
                            </tr>
                        </c:forEach>
                            <tr>
                                <td colspan="2"><input type="date" name="data1"><input type="date" name="data2"></td>
                            </tr>
                     </tbody>
                 </table>
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
