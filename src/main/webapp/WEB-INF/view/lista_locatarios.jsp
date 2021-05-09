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

<div class="container-fluid content">
    <div class="row">
        <div class="col">
            <div class="jumbotron jumbotron-fluid" style="padding: 1rem 2rem !important;">
                <div class="container">
                    <h1 class="display-4">Lista de Locatários</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row j-c-c">
        <div class="col-sm-9 table-responsive">
            <form style="min-height:346px">
                <input id="txtSearch" placeholder="Pesquisa" class="form-control">
                <table id="example" class="display table table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Aluguel</th>
                        <th>Endereço</th>
                        <th>Valor do Aluguel</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>

                    </tr>

                    </tbody>
                    <tfoot>
                    <tr>
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

	// $document.ready(function () {
	// 	$('#btn-addlab').attr("display","none");
	// });

	$('#txtSearch').on('keyup', function() {
		$('#example')
		.DataTable()
		.search($('#txtSearch').val(), false, true)
		.draw();
	});
</script>



</body>
</html>





