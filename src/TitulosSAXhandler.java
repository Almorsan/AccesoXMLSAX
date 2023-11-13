
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TitulosSAXhandler extends DefaultHandler {

    private String etiqueta;

    public TitulosSAXhandler() {
        etiqueta = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (etiqueta.equals("Titulo")) {
            String titulo = new String(ch, start, length);
            titulo = titulo.replaceAll("[\t\n]", "").trim(); //.trim() elimina los espacios en blanco al principio y al final de una cadena
            if (!titulo.isEmpty()) {
                System.out.print(titulo + ", ");
            }
        } else if (etiqueta.equals("Autor")) {
            String autor = new String(ch, start, length);
            System.out.println(autor.trim());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Libro")) {
            etiqueta = "Libro";

        } else if (qName.equals("Titulo")) {
            etiqueta = "Titulo";
        } else if (qName.equals("Autor")) {
            etiqueta = "Autor";
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("LISTADO DE TITULOS");
        System.out.println("==================");
    }

}
