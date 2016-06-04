<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<%-- <%@ include file="/header.html" --%>
<jsp:include page="../header.jsp" />
<% response.setStatus(404);%>
<%-- CONTEÚDO DE ERROR --%>
<div class="col-lg-12">
    <button onclick="history.back()">Click para voltar para a página anterior</button>
    <h1>500 - erro interno.</h1>
    <br />
    <p><b>Código do erro:</b> ${pageContext.errorData.statusCode}</p>
    <p><b>URL :</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
    <br />                 
</div>
<%-- RODAPÉ DO HTML --%>
<%--@ include  file="/footer.html" --%>
<jsp:include page="../footer.jsp" />            