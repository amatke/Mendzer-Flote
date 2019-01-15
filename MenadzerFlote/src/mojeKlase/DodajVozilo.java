package mojeKlase;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javax.swing.*;

import tipPodatka.TipPodatkaVozila;

public class DodajVozilo extends JPanel {

	private static final long serialVersionUID = 1L;

	public DodajVozilo(final JFrame tatko) {
		setVisible(false);
		setLayout(new BorderLayout()); // da bismo mogli da imamo panele ...sever jug zapad istok...				

		JPanel pnlGornjji = new JPanel();
		JPanel pnlDonji = new JPanel();

		this.add(pnlGornjji, BorderLayout.NORTH);
		this.add(pnlDonji, BorderLayout.SOUTH);

		pnlGornjji.setLayout(new GridLayout(24, 2));

		JLabel labelaTablice = new JLabel("Broj tablica ");
		final JTextField tekstTablice = new JTextField();

		JLabel labelaDatum1registVozila = new JLabel("Datum prvog registrovanja vozila ");
		final JTextField tekstDatum1registVozila = new JTextField();

		JLabel labelaDatumIzdavanjaSaobrDozvole = new JLabel(
				"Datum izdavanja saobracajne dozvole ");
		final JTextField tekstDatumIzdavanjaSaobrDozvole = new JTextField();

		JLabel labelaPrezimeVlasnika = new JLabel("Prezime vlasnika ");
		final JTextField tekstPrezimeVlasnika = new JTextField();

		JLabel labelaImeVlasnika = new JLabel("Ime vlasnika ");
		final JTextField tekstImeVlasnika = new JTextField();

		JLabel labelaPrebivalisteVlasnika = new JLabel("Prebivaliste vlasnika ");
		final JTextField tekstPrebivalisteVlasnika = new JTextField();

		JLabel labelaPrezimeKorisnikaVozila = new JLabel("Prezime korisnika ");
		final JTextField tekstPrezimeKorisnikaVozila = new JTextField();

		JLabel labelaImeKorisnikaVozila = new JLabel("Ime korisnika ");
		final JTextField tekstImeKorisnikaVozila = new JTextField();

		JLabel labelaPrebivalisteKorisnikaVozila = new JLabel("Prebivaliste korisnika ");
		final JTextField tekstPrebivalisteKorisnikaVozila = new JTextField();

		JLabel labelaMarkaVozila = new JLabel("Marka vozila ");
		final JTextField tekstMarkaVozila = new JTextField();

		JLabel labelaTipVozila = new JLabel("Tip vozila ");
		final JTextField tekstTipVozila = new JTextField();

		JLabel labelaModel = new JLabel("Model ");
		final JTextField tekstModel = new JTextField();

		JLabel labelaBrSasije = new JLabel("Broj sasije ");
		final JTextField tekstBrSasije = new JTextField();

		JLabel labelaBrMotora = new JLabel("Broj motora ");
		final JTextField tekstBrMotora = new JTextField();

		JLabel labelaMaxDozvoljenaMasa = new JLabel("Maksimalna dozvoljena masa ");
		final JTextField tekstMaxDozvoljenaMasa = new JTextField();

		JLabel labelaMasaSamogvozila = new JLabel("Masa samog vozila ");
		final JTextField tekstMasaSamogVozila = new JTextField();

		JLabel labelaVazenjeRegistracije = new JLabel("Vazenje registracije ");
		final JTextField tekstVazenjeRegistracije = new JTextField();

		JLabel labelaHomologijskaOznaka = new JLabel("Homologijska oznaka ");
		final JTextField tekstHomologijskaOznaka = new JTextField();

		JLabel labelaRadnaZapreminaMotora = new JLabel("Radna zapremina motora ");
		final JTextField tekstRadnaZapreminaMotora = new JTextField();

		JLabel labelaSnagaMotoraUkw = new JLabel("Snaga motora u kw ");
		final JTextField tekstSnagaMotoraUkw = new JTextField();

		JLabel labelaVrstaGoriva = new JLabel("Vrsta goriva ");
		final JTextField tekstVrstaGoriva = new JTextField();

		JLabel labelaOdnosSnagaMasa = new JLabel("Odnos snage i mase ");
		final JTextField tekstOdnosSnagaMasa = new JTextField();

		JLabel labelaBrMestaSedenje = new JLabel("Broj mesta za sedenje ");
		final JTextField tekstBrMestaSedenje = new JTextField();

		JLabel labelaBrMesteStajanje = new JLabel("Broje mesta za stajanje ");
		final JTextField tekstBrMestaStajanje = new JTextField();

		JButton dugmePotvrda = new JButton("Potvrda");

		pnlGornjji.add(labelaTablice);
		pnlGornjji.add(tekstTablice);
		pnlGornjji.add(labelaDatum1registVozila);
		pnlGornjji.add(tekstDatum1registVozila);
		pnlGornjji.add(labelaDatumIzdavanjaSaobrDozvole);
		pnlGornjji.add(tekstDatumIzdavanjaSaobrDozvole);
		pnlGornjji.add(labelaImeVlasnika);
		pnlGornjji.add(tekstImeVlasnika);
		pnlGornjji.add(labelaPrezimeVlasnika);
		pnlGornjji.add(tekstPrezimeVlasnika);
		pnlGornjji.add(labelaPrebivalisteVlasnika);
		pnlGornjji.add(tekstPrebivalisteVlasnika);
		pnlGornjji.add(labelaImeKorisnikaVozila);
		pnlGornjji.add(tekstImeKorisnikaVozila);
		pnlGornjji.add(labelaPrezimeKorisnikaVozila);
		pnlGornjji.add(tekstPrezimeKorisnikaVozila);
		pnlGornjji.add(labelaPrebivalisteKorisnikaVozila);
		pnlGornjji.add(tekstPrebivalisteKorisnikaVozila);
		pnlGornjji.add(labelaMarkaVozila);
		pnlGornjji.add(tekstMarkaVozila);
		pnlGornjji.add(labelaTipVozila);
		pnlGornjji.add(tekstTipVozila);
		pnlGornjji.add(labelaModel);
		pnlGornjji.add(tekstModel);
		pnlGornjji.add(labelaBrMotora);
		pnlGornjji.add(tekstBrMotora);
		pnlGornjji.add(labelaBrSasije);
		pnlGornjji.add(tekstBrSasije);
		pnlGornjji.add(labelaMaxDozvoljenaMasa);
		pnlGornjji.add(tekstMaxDozvoljenaMasa);
		pnlGornjji.add(labelaMasaSamogvozila);
		pnlGornjji.add(tekstMasaSamogVozila);
		pnlGornjji.add(labelaVazenjeRegistracije);
		pnlGornjji.add(tekstVazenjeRegistracije);
		pnlGornjji.add(labelaHomologijskaOznaka);
		pnlGornjji.add(tekstHomologijskaOznaka);
		pnlGornjji.add(labelaRadnaZapreminaMotora);
		pnlGornjji.add(tekstRadnaZapreminaMotora);
		pnlGornjji.add(labelaSnagaMotoraUkw);
		pnlGornjji.add(tekstSnagaMotoraUkw);
		pnlGornjji.add(labelaVrstaGoriva);
		pnlGornjji.add(tekstVrstaGoriva);
		pnlGornjji.add(labelaOdnosSnagaMasa);
		pnlGornjji.add(tekstOdnosSnagaMasa);
		pnlGornjji.add(labelaBrMestaSedenje);
		pnlGornjji.add(tekstBrMestaSedenje);
		pnlGornjji.add(labelaBrMesteStajanje);
		pnlGornjji.add(tekstBrMestaStajanje);

		pnlDonji.add(dugmePotvrda);
		dugmePotvrda.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) { // PROVERA POLJA- DA LI SU PRAVILNO POPONJUNA
														
				if (tekstTablice.getText().trim().equals("")
						|| tekstTablice.getText().trim().equals(null)
						|| tekstBrSasije.getText().trim().equals("")
						|| tekstBrSasije.getText().trim().equals(null)
						|| tekstBrMotora.getText().trim().equals("")
						|| tekstBrMotora.getText().trim().equals(null)) {

					JOptionPane.showMessageDialog(tatko, "Niste pravilno popunili polja!");
				}

				else {

					Boolean Postoji = false;
					TipPodatkaVozila voziloTest = new TipPodatkaVozila();
					ObjectInputStream ois = null;

					try {
						FileInputStream ulaz = new FileInputStream("Vozila.baza");			 // samo u serijalizabilnom fajlu mozemo da upisujemo u objekat
						while (true) {
							ois = new ObjectInputStream(ulaz);
							voziloTest = (TipPodatkaVozila) ois.readObject(); 					// citanja iz fajla i smestanje u VoziloTest
					
							if (voziloTest.Tablice.trim().equals(tekstTablice.getText().trim()) 			// provera da li ovzilo postoji u bazi
								|| voziloTest.BrSasije.trim().equals(tekstBrSasije.getText().trim())
								|| voziloTest.BrMotora.trim().equals(tekstTablice.getText().trim())) {

								Postoji = true;			// vozilo postoji u bazi
							}
						}

					} catch (EOFException eof) {					// pokupi null sa bafera. ovo mora da ne bi pukao program!
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(tatko, e1.getMessage());
						System.exit(ERROR);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
						System.exit(ERROR);
					} finally {
						try {
							ois.close();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(tatko,
									e1.getMessage());
						}
					}

					if (Postoji) {
						JOptionPane.showMessageDialog(tatko, "Duplirali ste vozilo!");
					}

					else if (!Postoji) { 											// SKUPLJANJE PODATaKA - PUNJENJE
						TipPodatkaVozila voziloUpis = new TipPodatkaVozila();

						voziloUpis.Tablice = tekstTablice.getText();
						voziloUpis.Datum1registVozila = tekstDatumIzdavanjaSaobrDozvole.getText().trim();
						voziloUpis.DatumIzdavanjaSaobrDozvole = tekstDatumIzdavanjaSaobrDozvole.getText().trim();
						voziloUpis.PrezimeVlasnika = tekstPrezimeVlasnika.getText();
						voziloUpis.ImeVlasnika = tekstImeVlasnika.getText();
						voziloUpis.PrebivalisteVlasnika = tekstPrebivalisteVlasnika.getText();
						voziloUpis.PrezimeKorisnikaVozila = tekstPrezimeKorisnikaVozila.getText();
						voziloUpis.ImeKorisnikaVozila = tekstImeKorisnikaVozila.getText();
						voziloUpis.PrebivalisteKorisnikaVozila = tekstPrebivalisteKorisnikaVozila.getText();
						voziloUpis.MarkaVozila = tekstMarkaVozila.getText();
						voziloUpis.TipVozila = tekstTipVozila.getText();
						voziloUpis.Model = tekstModel.getText();
						voziloUpis.BrSasije = tekstBrSasije.getText();
						voziloUpis.MaxDozvoljenaMasa = tekstMaxDozvoljenaMasa.getText();
						voziloUpis.MasaSamogVozila = tekstMasaSamogVozila.getText();
						voziloUpis.VazenjeRegistracije = tekstVazenjeRegistracije.getText();
						voziloUpis.HomologijskaOznaka = tekstHomologijskaOznaka.getText();
						voziloUpis.RadnaZapreminaMotora = tekstRadnaZapreminaMotora.getText();
						voziloUpis.SnagaMotoraUkw = tekstSnagaMotoraUkw	.getText();
						voziloUpis.BrMotora = tekstBrMotora.getText();
						voziloUpis.VrstaGoriva = tekstVrstaGoriva.getText();
						voziloUpis.OdnosSnagaMasa = tekstOdnosSnagaMasa.getText();
						voziloUpis.BrMestaSedenje = tekstBrMestaSedenje.getText();
						voziloUpis.BrMestaStajanje = tekstBrMestaStajanje	.getText();

						File f = new File("Vozila.baza");

						try { 				// UPISIVANJE novog vozila U FAJL Vozilo.baza
																		// ako je fajl vec napravljen(nije prazan) onda pomocu apending klase nastavi da pises dalje
							if (f.exists()) {							//  (ne prepisujuci preko postojeceg objekta)
								FileOutputStream izlaz = new FileOutputStream("Vozila.baza", true);
								AppendingObjectOutputStream oos = new AppendingObjectOutputStream(izlaz);
								oos.writeObject(voziloUpis);
								//oos.flush();
								oos.close();
								System.out.println("Appen");
							} else {
								FileOutputStream izlaz = new FileOutputStream("Vozila.baza");
								ObjectOutputStream oos = new ObjectOutputStream(izlaz);
								oos.writeObject(voziloUpis);
								//oos.flush();
								oos.close();
							}
						} catch (FileNotFoundException e1) {							
							JOptionPane.showMessageDialog(tatko,e1.getMessage());
							System.exit(ERROR);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(tatko, e1.getMessage());
							System.exit(ERROR);
						}

						JOptionPane.showMessageDialog(tatko, "Uspesno ste uneli vozilo sa "	+ voziloUpis.Tablice + " tablicama.");
					}
				}
			}
		});

	}
}
