package tipPodatka;

import java.io.Serializable;


public class TipPodatkaVozaca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String Ime;
	public String Prezime;
	public String Datum;
	public String MestoRodjenja;
	public String DozvolaVaziOd;
	public String DozvolaVaziDo;
	public String DozvoluIzdao;
	public String BrojDozvole;
	public String Prebivaliste;
	public String Kategorije;
	public String Ogranicenje;
	
	public TipPodatkaVozaca() {}
	
}
