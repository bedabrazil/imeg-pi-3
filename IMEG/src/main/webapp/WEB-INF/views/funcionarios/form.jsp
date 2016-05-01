<form action="funcionarios" method="post">
    <fieldset class="well">
        <div class="col-lg-6 form-space">
            <label for="">Nome do Funcionário</label>
            <input class="form-control" type="text" id="nome-funcionario" name="nome-funcionario"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Cargos </label>
            <select name="cargo-id" class="form-control" >
                <option value="">Selecione um Cargo</option>
                <option value="1">Cargo 1</option>
                <option value="2">Cargo 2</option>
                <option value="3">Cargo 3</option>
                <option value="4">Cargo 4</option>
                <option value="5">Cargo 5</option>
            </select>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Unidades </label>
            <select name="cargo-id" class="form-control" >
                <option value="">Selecione um Unidade</option>
                <option value="1">Unidade 1</option>
                <option value="2">Unidade 2</option>
                <option value="3">Unidade 3</option>
                <option value="4">Unidade 4</option>
                <option value="5">Unidade 5</option>
            </select>
        </div>    
        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-funcionario"/>
        </div>
    </fieldset>
</form>