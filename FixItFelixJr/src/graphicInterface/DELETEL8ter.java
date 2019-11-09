package graphicInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JRadioButton;

import util.GameConstants;
import util.ResourcePathConstants;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class DELETEL8ter {
	
	
	private String imageUrl= ResourcePathConstants.WINDOW_TWOPANNELS;
	private Image img;
	

	private JFrame frmFixItFelix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DELETEL8ter window = new DELETEL8ter();
					window.frmFixItFelix.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DELETEL8ter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFixItFelix = new JFrame();
		frmFixItFelix.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		frmFixItFelix.setTitle("Fix it felix");
		frmFixItFelix.setBounds(100, 100, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		frmFixItFelix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{GameConstants.WINDOW_WIDTH/4, GameConstants.WINDOW_WIDTH/2, GameConstants.WINDOW_WIDTH/4, 0};
		gridBagLayout.rowHeights = new int[] {GameConstants.WINDOW_HEIGHT-50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frmFixItFelix.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frmFixItFelix.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
	}

}
