<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="categorias" method="post">
    <fieldset class="well">
        <div class="col-lg-12 <c:if test="${sessionScope.error}">errors</c:if>"><c:if test="${sessionScope.error}"> ${msg}</c:if></div>
        <div class="col-lg-6 form-space">
            <label for="">Nome da Categoria</label>
            <input class="form-control" type="text" id="nome_categoria" name="nome_categoria"/>
        </div>

        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-categoria"/>
        </div>
    </fieldset>
</form>