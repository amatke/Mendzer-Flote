package tipPodatka;

import java.io.Serializable;


public class TipPodatkaKazne implements Serializable {		//serijalizovanje...


	private static final long serialVersionUID = 1L;

	public boolean Placena;
	public  String Vrsta;
	public String Datum;
	public int Iznos;
	public String RokZaRegulisanje;
	public String Tablice;
	
	public TipPodatkaKazne(){
		
	}
	
}
