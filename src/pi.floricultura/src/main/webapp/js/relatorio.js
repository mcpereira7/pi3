function inputDateNow(id) {
	
	var now = new Date();
	
	var day = ("0" + now.getDate()).slice(-2);
	var month = ("0" + (now.getMonth() + 1)).slice(-2);
	var hoje = now.getFullYear()+"-"+(month)+"-"+(day)
	
	document.getElementById(id).setAttribute("value", hoje);
}