<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">


    <title>Sistema de Recibos</title>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="index.php">Sistema de Recibos</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" style="justify-content: space-between;" id="conteudoNavbarSuportado">
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Cadastro
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="cadastro">Cadastro</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Imoveis
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="lista_imovel">Lista de Imóveis</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Locadores
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="lista_locador">Lista de Locadores</a>
				</div>
			</li>
			<li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Locatarios
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="lista_locatario">Lista de Locatarios</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Recibos
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="lista_recibo">Lista de recibos</a>
                </div>
            </li>
		</ul>
	</div>
</nav>


<div class="container-fluid content">
    <div class="row">
        <div class="col">
            <div class="jumbotron jumbotron-fluid" style="padding: 1rem 2rem !important;">
                <div class="container">
                    <h1 class="display-4">Lista de Recibos</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row j-c-c">
        <div class="col-sm-9 table-responsive">
            <form style="min-height:346px">
                <table id="example" class="display table table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Nome do Locatario</th>
                        <th>Inicio do Contrato</th>
                        <th>Fim do Contrato</th>
                        <th>Nome do Locador</th>
                        <th>Valor do Condominio</th>
                        <th>Valor do Aluguel</th>
                        <th>Impostos</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                    <tfoot>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </tfoot>
                </table>
            </form>
        </div>
    </div>

</div>

</div>
<footer style="padding: 0.5rem 0;color: #999;text-align: center;background-color: #f9f9f9;border-top: .05rem solid #e5e5e5;width: 100%;">
    <p>Sistema de Recibos</p>
</footer>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js" integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g==" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


<script>
    $(document).ready(function() {
        $('#example').DataTable( {
            "pageLength": 10,
            "dom":'t<"toolbar"><"aftertb col-sm-5"i><"aftertb col-sm-7"p>',
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
            },
            "initComplete": function(settings, json) {

            }
        } );
    } );

	$(document).ready(function() {

    	    $.get( "/listarRecibos", function( data ) {
    	        innerHtml = ""
    	        data.forEach(function(recibo) {
    	            var inicio = recibo.imovel.locatario.inicioContrato.substring(0, 10);
    	            var fim = recibo.imovel.locatario.fimContrato.substring(0, 10);
    	            innerHtml += "<tr><td>" + recibo.imovel.locatario.name + "</td><td>" + inicio + "</td><td>" + fim + "</td><td>" + recibo.imovel.locador.nome + "</td><td>" + recibo.imovel.valorCondominio + "</td><td>" + recibo.imovel.valorAluguel + "</td><td>" + recibo.imovel.valorImpostos + "</td></tr>"
    	        });
              $( "tbody" ).html( innerHtml );
            });
    });
</script>
</body>
</html>





