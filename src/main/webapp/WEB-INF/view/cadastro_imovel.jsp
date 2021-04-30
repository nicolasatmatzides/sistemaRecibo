<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="assets/css/style.css" rel="stylesheet">
    <title>Sistema de Recibos</title>

</head>
<body>

<div class="container-fluid content">
    <div class="row">
        <div class="col">
            <div class="jumbotron jumbotron-fluid" style="padding: 1rem 2rem !important;">
                <div class="container">
                    <h1 class="display-4">Lista de Imóveis</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="justify-content: center;">
        <div class="col-sm-6">
            <form method="GET" action="/home" id="cadastro-form">
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="endereco">Endereço</label>
                        <input required name="endereco" type="text" class="form-control" id="txtEnd" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="complemento">Complemento</label>
                        <input name="complemento" type="text" class="form-control" id="txtCompl" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="cidade">Cidade</label>
                        <input required name="cidade" type="text" class="form-control" id="txtCid" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="estado">Estado</label>
                        <input required name="estado" type="text" class="form-control" id="txtEst" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="cep">CEP</label>
                        <input required name="cep" type="text" class="form-control" id="txtCep" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="condominio">Condomínio</label>
                        <input required name="condominio" type="number"step="0.01"  class="form-control" id="txtVal" value="">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="impostos">Impostos</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtValImp" value="">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="impostos">Nome do Locador</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtNome" value="">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="impostos">CPF do Locador</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtCpf" value="">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="impostos">Nome do Locatario</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtNomeLocatario" value="">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="impostos">Email</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtEmail" value="">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="impostos">Valor do Aluguel</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtValAl" value="">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="impostos">Telefone</label>
                        <input required name="impostos" type="text"  class="form-control" id="txtTel" value="">
                    </div>
                </div>

                <button type="button" type="submit" id="btnVai" class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo">
                    Salvar
                </button>
            </form>
        </div>
    </div>


</div>

</div>

<footer style="padding: 0.5rem 0;color: #999;text-align: center;background-color: #f9f9f9;border-top: .05rem solid #e5e5e5;width: 100%;margin-top:10px;bottom:0;">
    <p>Sistema de Recibos</p>
</footer>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>

<script>
	$('.gera-recibo').click(function(e) {
		document.getElementById('gerar-recibo').value = e.target.id;
		document.getElementById('geraRecibo').submit();
	});

	$(document).ready(function() {

	    $("#btnVai").click(function() {
	        let formData = { };

            console.log(formData);

	        $.ajax({
              type: "POST",
              url: "/adicionaImovel?endereco=" + $("#txtEnd").val()
                    + "&complemento=" + $("#txtCompl").val()
                    + "&cidade=" + $("#txtCid").val()
                    + "&estado=" + $("#txtEst").val()
                    + "&cep=" + $("#txtCep").val()
                    + "&valorCondominio=" + $("#txtVal").val()
                    + "&valorImpostos=" + $("#txtValImp").val()
                    + "&nomeLocador=" + $("#txtNome").val()
                    + "&cpfLocador=" + $("#txtCpf").val()
                    + "&nomeLocatario=" + $("#txtNomeLocatario").val()
                    + "&email=" + $("#txtEmail").val()
                    + "&valorAluguel=" + $("#txtValAl").val()
                    + "&telefone=" + $("#txtTel").val(),
              data: formData,
              success: function() {
                console.log("Imovel adicionado");
                location.reload();
              },
              dataType: "json",
            });
	    });
	});
</script>
</body>
</html>
