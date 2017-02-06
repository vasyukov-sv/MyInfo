package Impls.CB;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbt-vasyukov-sv on 01.02.2017.
 */
public class Course {
    private final Map<String, Float> rate;
    private String code;
    private String url;

    public Course() {
        rate = new HashMap<String, Float>();
    }

    public void setCode(String code) {
        this.code = code;
    }

    void load() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(url);
            NodeList records = document.getElementsByTagName("Record");
            for (int i = 0; i < records.getLength(); i++) {
                String dateRate = records.item(i).getAttributes().getNamedItem("Date").getNodeValue();
                Node record = records.item(i);
                if (record instanceof Element) {
                    Element concreteRecord = (Element) record;
                    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                    symbols.setDecimalSeparator(',');
                    DecimalFormat format = new DecimalFormat("0.#");
                    format.setDecimalFormatSymbols(symbols);
                    float f = format.parse(concreteRecord.getElementsByTagName("Value").item(0).getTextContent()).floatValue();
                    this.rate.put(dateRate, f);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Course{" +
                "rate=" + rate +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
