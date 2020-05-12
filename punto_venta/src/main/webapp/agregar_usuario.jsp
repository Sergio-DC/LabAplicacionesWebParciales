<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Alta Usuario</title>
</head>


<body>
	<div class="container">
		<H3 class="text-center m-5">Alta Usuario</H3>
		
		<div class="row justify-content-center">
			<form id="form-producto" action="" class="">
			  <div class="form-group">
					<label for="nombre">Usuario:</label>
					<input type="text" class="form-control " placeholder="1234" id="usuario">			  
			  </div>
			  <div class="form-group">
					<label for="pwd">Nombre:</label>
					<input type="text" class="form-control" placeholder="" id="nombre">
			  </div>
			  
			  <div class="form-group">
					<label for="pwd">Password:</label>
					<input type="password" class="form-control" placeholder="" id="pass">
			  </div>
			  <div class="form-group">
				  <label for="pwd">Rol:</label>
				  <select class="custom-select" id="rol">
					  <option selected>Open this select menu</option>
					  <option value="1">Administrador</option>
					  <option value="2">Ventas</option>
				  </select>
			  </div>
			  
			  <div class="form-group">
				  <label for="pwd">Estatus:</label>
				  <select class="custom-select" id="estatus">
					  <option selected>Open this select menu</option>
					  <option value="1">Activo</option>
					  <option value="2">Inactivo</option>
				  </select>
			  </div>
			  
			  <input class="btn btn-outline-success" type="submit" onclick="agregarProducto();" value="Agregar Usuario">
			</form>
		</div>
	</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	function agregarProducto() {
		var usuario = $("#usuario").val();
		var nombre = $("#nombre").val();
		var password = $('#pass').val();
		var rol = $("#rol").val();
		var estatus = $("#estatus").val();
		
		console.log("nombre: ", nombre);
		
		
		$('#form-producto').submit(function(event) {
			$.ajax({
				type : "POST",
				url : "agregar_usuario.action",
				data : "usuario.user_id=" + usuario + "&usuario.user_name=" + nombre + "&usuario.user_password=" + password + "&usuario.user_rol=" + rol + "&usuario.user_status=" + estatus,
				success : function(data) {
					var mensaje = data;
					console.log("mensaje del server: ", mensaje);
					swal("Usuario Registrado", nombre, "success");
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