package mojeKlase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tipPodatka.TipPodatkaKazne;
import tipPodatka.TipPodatkaVozila;

public class Izvestaj extends JPanel{

	private static final long serialVersionUID = 1L;

	public Izvestaj(final Frame tatko) {
		setVisible(false);
		this.setLayout(new BorderLayout());
		
		JPanel pnlGornji = new JPanel();
		final JPanel pnlDonji = new JPanel();
		this.add(pnlDonji, BorderLayout.SOUTH);
		this.add(pnlGornji, BorderLayout.NORTH);
		pnlGornji.setLayout(new FlowLayout());
		pnlDonji.setLayout(new FlowLayout());
		
		JTextArea ispisNaEkranu = new JTextArea("");
		ispisNaEkranu.setBackground(Color.LIGHT_GRAY);
		pnlDonji.add(ispisNaEkranu);
		
		List<String> listaTablica = new ArrayList<String>();		// array listaTablica 
		TipPodatkaVozila vozilo = new TipPodatkaVozila();
		
		FileInputStream ulaz;										//	citanje TABLICA iz fajla Vozilo.baza
		ObjectInputStream ois = null;
		try {
			ulaz = new FileInputStream("Vozila.baza");	
			ois = new ObjectInputStream(ulaz);
			while(true){
				vozilo = (TipPodatkaVozila) ois.readObject();
				
			listaTablica.add(vozilo.Tablice);	
			System.out.println(listaTablica);
			}
			
							// punjenje listeTablica sa svim tablicama iz Vozila.baza
			
		} catch(EOFException e1){
			
		}catch (FileNotFoundException e1) {		
			JOptionPane.showMessageDialog(tatko, "izveestaj4: " + e1.getMessage());
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(tatko, "izveestaj5: " + e1.getMessage());
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(tatko, "izveestaj6: " + e1.getMessage());
		}
		finally{
			try {
				ois.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(tatko, "izveestaj7: " + e1.getMessage());
			}
		}

		final String[] simpleListaTablice = new String[listaTablica.size()];		// primitivna lista
		listaTablica.toArray(simpleListaTablice); 									// konvertovanje array liste(sa objektima) u primitivnu simplelistu, koja sadrzi sve tablice
		
		JLabel lblTablice = new JLabel("Tablice");								
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox cmbTablice = new JComboBox(simpleListaTablice);
		JButton dugme = new JButton("Kreiraj izvestaj");
		
		pnlGornji.add(lblTablice);
		pnlGornji.add(cmbTablice);
		
		
		dugme.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {				//  na klik Kreiraj izvestaj radi sledece: 
				pnlDonji.setVisible(true);					
				
				FileInputStream ulaz;
				ObjectInputStream ois = null;
				TipPodatkaKazne kazna = new TipPodatkaKazne();
				try {
					ulaz = new FileInputStream("Kazne.baza");		// cita SVE kazne iz kazne.baza
					ois = new ObjectInputStream(ulaz);
					
					while(true){
						
						kazna = (TipPodatkaKazne) ois.readObject();
						
						if(kazna.Tablice.toLowerCase().trim().equals(simpleListaTablice[cmbTablice.getSelectedIndex()].toLowerCase().trim())) {		// ako odabrane TABLICAME iz comboboxa POSTOJE U KAZNAMA, onda se ISPISUJE NA EKRAN IZVESTAJ 
							//System.out.println(kazna.Tablice);
							
							ispisNaEkranu.append("Placena/Neplacena kazna: ");
							if (kazna.Placena) {	
								ispisNaEkranu.append("Placeno\n");								
							}
							else {
								ispisNaEkranu.append("Nije placeno\n");
							}
							ispisNaEkranu.append("Datum izdavanja: ");
							ispisNaEkranu.append(kazna.Datum+"\n");
							ispisNaEkranu.append("Iznos u dinarima: ");
							ispisNaEkranu.append(String.valueOf(kazna.Iznos)+" din\n");
							ispisNaEkranu.append("Rok za regulisanje: ");
							ispisNaEkranu.append(kazna.RokZaRegulisanje+"\n");
							ispisNaEkranu.append("---------------------------------------------------------------------------------------");
						}	
					}	
				} catch (EOFException eof){} 
				 catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(tatko, "izveestaj1: " + e1.getMessage());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(tatko, "izveestaj2: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(tatko, "izveestaj3: " + e1.getMessage());
				}
				finally{
					try {
						ois.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(tatko, "izveestaj4: " + e1.getMessage());
					}
				}
			}
		});
		pnlGornji.add(dugme);
		
	}
}
