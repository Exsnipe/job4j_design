package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;
import java.io.StringReader;

public class AirplaneXml {
    public static void main(String[] args) throws Exception {
        Airplane airplane = new Airplane("an-2", 4000,
                false, new Crew(2), new int[] {5, 8, 2, 9, 4});
        JAXBContext jaxbContext = JAXBContext.newInstance(Airplane.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(airplane, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Airplane result = (Airplane) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
