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
		
		JPanel panel_1 = new GraphicWindow((panel.getComponentCount())%5,panel.getComponentCount()/5);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel.add(panel_20);
	}

}
