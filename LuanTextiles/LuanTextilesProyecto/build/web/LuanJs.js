/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  bandera = true;
  bandera_cerrar_sesion = true;
   indiceU = 0;
   indiceP = 0;
function Despliega(id,padre){
    if(bandera === true){
       var conte = document.getElementsByClassName(padre);
            conte[0].style.display="block";
       document.getElementById(id).style.display="block";
         bandera = false;
     }
     else{
        var conte = document.getElementsByClassName(padre);
            conte[0].style.display="none"; 
        document.getElementById(id).style.display="none";
         bandera = true; 
     }
    }
 function DespliegaCS(){
     if(bandera_cerrar_sesion === true){       
         document.getElementById("cerrarsesion").style.marginLeft ="80px";
         bandera_cerrar_sesion = false;
     }
     else{
         document.getElementById("cerrarsesion").style.marginLeft ="0px";
         bandera_cerrar_sesion = true;
     }

 }

function getInput(type, placeholder,clase,name){
  var nodo = document.createElement("input");
  nodo.type = type;
  nodo.placeholder = placeholder;
  nodo.className = clase;
  nodo.name = name;
  nodo.required ="";
  return nodo;
}
function getInputU(type, placeholder,clase,name){
  indiceU=indiceU+1;
  var nodo = document.createElement("input");
  nodo.type = type;
  nodo.placeholder = placeholder;
  nodo.className = clase;
  nodo.name = name;
  nodo.setAttribute("onkeyup","Calsubtotal('"+indiceU+"')");
  return nodo;
}
function getInputP(type, placeholder,clase,name){
  indiceP=indiceP+1;
  var nodo = document.createElement("input");
  nodo.type = type;
  nodo.placeholder = placeholder;
  nodo.className = clase;
  nodo.name = name;
  nodo.setAttribute("onkeyup","Calsubtotal('"+indiceP+"')");
  return nodo;
}
function getSelect(clase){
    var nodoSelect = document.createElement("select");
    nodoSelect.className = clase; 
    nodoSelect.name ="categoriacbx";
    var opciones =["categoria" , "poleras","chompas","abrigos"];
    
    for(var i=0;i < opciones.length;i++){
    var nodoOption = document.createElement("option");
    var nodoTexto = document.createTextNode(opciones[i]);
    nodoOption.appendChild(nodoTexto);
    nodoOption.value=opciones[i];
    nodoSelect.appendChild(nodoOption);
    }
    
    return nodoSelect;
}

function append(className, nodoToAppend){
  var nodo = document.getElementsByClassName(className)[0];
  nodo.appendChild(nodoToAppend);
}

/*ESTE ES EL CODIGO Q SE SUPONE DEBERIA  AGREGAR LAS CAJAS DE TEXTO */
function Agregaitems(){
    var nodo7 = getSelect("cbx");
    var nodo1 = getInputU("number", "unid", "datos-pedido unidades prueba","unidades");
    var nodo2 = getInputP("number", "pre", "datos-pedido precio-unitario prueba","precioUni");
    var nodo3 = getInput("date", "fecha de entrega", "datos-pedido fecha-entrega prueba","fechaEntrega");
    var nodo4 = getInput("text", "detalles", "datos-pedido detalles prueba","detalles");
    var nodo5 = getInput("number", "total", "datos-pedido total prueba","subTotal");
    append("cont-lista-pedido-hijo", nodo7);
    append("cont-lista-pedido-hijo", nodo1);
    append("cont-lista-pedido-hijo", nodo2);
    append("cont-lista-pedido-hijo", nodo3);
    append("cont-lista-pedido-hijo", nodo4);
    append("cont-lista-pedido-hijo", nodo5);
  }
  /**/

function Calsubtotal(indice){
     var subtotal =0;
     var unidades = document.getElementsByClassName("unidades");
     var precio = document.getElementsByClassName("precio-unitario");
     var resultado =  document.getElementsByClassName("total");
     subtotal = unidades[indice].value * precio[indice].value;
     resultado[indice].value = subtotal.toFixed(2);
    /*alert( "el subtotal es :"+subtotal + " del indice :"+indice);*/
     CalTotal();
     
}
function CalTotal(){
    var total = document.getElementsByClassName("lbl-A");
    var totaljsp = document.getElementById("totaljsp");
    var pretotal = 0;
    var subtotales = document.getElementsByClassName("total");
    var lengthTotales = subtotales.length;
    for (var i = 0 ; i < lengthTotales; i++){
        r = subtotales[i].value;
        if(r ===''){
            r=0;
            pretotal = pretotal + parseFloat(r);
        }
        else {
            pretotal = pretotal + parseFloat(r);
        }     
        
    }
    total[0].innerHTML ="S/"+pretotal;
    totaljsp.value =pretotal;
    /*alert(" si ");*/
    
}
