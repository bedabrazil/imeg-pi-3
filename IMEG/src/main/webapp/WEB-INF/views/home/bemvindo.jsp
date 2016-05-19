<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />

<div class="page-header">
    <h3>Olá ${sessionScope.usuario.nome} <small>Seja Bem Vindo!</small></h3>
</div>
<div class="panel panel-default">
  <div class="panel-heading">Dashboard</div>
  <div class="panel-body">
    
  </div>
</div>    
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />
