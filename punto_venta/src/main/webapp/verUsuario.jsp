<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Alta Producto</title>
</head>


<body>
	<%@include file="navbar.jsp" %>
	<div class="container mt-3">
		<H3 class="text-center">Alta Usuario</H3>
		
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

	
<script type="text/javascript">
	$(document).ready(function() {
		var user_id = getUrlVars()['user_id'];
		console.log("Y el valor es: " + user_id);
		
		$.ajax({
			type : "POST",
			url : "buscarUsuario.action",
			data : "auxUserId=" + user_id,
			success : function(data) {
				var usuario = data.usuarios;
				console.log("usuario: ", usuario);
				$('#usuario').val(usuario.user_id);
				$('#nombre').val(usuario.user_name);
				$('#pass').val(usuario.user_password);
				$('#rol').val(usuario.user_rol);
				$('#estatus').val(usuario.user_status);
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
</script>
</body>
</html>