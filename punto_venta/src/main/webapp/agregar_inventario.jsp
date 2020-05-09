<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="text-center m-5">Agregar Inventario</h3>
		<div class="row justify-content-center">
			<form class="" action="" id="buscar-form">			
				<div class="form-group row">				
					<div class="input-group mb-2 mr-sm-2 col-12">
						<div class="">
							<input type="text" class="form-control" placeholder="Clave" id="clave">
						</div>
						<div class="input-group-append">
							<input type="submit" value="buscar">
						</div>
			  		</div>
		  		</div>
		  		
	  			<div class="form-group row" id="actualizar-form">
		  			<label class="col-4">Descripcion</label>
		  			<div class="col-6">
		  				<p id="descripcion">Jabon</p>
		  			</div>
	  			</div>
	  			<div class="form-group row">
		  			<label class="col-4">Unidad</label>
		  			<div class="col-6" id="unidad">
		  				<p>PZA</p>
		  			</div>
	  			</div>
		 </form>		
  		</div>
  		<div class="row justify-content-center">
  			<form action="" class="row" id="form-actualizar">
			 	<div class="form-group row">				
					<div class="input-group mb-2 mr-sm-2 col-12">
						<div class="">
							<input type="text" class="form-control" placeholder="Cantidad de Entrada" id="cantidad">
						</div>
						<div class="input-group-append">
							<button>Agregar</button>
						</div>
			  		</div>
	  			</div>
		 	</form>	
		 		
  		</div>
		<div class="row justify-content-center" >
  			<div id="message"></div>
		</div>
  		
	</div>
<script type="text/javascript">
		
		$('#buscar-form').submit(function(event) {
			var clave = $('#clave').val();
			$.ajax({
				type : "POST",
				url: "buscar_producto.action",
				data : "clave=" + clave,
				success : function(data) {
					var producto = data.producto
					console.log("Data :): ", data.producto)
					//Pintar Datos obtenidos del server en el html
					$('#descripcion').text(producto.descripcion);
					$('#unidad').text(producto.unidad);
				},
				error: function (data) {
					alert("Some error occured.");
				}
			});
			event.preventDefault();
		});
		
		$('#form-actualizar').submit(function(event){
			var clave = $('#clave').val();
			var cantidad = $('#cantidad').val();
			$.ajax({
				type: 'POST',
				url: 'actualizar_producto_inventario.action',
				data: 'clave=' + clave + '&cantidad=' + cantidad,
				success : function(data) {
					console.log("Actualizacion Exitosa: ", data);
					$('#message').html(data);
				},
				error: function (data) {
					alert("Some error occured.");
				}
			});
			
			event.preventDefault();
		});
</script>  
</body> 
</html> 
