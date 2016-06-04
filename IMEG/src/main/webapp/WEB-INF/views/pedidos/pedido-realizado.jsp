
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- CONTEÚDO DE VENDIDOS/INDEX --%>

<c:choose>
    <c:when test="${sessionScope.sale_success}">
        <div class="col-lg-12 pedido-sucesso">
            <div class="col-lg-12">
                <h1>PEDIDO #${sale_number}</h1>
                <h4>REALIZADO COM SUCESSO</h4>
                <a href="<c:url value="/vender"/>" class="btn btn-default">Continuar Vendendo</a>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <jsp:include page="carrinho.jsp" />
    </c:otherwise>
</c:choose>

<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />