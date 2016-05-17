<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${unidade == null}"><c:set var="action" value="/unidades/novo"/></c:when>
    <c:otherwise><c:set var="action" value="unidades/editar?id=${unidade.id}"/></c:otherwise>
</c:choose> 

<c:choose>
    <c:when test="${error}"><c:set var="alert" value="alert alert-danger"/></c:when>
</c:choose>  

<form action="${action}" method="post">
    <c:if test="${unidade != null}">
        <input type="hidden" name="id_estado" value="${unidade.id}">
    </c:if>

    <fieldset class="well">
        <div class="col-lg-6 form-space">
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
        </div>
        <div class="col-lg-6 form-space">
            <label for="">Nome da Unidade</label>
            <input class="form-control" type="text" value="<c:if test="${unidade != null }">${unidade.nome}</c:if>" id="nome-unidade" name="nome-unidade"/>

            </div>
            <div class="col-lg-4 form-space">
                <label for="">Cidades </label>
                <select name="estado-id" class="form-control" >  
                    <option value="<c:if test="${unidade != null }">${unidade.estado.nome}</c:if>">Selecione uma Cidade</option>
                    
                <c:forEach items="${estados}" var="estado">                    
                    <option value="${unidade.estado.id}">${estado.nome}</option>
                </c:forEach>
            </select>
        </div>
        <%--
        <div class="col-lg-12 form-space">
            <label for="ativo_unidades">Ativo</label>
            <input class="btn btn-button" type="checkbox" id="commit-unidade"/>
        </div>
        --%>
        </br>
        <div class="col-lg-12 form-space">
            <a href="<c:url value="/unidades"></c:url>" class="btn btn-default">Voltar</a>
                <button class="btn btn-default ajax" type="submit" id="commit-unidade">
                <c:choose><c:when test="${unidade != null}">Alterar</c:when>
                    <c:otherwise>Salvar</c:otherwise>
                </c:choose>
            </button>
        </div>
    </fieldset>
</form>