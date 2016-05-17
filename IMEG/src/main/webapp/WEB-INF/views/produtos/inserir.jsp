<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
            <%-- CONTEÚDO DE PRODUTOS/Inserir--%>
<c:choose>
    <c:when test="${produto == null}"><c:set var="action" value="/produtos/inserir"/></c:when>
    <c:otherwise><c:set var="action" value="/produtos/inserir"/></c:otherwise>
</c:choose>
<form enctype="application/x-www-form-urlencoded" action="inserir" method="post">
    <fieldset class="well">    
        <div class="col-lg-3 form-space">
            <label for="">Nome do Produto</label>
            <input type="hidden" name="id_produto" value="<c:if test="${produto!= null }">${produto.id}</c:if>"> 
            <input class="form-control" type="text" value="<c:if test="${produto!= null }">${produto.nome}</c:if>" id="nm_produto" name="nm_produto" readonly="readonly" />
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Preço de Custo</label>
            <input class="form-control" type="text" id="preco_custo_produto" name="preco_custo_produto"required="false" />
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Quantidade</label>
            <input class="form-control" type="text" id="quantidade" name="quantidade" required="false"  />
        </div>   
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/produtos"></c:url>" class="btn btn-default">Voltar</a>   
            <button class="btn btn-button ajax" type="submit" id="commit_produto">Enviar</button>
        </div>             
    </fieldset>    
</form>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />     