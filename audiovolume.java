import java.io.IOException;
import java.io.File;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class audiovolume extends JPanel{

    private ImageIcon empty;
    private ImageIcon fill;
    private JLabel []magi;
    private float box;
    private int counter;
    private JButton in;
    private JButton de;
    private FloatControl control;
    private class buttonhandler implements ActionListener{
        public void actionPerformed (ActionEvent e)
        {
            if(e.getActionCommand().equals(in.getActionCommand()))
                if(counter<9)
                {
                    counter++;
                    magi[counter].setIcon(fill);
                    control.setValue(counter*box-72);
                }
            if(e.getActionCommand().equals(de.getActionCommand()))
                if(counter>=0)
                {
                    magi[counter].setIcon(empty);
                    counter--;
                    if(counter!=-1)
                    control.setValue(counter*box-72);
                }
            System.out.println(control.getValue());
        }
    }
    public audiovolume ()
    {
        counter=4;
        try{
            File audiofile = new File("music/mapmusic0.wav");
            AudioInputStream audioinputstream=AudioSystem.getAudioInputStream(audiofile);
            Clip clip=AudioSystem.getClip();
            clip.open(audioinputstream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            control=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            box=(control.getMaximum()-control.getMinimum())/10.0f;

        }catch(IOException ex)
        {}catch(LineUnavailableException ex)
        {}catch(UnsupportedAudioFileException ex)
        {}


        in=new JButton(new ImageIcon("ButtonImage/in.png"));
        de=new JButton(new ImageIcon("ButtonImage/de.png"));

        in.setRolloverIcon(new ImageIcon("ButtonImage/in2.png"));
        de.setRolloverIcon(new ImageIcon("ButtonImage/de2.png"));

        in.setActionCommand("in");
        de.setActionCommand("de");

        buttonhandler handler= new buttonhandler();
        in.addActionListener(handler);
        de.addActionListener(handler);

        magi=new JLabel[10];
        empty=new ImageIcon("ButtonImage/empty.png");
        fill=new ImageIcon("ButtonImage/fill.png");

        for(int i=0;i<5;i++)
            magi[i]=new JLabel(fill);
        for(int i=5;i<10;i++)
            magi[i]=new JLabel(empty);
        
        setFocusable(true);
        
    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(new ImageIcon("ButtonImage/adjustbackground.png").getImage(),0,0,174,20,null);
        
        add(in);
        add(de);

        in.setContentAreaFilled(true);

        de.setContentAreaFilled(true);

        de.setBounds(0,1,20,20);
        for(int i=0;i<10;i++)
        {
            add(magi[i]);
            magi[i].setBounds(22+i*13,1,13,18);
        }
        
        in.setBounds(152,1,20,20);
    }
    public void setFile(String filename)
    {
        
    }
}