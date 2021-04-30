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
  <h1>Adicionar Imovel e Locador</h1>
  <form action="/home">
    <input type="text" placeholder="Endereco" id="txtEnd" class="form-control"/>
    <input type="text" placeholder="Complemento" id="txtCompl" class="form-control"/>
    <input type="text" placeholder="Cidade" id="txtCid" class="form-control"/>
    <input type="text" placeholder="Estado" id="txtEst" class="form-control"/>
    <input type="text" placeholder="Cep" id="txtCep" class="form-control"/>
    <input type="text" placeholder="Valor do Condominio" id="txtVal" class="form-control"/>
    <input type="text" placeholder="Valor dos Impostos" id="txtValImp" class="form-control"/>

    <input type="text" placeholder="Nome do Locador" id="txtNome" class="form-control"/>
    <input type="text" placeholder="CPF do Locador" id="txtCpf" class="form-control"/>

    <input type="text" placeholder="Nome do Locatario" id="txtNomeLocatario" class="form-control"/>
    <input type="text" placeholder="Email" id="txtEmail" class="form-control"/>
    <input type="text" placeholder="Valor do Aluguel" id="txtValAl" class="form-control"/>
    <input type="text" placeholder="Telefone" id="txtTel" class="form-control"/>
    <button type="submit" class="btn btn-primary" id="btnVai">Vai</button>
  </form>
  <hr>
  <h1>Imoveis</h1>
  <ul id='lstImoveis'>

  </ul>
</div>

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

	    $.get( "/listarImovel", function( data ) {
	        innerHtml = ""
	        data.forEach(function(imovel) {
	            innerHtml += "<li>" + imovel.id + " - " + imovel.endereco + "</li>"
	        });
          $( "ul" ).html( innerHtml );
        });

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
              },
              dataType: "json",
            });
	    });
	});
</script>

</body>
</html>
