<form enctype="application/x-www-form-urlencoded" action="produtos" method="post">
    <fieldset class="well"> 
        <div class="col-lg-3 form-space">
            <label for="">Preço de Custo</label>
            <input class="form-control" type="text" id="preco_custo_produto" name="preco_custo_produto"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Preço de Venda</label>
            <input class="form-control" type="text" id="preco_venda_produto" name="preco_venda_produto"/>
        </div>
        <div class="col-lg-3 form-space">
            <label for="">Categoria </label>
            <select name="categoria_id" class="form-control" >
                <option value="">Selecione uma Categoria</option>
                <option value="1">Categoria 1</option>
                <option value="2">Categoria 2</option>
                <option value="3">Categoria 3</option>
                <option value="4">Categoria 4</option>
                <option value="5">Categoria 5</option>
            </select>
        </div>
        <div class="col-lg-12 form-space">
            <button class="btn btn-button ajax" type="submit" id="commit_produto">Enviar</button>
        </div>
    </fieldset>
    
</form>