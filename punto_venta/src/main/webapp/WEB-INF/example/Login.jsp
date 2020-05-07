<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
    
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Iniciar sesion</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/main-colors.css">
	<script src="../js/jquery-3.4.1.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	
</head>
<body class="color-celeste-dos">
	<div class="container col-12 col-md-6 col-lg-4 text-center">
				
				<h1>Inicia Sesion</h1>
				
	
				<form action="goto_validar_login" class="form_comentarios justify-content-end">
					<div class="form-group justify-content-center">
					<img src="../img/img_avatar1.png" alt="Jane Doe" class="mr-3 mt-5 rounded-circle" style="width:120px;">
					</div>
					<div class="form-group justify-content-center">
					<input type="text" name="usuario.user_id" placeholder="User ID" class="form-control">
					</div>
					<div class="form-group justify-content-center">
					<input type="password" name="usuario.user_pass" placeholder="Password" class="form-control">
					</div>
					<div class="form-group justify-content-center">
					<button type="submit" class="btn btn-primary">Log in</button>
					</div>
						
					
				</form>
		
		
	</div>
</body>
</html>