/**
 * 
 */

function validarFormularios(form){
	
	var dato;
	
	dato = form.usuario;
	if(dato.value == ""){
		alert("Debe ingresar el usuario!");
		return false;
	}
	
	dato = form.password;
	if(dato.value == ""){
		alert("Debe ingresar una contraseña!");
		return false;
	}
	
	dato = form.tecnologia;
	var i;
	var check = false;
	
	for(i = 0; i < dato.length; i++){
		if(dato[i].checked){
			check = true;
		}
	}
	
	if(!check){
		alert("Debe seleccionar alguna tecnologia");
		return false;
	}
	
	
	dato = form.genero;
	check = false;
	
	for(i = 0; i < dato.length; i++){
		if(dato[i].checked){
			check = true;
		}
	}
	
	if(!check){
		alert("Debe seleccionar algun genero");
		return false;
	}
	
	dato = form.comentarios;
	if(dato.value == ""){
		alert("Debe agregar algun comnetario");
		return false;
	}
	
}