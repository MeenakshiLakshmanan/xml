import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class jaxb_write {

	/**
	 * @param args
	 * @throws JAXBException
	 */
	public static void main(String[] args) throws JAXBException {
		LICs lics = new LICs();
		List<LIC> al = new ArrayList<LIC>();
		LIC lic[] = new LIC[10];

		for (int i = 0; i < 10; i++) {
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

		lics.setLic(al);

		File f = new File("src/policy1.xml");
		JAXBContext jaxb = JAXBContext.newInstance(LICs.class);

		Marshaller m = jaxb.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		m.marshal(lics, f);

		System.out.println("Written into file");

	}

}
