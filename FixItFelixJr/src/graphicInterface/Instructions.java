package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Instructions extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String imageUrl= "graphicInterface/Image/fixItFelix.jpg";
		private Image img;
		
		public Instructions()
		{
			URL urlImg= getClass().getClassLoader().getResource(imageUrl);
			if(urlImg == null)
			{
				System.out.println("No se encuntra la imagen");
			}
			else
			{
				try {
					setImg(ImageIO.read(urlImg));
					
				}
				catch (IOException e)
				{
					e.getStackTrace();
				}
			}
			this.setSize(1000,1000);
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
			g.drawImage(img, 0, 0, 1000, 1000, null);
		}

		public static void main(String args[])
		{
			Instructions i= new Instructions();
			JFrame j= new JFrame();
			j.setSize(1000, 1000);
			j.getContentPane().add(i);
			j.setVisible(true);
		}
	}
