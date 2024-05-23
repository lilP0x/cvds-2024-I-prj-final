package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Product;
import co.edu.eci.cvds.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PdfController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/pdf/generate")
    public ResponseEntity<byte[]> generatePdf() {

        List<Product> productosEnCarrito = carritoService.getProductosEnCarrito();
        String htmlContent = constructHtmlContent(productosEnCarrito);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder().withHtmlContent(htmlContent, null);
        try {
            builder.toStream(outputStream);
            builder.run();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al generar el PDF".getBytes(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "cotizacion.pdf");

        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }

    private String constructHtmlContent(List<Product> productosEnCarrito) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html><head><title>Tu Cotización</title></head><body style=\"margin: 20px;\">");
        htmlContent.append("<h1 style=\"margin-bottom: 20px;\">Tu Cotización</h1>");
        htmlContent.append("<table style=\"width: 100%; border-collapse: collapse; margin-top: 20px;\">");
        htmlContent.append("<thead><tr>");
        htmlContent.append("<th style=\"border: 1px solid #000; padding: 10px;\">Producto o Servicio</th>");
        htmlContent.append("<th style=\"border: 1px solid #000; padding: 10px;\">Calidad</th>");
        htmlContent.append("<th style=\"border: 1px solid #000; padding: 10px;\">Impuesto Unitario</th>");
        htmlContent.append("<th style=\"border: 1px solid #000; padding: 10px;\">Precio Unitario</th>");
        htmlContent.append("<th style=\"border: 1px solid #000; padding: 10px;\">Precio Total</th>");
        htmlContent.append("</tr></thead>");
        htmlContent.append("<tbody>");
    
        double subtotal = 0;
        double impuestoTotal = 0;
        for (Product producto : productosEnCarrito) {
            double precioUnitario = producto.getValor();
            double impuestoUnitario = producto.getImpuesto();
            double precioTotal = precioUnitario + impuestoUnitario;
            htmlContent.append("<tr>");
            htmlContent.append("<td style=\"border: 1px solid #000; padding: 10px;\">").append(producto.getNombre()).append("</td>");
            htmlContent.append("<td style=\"border: 1px solid #000; padding: 10px;\">Calidad del producto</td>");
            htmlContent.append("<td style=\"border: 1px solid #000; padding: 10px;\">").append(impuestoUnitario).append("</td>");
            htmlContent.append("<td style=\"border: 1px solid #000; padding: 10px;\">").append(precioUnitario).append("</td>");
            htmlContent.append("<td style=\"border: 1px solid #000; padding: 10px;\">").append(precioTotal).append("</td>");
            htmlContent.append("</tr>");
            subtotal += precioUnitario;
            impuestoTotal += impuestoUnitario;
        }
    
        double cotizacion = subtotal + impuestoTotal;
    
        htmlContent.append("</tbody>");
        htmlContent.append("<tfoot>");
        htmlContent.append("<tr><td colspan='4' style=\"border: 1px solid #000; padding: 10px;\">Subtotal</td><td style=\"border: 1px solid #000; padding: 10px;\">").append(subtotal).append("</td></tr>");
        htmlContent.append("<tr><td colspan='4' style=\"border: 1px solid #000; padding: 10px;\">Impuesto Total</td><td style=\"border: 1px solid #000; padding: 10px;\">").append(impuestoTotal).append("</td></tr>");
        htmlContent.append("<tr><td colspan='4' style=\"border: 1px solid #000; padding: 10px;\">Cotización</td><td style=\"border: 1px solid #000; padding: 10px;\">").append(cotizacion).append("</td></tr>");
        htmlContent.append("</tfoot>");
        htmlContent.append("</table>");
        htmlContent.append("</body></html>");
    
        return htmlContent.toString();
    }
    
}
