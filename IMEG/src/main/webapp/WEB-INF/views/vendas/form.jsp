
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>  

<form enctype="application/x-www-form-urlencoded" action="<c:url value="/produtos/venda"/>" method="post">
    <fieldset class="well"> 
            <div class="col-lg-3 form-space">
                <label for="">Produtos</label>
                <select name="produto_id" class="form-control" >
                <option value="0">Selecione um Produto</option>                        
                <c:forEach items="${produtos}" var="produto">
                    <option value="${produto.id}">${produto.nome}</option>
                </c:forEach>
            </select>
        </div>
           <div class="col-lg-3 form-space">
                <label for="">Quantidade</label>
                <input class="form-control" type="number" id="quantidade" name="quantidade" min="1"/>
            </div>
            <div class="col-lg-3 form-space">
                <label for="">Preço de Venda</label>
                <input class="form-control" type="number" id="preco_venda" name="preco_venda" step="any"/>
            </div>
        <div class="col-lg-12 form-space">
            <button class="btn btn-default" type="submit" id="commit-produto">
                Adicionar
            </button>
        </div>
                
  <div class="col-lg-12 table-reposnsive">
    <table class="table table-hover">
        <thead>
            <th>ID</th>
            <th>Produto</th> 
            <th>Categoria</th>
            <th>Quantidade</th>
            <th>Total</th>
        </thead>
        <tbody>
           <c:forEach items="${lista.getItens()}" var="item">
            <tr>          
                <td>${lista.id}</td>
                <td>${lista.produto.nome}</td>
                <td>${lista.categoria.nome}</td>
                <td>${lista.quantidade}</td>
                <td>${lista.total}</td>
             
             <fmt:formatNumber type="currency" 
            value="${lista.produto.precoVenda }"/>
        <td>
          <fmt:formatNumber type="currency" 
            value="${lista.quantidade * lista.produto.precoVenda }"/>
        </td>
      </tr>          
    </c:forEach>
        </tbody>
    </table>
</div>        
      <div class="col-lg-12 form-space">
                <a href="<c:url value="/produtos"></c:url>" class="btn btn-default">Voltar</a>       
       </div>                
    </fieldset>
</form>
