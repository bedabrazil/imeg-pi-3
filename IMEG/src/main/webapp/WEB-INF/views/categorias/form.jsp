<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${categoria == null}"><c:set var="action" value="/categorias/novo"/></c:when>
    <c:otherwise><c:set var="action" value="/categorias/editar?id=${categoria.id}"/></c:otherwise>
</c:choose>    
<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>    



<form action="<c:url value="${action}"/>" method="post" class="call">
    <c:if test="${categoria != null}">
        <input type="hidden" name="id_categoria" value="${categoria.id}">
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
        <div class="col-lg-6 form-space">
            <label for="">Nome da Categoria</label>

            <input class="form-control" type="text" value="<c:if test="${categoria != null }">${categoria.getNome()}</c:if>" id="nome_categoria" name="nome_categoria"/>
        </div>
        <div class="col-lg-12 form-space">
                <label for="ativo_categoria">Ativo</label>
                <input type="checkbox" id="ativo_categoria" class="" <c:if test="${categoria.isStatus()}">checked='checked'</c:if> name="ativo" value="true">
        </div>
        <div class="col-lg-12 form-space">
                <a href="<c:url value="/categorias"></c:url>" class="btn btn-default">Voltar</a>            
                <button class="btn btn-default" type="submit" id="commit-categoria">
                <c:choose>
                    <c:when test="${categoria != null}">Alterar</c:when>
                    <c:otherwise>Salvar</c:otherwise>
                </c:choose>
            </button>
        </div>        
    </fieldset>
</form>