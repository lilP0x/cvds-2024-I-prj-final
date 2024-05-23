package co.edu.eci.cvds.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class PdfController {

    @GetMapping("/pdf/generate")
    public ResponseEntity<byte[]> generatePdf() {
 
        String htmlContent = constructHtmlContent(); 

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

    private String constructHtmlContent() {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html><head><title>Tu Cotización</title></head><body>");
        htmlContent.append("<h1>Tu Cotización</h1>");
        htmlContent.append("<table>");
        htmlContent.append("<thead><tr>");
        htmlContent.append("<th>Producto o Servicio</th>");
        htmlContent.append("<th>Calidad</th>");
        htmlContent.append("<th>Impuesto Unitario</th>");
        htmlContent.append("<th>Precio Unitario</th>");
        htmlContent.append("<th>Precio Total</th>");
        htmlContent.append("</tr></thead>");
        htmlContent.append("<tbody>");


        // Aquí van los datitos 
        htmlContent.append("<tr><td>Producto A</td><td>Calidad del producto</td><td>15</td><td>$100,000.00</td><td>$100,015.00</td></tr>");
        htmlContent.append("<tr><td>Producto B</td><td>Calidad del producto</td><td>18</td><td>$200,000.00</td><td>$200,018.00</td></tr>");
        htmlContent.append("<tr><td>Producto C</td><td>Calidad del producto</td><td>12</td><td>$250,000.00</td><td>$250,012.00</td></tr>");
        htmlContent.append("</tbody>");
        htmlContent.append("<tfoot>");
        htmlContent.append("<tr><td colspan='4'>Subtotal</td><td>$550,000.00</td></tr>");
        htmlContent.append("<tr><td colspan='4'>Impuesto Total</td><td>$45.00</td></tr>");
        htmlContent.append("<tr><td colspan='4'>Cotización</td><td>$550,045.00</td></tr>");
        htmlContent.append("</tfoot>");
        htmlContent.append("</table>");
        htmlContent.append("<div>");
        htmlContent.append("<button onclick='devolverse()'>Devolverse al carrito de compra</button>");
        htmlContent.append("<button onclick='generarPDF()'>Finalizar Cotización</button>");
        htmlContent.append("</div>");
        htmlContent.append("<script>");
        htmlContent.append("function devolverse() { window.location.href = '/carrito'; }");
        htmlContent.append("function generarPDF() { window.location.href = '/pdf/generate'; }");
        htmlContent.append("</script>");
        htmlContent.append("</body></html>");

        return htmlContent.toString();
    }
}