import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import mojeKlase.DodajKaznu;
import mojeKlase.DodajVozaca;
import mojeKlase.DodajVozilo;
import mojeKlase.Gume;
import mojeKlase.Izvestaj;
import mojeKlase.MeniDugme;

public class Aplikacija {

	private JFrame frame;
	
	public static void main(String[] args) {
		try {
			Aplikacija window = new Aplikacija();		// kreiranje nove aplikacije
			window.frame.setVisible(true);				// podesavanje frejma na vidljivo
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Aplikacija(){								// Konstruktor za pravljenje aplikacije
		inicijalizuj();
	}

	private void inicijalizuj() {						// Inicijalizacija sadrzaja frejma
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setTitle("Menadzer flote");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("glavna.png")));	
	
		final JTabbedPane TabGlavni = new JTabbedPane(JTabbedPane.TOP);						// glavni tab na kojeg su prikaceni ostali
		TabGlavni.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()-36));
		frame.getContentPane().add(TabGlavni, BorderLayout.NORTH);
		
		JPanel pnlVozila = new JPanel();
		JPanel pnlVozaci = new JPanel();
		JPanel pnlIzvestaj = new JPanel();
		final JPanel pnlPomoc = new JPanel();
		
		final JPanel pnlVozilaMeniBar = new JPanel();				/*MENI BAROVI*/
		final JPanel pnlVozaciMeniBar = new JPanel();
		final JPanel pnlIzvestajMeniBar = new JPanel();
		final JPanel pnlPomocMeniBar = new JPanel();			
		
		final DodajVozilo dodajVozilo = new DodajVozilo(frame);		/*INSTANCE MOJIH KLASA*/
		final DodajKaznu dodajKaznu = new DodajKaznu(frame);
		final DodajVozaca dodajVozaca = new DodajVozaca(frame);
		final Izvestaj izvestaj = new Izvestaj(frame);
		final Gume gumeVozila = new Gume(frame);
		
		TabGlavni.addTab("Vozila", null, pnlVozila, null);
		TabGlavni.addTab("Vozaci", null, pnlVozaci, null);
		TabGlavni.addTab("Izvestaj", null, pnlIzvestaj, null);	
		TabGlavni.addTab("Pomoc", null, pnlPomoc, null);
		
 /********************************************************************************************************************************/		
		pnlVozila.add(pnlVozilaMeniBar);
		pnlVozila.add(dodajVozilo);
		pnlVozila.add(dodajKaznu);
		pnlVozila.add(gumeVozila);
		
		pnlVozilaMeniBar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
		pnlVozilaMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
		pnlVozilaMeniBar.setBackground(Color.GRAY);
 /********************************************************************************************************************************/			
		pnlVozaci.add(pnlVozaciMeniBar);
		pnlVozaci.add(dodajVozaca);

		

		pnlVozaciMeniBar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
		pnlVozaciMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
		pnlVozaciMeniBar.setBackground(Color.GRAY);
		
 /********************************************************************************************************************************/			
		pnlIzvestaj.add(pnlIzvestajMeniBar);
		pnlIzvestaj.add(izvestaj);
		
		pnlIzvestajMeniBar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
		pnlIzvestajMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
		pnlIzvestajMeniBar.setBackground(Color.GRAY);
		
/********************************************************************************************************************************/			
		pnlPomoc.add(pnlPomocMeniBar);
		
		pnlPomocMeniBar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
		pnlPomocMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
		pnlPomocMeniBar.setBackground(Color.GRAY);
/********************************************************************************************************************************/		
		
		MeniDugme dgmVozilaDodavanje = new MeniDugme("Dodaj", "auto.png");
		dgmVozilaDodavanje.addMouseListener(new MouseListener() {			//lisener za dugme dodaj vozilo
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {				
				dodajVozilo.setVisible(true);
				dodajKaznu.setVisible(false);
				gumeVozila.setVisible(false);
			}
		});
		pnlVozilaMeniBar.add(dgmVozilaDodavanje);						// dodavanje dugmeta na meniBar
		
