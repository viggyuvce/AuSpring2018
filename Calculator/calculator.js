var string = "";

function updateString(elem){
	string+=elem;
	document.getElementById("q").value = string;
	let result = eval(string);
	
	document.getElementById("a").value = result;
}

function pop(){
	string = ""
	document.getElementById("q").value = string;
	document.getElementById("a").value = string;
}

function changeSign(){
	let currentChar = string.slice(-1);
	console.log(currentChar);
	console.log(string);
}