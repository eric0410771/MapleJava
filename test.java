import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.Action;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;

public class test extends JFrame{
    private JLabel p1;
    private JLabel p2;
    int location1 = 0;
    int location2 = 400;
    boolean ismove1;
    boolean ismove2;
    private class MouseHandler extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            System.out.println("dd");
            p1.requestFocus();
        }
    }
    private class KeyHandler extends KeyAdapter{
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyChar()=='d')
            {
                ismove1 = true;
            }
            if(e.getKeyChar()=='j')
            {
                ismove2 = true;
            }
        }
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyChar()=='d')
            {
                ismove1 = false;
            }
            if(e.getKeyChar()=='j')
            {
                ismove2 = false;
            }
        }

    }
    public test()
    {
        setLayout(null);
        Container container = getContentPane();
        p1 = new JLabel(new ImageIcon("chara2/standingright0.png"));
        p2 = new JLabel(new ImageIcon("chara2/standingleft0.png"));

        add(p1);
        add(p2);

        p1.setBounds(0,0,100,80);
        p2.setBounds(400,0,100,80);
        Move1thread thread1 = new Move1thread();
        Move2thread thread2 = new Move2thread();

        thread1.start();
        thread2.start();

        /*

        Action moved = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                ismove1 = true;
            }
        };
        Action amoved = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                ismove1 = false;
            }
        };
        Action movej = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                ismove2 = true;
            }
        };
        Action amovej = new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                ismove2 = false;
            }
        };
        p1.getInputMap().put(KeyStroke.getKeyStroke("D"),"moved");
        p1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0,true),"amoved");
        p1.getInputMap().put(KeyStroke.getKeyStroke("J"),"movej");
        p1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_J,0,true),"amovej");

        p1.getActionMap().put("moved",moved);
        p1.getActionMap().put("amoved",amoved);
        p1.getActionMap().put("movej",movej);
        p1.getActionMap().put("amovej",amovej);*/
        addKeyListener(new KeyHandler());
        //addMouseListener(new MouseHandler());
        setSize(600,500);
        setDefaultCloseOperation(3);
        setVisible(true);
    }
    public class Move1thread extends Thread{
        public void run()
        {
            while(true)
            {
                if(ismove1)
                {
                    location1+=1;
                    p1.setBounds(location1,0,100,80);
                    try{
                        Thread.sleep(300);
                    }catch(InterruptedException e)
                    {}
                }
                try{
                    Thread.sleep(20);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    public class Move2thread extends Thread{
        public void run()
        {
            while(true)
            {
                if(ismove2)
                {
                    location2-=1;
                    p2.setBounds(location2,0,100,80);
                    try{
                        Thread.sleep(300);
                    }catch(InterruptedException e)
                    {}
                }                try{
                    Thread.sleep(20);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    public void setFocus()
    {
        p1.requestFocus();
    }
    public static void main(String args[])
    {
        test application = new test();
        //application.setFocus();
    }
}
