<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- CABEÇALHO DO HTML --%>
<jsp:include page="../header.jsp" />
            <%-- CONTEÚDO DE PRODUTOS/Inserir--%>
<c:choose>
    <c:when test="${produto == null}"><c:set var="action" value="/produtos/inserir"/></c:when>
    <c:otherwise><c:set var="action" value="/produtos/inserir?id=${produto.id}"/></c:otherwise>    
</c:choose>
<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>  
<form enctype="application/x-www-form-urlencoded" action="<c:url value="${action}"/>" method="post">
    <fieldset class="well">
        <div id="warning" class="col-lg-12 ${alert}">
            
            <c:if test="${not empty mensagens}">
                
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>        

                <p>Existem <strong>${mensagens.size()}</strong> erro(s) a ser(em) corrigidos.</p>

            </c:if>
            <div class="col-lg-12">
                <p></p>
                <ul>
                    <c:forEach items="${mensagens}" var="msg">
                        <li>${msg}</li>
                        </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Nome do Produto</label>
            <input type="hidden" name="id_produto" value="<c:if test="${produto!= null }">${produto.id}</c:if>"> 
            <input class="form-control" type="text" value="<c:if test="${produto!= null }">${produto.nome}</c:if>" id="nm_produto" name="nm_produto" readonly="readonly" />
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Preço de Custo</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-money"></i></span>
                <input class="form-control maskmoney" maxlength="16" type="text" id="preco_custo_produto" name="preco_custo_produto"/>
            </div>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Preço de Venda</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-money"></i></span>
                <input class="form-control maskmoney" maxlength="16" type="text" id="preco_venda_produto" name="preco_venda_produto"/>
            </div>
        </div>
        
        <div class="col-lg-3 form-space">
            <label for="">Quantidade</label>
            <input class="form-control number" maxlength="4" type="text" id="quantidade" name="quantidade" min="1" />
        </div>   
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/produtos"></c:url>" class="btn btn-default">Voltar</a>   
            <button class="btn btn-default ajax" type="submit" id="commit_produto">Enviar</button>
        </div>             
    </fieldset>    
</form>
<%-- RODAPÉ DO HTML --%>
<jsp:include page="../footer.jsp" />     
