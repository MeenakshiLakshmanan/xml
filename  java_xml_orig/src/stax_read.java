import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class stax_read {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LIC lic = null;
		ArrayList<LIC> al = new ArrayList<LIC>();
		FileInputStream f = new FileInputStream("src/policy1.xml");

		XMLInputFactory xml = XMLInputFactory.newInstance();
		XMLStreamReader reader = xml.createXMLStreamReader(f);
		reader.next();

		while (reader.hasNext()) {
			int event = reader.next();

			if (event == XMLEvent.START_ELEMENT) {

				String elem = reader.getName().toString();

				if (elem.equals("LIC")) {
					lic = new LIC();
					al.add(lic);
				} else if (elem.equals("phone")) {
					lic.setPhone(reader.getElementText());
				} else if (elem.equals("name")) {
					
					lic.setName(reader.getElementText());
				}else if (elem.equals("date")) {
					Date d =new SimpleDateFormat("yyyy/MM/dd").parse(reader.getElementText());
					lic.setDate(d);
				}

			}

		}

		for (LIC l : al) {
			System.out.println(l);
		}

	}

}
