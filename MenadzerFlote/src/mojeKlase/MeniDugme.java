package mojeKlase;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class MeniDugme extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Napravi panel
	 */
	public MeniDugme(String TekstIkonice, String imeSlike) {
		this.setVisible(true);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(68, 93));
		
		JPanel panelIkonica = new JPanel();
		panelIkonica.setLayout(new BorderLayout());
		panelIkonica.setBounds(10, 10, 48, 48);
		
		JLabel lblSaSlikom = new JLabel();
		lblSaSlikom.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imeSlike)));

		panelIkonica.add(lblSaSlikom);
		this.add(panelIkonica, BorderLayout.CENTER);
		
		JTextArea tekst = new JTextArea();
		tekst.setText(TekstIkonice);
		tekst.setWrapStyleWord(true);
		tekst.setLineWrap(false);				
		tekst.setOpaque(false);
		tekst.setEditable(false);
		tekst.setFocusable(false);
		tekst.setLayout(new BorderLayout());					// sa textarea
		tekst.setFont(new Font("Calibri", Font.PLAIN, 11));
		tekst.setBounds(3, 69, 57, 14);								// (10, 69, 48, 14);
		tekst.setBackground(null);
		this.add(tekst, BorderLayout.CENTER);		// ovo ne radi!
			
	}
}
