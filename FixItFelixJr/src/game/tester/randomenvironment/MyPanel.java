package game.tester.randomenvironment;

import java.awt.*;  
import java.awt.event.*;  

@SuppressWarnings("serial")
public class MyPanel extends Frame implements KeyListener{  
    Label l;  
    TextArea area;  
    MyPanel(){  
          
        l=new Label();  
        l.setBounds(20,50,100,20);  
        area=new TextArea();  
        area.setBounds(20,80,300, 300);  
        area.addKeyListener(this);  
          
        add(l);add(area);  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void keyPressed(KeyEvent e) { 
    	if (KeyEvent.VK_SPACE == e.getKeyCode())
    		l.setText("Key Pressed");  
    }  
    public void keyReleased(KeyEvent e) {
    	if (KeyEvent.VK_SPACE == e.getKeyCode())
    		l.setText("Key Released");  
    }  
    public void keyTyped(KeyEvent e) { 
    	if (KeyEvent.VK_SPACE == e.getKeyCode())
    		l.setText("Key Typed");  
    }  
  
    public static void main(String[] args) {  
        new MyPanel();  
    }  
}  