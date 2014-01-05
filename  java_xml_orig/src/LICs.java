import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LICs")
@XmlAccessorType(XmlAccessType.FIELD)
public class LICs {
	@XmlElement(name = "LIC", type = LIC.class)
	List<LIC> lic;

	public static void main(String[] args) {

	}

	public List<LIC> getLic() {
		return lic;
	}

	public void setLic(List<LIC> lic) {
		this.lic = lic;
	}

}
