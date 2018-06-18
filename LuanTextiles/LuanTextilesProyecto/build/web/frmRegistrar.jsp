<div class="ventana-registrar" id="ventana-registrar" >
                           <h1>REGISTRAR</h1>
                           <form >
                               <input type="text" placeholder="ingrese un nombre de el cliente" name="nombrecliente" class="datos-cli" id="nomCli" >
                               <div class="cont-lista-pedido">
                                  <div class="cont-lista-pedido-hijo">
                                      
                                      <select class="cbx" name="categoriacbx">
                                       <option value="categoria">categoria</option>
                                       <option value="poleras">poleras</option>
                                       <option value="chompas" >chompas</option>
                                       <option value="abrigos" >abrigos</option>        
                                      </select>
                                      <input type="number" placeholder="unid" name="unidades" min="0" class="datos-pedido unidades" onkeyup="Calsubtotal('0')" required="" >
                                   <input type="number" placeholder="pre" name="precioUni" min="0"class="datos-pedido precio-unitario" onkeyup="Calsubtotal('0')" required="">
                                   <input type="date" placeholder="fecha de entrega" name="fechaEntrega" class="datos-pedido fecha-entrega" required="" >
                                   <input type="text" placeholder="detalles" name="detalles" class="datos-pedido detalles" required="">
                                   <input type="number" placeholder="total" name="subTotal" min="0" class="datos-pedido total " required="">
                                 
                                  </div>                           
                               </div>
                               <label  name="total" class="lbl-A">S/0.0</label>
                               <input type="number"  name="total" id="totaljsp" style="display: none;" value="0">
                               <input type="button" value="Agregar producto" class="datos-pedido more btn" onclick="Agregaitems()">
                             <input type="reset" value="CERRAR" class="datos-pedido more btn" onclick="Despliega('ventana-registrar','padre-ventanas')">
                             <input type="submit" value="GUARDAR PEDIO" class="datos-pedido more btn" id="btnregistrar">
                             
                           </form>
                                </div>