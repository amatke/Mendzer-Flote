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

import tipPodatka.TipPodatkaVozaca;

public class DodajVozaca extends JPanel {

	private static final long serialVersionUID = 1L;

	public DodajVozaca(final JFrame tatko) {
		setLayout(new BorderLayout()); // omogucava nam slaganje prema stranama  sveta (sever,jug,centar...)			
		setVisible(false);

		JPanel pnlGornjji = new JPanel();
		JPanel pnlDonji = new JPanel();

		this.add(pnlGornjji, BorderLayout.NORTH);
		this.add(pnlDonji, BorderLayout.SOUTH);

		pnlGornjji.setLayout(new GridLayout(12, 2));

		JLabel labelaIme = new JLabel("Ime ");
		final JTextField tekstIme = new JTextField();

		JLabel labelaPrezime = new JLabel("Prezime ");
		final JTextField tekstPrezime = new JTextField();

		JLabel labelaDatum = new JLabel("Datum vozaca ");
		final JTextField tekstDatum = new JTextField();

		JLabel labelaMestoRodjenja = new JLabel("Mesto rodjenja ");
		final JTextField tekstMestoRodjenja = new JTextField();

		JLabel labelaDozvolaVaziDo = new JLabel("Dozvola vazi do ");
		final JTextField tekstDozvolaVaziDo = new JTextField();

		JLabel labelaDozvoluIzdao = new JLabel("Dozvolu izdao ");
		final JTextField tekstDozvoluIzdao = new JTextField();

		JLabel labelaBrojDozvole = new JLabel("Broj dozvole ");
		final JTextField tekstBrojDozvole = new JTextField();

		JLabel labelaPrebivaliste = new JLabel("Prebivaliste vozaca ");
		final JTextField tekstPrebivaliste = new JTextField();

		JLabel labelaKategorije = new JLabel("Kategorije ");
		final JTextField tekstKategorije = new JTextField();

		JLabel labelaDozvolaVaziOd = new JLabel("Dozvola vazi od ");
		final JTextField tekstDozvolaVaziOd = new JTextField();

		JLabel labelaOgranicenje = new JLabel("Ogranicenje ");
		final JTextField tekstOgranicenje = new JTextField();

		JButton dgmDodajVozaca = new JButton("Dodaj ");

		pnlGornjji.add(labelaIme);
		pnlGornjji.add(tekstIme);
		pnlGornjji.add(labelaPrezime);
		pnlGornjji.add(tekstPrezime);
		pnlGornjji.add(labelaDatum);
		pnlGornjji.add(tekstDatum);
		pnlGornjji.add(labelaMestoRodjenja);
		pnlGornjji.add(tekstMestoRodjenja);
		pnlGornjji.add(labelaDozvolaVaziOd);
		pnlGornjji.add(tekstDozvolaVaziOd);
		pnlGornjji.add(labelaDozvolaVaziDo);
		pnlGornjji.add(tekstDozvolaVaziDo);
		pnlGornjji.add(labelaDozvoluIzdao);
		pnlGornjji.add(tekstDozvoluIzdao);
		pnlGornjji.add(labelaBrojDozvole);
		pnlGornjji.add(tekstBrojDozvole);
		pnlGornjji.add(labelaPrebivaliste);
		pnlGornjji.add(tekstPrebivaliste);
		pnlGornjji.add(labelaKategorije);
		pnlGornjji.add(tekstKategorije);
		pnlGornjji.add(labelaOgranicenje);
		pnlGornjji.add(tekstOgranicenje);

		pnlDonji.add(dgmDodajVozaca);

		dgmDodajVozaca.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {													// ISPITIVANJE PRAVILNOG POPUNJAVANJA POLJA
				if (tekstIme.getText().trim().equals("") || tekstIme.getText().trim().equals(null) 									
					|| tekstPrezime.getText().trim().equals("") || tekstPrezime.getText().trim().equals(null)
					|| tekstBrojDozvole.getText().trim().equals("")	|| tekstBrojDozvole.getText().trim().equals(null)) {

					JOptionPane.showConfirmDialog(tatko, "Niste ispravno popunili polja!");
				} 
				else {
					boolean postoji = false;
					ObjectInputStream ois = null;
					try {
						FileInputStream izlaz = new FileInputStream("Vozaci.baza"); 			// citanje iz Vozaci.baza
						TipPodatkaVozaca vozaciTest = new TipPodatkaVozaca();
						while (true) {
							ois = new ObjectInputStream(izlaz);
							vozaciTest = (TipPodatkaVozaca) ois.readObject();
							if (vozaciTest.BrojDozvole.trim().equals(
								tekstBrojDozvole.getText().trim())) { 					// provera da li dati brDozvole vec postoji u bazi									
								postoji = true;
							}
						}
					} catch (EOFException eof) {
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(tatko, e1.getMessage());
						System.exit(ERROR);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} finally {
						try {
							ois.close();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(tatko,e1.getMessage());
							System.exit(ERROR);
						}
					}

					if (postoji) {
						JOptionPane.showMessageDialog(tatko, "Vozac sa unetom dozvolom vec postoji u bazi!");
					} 
					else {
						TipPodatkaVozaca noviVozac = new TipPodatkaVozaca(); // instanca
																				// vozaca
						noviVozac.Ime = tekstIme.getText().trim(); // punjenje podataka									
						noviVozac.Prezime = tekstPrezime.getText().trim();
						noviVozac.Datum = tekstDatum.getText();
						noviVozac.MestoRodjenja = tekstMestoRodjenja.getText();
						noviVozac.DozvolaVaziDo = tekstDozvolaVaziDo.getText().trim();
						noviVozac.DozvoluIzdao = tekstDozvoluIzdao.getText().trim();
						noviVozac.BrojDozvole = tekstBrojDozvole.getText().trim();
						noviVozac.Prebivaliste = tekstPrebivaliste.getText().trim();
						noviVozac.Kategorije = tekstKategorije.getText().trim();
						noviVozac.DozvolaVaziOd = tekstDozvolaVaziOd.getText().trim();
						noviVozac.Ogranicenje = tekstOgranicenje.getText().trim();

						File fa = new File("Vozaci.baza");
						ObjectOutputStream oos = null;
						
						try {
							if (fa.exists()) {
								FileOutputStream ulaz = new FileOutputStream("Vozaci.baza", true); // upisivanje vozaca u Vozaci.txt
								oos = new AppendingObjectOutputStream(ulaz);
								oos.writeObject(noviVozac);
								oos.close();
							} 
							else {
								FileOutputStream ulaz = new FileOutputStream("Vozaci.baza"); // upisivanje vozaca u Vozaci.txt
								oos = new ObjectOutputStream(ulaz);
								oos.writeObject(noviVozac);
								oos.close();
							}

						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(tatko,e1.getMessage());
							System.exit(ERROR);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(tatko,e1.getMessage());
							System.exit(ERROR);
						}

						JOptionPane.showMessageDialog(tatko, "Uspesno ste uneli vozaca!");

						tekstIme.setText(""); // posle unetog vozaca se prazne polja (jtextfield)
						tekstPrezime.setText("");
						tekstDatum.setText("");
						tekstMestoRodjenja.setText("");
						tekstDozvolaVaziDo.setText("");
						tekstDozvoluIzdao.setText("");
						tekstBrojDozvole.setText("");
						tekstPrebivaliste.setText("");
						tekstKategorije.setText("");
						tekstDozvolaVaziOd.setText("");
						tekstOgranicenje.setText("");

					}
				}
			}
		});

	}
}
