<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- LISTAGEM DAS CARGOS --%>
<div class="panel panel-default">
    <div class="panel-heading"><h3><i class="fa fa-cog" aria-hidden="true"></i>&nbsp;Cargos</h3></div>
    <div class="panel-body"> 
        <jsp:include page="listagem.jsp"/>
    </div>
</div>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />