<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- CONTEÚDO DE VENDIDOS/INDEX --%>

<c:choose>
    <c:when test="${sessionScope.sale_success != null && sessionScope.sale_success}">
        <jsp:include page="pedido-realizado.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="carrinho.jsp" />
    </c:otherwise>
</c:choose>
        

<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />