<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Formulario simple</title>
</head>


<body>
	<div class="container">
		<H3 class="text-center m-5">Agregar Producto</H3>
		
		<div class="row justify-content-center">
			<form id="form-producto" action="" class="">
			  <div class="form-group">
					<label for="nombre">Clave del Producto:</label>
					<input type="text" class="form-control " placeholder="1121" id="clave">			  
			  </div>
			  <div class="form-group">
					<label for="pwd">Descripcion:</label>
					<input type="text" class="form-control" placeholder="Descripcion" id="descripcion">
			  </div>
			  <div class="form-group">				
						<label for="mail">Unidad de venta:</label>
						<div class="input-group mb-2 mr-sm-2">
							<input type="text" class="form-control" placeholder="Pza" id="unidad">
							<div class="input-group-append">
								<div class="input-group-text">@example.com</div>
							</div>
				  		</div>
			  </div>
			  
			  <div class="form-group">
					<label for="pwd">Inventario:</label>
					<input type="text" class="form-control" placeholder="55" id="inventario">
			  </div>
			  
			  <div class="form-group">
					<label for="pwd">Precio de Venta:</label>
					<input type="text" class="form-control" placeholder="$12" id="precio">
			  </div>
			  
			  <input type="submit" onclick="agregarProducto();" value="Enviar datos">
			</form>
		</div>
	</div>
	
<script type="text/javascript">
	function agregarProducto() {
		var clave = $("#clave").val();
		var descripcion = $("#descripcion").val();
		var unidad = $("#unidad").val();
		var inventario = $("#inventario").val();
		var precio = $('#precio').val();
		
		$('#form-producto').submit(function(event) {
			$.ajax({
				type : "POST",
				url : "agregar_producto.action",
				data : "productos.clave=" + clave + "&productos.descripcion=" + descripcion + "&productos.unidad=" + unidad + "&productos.inventario=" + inventario + "&productos.precio=" + precio,
				success : function(data) {
					var ht = data.productos.descripcion;
					console.log("mensaje del server: ", ht);
					//$("#resp").html(ht);
				},
				error : function(data) {
					alert("Some error occured.");
				}
			});
			
			event.preventDefault();
		});
		
		
	}
</script>
</body>
</html>