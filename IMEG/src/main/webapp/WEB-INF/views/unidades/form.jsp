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
                <option value="1">Cidade 1</option>
                <option value="2">Cidade 2</option>
                <option value="3">Cidade 3</option>
                <option value="4">Cidade 4</option>
                <option value="5">Cidade 5</option>
            </select>
        </div>
        <div class="col-lg-12 form-space">
            <input class="btn btn-button" type="submit" id="commit-unidade"/>
        </div>
    </fieldset>
</form>