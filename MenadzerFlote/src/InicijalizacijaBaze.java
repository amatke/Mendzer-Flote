import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tipPodatka.TipPodatakaGume;
import tipPodatka.TipPodatkaKazne;
import tipPodatka.TipPodatkaVozaca;
import tipPodatka.TipPodatkaVozila;

public class InicijalizacijaBaze {

	public static void main(String[] args) {
		TipPodatkaVozila vozilo = new TipPodatkaVozila();

		vozilo.Tablice = "BG 001-AA";
		vozilo.Datum1registVozila = "1995, 01, 28";
		vozilo.DatumIzdavanjaSaobrDozvole = "1994, 01, 28";
		vozilo.PrezimeVlasnika = "MARKO";
		vozilo.ImeVlasnika = "MARKOVIC";
		vozilo.PrebivalisteVlasnika = "BOR";
		vozilo.PrezimeKorisnikaVozila = "MARKOVIC";
		vozilo.ImeKorisnikaVozila = "MARKO";
		vozilo.PrebivalisteKorisnikaVozila = "BOR";
		vozilo.MarkaVozila = "ZASTAVA";
		vozilo.TipVozila = "LIMUZINA";
		vozilo.Model = "101";
		vozilo.BrSasije = "VF1234567890";
		vozilo.MaxDozvoljenaMasa = "600kg";
		vozilo.MasaSamogVozila = "800kg";
		vozilo.VazenjeRegistracije = "2015-10-10";
		vozilo.HomologijskaOznaka = "";
		vozilo.RadnaZapreminaMotora = "1.2";
		vozilo.SnagaMotoraUkw = "45";
		vozilo.BrMotora = "MOT1324567890";
		vozilo.VrstaGoriva = "UGALJ";
		vozilo.OdnosSnagaMasa = "";
		vozilo.BrMestaSedenje = "5";
		vozilo.BrMestaStajanje = "0";

		try {																		// upisuje u fajl novo vozilo
			FileOutputStream izlaz = new FileOutputStream("Vozila.baza");
			ObjectOutputStream oos = new ObjectOutputStream(izlaz);
			oos.writeObject(vozilo);
			oos.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		}
		System.out.println("Gotovo vozilo!");
		
/**********************************************************************************************************************************************************/	
	
		TipPodatkaVozaca vozac = new TipPodatkaVozaca();
		
		vozac.Ime = "MARKO";
		vozac.Prezime = "MARKOVIC";
		vozac.Datum = "1988, 05, 25";
		vozac.MestoRodjenja = "BOR";
		vozac.DozvolaVaziDo = "2020, 05, 5";
		vozac.DozvoluIzdao = "PU BOR";
		vozac.BrojDozvole = "123654987";
		vozac.Prebivaliste = "BOR";
		vozac.Kategorije = "B";
		vozac.DozvolaVaziOd = "2010, 05, 5";
		vozac.Ogranicenje = "";
		try {																	// upisuje u fajl nov vozac
			FileOutputStream izlaz = new FileOutputStream("Vozaci.baza");
			ObjectOutputStream oos = new ObjectOutputStream(izlaz);
			oos.writeObject(vozac);
			oos.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		}
		System.out.println("Gotovo vozac!");

/**********************************************************************************************************************************************************/	
		
		TipPodatkaKazne kazna = new TipPodatkaKazne(); 
		
		kazna.Placena = false;
		kazna.Datum = "2015, 01, 26";
		kazna.Iznos = 15000;
		kazna.RokZaRegulisanje = "2015, 02, 25";
		kazna.Tablice = "BG 001-AA";
		kazna.Vrsta = "Prelazak na crveno";
		
		try {																	// upisuje u fajl nove kazne
			FileOutputStream izlaz = new FileOutputStream("Kazne.baza");
			ObjectOutputStream oos = new ObjectOutputStream(izlaz);
			oos.writeObject(kazna);
			oos.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		}
		System.out.println("Gotovo kazne!");
		
/**********************************************************************************************************************************************************/
		
		TipPodatakaGume guma = new TipPodatakaGume();
		
		guma.tablice = "BG 001-AA";
		guma.pDesna = "70";
		guma.pLeva = "70";
		guma.zDesna = "70";
		guma.zLeva = "70";
		
		try {																	// upisuje u fajl novo gume
			FileOutputStream izlaz = new FileOutputStream("Gume.baza");
			ObjectOutputStream oos = new ObjectOutputStream(izlaz);
			oos.writeObject(guma);
			oos.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.exit(1);
		}
		System.out.println("Gotovo gume!");
		
		
	}
}
