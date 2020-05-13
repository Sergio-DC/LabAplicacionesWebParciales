<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Usuarios</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp" %>
    <div class="container mt-3">
      		<H3 class="text-center">Lista Usuarios</H3>
      		
            <form action="" class="">
                <div class="form-group row justify-content-center">
                    <div class="col-4">
                        <input type="text"  placeholder="Ingresa la clave del producto" id="CodigoB" class="form-control" required>
                    </div>
                    <a name="" href="agregar_usuario.jsp" class="btn btn-outline-success btn-lg" onclick="">Nuevo Usuario</a>
                    <!-- <input type="button" name="" class="btn btn-outline-danger btn-lg" onclick="limpiar()" value="Limpiar"> -->
           
                </div>
            </form>
            <div class="row justify-content-center" style="width:100%;">
                <div class="col-10 col-form-label">

                    <!--TABLA PARA DATOS PBP-->
                    <table class="table table-striped" id="table-entrada">
                        <thead class="thead-dark">
                            <tr>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Rol</th>
                                <th>Estatus</th>
                                
                            </tr>
                        </thead>
                        <tbody id="tbody-entrada">

                        </tbody>
                    </table>
                </div>

            </div>
            <div class="form-group row justify-content-center" align="center" style="width:100%;">
                <div class="col-10">
                    <button class="btn btn-outline-danger btn-lg" id="bConsultar">Consultar</button>
                    <br><br>
                    
                </div>
            </div>
    </div>
<script type="text/javascript">
	var bEliminar;
	
    $('#bConsultar').click(function(){
        actualizarInfo();
    });

	function limpiar(){
	  var template = "";
	  $('#tbody-entrada').html(template);
	  $('form').trigger('reset');
	  $('#CodigoB').removeClass('is-valid');
	  $('#CodigoB').removeClass('is-invalid');
	}
	function actualizarInfo() {
	  $.get("consultar_usuarios", function (response, status) {
		  console.log("Pase 3");
		  console.log("Msg: ", response);
	      var registros = genTemplate(response.lista_usuarios);
	
	        $('#tbody-entrada').html(registros);
	    });
	}
	
	function genTemplate(data){
			console.log("template: ", data)
		  try{
			 
		    var registros = '';
		    var a = 5;
		    var b = 10;
		    console.log(`Fifteen is ${a}`);
		    data.forEach(element => {
			      registros += '<tr><td>' + element.user_id + '</td><td>' + element.user_name + '</td>';
			      registros += '<td>' + element.user_rol + '</td><td>' + element.user_status + '</td></tr>';
		    });
		    //console.log("registros: ", registros);
		    return registros;
		
		  }catch(error){
		      return null;//Registro no encontrado
		  }	      
	}
</script>

</body>
</html>