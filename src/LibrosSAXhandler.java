
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler {

    int contador = 0;

    public LibrosSAXhandler() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        if (qName.equals("Libro")) {
            contador++;
            System.out.println("Libro n�: " + contador + "\n");
            System.out.println("Publicado en: " + atts.getValue(atts.getQName(0))); //extrae el primer atributo
        } else if (qName.equals("Titulo")) {
            System.out.print("\n " + "El t�tulo es: ");//a�n no sabemos c�al es el t�tulo, eso lo sabremos en el evento characters

        } else if (qName.equals("Autor")) {
            System.out.print("\n " + "El autor es: ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Libro")) {
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", "");//quita todos los tabuladores
        car = car.replaceAll("\n", "");
        System.out.println(car);
    }

}
