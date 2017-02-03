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
import java.util.Map;

/**
 * Created by sbt-vasyukov-sv on 01.02.2017.
 */
public class Course {
    private Map<String, Float> rate;
    private String code;
    private String url;

    public Course() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void load() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(url);
            NodeList records = document.getElementsByTagName("Record");
            for (int i = 0; i < records.getLength(); i++) {
                String dateRate=records.item(i).getAttributes().getNamedItem("Date").getNodeValue();

                Node record  = records.item(i);
                if(record instanceof Element) {
                    Element concreteRecord = (Element)record;
                    System.out.println(concreteRecord);
                    String  rate = concreteRecord.getElementsByTagName("Value").item(0).getNodeValue();
                    System.out.println(dateRate);
                    System.out.println(concreteRecord.getElementsByTagName("Value").item(0));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
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
