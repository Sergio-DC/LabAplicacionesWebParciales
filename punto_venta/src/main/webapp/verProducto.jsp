<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Editar Producto</title>
</head>


<body>
	<%@include file="navbar.jsp" %>
	<div class="container mt-3">
		<H3 class="text-center">Editar Producto</H3>
		
		<div class="row justify-content-center">
			<form id="form-producto" action="" class="">
			  <div class="form-group">
					<label for="nombre">Clave del Producto:</label>
					<input type="text" class="form-control" id="clave" readonly>			  
			  </div>
			  <div class="form-group">
					<label for="pwd">Descripcion:</label>
					<input type="text" class="form-control" placeholder="Descripcion" id="descripcion">
			  </div>
			  <div class="form-group">				
						<label for="mail">Unidad de venta:</label>
						<div class="input-group mb-2 mr-sm-2">
							<input type="text" class="form-control" placeholder="Pza" id="unidad">
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
			  
			  <input class="btn btn-outline-success" type="submit" onclick="editarProducto();" value="Editar Producto">
			</form>
		</div>
	</div>
	
<script type="text/javascript">
	$(document).ready(function() {
		var clave = getUrlVars()['clave'];
		console.log("Y el valor es: " + clave);
		
		$.ajax({
			type : "POST",
			url : "buscar_producto.action",
			data : "clave=" + clave,
			success : function(data) {
				var producto = data.producto;
				$('#clave').val(producto.clave);
				$('#descripcion').val(producto.descripcion);
				$('#unidad').val(producto.unidad);
				$('#inventario').val(producto.inventario);
				$('#precio').val(producto.precio);
			},
			error : function(error) {
				console.log("Error: " + error);
			}
		});
		
	});
	
	function getUrlVars()
	{
	    var vars = [], hash;
	    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	    for(var i = 0; i < hashes.length; i++)
	    {
	        hash = hashes[i].split('=');
	        vars.push(hash[0]);
	        vars[hash[0]] = hash[1];
	    }
	    return vars;
	}
	
	function editarProducto() {
		var clave = $("#clave").val();
		var descripcion = $("#descripcion").val();
		var unidad = $("#unidad").val();
		var inventario = $("#inventario").val();
		var precio = $('#precio').val();
		
		$('#form-producto').submit(function(event) {
			$.ajax({
				type : "POST",
				url : "editar_producto.action",
				data : "productos.clave=" + clave + "&productos.descripcion=" + descripcion + "&productos.unidad=" + unidad + "&productos.inventario=" + inventario + "&productos.precio=" + precio,
				success : function(data) {
					swal("Producto Editado", "Exitosamente", "success");	
				},
				error : function(data) {
					swal("Ocurrio un Error", ":(", "error");	
				}
			});
			
			event.preventDefault();
		});	
	}
	
</script>
</body>
</html>