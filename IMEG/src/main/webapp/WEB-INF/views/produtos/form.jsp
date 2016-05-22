
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${produto == null}"><c:set var="action" value="/produtos/novo"/></c:when>
    <c:otherwise><c:set var="action" value="/produtos/editar?id=${produto.id}"/></c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>  

<form enctype="application/x-www-form-urlencoded" action="<c:url value="${action}"/>" method="post">
    <c:if test="${produto != null}">
        <input type="hidden" name="id_funcionario" value="${produto.id}">
    </c:if>
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
            <input class="form-control" value="<c:if test="${produto != null }">${produto.nome}</c:if>" type="text" id="nome_produto" name="nome_produto"/>
            </div>
            <div class="col-lg-3 form-space">
                <label for="">Quantidade Mínima</label>
                <input class="form-control" value="<c:if test="${produto != null }">${produto.qtdeMin}</c:if>" type="text" id="qtd_min_produto" name="qtd_min_produto"/>
            </div>
            <div class="col-lg-3 form-space">
                <label for="">Quantidade Máxima</label>
                <input class="form-control" value="<c:if test="${produto != null }">${produto.qtdeMax}</c:if>" type="text" id="qtd_max_produto" name="qtd_max_produto"/>
            </div>

            <div class="col-lg-3 form-space">
                <label for="">Categoria </label>
                <select name="categoria_id" class="form-control" >
                <c:choose>
                    <c:when test="${produto == null}">                        
                        <option value="0">Selecione uma Categoria</option>                        
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value="${produto.categoria.id}"/>" <c:if test="${produto != null}">${produto.categoria.nome}</c:if>><c:out value="${produto.categoria.nome}"/></option>
                    </c:otherwise>
                </c:choose>                         
                <c:forEach items="${Listacategorias}" var="Listacategoria">
                    <option value="${Listacategoria.id}" <c:if test="${Listacategoria.id == produto.categoria.id}">selected="selected"</c:if> >${Listacategoria.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-12 form-space">
            <label for="ativo_produto">Ativo</label>
            <input type="checkbox" id="ativo_produto" class="" <c:if test="${produto.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
         </div>
         <div class="col-lg-12 form-space"><br><br></div>
         
            <div class="col-lg-12 form-space">
                <a href="<c:url value="/produtos"></c:url>" class="btn btn-default">Voltar</a>       
                <button class="btn btn-default" type="submit" id="commit-produto">
                <c:choose>
                    <c:when test="${produto != null}">Alterar</c:when>
                    <c:otherwise>Salvar</c:otherwise>
                </c:choose>
            </button>
        </div>
    </fieldset>

</form>
