<form action="produtos" method="post">
    <div class="col-lg-6 form-space">
        <label for="">Nome do Produto</label>
        <input class="form-control" type="text" id="nome-produto" name="nome-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Preço de Custo</label>
        <input class="form-control" type="text" id="preco-custo-produto" name="preco-custo-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Preço de Venda</label>
        <input class="form-control" type="text" id="preco-venda-produto" name="preco-venda-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Quantidade Mínima</label>
        <input class="form-control" type="text" id="qtd-min-produto" name="qtd-min-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Quantidade Máxima</label>
        <input class="form-control" type="text" id="qtd-max-produto" name="qtd-max-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Saldo </label>
        <input class="form-control" type="text" id="saldo-produto" name="saldo-produto"/>
    </div>
    <div class="col-lg-3 form-space">
        <label for="">Categoria </label>
        <select name="categoria-id" class="form-control" >
            <option value="">Selecione uma Categoria</option>
            <option value="1">Categoria 1</option>
            <option value="2">Categoria 2</option>
            <option value="3">Categoria 3</option>
            <option value="4">Categoria 4</option>
            <option value="5">Categoria 5</option>
        </select>
    </div>
    <div class="col-lg-12 form-space">
        <input class="btn btn-button" type="submit" id="commit-produto"/>
    </div>
    
</form>