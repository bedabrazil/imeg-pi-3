<form action="funcionarios" method="post">
    <fieldset class="well">
        <div class="col-lg-6 form-space">
            <label for="">Nome do Funcionário</label>
            <input class="form-control" type="text" id="nome-funcionario" name="nome_funcionario"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Cargos </label>
            <select name="cargo_id" class="form-control" >
                <option value="">Selecione um Cargo</option>
                
            </select>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Unidades </label>
            <select name="unidade_id" class="form-control" >
                <option value="">Selecione um Unidade</option>
                <option value="1">Unidade 1</option>
                
            </select>
        </div>    
        <div class="col-lg-4">
            <label for="acesso_id">Permissão</label>
            <select name="acesso_id" class="form-control">
                <option value="0">Selecione um tipo de permissão</option>
            <c:forEach items="${acessos}" var="acesso">
                <option value="${acesso.id}" <c:if test="${acesso.id == cargo.acesso.id}">selected="selected"</c:if> >${acesso.nome}</option>
            </c:forEach>
            </select>
        </div>        
        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-funcionario"/>
        </div>
    </fieldset>
</form>