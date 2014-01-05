import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class stax_write {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LICs lics = new LICs();
		List<LIC> al = new ArrayList<LIC>();
		LIC lic[] = new LIC[5];

		for (int i = 0; i < 5; i++) {
			lic[i] = new LIC();
		}

		lic[0].setName("Meena");
		lic[0].setPhone("8971833672");
		lic[0].setDate(new Date("2013/02/23"));
		lic[1].setName("Malar");
		lic[1].setPhone("9843621675");
		lic[1].setDate(new Date("2010/12/20"));
		lic[2].setName("Priya");
		lic[2].setPhone("9945623451");
		lic[2].setDate(new Date("2001/06/11"));
		al.add(lic[0]);
		al.add(lic[1]);
		al.add(lic[2]);

		FileOutputStream f = new FileOutputStream("src/policy1.xml");

		XMLOutputFactory xml = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = xml.createXMLStreamWriter(f);

		writer.writeStartDocument();
		writer.writeStartElement("LICs");
		for (LIC i : al) {
			writer.writeStartElement("LIC");
			writer.writeStartElement("name");
			writer.writeCharacters(i.getName());
			writer.writeEndElement();
			writer.writeStartElement("phone");
			writer.writeCharacters(i.getPhone());
			writer.writeEndElement();
			writer.writeStartElement("date");
			writer.writeCharacters(new SimpleDateFormat("yyyy/MM/dd").format(i.getDate()));
			writer.writeEndElement();
			writer.writeEndElement();
		}
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.flush();
		writer.close();

	}

}
