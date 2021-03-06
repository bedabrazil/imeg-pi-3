
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
        <input type="hidden" name="id_produto" value="${produto.id}">
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

        <div class="col-lg-5 form-space">
            <label for="nome_produto">Nome do Produto</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-product-hunt fa-fw"></i></span>             
                <input class="form-control" placeholder="Nome do Produto" value="<c:if test="${produto != null }">${produto.nome}</c:if>" type="text" id="nome_produto" name="nome_produto"/>
                </div>
            </div>
            <div class="col-lg-3 form-space">
                <label for="categoria_id">Categoria </label>
                <select name="categoria_id" class="form-control" >
                <c:choose>
                    <c:when test="${produto == null}">                        
                        <option value="0">Selecione uma Categoria</option>                        
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value="${produto.categoria.id}"/>" <c:if test="${produto != null}">${produto.categoria.nome}</c:if>><c:out value="${produto.categoria.nome}"/></option>
                    </c:otherwise>
                </c:choose>                         
                <c:forEach items="${categorias}" var="categoria">
                    <option value="${categoria.id}" <c:if test="${categoria.id == produto.categoria.id}">selected="selected"</c:if> >${categoria.nome}</option>
                </c:forEach>
            </select>
            </div>
                
            <div class="col-lg-2 form-space">
                <label for="qtd_min_produto">Quantidade M�nima</label>
                <input class="form-control number" placeholder="Quantidade M�nima" maxlength="4" value="<c:if test="${produto != null }">${produto.qtdeMin}</c:if>" type="text" id="qtd_min_produto" name="qtd_min_produto"/>
            </div>
            <div class="col-lg-2 form-space">
                <label for="qtd_max_produto">Quantidade M�xima</label>
                <input class="form-control number" placeholder="Quantidade M�xima" maxlength="4" value="<c:if test="${produto != null }">${produto.qtdeMax}</c:if>" type="text" id="qtd_max_produto" name="qtd_max_produto"/>
            </div>
            <div class="col-lg-2 form-space">
                <label for="preco_custo_produto">Pre�o de Custo</label>
                <input type="text" placeholder="Pre�o de Custo" maxlength="16" name="preco_custo_produto" id="preco_custo_produto" class="form-control maskmoney" value="<c:if test="${produto != null }">${produto.precoCusto}</c:if>">
            </div>
            <div class="col-lg-2 form-space">
                <label for="preco_venda_produto">Pre�o de Venda</label>
                <input type="text" placeholder="Pre�o de Venda" maxlength="16" name="preco_venda_produto" id="preco_venda_produto" class="form-control maskmoney" value="<c:if test="${produto != null }">${produto.precoVenda}</c:if>">
            </div>
            <div class="col-lg-12"></div>
            <div class="col-lg-6 form-space">
                <label for="descricao_curta_produto">Descri��o Curta</label>
                <textarea class="form-control" name="descricao_curta_produto" id="descricao_curta_produto" cols="8" rows="6"><c:if test="${produto != null }">${produto.descricaoCurta}</c:if></textarea>
            </div>
            <div class="col-lg-6 form-space">
                <label for="descricao_produto">Descri��o Longa</label>
                <textarea class="form-control" name="descricao_produto" id="descricao_produto" cols="8" rows="6"><c:if test="${produto != null }">${produto.descricao}</c:if></textarea>
            </div>
        <div class="col-lg-12 form-space">
            <label for="ativo_produto">Ativo</label>
            <input type="checkbox" id="ativo_produto" class="" <c:if test="${produto.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
            </div>            
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
