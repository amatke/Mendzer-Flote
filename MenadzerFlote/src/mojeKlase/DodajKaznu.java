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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tipPodatka.TipPodatkaKazne;
import tipPodatka.TipPodatkaVozila;

public class DodajKaznu extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public DodajKaznu(final JFrame tatko) {
		this.setVisible(false);
		this.setLayout(new BorderLayout()); 										// ovogucava nam strane sveta

		JPanel pnlGornji = new JPanel();
		JPanel pnlDonji = new JPanel();
		this.add(pnlGornji, BorderLayout.NORTH);
		this.add(pnlDonji, BorderLayout.SOUTH);

		pnlGornji.setLayout(new GridLayout(7, 2)); 									// 7 vrsta po 2 kolone u gornjem panelu

		TipPodatkaVozila vozilo = new TipPodatkaVozila();

		List<String> ListaTablica = new ArrayList<String>();						 // array lista talblica

		ObjectInputStream ois = null;
		try {
			FileInputStream ulaz = new FileInputStream("Vozila.baza"); 				// citanje fajla Vozila.baza
			ois = new ObjectInputStream(ulaz);
			while (true) {
				vozilo = (TipPodatkaVozila) ois.readObject();
				ListaTablica.add(vozilo.Tablice); 									// PUNJENJE listeTablica SASVIM TABLICAMA
			}
		} catch (EOFException eof) { 												// mora nekako da se pokupi EOF; i znaci da je ucitao do kraja fajl
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "KAZNE1: " + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "KAZNE-VOZILO 2: " + e.getMessage());
			System.exit(1);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "KAZNE3: " + e.getMessage());
			System.exit(1);
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "KAZNE4: " + e.getMessage());
				System.exit(1);
			}
		}

		final String[] simpleListaTablica = new String[ListaTablica.size()]; // primitivna lista tablica
		ListaTablica.toArray(simpleListaTablica); // konvertovanje array liste u mprimitivnu listu

		JLabel labelaTablice = new JLabel("Tablice ");
		@SuppressWarnings("unchecked")
		final JComboBox cmbTablice = new JComboBox(simpleListaTablica); 

		JLabel labelaPlacena = new JLabel("Placena ");
		final JCheckBox tekstPlacena = new JCheckBox("", false);

		JLabel labelaLokacija = new JLabel("Lokacija ");
		JTextField tekstLokacija = new JTextField();

		JLabel labelaDatum = new JLabel("Datum ");
		final JTextField tekstDatum = new JTextField();

		JLabel labelaIznos = new JLabel("Iznos ");
		final JTextField tekstIznos = new JTextField();

		JLabel labelaRokZaRegulisanje = new JLabel("Rok za regulisanje ");
		final JTextField tekstRokZaRegulisanje = new JTextField();

		JLabel labelaVrsta = new JLabel("Vrsta");
		final JTextField tekstVrsta = new JTextField();

		pnlGornji.add(labelaTablice);
		pnlGornji.add(cmbTablice);
		pnlGornji.add(labelaPlacena);
		pnlGornji.add(tekstPlacena);
		pnlGornji.add(labelaLokacija);
		pnlGornji.add(tekstLokacija);
		pnlGornji.add(labelaDatum);
		pnlGornji.add(tekstDatum);
		pnlGornji.add(labelaIznos);
		pnlGornji.add(tekstIznos);
		pnlGornji.add(labelaRokZaRegulisanje);
		pnlGornji.add(tekstRokZaRegulisanje);
		pnlGornji.add(labelaVrsta);
		pnlGornji.add(tekstVrsta);

		JButton dgmSnimi = new JButton("Dodaj");

		dgmSnimi.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {

				TipPodatkaKazne novaKazna = new TipPodatkaKazne();

				novaKazna.Tablice = simpleListaTablica[cmbTablice.getSelectedIndex()]; // kreiranje kazni!
				novaKazna.Iznos = Integer.parseInt(tekstIznos.getText().trim());
				novaKazna.Datum = tekstDatum.getText().trim();
				novaKazna.Placena = tekstPlacena.isSelected();
				novaKazna.RokZaRegulisanje = tekstRokZaRegulisanje.getText().trim();
				novaKazna.Vrsta = tekstVrsta.getText();

				File fl = new File("Kazne.baza");

				FileOutputStream izlaz;
				ObjectOutputStream oos = null;
				try {														 // upisivanje kazni u fajl Kazne.baza
					if (fl.exists()) {
						izlaz = new FileOutputStream("Kazne.baza",true);
						oos = new AppendingObjectOutputStream(izlaz);
						oos.writeObject(novaKazna);
						oos.close();
					} 
					else {
						izlaz = new FileOutputStream("Kazne.baza");
						oos = new ObjectOutputStream(izlaz);
						oos.writeObject(novaKazna);
						oos.close();
					}

				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(tatko, "KAZNE2: " + e1.getMessage());
					;
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(tatko, "KAZNE3: " + e1.getMessage());
				}

				JOptionPane.showMessageDialog(tatko, "Sacuvano!");
			}

		});
		pnlDonji.add(dgmSnimi);

	}
}
