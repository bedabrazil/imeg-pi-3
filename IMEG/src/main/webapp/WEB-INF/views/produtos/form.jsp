
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${produto == null}"><c:set var="action" value="/produtos/novo"/></c:when>
    <c:otherwise><c:set var="action" value="/funcionarios/editar?id=${produto.id}"/></c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>  

<form enctype="application/x-www-form-urlencoded" action="<c:url value="${action}"/>" method="post">
    <fieldset class="well"> 
        <div class="col-lg-3 form-space">
            <label for="">Nome do Produto</label>
            <input class="form-control" type="text" id="nome_produto" name="nome_produto" />
        </div>
      
        <div class="col-lg-3 form-space">
            <label for="">Quantidade Mínima</label>
            <input class="form-control" type="text" id="qtd_min_produto" name="qtd_min_produto"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Quantidade Máxima</label>
            <input class="form-control" type="text" id="qtd_max_produto" name="qtd_max_produto"/>
        </div>
       
        <div class="col-lg-3 form-space">
            <label for="">Categoria </label>
            <select name="categoria_id" class="form-control" >
                <option value="">Selecione uma Categoria</option>
                
                <c:forEach items="${Listacategorias}" var="Listacategoria">
                        <option value="${Listacategoria.id}" <c:if test="${Listacategoria.id == cargo.Listacategoria.id}">selected="selected"</c:if> >${Listacategoria.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/produtos"></c:url>" class="btn btn-default">Voltar</a>            
            <button class="btn btn-default ajax" type="submit" id="commit_produto">Enviar</button>
        </div>
    </fieldset>
   
</form>
