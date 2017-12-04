package logic;
/*package softwareproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import softwareproject.TrainingDAO;
import softwareproject.DatabaseSingleton;
import softwareproject.Training;

public class BiblioGUI {
	private JFrame frame;

	private JPanel panel;

	private JTextField naam, idLeerkracht, idPlaats;

	private JButton toevoegen, cancel;

	public JButton getToevoegen() {
		if (toevoegen == null) {
			toevoegen = new JButton("Toevoegen");
			toevoegen.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					boekToevoegen();
					clearTextFields();
				}

			});
		}
		return toevoegen;
	}

	private void boekToevoegen() {
		TrainingDAO boekDAO = new TrainingDAO();
		Training boekVO = new Training();
		boekVO.setNaamTraining(getNaam().getText());
		boekVO.setIdLeerkracht(boekVO.getIdLeerkracht());
		boekVO.setIdPlaats(boekVO.getIdPlaats());
		if (boekDAO.insert(boekVO) > 0)
			JOptionPane.showMessageDialog(getFrame(), "Boek toegevoegd!");
		else
			JOptionPane.showMessageDialog(getFrame(), "Boek NIET toegevoegd!");
	}

	private void clearTextFields() {
		naam.setText("");
	    
	}

	public JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					clearTextFields();
				}
			});
		}
		return cancel;
	}

	public BiblioGUI() {
		getFrame().setVisible(true);
	}

	public JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame();
			frame.setTitle("Training");
			frame.setContentPane(getPanel());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					try {
						DatabaseSingleton.getDatabaseSingleton().getConnection(
								true).close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			frame.pack();
		}
		return frame;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 2));
			panel.add(new JLabel("naam: "));
			panel.add(getNaam());
			panel.add(new JLabel("idLeerkracht"));
			panel.add(getIdLeerkracht());
			panel.add(new JLabel("idPlaats"));
			panel.add(getIdPlaats());
			panel.add(getToevoegen());
			panel.add(getCancel());
		}
		return panel;
	}

	public JTextField getNaam() {
		if (naam == null) {
			naam = new JTextField();
		}
		return naam;
	}

	public JTextField getIdLeerkracht() {
		if (idLeerkracht == null) {
			idLeerkracht = new JTextField();
		}
		return idLeerkracht;
	}

	public JTextField getIdPlaats() {
		if (idPlaats == null) {
			idPlaats = new JTextField();
		}
		return idPlaats;
	}

	public static void main(String[] args) {
		new BiblioGUI();
	}

}*/
