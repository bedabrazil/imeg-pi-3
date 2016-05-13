<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="unidades" method="post">
    <fieldset class="well">
        <div class="col-lg-6 form-space">
            <label for="">Nome da Unidade</label>
            <input class="form-control" type="text" id="nome-unidade" name="nome-unidade"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Cidades </label>
            <select name="estado-id" class="form-control" >
                <option value="">Selecione uma Cidade</option>
                <c:forEach items="${estados}" var="estado">
                <option value="${estado.id}">${estado.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-unidade"/>
        </div>
    </fieldset>
</form>