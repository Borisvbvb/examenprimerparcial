
package com.emergentes.controlador;

import com.emergentes.modelo.Sesion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        
        if(ses.getAttribute("liRegist")==null){
                ArrayList<Sesion>listaux=new ArrayList<Sesion>();
                ses.setAttribute("liRegist", listaux);
            }
        
        ArrayList<Sesion>lista=(ArrayList<Sesion>)ses.getAttribute("liRegist");
        
        
        String op = request.getParameter("op");
       String opcion=(op!=null)?op:"view";
       
      Sesion obj1=new Sesion();
       
       int id,pos;
       
       switch(opcion){
           case"nuevo":
               request.setAttribute("miProd", obj1);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "editar":
               id=Integer.parseInt(request.getParameter("id"));
               pos= buscarIndice(request,id);
               obj1=lista.get(pos);
               request.setAttribute("miProd", obj1);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case"eliminar":     
                id=Integer.parseInt(request.getParameter("id"));
               pos= buscarIndice(request,id);
               lista.remove(pos);
               ses.setAttribute("liRegist", lista);
               response.sendRedirect("index.jsp");
               break;
           case"view":
               response.sendRedirect("index.jsp");
       }

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         HttpSession ses = request.getSession();
        ArrayList<Sesion>lista=(ArrayList<Sesion>)ses.getAttribute("liRegist");
        
        Sesion obj1=new Sesion();
        
        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setDescripcion(request.getParameter("descripcion"));
        obj1.setCantidad(request.getParameter("cantidad"));
        obj1.setCategorias(request.getParameter("categorias"));
        obj1.setPrecio(request.getParameter("precio"));
        
        int idt=obj1.getId();
        
        if(idt==0){

            int ultID;
            ultID=ultimoId(request);
            obj1.setId(ultID);
            ultimoId(request);
            lista.add(obj1);
        }
        else{

            lista.set(buscarIndice(request,idt), obj1);
        }
        ses.setAttribute("liRegist", lista);
        response.sendRedirect("index.jsp");
    }
     private int buscarIndice(HttpServletRequest request,int id){
        HttpSession ses=request.getSession();
        ArrayList<Sesion>lista=(ArrayList<Sesion>)ses.getAttribute("liRegist");
        
        int i=0;
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    private int ultimoId(HttpServletRequest request){
       HttpSession ses=request.getSession();
        ArrayList<Sesion>lista=(ArrayList<Sesion>)ses.getAttribute("liRegist");
        
        int idaux=0;
        for(Sesion item:lista){
            idaux=item.getId();
            
        }
        return idaux+1; 

    }

}