/********************************************************************************************************************************/			
		
		MeniDugme dgmDodavanjeKazne = new MeniDugme("Dodaj kaznu", "upozorenje.png");
		dgmDodavanjeKazne.addMouseListener(new MouseListener() {		// lisener za dugme dodaj kaznu
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				dodajKaznu.setVisible(true);
				gumeVozila.setVisible(false);
				dodajVozilo.setVisible(false);
			}
		});
		pnlVozilaMeniBar.add(dgmDodavanjeKazne);					// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/	

		MeniDugme dgmGumeVozila = new MeniDugme("Gume", "guma.png");	
		dgmGumeVozila.addMouseListener(new MouseListener() {			// lisener za dugme dodaj gume
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				gumeVozila.setVisible(true);
				dodajVozilo.setVisible(false);
				dodajKaznu.setVisible(false);
				
			}
		});	pnlVozilaMeniBar.add(dgmGumeVozila);				// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/
		
		MeniDugme dgmDodajVozaca = new MeniDugme("Dodaj", "dodaj.png");
		dgmDodajVozaca.addMouseListener(new MouseListener() {			//lisener za dugme dodaj vozaca
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				dodajVozaca.setVisible(true);	
			}
		});
		pnlVozaciMeniBar.add(dgmDodajVozaca);						// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/
	
		
		MeniDugme dgmIzvestaj = new MeniDugme("Izvestaj", "izvestaj.png");
		dgmIzvestaj.addMouseListener(new MouseListener() {					//lisener za dugme izvestaj
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				izvestaj.setVisible(true);
				
			}
		});
		pnlIzvestajMeniBar.add(dgmIzvestaj);							// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/	
		
		MeniDugme dgmOAutoru = new MeniDugme("O autoru", "info.png");		//lisener za dugme izvestaj
		dgmOAutoru.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(pnlPomoc, "Autor programa: Aleksa Matovic RM - 49/14");
				
			}
		});
		pnlPomocMeniBar.add(dgmOAutoru);									// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/	
		
		MeniDugme dgmPomoc = new MeniDugme("Pomoc", "help.png");
		dgmPomoc.addMouseListener(new MouseListener() {						//lisener za dugme izvestaj
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "UPUTSTVO ZA UPOTREBU:\n"
						+"\nU aplikiciji mogu se dodavati vozila, vozaci, gume i kazne vozaca. U izvestaju se citaju kazne vozaca. "
						+"\n"
						+"\n1. U tabu Vozila, na dugme dodaj, dodaju se nova vozila."
						+"\n2. U tabu Vozaci, na dugme dodaj, dodaju se vozaci."
						+"\n3. Kazne se mogu dodati samo unetim vozilima(tablicama)."
						+"\n4. Gume se mogu dodati samo unetim vozilima(tablicama)."
						+"\n5. Klikom na tab izvestaj prikazuju se izvestaji samo onih vozaca koji imaju kazne."
						+"\n"
						+"\n"
						+"\nAUTOR PROGRAMA: ALEKSA MATOVIC RM-49/14" );
										
			}
		});
		pnlPomocMeniBar.add(dgmPomoc);										// dodavanje dugmeta na meniBar
/********************************************************************************************************************************/	
		
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				TabGlavni.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()-36));
				TabGlavni.revalidate();
				
				pnlVozaciMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));	// mora final jer instanca new ComponentAdapter 
				pnlVozaciMeniBar.revalidate();													// trazi final da bi video nadredjenog
				
				pnlIzvestajMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
				pnlIzvestajMeniBar.revalidate();
				
				pnlPomocMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
				pnlPomocMeniBar.revalidate();
				
				pnlVozilaMeniBar.setPreferredSize(new Dimension(frame.getWidth() - 10, 93));
				pnlVozilaMeniBar.revalidate();													// posle svakog risajza mora da ide rivalidejt !
			}
		});
		
	}
}
