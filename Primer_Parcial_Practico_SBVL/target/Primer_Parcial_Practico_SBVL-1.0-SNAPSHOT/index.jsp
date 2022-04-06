<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Sesion"%>
<%
    ArrayList<Sesion> lista=(ArrayList<Sesion>)session.getAttribute("liRegist");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <table border="1">
            <tr>
                <td>
                    <label> <center> PRIMER PARCIAL TEM-742 </center> </label>
            <br>
            <label><center>Nombre: Sergio Boris Viscarra Llapaco </center> </label>
            <br>
            <label>Carnet: 9884317</label>
                </td>
            </tr>
        </table>
        <br>
        <br>
    <center><h1>PRODUCTOS</h1></center>
        <a href="MainController?op=nuevo">Nuevo Producto</a>
        
        <br>
        <br>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <%
                if(lista!=null){
                    for(Sesion item : lista){
                
            %>
                
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getDescripcion()%></td>
                <td><%=item.getCantidad()%></td>
                <td><%=item.getPrecio()%></td>
                <td><%=item.getCategorias()%></td>
           
               
                <td><a href="MainController?op=editar&id=<%=item.getId()%>">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=<%=item.getId()%>"
                       onclick="return confirm('Esta seguro de eliminar ');">Eliminar</a></td>
       
            </tr>
            <%
                      } 

                    }
            %>
              
    </body>
</html>
