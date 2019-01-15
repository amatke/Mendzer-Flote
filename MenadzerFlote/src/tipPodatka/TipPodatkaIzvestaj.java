package tipPodatka;

import java.io.Serializable;


public class TipPodatkaIzvestaj implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public String IzvestajIme;
	public String IzvestajPrezime;				// PODACI VOZACA
	public String IzvestajBrojDozvole;
	public String IzvestajPrebivaliste;
	
	public boolean Placena;
	public  String IzvestajVrsta;			// PODACI KAZNE
	public String IzvestajDatumIVreme;
	public Integer IzvestajIznos;
	public String IzvestajRokZaRegulisanje;
	public String IzvestajTablice;
	
	public TipPodatkaIzvestaj(){
		
	}
}
