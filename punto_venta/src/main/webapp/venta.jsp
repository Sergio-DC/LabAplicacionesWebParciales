<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venta</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

	<div class="container mt-3">
      		<H3 class="text-center">Venta</H3>
      		
            <form action="" class="" id="form1">
                <div class="form-group row justify-content-center">
                    <div class="col-3">
                        <input type="text"  placeholder="Clave" class="form-control" id="clave" required>
                    </div>
                    <div class="col-3">
                        <input type="text"  placeholder="Cantidad" class="form-control" id="cantidad" required>
                    </div>
                    <input type="submit" class="col-3 btn btn-outline-success btn-lg" id="btn_agregar" value="Agregar">
                    <button class="btn btn-outline-danger btn-lg" id="btn_cancelar" onclick="cancelar()">Cancelar</button>
           
                </div>
            </form>
            <div class="row justify-content-center" style="width:100%;">
                <div class="col-10 col-form-label">

                    <!--TABLA PARA DATOS PBP-->
                    <table class="table table-striped" id="table-entrada">
                        <thead class="thead-dark">
                            <tr>
                                <th>Clave</th>
                                <th>Descripción</th>
                                <th>Unidad</th>
                                <th>Cantidad</th>
                                <th>Precio x Unidad</th>
                                <th>Precio Final</th>
                            </tr>
                        </thead>
                        <tbody id="tbody-entrada">
                        </tbody>
                        
                        <div class="row justify-content-around">
                        	<button class="btn btn-warning" id="btn_fin_venta">Finalizar Venta</button>
                        	<div><label>Total: </label><input id="total" type="text" value=0> </input></div>                        	
                        </div>
                    </table>
                </div>

            </div>
    </div>
   
<script type="text/javascript">
		$('#form1').submit(function(event) {
			console.log("Evento: ", event);
			var clave = $('#clave').val();
			var cantidad = $('#cantidad').val();
			var auxTotal = $('#total').val();
			$.ajax({
				type : 'POST',
				url : 'buscar_producto.action',
				data : 'clave=' + clave,
				success : function(data){
					var producto = data.producto;
					producto.cantidad = cantidad;
					producto.precio_final = parseInt(producto.cantidad, 10) * parseInt(producto.precio, 10);
					productoAux = JSON.stringify(producto);
					sessionStorage.setItem(producto.clave, productoAux);
					auxTotal = parseInt(auxTotal,10) + parseInt(producto.precio_final, 10);
					$('#total').val(auxTotal);
					var registro = genTemplate(cantidad);
					$('#tbody-entrada').html(registro);
				}, error : function(data) {
					alert("Some error occured.");
				}
			});
			
			event.preventDefault();
		});
		
		$('#btn_fin_venta').click(function() {
			var auxTotal = $('#total').val();
			
			var aux1;
			var aux2;
			var aux3;
			var aux4;
			var aux5;
			var aux6;
			
			for (var i = 0; i < sessionStorage.length; i++) {
				var index = sessionStorage.key(i);
		        var value = JSON.parse(sessionStorage.getItem(index));
<<<<<<< HEAD
	    		console.log("Valor que envio: ", value);
	    		
=======
		        console.log(value);
		        
		        aux1 = value.clave;
		        aux2 = value.descripcion;
		        aux3 = value.unidad;
		        aux4 = value.cantidad;
		        aux5 = value.precio;
		        aux6 = value.precio_final;
		       
		        
>>>>>>> 94bcd697a745d30cc44072c113de69ab4b712578
		        $.ajax({
					type : 'POST',
					url : 'registrar_venta.action',
					data : 'producto_venta=' + value,
					data : "producto_venta.clave=" + aux1 + "&producto_venta.descripcion=" + aux2 + "&producto_venta.unidad=" + aux3 + "&producto_venta.cantidad=" + aux4 + "&producto_venta.precio_uni=" + aux5 + "&producto_venta.precio_fin=" + aux6,
					success : function(data){
						console.log("Venta Exitosa");
					}, 
					error : function(data) {
						alert("Some error occured.");
					}
				});		        
		        
			}
			
			
			
			
		});
		
	function cancelar() {
		$('#clave').val("");
		$('#cantidad').val("");
		sessionStorage.clear();
		$('#tbody-entrada').empty();
		swal("Venta Cancelada", "", "error");
		
	}
		
	
	function genTemplate(cantidad){
		$('#tbody-entrada').html();
		  try{
		    var registro = '';
		    
		    for (var i = 0; i < sessionStorage.length; i++) {
		        var index = sessionStorage.key(i);
		        var value = JSON.parse(sessionStorage.getItem(index));
		        console.log("value: " + value.descripcion);
		        registro += '<tr><td>' + value.clave + '</td><td>' + value.descripcion + '</td>';
		      	registro += '<td>' + value.unidad + '</td><td>' + value.cantidad + '</td>';
			    registro += '<td>' + value.precio + '</td><td>' + value.precio_final + "</td></tr>";
		    }		    
			//Actualizar Precio Total
		    return registro;
		
		  }catch(error){
			  console.log(error);
		      return null;//Registro no encontrado
		  }	      
	}
</script>

</body>
</html>