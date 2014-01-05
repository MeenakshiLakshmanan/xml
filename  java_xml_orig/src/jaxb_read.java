import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class jaxb_read {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxb = JAXBContext.newInstance(LICs.class);
		Unmarshaller m = jaxb.createUnmarshaller();
		File f = new File("src/policy1.xml");

		LICs lic = (LICs) m.unmarshal(f);
		List<LIC> al = lic.getLic();

		for (LIC temp : al) {
			System.out.println(temp + " ");

			int next = temp.getDate().getMonth() + 1 + 3;
			for (int i = 0; i < 3; i++) {
				next = (next > 12) ? next % 12 : next;
				if (next == 3) {
					System.out.println("Matching for March:" + temp.getName());
				}
				next = next + 3;
			}

		}

	}

}
