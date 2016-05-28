<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
<%-- CONTEÚDO DE PRODUTOS/COMPRAR --%>
<div class="col-lg-12">
    <c:choose>
        <c:when test="${not empty produtos}">
            <c:forEach items="${produtos}" var="produto" >
                <div class="col-lg-3">
                    <h4>#${produto.id}-${produto.nome}</h4>
                    <strong>${produto.precoVenda}</strong>
                    <span>${produto.saldo}</span>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            NÃO HÁ PRODUTOS
        </c:otherwise>
    </c:choose>
</div>    
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />