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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tipPodatka.TipPodatakaGume;
import tipPodatka.TipPodatkaVozila;

public class Gume extends JPanel {

	private static final long serialVersionUID = 1L;

	public Gume(final JFrame tatko) {
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		
		JPanel pnlGornji = new JPanel();
		JPanel pnlDonji = new JPanel();
		
		this.add(pnlGornji, BorderLayout.NORTH);
		this.add(pnlDonji, BorderLayout.SOUTH);
		
		pnlGornji.setLayout(new GridLayout(5, 2));
		pnlDonji.setLayout(new BorderLayout());
		
		TipPodatkaVozila vozilo = new TipPodatkaVozila();
		List<String> listaTablice = new ArrayList<String>();
		
		FileInputStream ulaz;
		ObjectInputStream ois = null;
		try {
			ulaz = new FileInputStream("Vozila.baza");
			ois = new ObjectInputStream(ulaz);
			while (true) {
				vozilo = (TipPodatkaVozila) ois.readObject();
				listaTablice.add(vozilo.Tablice);
			}
			
		}
		catch (EOFException eof) {
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(tatko, e.getMessage()+"1");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(tatko, e.getMessage()+"2");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(tatko, e.getMessage()+"3");
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(tatko, e.getMessage()+"4");
			}
		}
		
		final String[] simpleListaTablice = new String[listaTablice.size()];
		listaTablice.toArray(simpleListaTablice); 
		
		JLabel lblTablice = new JLabel("Tablice");
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox cmbTablice = new JComboBox(simpleListaTablice);
		
		JLabel lblpDesna = new JLabel("Prednja desna");
		JTextField tekstPDesna = new JTextField();
		
		JLabel lblpLeva = new JLabel("Prednja leva");
		final JTextField tekstPLeva = new JTextField();
		
		JLabel lblzDesna = new JLabel("Zadnja leva");
		final JTextField tekstzDesna = new JTextField();
		
		JLabel lblzLeva = new JLabel("Zadnja leva");
		final JTextField tekstzLeva = new JTextField();
		
		JButton dugme = new JButton("Snimi");
		
		dugme.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				TipPodatakaGume tipPodatakaGume = new TipPodatakaGume();	
				
				tipPodatakaGume.tablice = simpleListaTablice[cmbTablice.getSelectedIndex()];
				tipPodatakaGume.pDesna = tekstPLeva.getText();
				tipPodatakaGume.pLeva = tekstPLeva.getText();
				tipPodatakaGume.zDesna = tekstzDesna.getText();
				tipPodatakaGume.zLeva = tekstzLeva.getText();
				
				File fi = new File("Gume.baza");
				
				FileOutputStream izlaz;
				try {
					
					if (fi.exists()) {
						izlaz = new FileOutputStream("Gume.baza",true);
						AppendingObjectOutputStream oos = new AppendingObjectOutputStream(izlaz);
						oos.writeObject(tipPodatakaGume);
						oos.close();
					} 
					else {
						izlaz = new FileOutputStream("Gume.baza");
						ObjectOutputStream oos = new ObjectOutputStream(izlaz);
						oos.writeObject(tipPodatakaGume);
						oos.close();
					}
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(tatko, e1.getMessage());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(tatko, e1.getMessage());
				}
					
				JOptionPane.showMessageDialog(tatko, "Sacuvano!");
			}
		});
		
		pnlGornji.add(lblTablice);
		pnlGornji.add(cmbTablice);
		pnlGornji.add(lblpDesna);
		pnlGornji.add(tekstPDesna);
		pnlGornji.add(lblpLeva);
		pnlGornji.add(tekstPLeva);
		pnlGornji.add(lblzDesna);
		pnlGornji.add(tekstzDesna);
		pnlGornji.add(lblzLeva);
		pnlGornji.add(tekstzLeva);
		
		pnlDonji.add(dugme);
			
	}
}
