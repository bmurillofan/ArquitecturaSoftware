/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Package;

import DTO.Servlet.Package.formulario_1;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wezarkeVo
 */
public class mainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private formulario_1 myForm;
 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Assets Shop</title>");            
            out.println("</head>");
            
            out.println("<body>");
     
            out.println("<center>"+"<div>******************* Bienvenido al Asset Shop *******************</div>"+"\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <form name=\"formulario_1\" method=\"POST\">\n" +
            "            <input type=\"text\" name=\"nombre\" placeholder=\"Por favor ingrese su nombre\" required pattern=\"[A-z\\s]{5,}\" title=\"No caracteres especiales, nombre mayores a 5 letras\">\n" +
            "            <br>  <i>Elige un Inmueble</i> <br>        \n" +
            "            <input type=\"radio\" name=\"tipoInmueble\" value=\"150000000\" required checked>Casa 80m² - $150'000.000<br>\n" +
            "            <input type=\"radio\" name=\"tipoInmueble\" value=\"180000000\" required>Casa 100m² - $180'000.000<br>\n" +
            "            <input type=\"radio\" name=\"tipoInmueble\" value=\"130000000\" required>Apto 45² - $130'000.000<br>\n" +
            "            <input type=\"radio\" name=\"tipoInmueble\" value=\"150000000\" required>Apto 60m² - $150'000.000<br>\n "+
            "            <input type=\"text\" name=\"numeroCuotas\" placeholder=\"Numero de cuotas\" required pattern=\"[0-9]{1,}\" title=\"Numeros positivos\"><br>\n" +
            "            <input type=\"text\" name=\"cuotaInicial\" placeholder=\"Cuota inicial\" required pattern=\"[0-9]{1,}\" title=\"Numeros positivos\"><br> \n" +
            "            *********************************************************<br>     \n" +
            "        <input type=\"submit\" value=\"Cargar Datos\">\n" +
            "        </form>\n" +
            "        </center>");
           
 
            
            out.println("<br>");
            out.println("<center>");
            out.println("Bienvenid@ <Strong>"+ myForm.getNombre()+"</Strong> en la siguiente tabla se calculara sus cuotas");
            out.println("<br>");
            out.println("<br>");

            
            double var = myForm.getCastInt();
            double var_1 = myForm.getSaldoActual(var);
            double iteracionDescuento = myForm.getIteracionDescuento(var_1);  
            double valorXCuota = myForm.getValorXCuota(var_1);    
            String Format_1 = new DecimalFormat("#.###############").format(valorXCuota);
            String FormatAll = new DecimalFormat("#.###############").format(iteracionDescuento);
            out.println("<br>Calculo viabilidad: $"+FormatAll+"<br>");
            out.println("  Numero de cuotas  ----------  Valor Cuota ---------- Saldo Pendiente<br><br>");
            
            if (myForm.getCuotas()>myForm.getCastInt()) {
                       out.println("<br>No se permite la cantidad de cuotas, por favor disminuya la cifra<br>");
                }else{
            
            if(myForm.getCuotaInicial()== myForm.getCastInt()){
                myForm.Format_2 = new DecimalFormat("#.###############").format(iteracionDescuento);
                out.println("<br>"+"Se ignoró el numero de cuotas, el pago esta completado<br>");
            }else if(myForm.getCuotaInicial()> myForm.getCastInt()){
                double saldoXExcedido = myForm.getCuotaInicial()- myForm.getCastInt();
                var_1 = myForm.getCuotaInicial()-saldoXExcedido; 
                iteracionDescuento = myForm.getIteracionDescuento(var_1);
                valorXCuota = myForm.getValorXCuota(var_1);    
                String Format_3 = new DecimalFormat("#.###############").format(valorXCuota);
                for (int i = 1; i <= myForm.getCuotas(); i++) {
                iteracionDescuento = iteracionDescuento - valorXCuota; 
                myForm.Format_2 = new DecimalFormat("#.###############").format(iteracionDescuento);
                out.println("<br>"+"Cuota #"+i+"---------- $"+Format_3+" ---------- $"+myForm.Format_2+"<br>");
                 
                }  
                String Format_Temp = new DecimalFormat("#.###############").format(saldoXExcedido);
                out.println("<br>Felicidades! Se le retornara un valor de $"+Format_Temp+" de su cuota inicial<br>");
                
             }else{
                
                        for (int i = 1; i <= myForm.getCuotas(); i++) {
                        iteracionDescuento = iteracionDescuento - valorXCuota; 
                        myForm.Format_2 = new DecimalFormat("#.###############").format(iteracionDescuento);
                        out.println("<br>"+"Cuota #"+i+"---------- $"+Format_1+" ---------- $"+myForm.Format_2+"<br>");
                        }    
                
                
                    
                }
            
            }
            
            
             
            out.println("</center>");
            out.println("</body>");

            out.println("</html>");
            
         
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String tipoInmueble = request.getParameter("tipoInmueble");
        int numeroCuotas = Integer.parseInt(request.getParameter("numeroCuotas"));
        double cuotaInicial = Double.parseDouble(request.getParameter("cuotaInicial"));
        
        myForm = new formulario_1(nombre, numeroCuotas, cuotaInicial, tipoInmueble);
        processRequest(request, response);
        
       
 
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    

}
