import java.io.IOException;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;


public class InputFrame extends JFrame{
    private Scanner cin;
    private JTextField nametext;
    private JButton enter;
    private JButton end;
    private JButton ingame;
    private Clip clip;
    private File data;
    private File itemdata;
    private File missiondata;
    private File questdata;
    private UnableLabel unablelabel;


    private int past;
    private int mapcounter;
    private int level;
    private int meso;
    private int experiencevalue;
    private int crocodile;
    private int hpmax;
    private int mpmax;
    private int str;
    private int dex;
    private int luk;
    private int inte;
    private String name;

    private int missionnumber;
    private int []missionstate;
    private int itemtypenumber;
    private int []itemlist;
    private int questitemtypenumber;
    private int []questitemlist;

    private class UnableLabel extends JLabel{
        private JButton ok;
        private class OkButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                UnableLabel.this.setVisible(false);
            }
        }
        public UnableLabel()
        {
            super(new ImageIcon("ButtonImage/unable.png"));
            setLayout(null);
            ok = new JButton(new ImageIcon("ButtonImage/ok.png"));

            ok.setBounds(203,84,45,16);
            ok.addActionListener(new OkButtonHandler());

            add(ok);
        }
    }

    private class InGameHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try{
                cin = new Scanner(data);
                past = cin.nextInt();
                if(past!=0)
                {
                    mapcounter = cin.nextInt();
                    level = cin.nextInt();
                    meso = cin.nextInt();
                    experiencevalue = cin.nextInt();
                    crocodile = cin.nextInt();
                    hpmax = cin.nextInt();
                    mpmax = cin.nextInt();
                    str = cin.nextInt();
                    dex = cin.nextInt();
                    luk = cin.nextInt();
                    inte = cin.nextInt();
                    name = cin.nextLine();
                    

                    cin = new Scanner(missiondata);

                    missionnumber = cin.nextInt();
                    missionstate = new int [missionnumber];

                    for(int i =0;i<missionnumber;i++)
                    {
                        missionstate[i] = cin.nextInt();
                    }

                    cin = new Scanner(itemdata);

                    itemtypenumber = cin.nextInt();
                    itemlist = new int [itemtypenumber];

                    for(int i = 0;i<itemtypenumber;i++)
                    {
                        itemlist[i] = cin.nextInt();
                    }

                    cin = new Scanner(questdata);
                    questitemtypenumber = cin.nextInt();
                    questitemlist = new int [questitemtypenumber];
                    for(int i =0;i<questitemtypenumber;i++)
                    {
                        questitemlist[i] = cin.nextInt();
                    }

                    First_2 application = new First_2(name);
                    clip.stop();
                    InputFrame.this.dispose();
                    application.inGame(past,mapcounter,level,meso,experiencevalue,missionstate,itemlist,questitemlist,crocodile,hpmax,mpmax,str,dex,luk,inte,name);
                }
                else
                {
                    unablelabel.setVisible(true);
                }
            }catch(IOException ex)
            {}
        }
    }
    private class actionhandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {

            if(!nametext.getText().equals("")){
                First_2 application = new First_2(nametext.getText());
                clip.stop();
                InputFrame.this.dispose();
            }else
            {
                unablelabel.setVisible(true);
            } 
        }
    }
    private class EndHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            InputFrame.this.dispose();
            System.exit(1);
        }
    }
    public InputFrame()
    {
        setLayout(null);

        try{
            AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File("login.wav"));
            clip = AudioSystem.getClip();
            clip.open(inputstream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(IOException ex)
        {}catch(LineUnavailableException ex)
        {}catch(UnsupportedAudioFileException ex)
        {}

        data = new File("savedata/data.txt");
        missiondata = new File("savedata/missiondata.txt");
        itemdata = new File ("savedata/itemdata.txt");
        questdata = new File("savedata/questdata.txt");

        setContentPane(new JLabel(new ImageIcon("inputbackground2.png")));
        enter = new JButton(new ImageIcon("inputbutton.png"));
        enter.setRolloverIcon(new ImageIcon("inputbutton3.png"));
        enter.setBounds(759,304,84,38);
        enter.setContentAreaFilled(false);
        enter.setOpaque(false);
        enter.setBorderPainted(false);

        end = new JButton(new ImageIcon("ButtonImage/end.png"));
        end.setBounds(700,435,149,61);
        end.setContentAreaFilled(false);
        end.setOpaque(false);
        end.setBorder(new LineBorder(new Color(0,0,0,0)));

        ingame = new JButton(new ImageIcon("ButtonImage/ingame.png"));
        ingame.setBounds(540,435,149,61);
        ingame.setContentAreaFilled(false);
        ingame.setOpaque(false);
        ingame.setBorder(new LineBorder(new Color(0,0,0,0)));
        nametext = new JTextField("");
        nametext.setBorder(new LineBorder(new Color(0,0,0,0)));
        nametext.setForeground(Color.white);
        nametext.setFont(new Font(null,Font.BOLD,16));
        nametext.setBounds(552,295,180,25);
        nametext.setBackground(new Color(0,0,0,0));
        nametext.setOpaque(false);
        actionhandler handler =new actionhandler();

        unablelabel = new UnableLabel();
        unablelabel.setBounds(400,300,260,110);
        unablelabel.setVisible(false);

        add(end);
        add(enter);
        add(nametext);
        add(ingame);
        add(unablelabel);


        enter.addActionListener(handler);
        nametext.addActionListener(handler);
        end.addActionListener(new EndHandler());
        ingame.addActionListener(new InGameHandler());

        setUndecorated(true);
        pack();
    }
    public static void main(String args[])
    {
        InputFrame application = new InputFrame();
        application.setLocation((1360-application.getWidth())/2,(768-application.getHeight())/2);
        application.setVisible(true);
        application.setDefaultCloseOperation(2);
    }
}