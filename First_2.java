import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.MouseInfo;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.Formatter;


public class First_2 extends JFrame{
    private File data;
    private File itemdata;
    private File questdata;
    private File missiondata;
    private Formatter cout;
    private int itemtypenumber = 8;
    private int mesoitemtypenumber = 4;
    private int questitemtypenumber = 1;
    private int mapcounter = 4;
    private int totalmap = 8;
    private int []backgroundy;
    private DesktopContainer container;
    private SwingUtilities solo;
    private int mapwidth = 1017;
    private int mapheight = 720;
    private int []experience;
    private int fame;
    private int experiencevalue;
    private int hpmax;
    private int realhp;
    private int mpmax;
    private int realmp;
    private int str;
    private int dex;
    private int inte;
    private int luk;
    private JLabel []exp;
    private JLabel []hp;
    private JLabel []mp;
    private JLabel deathmessagebackground;
    private JLabel changeMapbackground;
    private JButton okbutton;
    private int itemlist[];
    private int questitemlist[];
    private int getmesovalue;
    private JTextField mesovalue;
    //private Graphics g2;

    private File []file;
    private File statefile;
    private File expfile;
    private String name="";
    private int level;

    private Cursor cursor;
    private Cursor cursor2;
    private Image cimage1;
    private Image cimage2;
    private ImageIcon []standingright;
    private ImageIcon []standingleft;
    private ImageIcon []walkleft;
    private ImageIcon []walkright;
    private ImageIcon []attackrightwitheff;
    private ImageIcon []attackleftwitheff;
    private ImageIcon onfloorright;
    private ImageIcon onfloorleft;
    private ImageIcon rjump;
    private ImageIcon ljump;
    private ImageIcon []rdattack;
    private ImageIcon []ldattack;
    private ImageIcon []ghost;
    private ImageIcon []background;
    private int locationx;
    private int locationy;
    private int way;
    private int dy;
    private int rate;
    private int attackrange;
    private int defense;
    private int copylocationy;
    private boolean isghost;
    private boolean isJump;
    private boolean isMove;
    private boolean isPMove;
    private boolean isdown;
    private boolean isShow;
    private boolean isChange;
    private boolean islevelup;
    private boolean isstanding;
    private boolean isattack;
    private boolean isstandingattack;
    private boolean isdattack;
    private boolean isinvincible = true;
    private boolean isup;
    private boolean ispickup;
    private JLabel []attacklabel;
    private JLabel[] copy;
    private JLabel chara;
    private JTextArea gainarea;

    private int []monsternumber;
    private ImageIcon []monsterlhit;
    private ImageIcon []monsterrhit;
    private ImageIcon []monsterstandingleft;
    private ImageIcon []monsterstandingright;
    private ImageIcon [][]monstermoveright;
    private ImageIcon [][]monstermoveleft;
    private ImageIcon [][]monsterldeath;
    private ImageIcon [][]monsterrdeath;
    private int []monsterlocationx;
    private int []monsterlocationy;
    private int [][]monstersize;
    private int attackx;
    private int attacky;
    private int [][]monsterblood;
    private int []filemonsterblood;
    private int []dfirsttime;
    private int []monsterway;
    private int []monstermoverightcounter;
    private int []monstermoveleftcounter;
    private int []monsterdeathcounter;
    private JLabel []monster;
    private SecureRandom randnumber;
    private boolean []isattacked;
    private boolean []hasattacked;
    private boolean []death;
    private boolean []isMonsterMoving;
    private boolean []monsterdeadover;
    private JLabel []monsterattacklabel;
    private int []monsterexperience;


    private int bosstype = 1;
    private ImageIcon bosslhit;
    private ImageIcon bossrhit;
    private ImageIcon bossstandingleft;
    private ImageIcon bossstandingright;
    private ImageIcon []bossmoveright;
    private ImageIcon []bossmoveleft;
    private ImageIcon []bossldeath;
    private ImageIcon []bossrdeath;
    private ImageIcon []bosslmagic;
    private ImageIcon []bossrmagic;
    private ImageIcon []magicleffect;
    private ImageIcon []magicreffect;
    private JLabel []blank;
    private JLabel bosshp;
    private int bosslocationx;
    private int bosslocationy;
    private int []bosssize;
    private int bossblood;
    private int bossmaxblood = 1000;
    private int bossexperience = 5000000;
    private int bossway;
    private int avoid;
    private int bossmoverightcounter;
    private int bossmoveleftcounter;
    private int bossdeathcounter;
    private JLabel boss;
    private boolean bisattacked;
    private boolean bhasattacked;
    private boolean bdeath;
    private boolean isbossmoving;
    private boolean ismagicattack;
    private JLabel magic;
    private Timer magictimer;


    private ImageIcon []deliverpicture;
    private JLabel []deliverypoint;
    private Timer delivertimer;
    private int [][]deliverlocationx;
    private int []delivernumber;
    private int maxdelivernumber;


    private int [][]delivermapcounter;
    private int [][][]deliverdata;

    private ImageIcon []leveluppicture;
    private JLabel levelup;
    private Timer leveluptimer;

    private ChatPane chatpane;

    private LVpane lvpane;

    private JTextField input;
    private JTextArea inputArea;
    private JScrollPane inputpane;
    private JButton toAll;


    private ToolInternalFrame toolframe;
    private ImageIcon tabbedbackground;
    private JButton toolButton;
    private Use use;
    private Etc etc;
    private Equip equip;
    private SetUp setup;
    private QuestItem []etcquestitem;
    private DropItem []usedropitem;
    private NumberTextField []numbertextfield;
    private ArrangeUseItemThread arrangeuseitemthread;
    private ArrangeEtcItemThread arrangeetcitemthread;


    private AbilityInternalFrame abilityframe;
    private JButton abilityButton;
    private int abilitypoint;
    private JTextField pointfield;
    private JTextField namefield;
    private JTextField jobfield;
    private JTextField levelfield;
    private JTextField hpfield;
    private JTextField mpfield;
    private JTextField expfield;
    private JTextField famefield;
    private JTextField strfield;
    private JTextField dexfield;
    private JTextField intfield;
    private JTextField lukfield;


    private DropItem dropitem[];
    private ImageIcon []dropitempicture;
    private int dropnumber;

    private MesoItem mesoitem[];
    private ImageIcon []mesoitempicture;
    private int mesonumber;

    private QuestItem questitem[];
    private ImageIcon []questitempicture;
    private int questitemnumber;

    private audiovolume volumepane;

    private StatePanel statepane;

    private JButton quitbutton;
    private JButton savebutton;
    private JButton keyboardhintbutton;
    private KeyBoardHintLabel keyboardhintlabel;

    private JInternalFrame skillframe;
    private int skillpoint;

    private QuickButtonPane quickbuttonpane;
    private JLabel []movinglabel;
    private ImageIcon quickbuttonbackground;
    private int holdtype = itemtypenumber-1;
    private SubQuickButtonPane []subquickbuttonpane;
    private JTextField copyuseitemnumber;
    private JLabel []keyhintlabel;
    private int keyhintnumber = 3;
    private int crocodile;
    private int barlog;
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~saleman
    private int salemannumber;
    private int salemanlocationx[];
    private int []salemanpicturenumber;
    private ImageIcon [][]salemanpicture;
    private JLabel saleman[];
    private SalePane []salepane;
    private String []itemname;
    private String []itemprice;
    private SaleManMouseHandler salemanmousehandler;
    private int clicksaleitem = -1;
    private BuyItemLabel buyitemlabel;
    private DisableLabel disablelabel;
    private JTextField usermesotext;

    private class DisableLabel extends JLabel{
        private JButton ok;
        public DisableLabel ()
        {
            super(new ImageIcon("ButtonImage/disableimage.png"));
            setLayout(null);
            ok = new JButton(new ImageIcon("ButtonImage/ok.png"));

            add(ok);
            ok.addActionListener(new OkButtonHandler());
            ok.setBounds(202,85,45,16);
        }
        private class OkButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                DisableLabel.this.setVisible(false);
            }
        }
    }
    private class BuyItemLabel extends JLabel{
        private NumberTextField number;
        private JButton ok;
        private JButton cancel;
        public BuyItemLabel(){
            
            super(new ImageIcon("ButtonImage/buyitemimage.png"));
            setLayout(null);
            number = new NumberTextField("");
            number.setHorizontalAlignment(SwingConstants.RIGHT);
            number.setEditable(true);
            ok = new JButton(new ImageIcon("ButtonImage/ok.png"));
            cancel = new JButton(new ImageIcon("ButtonImage/cancel.png"));

            add(ok);
            add(cancel);
            add(number);

            ok.addActionListener(new OkButtonHandler());
            cancel.addActionListener(new CancelButtonHandler());

            ok.setBounds(157,89,47,18);
            cancel.setBounds(207,88,47,18);
            number.setBounds(16,44,228,17);
        }
        private class CancelButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                number.setText("");
                BuyItemLabel.this.setVisible(false);
            }
        }
        private class OkButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                int value = Integer.parseInt(number.getText());
                int price = Integer.parseInt(itemprice[clicksaleitem]);
                int usermeso = Integer.parseInt(mesovalue.getText());

                if(value*price>usermeso)
                {
                    number.setText("");
                    buyitemlabel.setVisible(false);
                    disablelabel.setVisible(true);
                }
                else
                {
                    usermeso -= value*price;
                    mesovalue.setText(String.valueOf(usermeso));
                    usermesotext.setText(String.valueOf(usermeso));
                    itemlist[clicksaleitem] += value;
                    arrangeuseitemthread = new ArrangeUseItemThread();
                    arrangeuseitemthread.start();
                    buyitemlabel.setVisible(false);
                    number.setText("");
                }
            }
        }
    }

    private class SalePane extends JLabel{
        private SaleItem []saleitem;
        private JTextField []saleitemdata;
        private int pagecounter;
        private int totalpagecounter;
        private JButton leavestore;
        private JButton backbutton;
        private JButton nextbutton;
        private JLabel salenpc;
        private JLabel userlabel;
        private class SaleItemMouseHandler extends MouseAdapter{
            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount() == 2)
                {
                    for(int i =0;i<itemtypenumber-1;i++)
                        if(e.getSource() == saleitem[i])
                            {
                                clicksaleitem = i;
                                buyitemlabel.setVisible(true);
                            }
                }
            }
        }
        private class SalePaneCloseHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                for(int i  = 5*pagecounter;i<itemtypenumber&&i<5+5*pagecounter;i++)
                {
                    saleitem[i].setVisible(false);
                }
                SalePane.this.setVisible(false);
                chara.requestFocus();
            }
        }
        private class SaleItem extends JLabel{
            private NumberTextField iname;
            private NumberTextField iprice;
            private JLabel itemimage;
            private int itemtype;
            public SaleItem(int itemtype)
            {
                setLayout(null);
                this.itemtype = itemtype;
                itemimage = new JLabel(new ImageIcon("Item/item"+itemtype+".png"));
                iname = new NumberTextField(itemname[itemtype]);
                iprice = new NumberTextField(itemprice[itemtype]);
                add(itemimage);
                add(iname);
                add(iprice);
                
                itemimage.setBounds(0,0,35,35);
                iname.setBounds(35,0,100,17);
                iprice.setBounds(35,17,100,17);
                setSize(200,35);
                setBackground(new Color(75,223,250));
            }
        }
        public SalePane (int salemannumber,ImageIcon salemanpicture)
        {
            super(new ImageIcon("ButtonImage/salepanebackground.png"));
            setLayout(null);
            pagecounter = 0;
            totalpagecounter = (itemtypenumber-1)/5;
            leavestore = new JButton(new ImageIcon("ButtonImage/leavestorebutton.png"));
            nextbutton = new JButton(new ImageIcon("ButtonImage/nextbutton.png"));
            backbutton = new JButton(new ImageIcon("ButtonImage/backbutton.png"));
            salenpc = new JLabel(salemanpicture);
            userlabel = new JLabel(new ImageIcon("chara2/standingleft0.png"));

            SaleItemMouseHandler saleitemmousehandler = new SaleItemMouseHandler();

            usermesotext = new JTextField("");
            usermesotext.setHorizontalAlignment(SwingConstants.RIGHT);
            usermesotext.setOpaque(false);
            usermesotext.setEditable(false);

            add(disablelabel);
            add(buyitemlabel);


            saleitem = new SaleItem[itemtypenumber];
            
            int counter = 0;
            for(int i=0;i<itemtypenumber;i++)
            {
                saleitem[i] = new SaleItem(i);
                add(saleitem[i]);
                saleitem[i].setBounds(10,125+35*counter,200,35);
                saleitem[i].setVisible(false);
                saleitem[i].addMouseListener(saleitemmousehandler);
                counter++;
                counter%=5;
            }
            
            add(leavestore);
            add(nextbutton);
            add(backbutton);
            add(usermesotext);
            add(salenpc);
            add(userlabel);

            leavestore.addActionListener(new SalePaneCloseHandler());
            nextbutton.addActionListener(new NextButtonHandler());
            backbutton.addActionListener(new BackButtonHandler());

            buyitemlabel.setVisible(false);
            disablelabel.setVisible(false);


            userlabel.setBounds(256,4,100,78);
            salenpc.setBounds(30,4,60,78);
            usermesotext.setBounds(358,62,92,16);
            leavestore.setBounds(141,14,78,16);
            nextbutton.setBounds(148,90,46,18);
            backbutton.setBounds(85,90,46,18);
            buyitemlabel.setBounds(85,127,261,115);
            disablelabel.setBounds(85,127,260,112);
            setLocation(200,200);
            setSize(459,335);
        }
        private void setPage()
        {
            pagecounter = 0;
            for(int i = 0;i<5;i++)
            {
                saleitem[i].setVisible(true);
            }
        }
        private void setMeso()
        {
            usermesotext.setText(mesovalue.getText());
        }
        private class NextButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                if(pagecounter+1<=totalpagecounter)
                {
                    for(int i = 5*pagecounter;i<5*pagecounter+5;i++)
                    {
                        saleitem[i].setVisible(false);
                    }
                    pagecounter++;
                    for(int i = 5*pagecounter ; i<itemtypenumber&&i<5+5*pagecounter;i++)
                    {
                        saleitem[i].setVisible(true);
                    }
                }
            }
        }
        private class BackButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                if(pagecounter-1>=0)
                {
                    for(int i = 5*pagecounter ; i<itemtypenumber&&i<5+5*pagecounter;i++)
                    {
                        saleitem[i].setVisible(false);
                    }
                    pagecounter--;
                    for(int i = 5*pagecounter;i<5*pagecounter+5;i++)
                    {
                        saleitem[i].setVisible(true);
                    }
                }
            }
        }
    }
    public class SaleManThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(mapcounter==7)
                {
                    saleman[0].setVisible(true);
                }
                else
                {
                    saleman[0].setVisible(false);
                }
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    public class SaleManMouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e)
        {
            for(int i=0;i<salemannumber;i++)
            {
                if(e.getSource()==saleman[i])
                {
                    salepane[i].setVisible(true);
                    salepane[i].setMeso();
                    salepane[i].setPage();
                }
            }
        }
    }
    public class SaleManActionThread extends Thread{
        private int salemannumber;
        public SaleManActionThread(int salemannumber)
        {
            this.salemannumber = salemannumber;
        }
        public void run()
        {
            while(true)
            {
                for(int i=0;i<salemanpicturenumber[salemannumber];i++)
                {
                    saleman[salemannumber].setIcon(salemanpicture[salemannumber][i]);
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e)
                    {}
                }
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~npc
    private int missionnumber;
    private File npcfile;
    private boolean chatopen;
    private int npcnumber;
    private int []npcpicturenumber;
    private int []npclocationx;
    private JLabel []npclabel;
    private NpcChatPane []npcchatpane;
    private ImageIcon [][]npcpicture;
    
    private boolean mission[];
    private boolean missioncondition[];
    private boolean hasmission[];
    private boolean acceptmission[];
    private int [][]missionreward;


    private String missionname[];
    private String npccontent[][][];
    private String npcquestcontent[][][];
    private String npcquestyetcontent[][][];
    private String npcquestfinishcontent[][][];

    private int npccontentnumber[];
    private int npcquestcontentnumber[];
    private int npcquestyetcontentnumber[];
    private int npcquestfinishcontentnumber[];

    private int questlabeltype = 3;
    private JLabel questlabel[];
    private ImageIcon questlabelpicture[];

    public class NpcChatPane extends JLabel{
        
        private JButton ok;
        private JButton accept;
        private JButton reject;
        private int pagecounter;
        private int maxpagecounter;
        private JButton closebutton;
        private JButton nextbutton;
        private ImageIcon background;
        private JLabel npc;
        private int npcnumber;
        private JTextField questname;
        private JTextArea contentarea;
        public NpcChatPane (ImageIcon npc,int npcnumber)
        {
            super(new ImageIcon("ButtonImage/npcchatbackground.png"));
            setLayout(null);
            this.npc = new JLabel(npc);
            this.npcnumber = npcnumber;
            closebutton = new JButton(new ImageIcon("ButtonImage/closebutton.png"));
            contentarea = new JTextArea();
            nextbutton = new JButton(new ImageIcon("ButtonImage/nextbutton.png"));
            accept = new JButton(new ImageIcon("ButtonImage/accept.png"));
            reject = new JButton(new ImageIcon("ButtonImage/reject.png"));
            ok = new JButton(new ImageIcon("ButtonImage/ok.png"));
            questname = new JTextField(missionname[npcnumber]);
            add(questname);            
            add(accept);
            add(reject);
            add(ok);


            add(nextbutton);
            nextbutton.setBounds(447,129,46,18);
            nextbutton.addActionListener(new NextPageButtonHandler());

            contentarea.setEditable(false);
            contentarea.setForeground(Color.white);
            contentarea.setBackground(Color.black);
            accept.setVisible(false);
            reject.setVisible(false);
            ok.setVisible(false);
            ok.addActionListener(new OkHandler());
            add(closebutton);
            add(this.npc);
            add(contentarea);;

            (this.npc).setBounds(45,40,60,80);
            closebutton.setBounds(6,181,83,16);
            closebutton.addActionListener(new CloseHandler());
            contentarea.setBounds(150,19,362,143);
            accept.setBounds(350,180,56,16);
            reject.setBounds(426,180,56,16);
            ok.setBounds(460,184,45,16);

            accept.addActionListener(new AcceptButtonHandler());
            reject.addActionListener(new CloseHandler());
        }
        public void resume()
        {
            pagecounter = 0;
            if(!mission[npcnumber]&&hasmission[npcnumber])
            {
                //System.out.println("1");
                contentarea.setText("");
                maxpagecounter = npcquestcontent[npcnumber].length;
                for(int i = 0;i<npcquestcontent[npcnumber][pagecounter].length;i++)
                {
                    contentarea.append(npcquestcontent[npcnumber][0][i]+"\n");
                }
                questname.setForeground(new Color(39,218,233));
                questname.setBounds(324,134,190,20);
                questname.setEditable(false);
                questname.setOpaque(false);
                questname.setBorder(new LineBorder(new Color(0,0,0,0)));
                questname.addMouseListener(new QuestMouseHandler());
                ok.setVisible(false);
            }
            else if(hasmission[npcnumber]&&mission[npcnumber]&&missioncondition[npcnumber])
            {
                contentarea.setText("");
                //System.out.println("2");
                maxpagecounter = npcquestfinishcontent[npcnumber].length;
                for(int i =0;i<npcquestfinishcontent[npcnumber][pagecounter].length;i++)
                    contentarea.append(npcquestfinishcontent[npcnumber][pagecounter][i]+"\n");
                accept.setVisible(false);
                reject.setVisible(false);
                ok.setVisible(true);
            }
            else if(hasmission[npcnumber]&&mission[npcnumber]&&!missioncondition[npcnumber])
            {
                contentarea.setText("");
                //System.out.println("3");
                maxpagecounter = npcquestyetcontent[npcnumber].length;
                for(int i =0;i<npcquestyetcontent[npcnumber][pagecounter].length;i++)
                    contentarea.append(npcquestyetcontent[npcnumber][pagecounter][i]+"\n");
                accept.setVisible(false);
                reject.setVisible(false);
                ok.setVisible(false);
            }
            else if(!hasmission[npcnumber]&&mission[npcnumber])
            {
                contentarea.setText("");
                //System.out.println("4");
                maxpagecounter = npccontent[npcnumber].length;
                for(int i = 0;i<npccontent[npcnumber][pagecounter].length;i++)
                {
                    contentarea.append(npccontent[npcnumber][0][i]+"\n");
                }
                accept.setVisible(false);
                reject.setVisible(false);
                ok.setVisible(false);
            }
            if(pagecounter+1<maxpagecounter)
                nextbutton.setVisible(true);
            else
                nextbutton.setVisible(false);

        }
        private void nextPage()
        {
            contentarea.setText("");
            pagecounter++;
            if(!mission[npcnumber]&&hasmission[npcnumber])
            {
                questname.setVisible(false);
                for(int i = 0;i<npcquestcontent[npcnumber][pagecounter].length;i++)
                    contentarea.append(npcquestcontent[npcnumber][pagecounter][i]+"\n");
            }
            else if(!hasmission[npcnumber]&&mission[npcnumber])
            {
                for(int i =0;i<npccontent[npcnumber][pagecounter].length;i++)
                    contentarea.append(npccontent[npcnumber][pagecounter][i]+"\n");
            }
            if(maxpagecounter+1>=pagecounter)
            {
                accept.setVisible(false);
                reject.setVisible(false);
                ok.setVisible(false);
                nextbutton.setVisible(false);
                if(!mission[npcnumber]&&hasmission[npcnumber])
                {
                    accept.setVisible(true);
                    reject.setVisible(true);
                }
                if(mission[npcnumber]&&hasmission[npcnumber]&&missioncondition[npcnumber])
                {
                    ok.setVisible(true);
                }
            }
        }
        private class AcceptButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                mission[npcnumber] = true;
                NpcChatPane.this.setVisible(false);
                chatopen = false;
                chara.requestFocus();
            }
        }
        private class QuestMouseHandler extends MouseAdapter{
            public void mouseClicked(MouseEvent e)
            {
                nextPage();
                questname.setVisible(false);
            }
        }
        private class NextPageButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                nextPage();
            }
        }
        private class CloseHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                NpcChatPane.this.setVisible(false);
                chatopen = false;
                chara.requestFocus();
            }
        }
        private class OkHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                NpcChatPane.this.setVisible(false);
                chatopen = false;
                experiencevalue += missionreward[npcnumber][0];
                if(experiencevalue>=experience[level-120])
                {
                    islevelup=true;
                }
                int value = Integer.parseInt(mesovalue.getText());
                getmesovalue +=missionreward[npcnumber][1];
                mesovalue.setText(String.valueOf(getmesovalue));
                hasmission[npcnumber] = false;
                if(npcnumber==0)
                    questitemlist[0] = 0;
                arrangeetcitemthread = new ArrangeEtcItemThread();
                arrangeetcitemthread.start();
                chara.requestFocus();
            }
        }
    } 

    private class NpcMouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e)
        {
            for(int i =0;i<npcnumber;i++)
            {
                if(e.getSource()==npclabel[i])
                {
                    if(!chatopen&&!npcchatpane[i].isVisible())
                    {
                        npcchatpane[i].resume();
                        npcchatpane[i].setVisible(true);
                        chatopen = true;
                    }
                }
            }
        }
    }
    private class NpcThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(mapcounter == 4)
                {
                    for(int i =0;i<2;i++)
                    {
                        npclabel[i].setVisible(true);
                        if(!mission[i]&&hasmission[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[0]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&hasmission[i]&&!missioncondition[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[1]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&hasmission[i]&&missioncondition[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[2]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&!hasmission[i])
                        {
                            questlabel[i].setVisible(false);
                        }
                    }
                    for(int i = 2;i<npcnumber;i++)
                    {
                        npclabel[i].setVisible(false);
                        questlabel[i].setVisible(false);
                    }
                }
                else if(mapcounter ==5)
                {
                    for(int i=0;i<2;i++)
                    {
                        npclabel[i].setVisible(false);
                        questlabel[i].setVisible(false);
                    }
                    for(int i =2;i<4;i++)
                    {
                        npclabel[i].setVisible(true);
                        if(!mission[i]&&hasmission[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[0]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&hasmission[i]&&!missioncondition[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[1]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&hasmission[i]&&missioncondition[i])
                        {
                            questlabel[i].setIcon(questlabelpicture[2]);
                            questlabel[i].setVisible(true);
                        }
                        else if(mission[i]&&!hasmission[i])
                        {
                            questlabel[i].setVisible(false);
                        }
                    }
                }
                else
                {
                    for(int i =0;i<npcnumber;i++)
                    {
                        npclabel[i].setVisible(false);
                        questlabel[i].setVisible(false);
                    }
                }
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class NpcActionThread extends Thread{
        private int npcnumber;
        public NpcActionThread (int npcnumber)
        {
            this.npcnumber = npcnumber;
        }
        public void run()
        {
            int counter = 0;
            while(true)
            {
                npclabel[npcnumber].setIcon(npcpicture[npcnumber][counter]);
                counter++;
                counter%=npcpicturenumber[npcnumber];
                if(counter==0)
                {
                    try{
                        Thread.sleep(1600);
                    }catch(InterruptedException e)
                    {}
                }
                else 
                {
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e)
                    {}
                }
            }
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~quickbutton
    private class SubQuickButtonMouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e)
        {
            if(holdtype!=itemtypenumber-1)
            {
                ((SubQuickButtonPane)(e.getSource())).setType(holdtype);
                movinglabel[holdtype].setVisible(false);
                holdtype = itemtypenumber-1;
                
            }
        }
    }
    private class SubQuickButtonPane extends JPanel{
        private Image image;
        private ImageIcon holdingimage;
        private int holdingtype;
        private NumberTextField numbertextfield; 
        public SubQuickButtonPane(ImageIcon image,NumberTextField numbertextfield)
        {
            setLayout(null);
            this.numbertextfield = numbertextfield;
            holdingtype = itemtypenumber-1;
            this.image = image.getImage();
            addMouseListener(new SubQuickButtonMouseHandler());
            add(this.numbertextfield);
            (this.numbertextfield).setBounds(0,21,15,15);
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(image,0,0,getWidth(),getHeight(),null);
            if(holdingimage!=null)
            g.drawImage(holdingimage.getImage(),0,0,36,36,null);
        }
        public void setType(int type)
        {
            holdingtype = type;
            holdingimage = new ImageIcon("Item/item"+holdingtype+".png");
            numbertextfield.setText(String.valueOf(itemlist[type]));
            this.repaint();
        }
        public int getType()
        {
            return holdingtype;
        }
    }
    private class QuickButtonPane extends JPanel{
        private ImageIcon []subbackground;
        public QuickButtonPane()
        {
            setLayout(null);
            quickbuttonbackground = new ImageIcon("ButtonImage/quickbuttonbackground.png");
            movinglabel = new JLabel[itemtypenumber];
            subbackground = new ImageIcon[8];

            for(int i =0;i<itemtypenumber;i++)
                movinglabel[i] = new JLabel(new ImageIcon("Item/item"+i+".png"));
            
            subbackground[0] = new ImageIcon("ButtonImage/subquickbuttonpane0.png");
            subbackground[3] = new ImageIcon("ButtonImage/subquickbuttonpane2.png");
            subbackground[4] = new ImageIcon("ButtonImage/subquickbuttonpane0.png");
            subbackground[7] = new ImageIcon("ButtonImage/subquickbuttonpane2.png");
            for(int i =1;i<3;i++)
            {    subbackground[i] = new ImageIcon("ButtonImage/subquickbuttonpane1.png");
                subbackground[i+4] = new ImageIcon("ButtonImage/subquickbuttonpane1.png");
            }
            keyhintlabel = new JLabel[keyhintnumber];

            for(int i =0;i<keyhintnumber;i++)
            {
                keyhintlabel[i] = new JLabel(new ImageIcon("ButtonImage/keyhint"+i+".png"));
                add(keyhintlabel[i]);
            }


            subquickbuttonpane = new SubQuickButtonPane[8];
            for(int i =0;i<subquickbuttonpane.length;i++)
            {
                subquickbuttonpane[i] = new SubQuickButtonPane(subbackground[i],numbertextfield[i]);
            }
            subquickbuttonpane[0].setBounds(4,7,35,32);
            keyhintlabel[0].setBounds(14,7,20,10);
            subquickbuttonpane[1].setBounds(43,7,35,33);
            keyhintlabel[1].setBounds(53,7,20,10);
            subquickbuttonpane[2].setBounds(81,7,35,33);
            keyhintlabel[2].setBounds(91,7,20,10);
            subquickbuttonpane[3].setBounds(120,7,35,32);
            subquickbuttonpane[4].setBounds(4,44,35,32);
            subquickbuttonpane[5].setBounds(43,44,35,33);
            subquickbuttonpane[6].setBounds(81,44,35,33);
            subquickbuttonpane[7].setBounds(120,44,35,32);
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(quickbuttonbackground.getImage(),0,0,getWidth(),getHeight(),null);
            for(int i = 0;i<8;i++)
            {
                add(subquickbuttonpane[i]);
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~item
    private class HoldThread extends Thread{
        public void run()
        {
            while(true)
            {
                checkMovingLabel();
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    synchronized private void checkMovingLabel()
    {           
        while(holdtype!=itemtypenumber-1)
        {
            try{
                movinglabel[holdtype].setBounds((int)(MouseInfo.getPointerInfo().getLocation().getX()-First_2.this.getLocation().getX()-5),(int)(MouseInfo.getPointerInfo().getLocation().getY()-First_2.this.getLocation().getY()-5),36,36); 
            }
            finally{
            }
        }
    }
    private class ToolInternalFrame extends JInternalFrame{
        private JButton meso;
        private JTabbedPane mainpane;
        private Mesopane mesopane;
        private JFrame focus;
        private Cursor cursor;
        private Cursor cursor2;
        private Image cimage1;
        private Image cimage2;

        private class ToolMouseHandler extends MouseAdapter{
            public void mousePressed(MouseEvent e)
            {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    ToolInternalFrame.this.setCursor(cursor2);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(SwingUtilities.isLeftMouseButton(e))
                    ToolInternalFrame.this.setCursor(cursor);
            }
            public void mouseClicked(MouseEvent e)
            {
                movinglabel[holdtype].setVisible(false);
                if(holdtype!=itemtypenumber-1)
                {
                    movinglabel[holdtype].setVisible(false);
                    holdtype = itemtypenumber-1;
                }
            }
        }

        private class ItemMouseHandler extends MouseAdapter{
            public void mouseClicked(MouseEvent e)
            {
                if(!isghost&&e.getClickCount()==2)
                {
                    for(int i=0;i<itemtypenumber;i++)
                        if(e.getSource()==usedropitem[i])
                        {
                            usedropitem[i].effect();
                            itemlist[i]--;
                            for(int j =0;j<8;j++)
                                if(subquickbuttonpane[j].getType()==j)
                                {
                                    numbertextfield[j].setText(String.valueOf(itemlist[j]));
                                }
                            if(itemlist[i]==0)
                            {
                                ArrangeUseItemThread arrangeuseitemthread = new ArrangeUseItemThread();
                                arrangeuseitemthread.start();
                            }
                            else
                            {
                                usedropitem[i].setText(String.valueOf(itemlist[i]));
                            }
                            if(holdtype!=itemtypenumber)
                                movinglabel[holdtype].setVisible(false);
                        }
                    chara.requestFocus();

                }
                else if(e.getClickCount()==1)
                {
                    for(int i =0;i<itemtypenumber;i++)
                        if(e.getSource()==usedropitem[i])
                        {
                            if(holdtype!=itemtypenumber)
                                movinglabel[holdtype].setVisible(false);
                            holdtype = i;
                                movinglabel[holdtype].setVisible(true);
                        }
                    chara.requestFocus();
                }
            }
        } 
        public ToolInternalFrame(String title,boolean re,boolean cl,boolean ma,boolean ic)
        {
            super(title,re,cl,ma,ic);
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            try{
                cimage1=ImageIO.read(new File("Cursor/cursor.png"));
                cimage2=ImageIO.read(new File("Cursor/cursor2.png"));
                cursor=toolkit.createCustomCursor(cimage1,new Point(10,4),"cursor");
                cursor2=toolkit.createCustomCursor(cimage2,new Point(10,4),"cursor2");
                setCursor(cursor);
            }catch(IOException ex)
            {}
            addMouseListener(new ToolMouseHandler());
            setLayout(null);
            mainpane = new JTabbedPane();
            equip = new Equip();
            use = new Use();
            setup = new SetUp();
            etc = new Etc();
            arrangeuseitemthread = new ArrangeUseItemThread();
            tabbedbackground = new ImageIcon("ButtonImage/toolinternalbackground.png");
            mainpane.addTab("Equip",equip);
            mainpane.addTab("Use",use);
            mainpane.addTab("Set Up",setup);
            mainpane.addTab("Etc",etc);
            mesopane = new Mesopane();
            usedropitem = new DropItem[itemtypenumber];
            etcquestitem = new QuestItem[questitemtypenumber];
            numbertextfield = new NumberTextField[8];
            ItemMouseHandler itemmousehandler = new ItemMouseHandler();


            for(int i = 0;i<itemtypenumber;i++)
            {
                usedropitem[i] = new DropItem(i,0,dropitempicture[i]);
                usedropitem[i].addMouseListener(itemmousehandler);
            }

            for(int i =0;i<questitemtypenumber;i++)
            {
                etcquestitem[i] = new QuestItem(i,0,questitempicture[i]);
            }

            for(int i = 0;i<8;i++)
                numbertextfield[i] = new NumberTextField("");
            
            usedropitem[0].setToolTipText("<html>"+"Power Elixir"+"<br>"+"A legendary potion."+"<br>"+"Recovers all HP and MP"+"</html>");
            usedropitem[2].setToolTipText("<html>"+"Elixir"+"<br>"+"A legendary potion."+"<br>"+"Recovers 50% HP and 50%"+"<br>"+"MP."+"</html>");
        
            add(mainpane);
            mainpane.setBounds(1,0,178,262);
            add(mesopane);
            mesopane.setBounds(1,262,173,26);

            setSize(180,320);
            setVisible(true);
            setDefaultCloseOperation(1);
            addInternalFrameListener(new internalframehandler());
        }
        private class internalframehandler extends InternalFrameAdapter{
            public void internalFrameClosed(InternalFrameEvent e)
            {
                ToolInternalFrame.this.setVisible(false);
                chara.requestFocus();
            }
        }
        private class Mesopane extends JPanel{
            public Mesopane()
            {
                meso = new JButton(new ImageIcon("ButtonImage/coin.png"));
                mesovalue = new JTextField("0");
                mesovalue.setHorizontalAlignment(SwingConstants.RIGHT);
                mesovalue.setEditable(false);
                setSize(173,26);

            }
            public void paintComponent(Graphics g)
            {
                g.drawImage(new ImageIcon("ButtonImage/mesobackground.png").getImage(),0,0,173,26,null);
                add(meso);
                add(mesovalue);
                meso.setBounds(6,4,16,16);
                mesovalue.setBounds(23,4,115,16);
            }
        }
    }
    private class Equip extends JPanel{
        public Equip()
        {
            setLayout(new GridLayout(9,4,4,2));
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(tabbedbackground.getImage(),0,0,getWidth(),getHeight(),null);
        }
    }
    private class UseMouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e)
        {
            if(holdtype!=itemtypenumber-1)
            {
                movinglabel[holdtype].setVisible(false);
                holdtype = itemtypenumber-1;
            }
        }
    }
    private class Use extends JPanel{
        public Use()
        {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            addMouseListener(new UseMouseHandler());
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(tabbedbackground.getImage(),0,0,getWidth(),getHeight(),null);
        }

    }
    private class SetUp extends JPanel{
        public SetUp()
        {
            setLayout(new GridLayout(9,4,4,2));
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(tabbedbackground.getImage(),0,0,getWidth(),getHeight(),null);
        }
    }
    private class Etc extends JPanel{
        public Etc()
        {
            setLayout(new FlowLayout(FlowLayout.LEFT));
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(tabbedbackground.getImage(),0,0,getWidth(),getHeight(),null);
        }
    }
    private class ArrangeEtcItemThread extends Thread{
        public void run()
        {
            for(int i =0;i<questitemtypenumber;i++)
            {
                if(questitemlist[i]!=0)
                {
                    etc.add(etcquestitem[i]);
                    etcquestitem[i].setVisible(true);
                    etcquestitem[i].setText(String.valueOf(questitemlist[i]));
                }else
                {
                    etcquestitem[i].setVisible(false);
                }
            }
        }
    }

    private class ArrangeUseItemThread extends Thread{
        public void run()
        {
            for(int i =0;i<itemtypenumber;i++)
                if(itemlist[i]!=0)
                {
                    use.add(usedropitem[i]);
                    usedropitem[i].setVisible(true);
                    usedropitem[i].setText(String.valueOf(itemlist[i]));
                }else
                {
                    usedropitem[i].setVisible(false);
                }
        }
    }
    private class NumberTextField extends JTextField{
        public NumberTextField(String value)
        {
            super(value);
            setHorizontalAlignment(SwingConstants.RIGHT);
            setForeground(Color.black);
            setOpaque(false);
            setBorder(new LineBorder(new Color(0,0,0,0)));
            setEditable(false);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~pickitem
    private class PickActionThread extends Thread{
        private JLabel item;
        public PickActionThread(JLabel item)
        {
            this.item = item;
        }
        public void run()
        {
            int locationy = item.getY();
            int locationx = item.getX();
            for(int i =0;i<20;i++)
            {
                locationy-=1;
                item.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
            }
            if(item.getClass().getName().equals("First_2$MesoItem"))
                ((MesoItem)item).getMeso();
            else if(item.getClass().getName().equals("First_2$DropItem"))
            {
                itemlist[((DropItem)item).getType()]++;
                
                for(int i =0;i<8;i++)
                    if(subquickbuttonpane[i].getType()==((DropItem)item).getType())
                        {
                            numbertextfield[i].setText(String.valueOf(itemlist[((DropItem)item).getType()]));
                        }

                if(itemlist[((DropItem)item).getType()]==1)
                {
                     arrangeuseitemthread = new ArrangeUseItemThread();
                     arrangeuseitemthread.start();
                }
                else
                {
                    usedropitem[((DropItem)item).getType()].setText(String.valueOf(itemlist[((DropItem)item).getType()]));
                }
            }
            else if(item.getClass().getName().equals("First_2$QuestItem"))
            {
                questitemlist[((QuestItem)item).getType()]++;
                if(questitemlist[((QuestItem)item).getType()]==1)
                {
                    if(((QuestItem)item).getType()==0)
                    {
                        missioncondition[0] = true;
                    }
                    arrangeetcitemthread = new ArrangeEtcItemThread();
                    arrangeetcitemthread.start();
                }
                else
                {
                    etcquestitem[((QuestItem)item).getType()].setText(String.valueOf(questitemlist[((QuestItem)item).getType()]));
                }
            }
            item.setVisible(false);
        }
    }
    private class PickThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(ispickup&&!isghost)
                {
                    ispickup = false;
                    for(int i=0;i<dropnumber;i++)
                    {
                        if(way==1)
                        {
                            if(locationx<=dropitem[i].getLocationX()&&locationx+59>=dropitem[i].getLocationX())
                            {
                                PickActionThread pickactionthread = new PickActionThread(dropitem[i]);
                                pickactionthread.start();
                                int counter = i;
                                if(dropnumber!=1)
                                {
                                    dropitem[i] = dropitem[dropnumber-1];
                                }
                                dropnumber-=1;
                            }
                        }else
                        {
                            if(locationx<=dropitem[i].getLocationX()&&locationx+24>=dropitem[i].getLocationX())
                            {
                                PickActionThread pickactionthread = new PickActionThread(dropitem[i]);
                                pickactionthread.start();
                                int counter = i;
                                if(dropnumber!=1)
                                {
                                    dropitem[i] = dropitem[dropnumber-1];
                                }
                                dropnumber-=1;
                            }
                        }
                    }
                    for(int i = 0;i<mesonumber;i++)
                    {
                        if(way==1)
                        {
                            if(locationx<=mesoitem[i].getLocationX()&&locationx+59>=mesoitem[i].getLocationX())
                            {
                                PickActionThread pickactionthread = new PickActionThread(mesoitem[i]);
                                pickactionthread.start();
                                int counter = i;
                                if(mesonumber!=1)
                                {
                                    mesoitem[i] = mesoitem[mesonumber-1];
                                }
                                mesonumber-=1;
                            }
                        }else
                        {
                            if(locationx<=mesoitem[i].getLocationX()&&locationx+24>=mesoitem[i].getLocationX())
                            {
                                PickActionThread pickactionthread = new PickActionThread(mesoitem[i]);
                                pickactionthread.start();
                                int counter = i;
                                if(mesonumber!=1)
                                {
                                    mesoitem[i] = mesoitem[mesonumber-1];
                                }
                                mesonumber-=1;
                            }
                        }
                    }
                    for(int i =0;i<questitemnumber;i++)
                    {
                        if(way==1)
                        {
                            if(locationx<=questitem[i].getLocationX()&&locationx+59>=questitem[i].getLocationX())
                            {
                                if(i==0&&questitemlist[i]!=1)
                                {
                                    PickActionThread pickactionthread = new PickActionThread(questitem[i]);
                                    pickactionthread.start();
                                    int counter = i;
                                    if(questitemnumber!=1)
                                    {
                                        questitem[i] = questitem[questitemnumber-1];
                                    }
                                    questitemnumber-=1;
                                }
                                else
                                {
                                    inputArea.append("You can not have it more\n");
                                }
                            }
                        }else
                        {
                            if(locationx<=questitem[i].getLocationX()&&locationx+24>=questitem[i].getLocationX())
                            {
                                if(i==0&&questitemlist[i]!=1)
                                {
                                    PickActionThread pickactionthread = new PickActionThread(questitem[i]);
                                    pickactionthread.start();
                                    int counter = i;
                                    if(questitemnumber!=1)
                                    {
                                        questitem[i] = questitem[questitemnumber-1];
                                    }
                                    questitemnumber-=1;
                                }
                                else
                                {
                                    inputArea.append("You can not have it more\n");
                                }
                            }
                        }
                    }
                }
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~mesoitem
    private class MesoItem extends JLabel{
        private int type;
        private int locationx;
        private int locationy;
        public MesoItem(int type,int locationx,ImageIcon typepicture)
        {
            super(typepicture);
            this.type = type;
            this.locationx = locationx;
            this.locationy = backgroundy[mapcounter]-33;
        }
        public void getMeso()
        {
            if(type==0)
                getmesovalue += randnumber.nextInt(2)+20;
            if(type==1)
                getmesovalue += randnumber.nextInt(50)+200;
            if(type==2)
                getmesovalue += randnumber.nextInt(500)+2000;
            if(type==3)
                getmesovalue += randnumber.nextInt(5000)+20000;
            mesovalue.setText(String.valueOf(getmesovalue));

        }
        public int getLocationX()
        {
            return locationx;
        }
        public int getLocationY()
        {
            return locationy;
        }
    }
    private class MesoThread extends Thread{
        private MesoItem copymesoitem;
        public MesoThread(MesoItem copymesoitem)
        {
            this.copymesoitem = copymesoitem;
        }
        public void run()
        {
            int locationx = copymesoitem.getLocationX();
            int locationy = copymesoitem.getLocationY();

            for(int i = 0;i<20;i++)
            {
                copymesoitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
                locationy-=2;
            }
            for(int i=0;i<20;i++)
            {
                copymesoitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
                locationy+=2;
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~questitem
    private class QuestItem extends JLabel{
        private int type;
        private int locationx;
        private int locationy;
        public QuestItem(int type,int locationx,ImageIcon typepicture)
        {
            super(typepicture);
            this.type = type;
            this.locationx = locationx;
            this.locationy = backgroundy[mapcounter]-33;
            setForeground(Color.white);
        }
        public int getLocationX()
        {
            return locationx;
        }
        public int getLocationY()
        {
            return locationy;
        }
        public int getType()
        {
            return type;
        }
    }
    private class QuestThread extends Thread{
        private QuestItem copyquestitem;
        public QuestThread(QuestItem copyquestitem)
        {
            this.copyquestitem = copyquestitem;
        }
        public void run()
        {
            int locationx = copyquestitem.getLocationX();
            int locationy = copyquestitem.getLocationY();

            for(int i = 0;i<20;i++)
            {
                copyquestitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(6);
                }catch(InterruptedException e)
                {}
                locationy-=2;
            }
            for(int i=0;i<20;i++)
            {
                copyquestitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(6);
                }catch(InterruptedException e)
                {}
                locationy+=2;
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~dropitem
    private class DropItem extends JLabel{
        private int type;
        private int locationx;
        private int locationy;
        public DropItem(int type,int locationx,ImageIcon typepicture)
        {
            super(typepicture);
            this.type = type;
            this.locationx = locationx;
            this.locationy = backgroundy[mapcounter]-33;
            setForeground(Color.white);
        }
        public void effect()
        {
            if(type==0)
            {
                realhp+=hpmax;
                realmp+=mpmax;
                if(realhp>hpmax)
                    realhp = hpmax;
                if(realmp>mpmax)
                    realmp = mpmax;
            }
            if(type == 1)
            {
                realhp += 3000;
                if(realhp>hpmax)
                    realhp = hpmax;
            }
            if(type == 2)
            {
                realhp+=0.5*hpmax;
                realmp+=0.5*mpmax;
                if(realhp>hpmax)
                    realhp = hpmax;
                if(realmp>mpmax)
                    realmp = mpmax;
            }
            if(type == 3)
            {
                realhp +=2000;
                realmp +=2000;
                if(realmp>hpmax)
                    realhp = hpmax;
                if(realmp>mpmax)
                    realmp =mpmax;
            }
        }
        public int getLocationX()
        {
            return locationx;
        }
        public int getLocationY()
        {
            return locationy;
        }
        public int getType()
        {
            return type;
        }
    }
    private class DropThread extends Thread{
        private DropItem copydropitem;
        public DropThread(DropItem copydropitem)
        {
            this.copydropitem = copydropitem;
        }
        public void run()
        {
            int locationx = copydropitem.getLocationX();
            int locationy = copydropitem.getLocationY();

            for(int i = 0;i<20;i++)
            {
                copydropitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
                locationy-=2;
            }
            for(int i=0;i<20;i++)
            {
                copydropitem.setBounds(locationx,locationy,36,36);
                try{
                    Thread.sleep(12);
                }catch(InterruptedException e)
                {}
                locationy+=2;
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class DeliveryThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(isup&&!isghost)
                {
                    isup = false;
                    for(int i = 0 ;i<delivernumber[mapcounter];i++)
                        if(locationx<deliverlocationx[mapcounter][i]+50&&locationx>=deliverlocationx[mapcounter][i]-15)
                        {
                            isChange = true;
                            if(deliverdata[mapcounter][i][0]!=3)
                            changeMap(deliverdata[mapcounter][i][0],deliverdata[mapcounter][i][1]);
                            else
                            {
                                if(hasmission[2]&&mission[2])
                                    changeMap(deliverdata[mapcounter][i][0],deliverdata[mapcounter][i][1]);
                                else
                                    inputArea.append("You are not allowed to enter the region!\n");
                            }
                        }
                    isup = false;
                }
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    private void changeMap(int mapcounter,int charalocationx)
    {
        changeMapbackground.setVisible(true);
        this.mapcounter = mapcounter;
        
        solo.invokeLater(new ItemRemove());

        if(mapcounter ==4||mapcounter ==5||mapcounter==7)
            isinvincible = true;
        if(mapcounter!=3)
            boss.setVisible(false);
        else
            boss.setVisible(true);
        locationx = charalocationx;
        container.repaint();
        for(int i = 0 ;i<monsternumber[mapcounter] ; i++)
        {
            isattacked[i] = false;
            hasattacked[i] = false;
            death[i] = false;
            isMonsterMoving[i] = false;
            monsterdeadover[i] = false;
            monster[i].setVisible(true);
        }
        try {
            Thread.sleep(1500);
        }catch(InterruptedException e)
        {}
        for(int i =0;i<delivernumber[mapcounter];i++)
        {
            deliverypoint[i].setVisible(true);
        }
        for(int i=delivernumber[mapcounter];i<maxdelivernumber;i++)
            deliverypoint[i].setVisible(false);
        changeMapbackground.setVisible(false);
        isup=false;
        isChange = false;
    }
    private class RefreshThread extends Thread{
        public void run()
        {
            while(true)
            {
                try{
                    First_2.this.revalidate();
                    Thread.sleep(3000);
                }catch(InterruptedException e)
                {}
            }
        }
    }

    private class okhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            realhp = hpmax;
            deathmessagebackground.setVisible(false);
            okbutton.setVisible(false);
            isghost = false;
            changeMap(4,580);
            chara.requestFocus();
        }
    }

    private class inputhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(!(input.getText().equals(new String(""))))
            {
                inputArea.append(name+">>"+input.getText()+"\n");
                input.setText("");
            }
            else{
                chara.requestFocus();
            }
        }
    }

    private class Quitbuttonhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            First_2.this.dispose();
            System.exit(0);
        }
    }

    private class SaveButtonhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try{
                cout = new Formatter(data);
                cout.format("%d%n",1);
                cout.format("%d%n",mapcounter);
                cout.format("%d%n",level);
                cout.format("%s%n",mesovalue.getText());
                cout.format("%d%n",experiencevalue);
                cout.format("%d%n",crocodile);
                cout.format("%d%n",hpmax);
                cout.format("%d%n",mpmax);
                cout.format("%d%n",str);
                cout.format("%d%n",dex);
                cout.format("%d%n",luk);
                cout.format("%d%n",inte);
                cout.format("%s%n",name);
                cout.close();

                cout = new Formatter(missiondata);
                cout.format("%d%n",missionnumber);

                for(int i = 0;i<missionnumber;i++)
                {
                    if(mission[i]&&!hasmission[i])
                        cout.format("%d%n",0);
                    else if(!mission[i]&&hasmission[i])
                        cout.format("%d%n",1);
                    else if(mission[i]&&hasmission[i]&&!missioncondition[i])
                        cout.format("%d%n",2);
                    else if(mission[i]&&hasmission[i]&&missioncondition[i])
                        cout.format("%d%n",3);
                }
                cout.close();

                cout = new Formatter(itemdata);
                cout.format("%d%n",itemtypenumber);
                
                for(int i =0;i<itemtypenumber;i++)
                {
                    cout.format("%d%n",itemlist[i]);
                }

                cout.close();

                cout = new Formatter(questdata);
                cout.format("%d%n",questitemtypenumber);

                for(int i =0;i<questitemtypenumber;i++)
                {
                    cout.format("%d%n",questitemlist[i]);
                }

                cout.close();

            }catch(IOException io)
            {
                System.out.println("Error");
            }
        }
    }
    private class KeyBoardHintLabel extends JLabel{
        private JButton close;
        private class CloseHandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                KeyBoardHintLabel.this.setVisible(false);
            }
        }
        public KeyBoardHintLabel()
        {
            super(new ImageIcon("background/keyboardhint3.png"));
            setLayout(null);
            close = new JButton(new ImageIcon("ButtonImage/close.png"));

            add(close);
            close.addActionListener(new CloseHandler());
            close.setBounds(630,370,70,50);
        }

    }
    private class KeyHintHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            keyboardhintlabel.setVisible(true);
        }
    }

    private class Toolbuttonhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(!toolframe.isVisible())
            toolframe.setVisible(true);
            else
            toolframe.setVisible(false);
            chara.requestFocus();
        }
    }

    private class Abilitybuttonhandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(!abilityframe.isVisible())
            {
                abilityframe.requestFocusInWindow();
                pointfield.setText(String.valueOf(abilitypoint));
                abilityframe.setVisible(true);
            }
            else    
            {
                chara.requestFocusInWindow();
                abilityframe.setVisible(false);
            }
            chara.requestFocus();
        }
    }

    private class FirstMouseHandler extends MouseAdapter{
        private First_2 copy;
        public FirstMouseHandler (First_2 copy)
        {
            this.copy=copy;
        }

        public void mousePressed(MouseEvent e)
        {
            if(SwingUtilities.isLeftMouseButton(e))
                copy.setCursor(cursor2);
        }
        public void mouseReleased(MouseEvent e)
        {
            if(SwingUtilities.isLeftMouseButton(e))
            copy.setCursor(cursor);
        }
        public void mouseClicked(MouseEvent e)
        {
        
            if(!(e.getX()>=83&&e.getX()<=570&&e.getY()<=685&&e.getY()>=661))
            {
                chara.requestFocus();
                if(holdtype!=itemtypenumber-1)
                {
                    movinglabel[holdtype].setVisible(false);
                    holdtype = itemtypenumber-1;
                }
            }
        }
    }
    private class GhostThread extends Thread{
        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(isghost)
                {
                    isJump = false;
                    isattack = false;
                    isdown = false;
                    isstandingattack = false;
                    isdattack = false;
                    isstanding = true;

                    if(!deathmessagebackground.isVisible())
                    {
                        deathmessagebackground.setBounds(First_2.this.getWidth()/2-140,100,281,142);
                        deathmessagebackground.setVisible(true);
                        okbutton.setBounds(First_2.this.getWidth()/2-140+123,100+114,45,16);
                        okbutton.setVisible(true);
                    }
                    chara.setIcon(ghost[counter%3]);
                    chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy-8,65,80);
                    counter++;
                    try{
                        Thread.sleep(600);
                    }catch(InterruptedException e)
                    {}
                }
                System.out.print("");
            }
        }
    }
    private class MoveThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(isPMove&&!isghost)
                {
                    if(way==0)
                    {
                        locationy=511;
                        if(locationx>=5)
                            locationx-=6;
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy,100,69);
                    }else
                    {
                        locationy=511;
                        if(locationx<965)
                            locationx+=6;
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy,100,69);
                    }
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException ex)
                    {}
                }
                System.out.print("");
            }
        }
    }
    private class MoveActionThread extends Thread{
        public void run()
        {

            int counter = 0 ;
            while(true)
            {
                if(isPMove&&!isghost)
                {
                    counter++;
                    if(way==0)
                        chara.setIcon(walkleft[counter%4]);
                    else
                        chara.setIcon(walkright[counter%4]);
                    try{
                        Thread.sleep(166);
                    }catch(InterruptedException e){
                    }
                }
                else
                counter=0;
                System.out.print("");
            }
        }
    }
    private class DattackActionThread extends Thread{
        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(isdattack&&!isJump&&!isPMove&&!isMove&&!isghost)
                {
                    isdattack=false;
                    counter++;
                    if(way==0)
                        chara.setIcon(ldattack[counter%2]);
                    else
                        chara.setIcon(rdattack[counter%2]);
                    try{
                        if(counter%2==0)
                        Thread.sleep(300);
                        else
                        Thread.sleep(200);
                    }catch(InterruptedException e)
                    {
                    }
                }
                else
                counter=0;
                System.out.print("");
            }
        }
    }
    private class StandActionThread extends Thread{
        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(isstanding&&!isdown&&!isJump&&!isPMove&&!isattack&&!isstandingattack&&!isghost)
                {
                    counter++;
                    if(locationy!=511)
                        locationy=511;
                    chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy,100,69);
                    if(way==0)
                        chara.setIcon(standingleft[counter%3]);
                    else    
                        chara.setIcon(standingright[counter%3]);
                    try{
                        if(counter%3==0&&!isdown)
                        Thread.sleep(800);
                        else if(counter%3!=0&&!isdown)
                        Thread.sleep(200);
                    }catch(InterruptedException e)
                    {}
                }
                else
                    counter=0;
                System.out.print("");
            }
        }
    }
    private class BossThread extends Thread{
        private int time;
        public void run()
        {
            int choice;
            while(true)
            {
                if(mapcounter==3)
                {
                    if(!bhasattacked)
                    {
                        choice = randnumber.nextInt(3);
                        if(choice==0)
                        {
                            if(!bisattacked&&!bdeath)
                            {
                                bossway=0;
                                isbossmoving = true;
                                time=randnumber.nextInt(20)*3+5;
                                while((time--)!=0)
                                {
                                    if(bosslocationx+210>=2)
                                        bosslocationx-=3;
                                    boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                                    try{
                                        Thread.sleep(84);
                                    }catch(InterruptedException ex)
                                    {}
                                    System.out.print("");
                                    System.out.print("");
                                }
                            }
                        }
                        else if(choice ==1)
                        {
                            if(!bisattacked&&!bdeath)
                            {
                                bossway = 1;
                                isbossmoving = true;
                                time = randnumber.nextInt(20)*3+5;
                                while((time--)!=0)
                                {
                                    if(bosslocationx+360<1000)
                                        bosslocationx+=3;
                                    boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                                    try{
                                        Thread.sleep(84);
                                    }catch(InterruptedException e)
                                    {}
                                    System.out.print("");
                                    System.out.print("");
                                }
                            }
                        }
                        else
                        {
                            if(!bisattacked&&!bdeath)
                            {
                                isbossmoving = false;
                                if(bossway==0)
                                    boss.setIcon(bossstandingleft);
                                else
                                    boss.setIcon(bossstandingright);
                                time=randnumber.nextInt(20)+5;
                                while((time--)!=0)
                                {
                                    try{
                                        Thread.sleep(84);
                                    }catch(InterruptedException ex)
                                    {}
                                    System.out.print("");
                                    System.out.print("");
                                }
                            }
                        }
                    }
                    else if(!bdeath)
                    {
                        int back = randnumber.nextInt(5);
                        if(back>1&&!ismagicattack)
                        {
                            choice = randnumber.nextInt(3);
                            if(choice==1||choice==0)
                            {
                                if(locationx>bosslocationx+210)
                                {
                                    bossway = 1;
                                    isbossmoving = true;
                                    time = randnumber.nextInt(20)*3+5;
                                    while((time--)!=0)
                                    {
                                        if(bosslocationx+360<1000)
                                            bosslocationx+=3;
                                        boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                                        try{
                                            Thread.sleep(84);
                                        }catch(InterruptedException e)
                                        {}
                                        System.out.print("");
                                        System.out.print("");
                                    }
                                }
                                else
                                {
                                    bossway=0;
                                    isbossmoving = true;
                                    time = randnumber.nextInt(20)*3+5;
                                    while((time--)!=0)
                                    {
                                        if(bosslocationx+210>=0)
                                            bosslocationx-=3;
                                        boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                                        try{
                                            Thread.sleep(84);
                                        }catch(InterruptedException e)
                                        {}
                                        System.out.print("");
                                        System.out.print("");
                                    }

                                }
                            }
                        }else
                        {
                            if(locationx>bosslocationx+210)
                            {
                                bossway = 1;
                                isbossmoving = false;
                                ismagicattack = true;
                            }
                            else
                            {
                                bossway = 0;
                                isbossmoving = false;
                                ismagicattack = true;
                            }
                        }

                    }
                }else{
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e)
                    {}
                }
            }
        }
    }
    private class BossHpThread extends Thread{
        public void run()
        {
            int about;
            while(true)
            {
                if(mapcounter==3)
                {
                    if(bossblood < 0)
                        bdeath = true;
                    about = (bossblood*100)/bossmaxblood;
                    if(about<0)
                    about = 0;
                    bosshp.setVisible(true);
                    for(int i =0;i<about&&i<100;i++)
                    {
                        blank[i].setVisible(false);
                    }
                    for(int i = about;i<100;i++)
                    {
                        blank[i].setVisible(true);
                    }
                }else
                {
                    bosshp.setVisible(false);
                    for(int i =0;i<100;i++)
                    {
                        blank[i].setVisible(false);
                    }    
                }try{
                    Thread.sleep(200);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class BossDeathThread extends Thread{
        public void run()
        {
            boolean over = false;
            while(true)
            {
                if(bdeath&&!over)
                {
                    over = true;
                    experiencevalue += bossexperience;
                    missioncondition[2] = true;
                    if(bossway==0)
                    {
                        for(int i = 0;i<bossdeathcounter;i++)
                        {
                            boss.setIcon(bossldeath[i]);
                            try{
                                Thread.sleep(300);
                            }catch(InterruptedException e)
                            {}
                        }
                    }else
                    {
                        for(int i =0;i<bossdeathcounter;i++)
                        {
                            boss.setIcon(bossrdeath[i]);
                            try{
                                Thread.sleep(300);
                            }catch(InterruptedException e)
                            {}
                        }
                    }
                    boss.setVisible(false);
                }try{
                    Thread.sleep(100);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class BossMagicThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(ismagicattack)
                {
                    magictimer.schedule(new MagicTimerTask(),200);
                    if(locationx>bosslocationx+210)
                    {
                        for(int i = 0 ;i<bossrmagic.length;i++)
                        {
                            boss.setIcon(bossrmagic[i]);
                            try{
                                Thread.sleep(200);
                            }catch(InterruptedException e)
                            {}
                        }
                    }
                    else
                    {
                        for(int i =0;i<bosslmagic.length;i++)
                        {
                            boss.setIcon(bosslmagic[i]);
                            try{
                                Thread.sleep(200);
                            }catch(InterruptedException e)
                            {}
                        }
                    }
                    ismagicattack = false;
                }
                try{
                    Thread.sleep(200);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class MagicTimerTask extends TimerTask{
        public void run()
        {
            int bossattackvalue = randnumber.nextInt(3000)+3000;
            if(bossway==0&&!isinvincible)
            {
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e)
                {}
                magic.setVisible(true);
                monstershowattack(bossattackvalue,locationx,locationy+20);
                for(int i =0;i<6;i++)
                {
                    magic.setIcon(magicleffect[i]);
                    magic.setBounds(locationx,locationy-30,140,133);
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e)
                    {}
                }
                magic.setVisible(false);
                isinvincible = true;
            }
            if(bossway==1&&!isinvincible)
            {
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e)
                {}
                magic.setVisible(true);
                monstershowattack(bossattackvalue,locationx,locationy+20);
                for(int i =0;i<6;i++)
                {
                    magic.setIcon(magicreffect[i]);
                    magic.setBounds(locationx,locationy-30,140,133);
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e)
                    {}
                }
                magic.setVisible(false);
                isinvincible = true;
            }
        }
    }
    private class BossAttackThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(mapcounter==3)
                {
                    int bossattackvalue = randnumber.nextInt(2000)+2000;
                    if(!isattack&&!isdattack)
                    {
                        if(!isinvincible&&!isghost&&!bdeath&&bosslocationx+210<locationx+50&&bosslocationx+210+150-20>=locationx)
                        {
                            if(!isinvincible){
                                monstershowattack(bossattackvalue,locationx,locationy);
                                try{
                                Thread.sleep(500);
                                }catch(InterruptedException e)
                                {}
                            }
                        }
                    }
                    else
                    {
                        if(way==0)
                        {
                            if(!isinvincible&&!isghost&&!bdeath&&bosslocationx+210<locationx+65&&bosslocationx+210+150-20>=locationx+113)
                            {
                                if(!isinvincible)
                                {
                                    monstershowattack(bossattackvalue,locationx+65,locationy);
                                    try{
                                        Thread.sleep(500);
                                    }catch(InterruptedException e)
                                    {}
                                }
                            }
                        }
                        if(!isinvincible&&!isghost&&!bdeath&&bosslocationx+210<locationx&&bosslocationx+210+150-20>=locationx+50)
                        {
                            if(!isinvincible)
                            {
                                monstershowattack(bossattackvalue,locationx,locationy);
                                try{
                                Thread.sleep(500);
                                }catch(InterruptedException e)
                                {}
                            }
                        }
                    }
                }
                try{
                    Thread.sleep(30);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    private class BossActionThread extends Thread{

        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(!bdeath&&isbossmoving&&!bisattacked&&!ismagicattack)
                {
                    counter++;
                    if(bossway==0)
                        boss.setIcon(bossmoveleft[counter%bossmoveleftcounter]);
                    else
                        boss.setIcon(bossmoveright[counter%bossmoverightcounter]);

                    try{
                        Thread.sleep(150);
                    }catch(InterruptedException e)
                    {}
                }else
                counter=0;
                System.out.print("");
            }
        }
    }
    private class MonsterActionThread extends Thread{
        private int monsternumber;  
        public MonsterActionThread(int monsternumber)
        {
            this.monsternumber = monsternumber;
        }
        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(!death[monsternumber]&&isMonsterMoving[monsternumber]&&!isattacked[monsternumber])
                {
                    counter++;
                    if(monsterway[monsternumber]==0)
                        monster[monsternumber].setIcon(monstermoveleft[mapcounter][counter%monstermoveleftcounter[mapcounter]]);
                    else
                        monster[monsternumber].setIcon(monstermoveright[mapcounter][counter%monstermoverightcounter[mapcounter]]);

                    try{
                        Thread.sleep(150);
                    }catch(InterruptedException e)
                    {}
                }else
                counter=0;
                System.out.print("");
            }
        }
    }
    private class MonsterMove extends Thread{
        private int choice;
        private int time;
        private int monsternumber;
        public MonsterMove(int monsternumber)
        {
            this.monsternumber = monsternumber;
        }
        public void run()
        {
            while(true)
            {
                choice=randnumber.nextInt(3);
                
                if(!hasattacked[monsternumber])
                {
                    if(choice==0)
                    {
                        if(!isattacked[monsternumber]&&!death[monsternumber])
                        {
                            monsterway[monsternumber]=0;
                            isMonsterMoving[monsternumber] = true;
                            time=randnumber.nextInt(20)+5;
                            while((time--)!=0)
                            {
                                if(monsterlocationx[monsternumber]>=2)
                                    monsterlocationx[monsternumber]-=2;
                                monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                try{
                                    Thread.sleep(84);
                                }catch(InterruptedException ex)
                                {}
                                System.out.print("");
                                System.out.print("");
                            }
                        }
                    }
                    else if(choice==1)
                    {
                        if(!isattacked[monsternumber]&&!death[monsternumber])
                        {
                            monsterway[monsternumber]=1;
                            isMonsterMoving[monsternumber] = true;
                            time=randnumber.nextInt(20)+5;
                            while((time--)!=0)
                            {
                                try{
                                  Thread.sleep(84);
                                }catch(InterruptedException ex)
                                {}
                                if(monsterlocationx[monsternumber]+monstersize[mapcounter][1]<=968)
                                monsterlocationx[monsternumber]+=2;
                                monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                System.out.print("");
                                System.out.print("");
                            }
                        }
                    }
                    else if(choice==2)
                    {
                        if(!isattacked[monsternumber]&&!death[monsternumber])
                        {
                            isMonsterMoving[monsternumber] = false;
                            if(monsterway[monsternumber]==0)
                            monster[monsternumber].setIcon(monsterstandingleft[mapcounter]);
                            else
                            monster[monsternumber].setIcon(monsterstandingright[mapcounter]);
                            time=randnumber.nextInt(10)+5;
                            while((time--)!=0)
                            {
                                try{
                                    Thread.sleep(84);
                                }catch(InterruptedException ex)
                                {}
                                System.out.print("");
                                System.out.print("");
                            }
                        }
                    }
                }
                else
                {
                    int change;
                    if(locationx<monsterlocationx[monsternumber])
                    {
                        if(!isattacked[monsternumber])
                        {
                            monsterway[monsternumber]=0;
                            isMonsterMoving[monsternumber] = true;
                            time=randnumber.nextInt(20)+5;
                            while((time--)!=0)
                            {
                                if(monsterlocationx[monsternumber]>=2)
                                    monsterlocationx[monsternumber]-=2;
                                monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                try{
                                    Thread.sleep(84);
                                }catch(InterruptedException ex)
                                {}
                                System.out.print("");
                                System.out.print("");
                            }
                        }else
                        {
                            change = randnumber.nextInt(6);
                            if(change<2)
                            {
                                monsterway[monsternumber]=1;
                                isMonsterMoving[monsternumber] = true;
                                time=randnumber.nextInt(20)+5;
                                while((time--)!=0)
                                {
                                    try{
                                        Thread.sleep(84);
                                    }catch(InterruptedException ex)
                                    {}
                                    if(monsterlocationx[monsternumber]<=968)
                                    monsterlocationx[monsternumber]+=2;
                                    monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                    System.out.print("");
                                    System.out.print("");
                                }
                            }
                        }
                    }
                    if(locationx>monsterlocationx[monsternumber])
                    {
                        if(!isattacked[monsternumber])
                        {
                            monsterway[monsternumber]=1;
                            isMonsterMoving[monsternumber] = true;
                            time=randnumber.nextInt(20)+5;
                            while((time--)!=0)
                            {
                                try{
                                    Thread.sleep(84);
                                }catch(InterruptedException ex)
                                {}
                                if(monsterlocationx[monsternumber]<=968)
                                monsterlocationx[monsternumber]+=2;
                                monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                System.out.print("");
                                System.out.print("");
                            }
                        }else
                        {
                            change = randnumber.nextInt(6);
                            if(change<2)
                            {
                                monsterway[monsternumber]=1;
                                isMonsterMoving[monsternumber] = true;
                                time=randnumber.nextInt(20)+5;
                                while((time--)!=0)
                                {
                                    try{
                                        Thread.sleep(84);
                                    }catch(InterruptedException ex)
                                    {}
                                    if(monsterlocationx[monsternumber]<=968)
                                    monsterlocationx[monsternumber]+=2;
                                    monster[monsternumber].setBounds(monsterlocationx[monsternumber],backgroundy[mapcounter]-580+monsterlocationy[monsternumber]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                    System.out.print("");
                                    System.out.print("");
                                }
                            }
                        }
                    }
                }
                try{
                    Thread.sleep(25);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class GainingThread extends Thread{
        public void run()
        {
            while(true)
            {
                try{
                    gainarea.setText("");
                    Thread.sleep(3000);
                }catch(InterruptedException e)
                {}
            }
        }
    }
    private class MReliveThread extends Thread{
        public void run()
        {
            while(true)
            {
                for(int i=0;i<monsternumber[mapcounter];i++)
                {
                    if(death[i])
                    {
                        try{
                            Thread.sleep(3000);
                        }catch(InterruptedException e)
                        {}
                        monsterway[i]=randnumber.nextInt(2);
                        monsterlocationx[i] = randnumber.nextInt(mapwidth);
                        monsterlocationy[i] = 580-26;
                        death[i] = false;
                        isattacked[i] = false;
                        monster[i].setIcon(monsterstandingleft[mapcounter]);
                        monster[i].setBounds(monsterlocationx[i],backgroundy[mapcounter]-580+monsterlocationy[i]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                        monsterdeadover[i] = false;
                        monster[i].setVisible(true);
                    }
                    System.out.print("");
                }
                try{
                    Thread.sleep(25);
                }catch(InterruptedException e)
                {}
            }
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class MDeathActionThread extends Thread{
        private int monsternumber;
        public MDeathActionThread(int monsternumber)
        {
            this.monsternumber = monsternumber;
        }
        public void run(){
            while(true)
            {
               if(death[monsternumber]&&!monsterdeadover[monsternumber])
                {
                    for(int counter = 0;counter<monsterdeathcounter[mapcounter];counter++)
                    {
                        if(monsterway[monsternumber]==0)
                            monster[monsternumber].setIcon(monsterldeath[mapcounter][counter]);
                        else
                            monster[monsternumber].setIcon(monsterrdeath[mapcounter][counter]);
                        try{
                            Thread.sleep(150);
                        }catch(InterruptedException e)
                        {}
                    }
                    monsterdeadover[monsternumber] = true;
                    monster[monsternumber].setVisible(false);
                }try{
                    Thread.sleep(25);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    private class AddMesoItem extends Thread{
        private MesoItem mesoitem;
        public AddMesoItem(MesoItem mesoitem)
        {
            this.mesoitem = mesoitem;
        }
        public void run()
        {
            First_2.this.add(mesoitem,1);
        }
    }
    private class AddDropItem extends Thread{
        private DropItem dropitem;
        public AddDropItem(DropItem dropitem)
        {
            this.dropitem = dropitem;
        }
        public void run()
        {
            First_2.this.add(dropitem,1);
        }
    }
    private class AddQuestItem extends Thread{
        private QuestItem questitem;
        public AddQuestItem(QuestItem questitem)
        {
            this.questitem = questitem;
        }
        public void run()
        {
            First_2.this.add(questitem,1);
        }
    }
    private class ItemRemove extends Thread{    
        public ItemRemove()
        {
            setPriority(7);
        }
        public void run()
        {

            for(int i = 0;i<dropnumber;i++)
                dropitem[i].setBounds(0,0,0,0);
            for(int i = 0;i<mesonumber;i++)
                mesoitem[i].setBounds(0,0,0,0);
            for(int i = 0;i<questitemnumber;i++)
                questitem[i].setBounds(0,0,0,0);

            dropnumber = 0;
            mesonumber = 0;
            questitemnumber = 0;
        }
    }
    private class MDeathThread extends Thread{
        public void run(){
            while(true)
            {
                for(int i=0;i<monsterblood[mapcounter].length;i++)
                {
                    if(monsterblood[mapcounter][i]<0)
                    {
                        int itemormeso = randnumber.nextInt(2);
                        if(itemormeso==0){
                            int type = randnumber.nextInt(4);
                            First_2.this.dropitem[dropnumber] = new DropItem(type,monsterlocationx[i]+50,dropitempicture[type]);
                            solo.invokeLater(new AddDropItem(dropitem[dropnumber]));
                            DropThread dropthread = new DropThread(dropitem[dropnumber]);
                            dropnumber++;
                            dropthread.start();
                        }else
                        {
                            int type = randnumber.nextInt(mesoitemtypenumber);
                            First_2.this.mesoitem[mesonumber] = new MesoItem(type,monsterlocationx[i]+50,mesoitempicture[type]);
                            solo.invokeLater(new AddMesoItem(mesoitem[mesonumber]));
                            MesoThread mesothread = new MesoThread(mesoitem[mesonumber]);
                            mesonumber++;
                            mesothread.start();
                        }
                        if(mission[0]&&hasmission[0]&&mapcounter==2)
                        {
                            int chance = randnumber.nextInt(500);
                            if(chance>400)
                            {
                                int type = randnumber.nextInt(questitemtypenumber);
                                First_2.this.questitem[questitemnumber] = new QuestItem(type,monsterlocationx[i]+50,questitempicture[type]);
                                solo.invokeLater(new AddQuestItem(questitem[questitemnumber]));
                                QuestThread questthread = new QuestThread(questitem[questitemnumber]);
                                questitemnumber++;
                                questthread.start();
                            }
                        }

                        if(!missioncondition[3]&&mission[3]&&hasmission[3]&&mapcounter==6)
                        {
                            crocodile++;
                            if(crocodile == 30)
                            missioncondition[3] = true;
                        }
                        hasattacked[i]=false;
                        monsterblood[mapcounter][i]=filemonsterblood[mapcounter];
                        death[i] = true;
                        gainarea.append("Exp:"+monsterexperience[mapcounter]+"\n");
                        experiencevalue+=monsterexperience[mapcounter];
                        if(experiencevalue>=experience[level-120])
                        {
                            islevelup=true;
                        }
                        try{
                            Thread.sleep(500);
                        }catch(InterruptedException e)
                        {}
                    }
                }try{
                    Thread.sleep(25);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    private class LevelTimerTask extends TimerTask{
        private Clip clip;
        public LevelTimerTask()
        {
            try{
                File levelupfile = new File("music/levelup.wav");
                AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(levelupfile);
                clip = AudioSystem.getClip();
                clip.open(audioinputstream);
            }catch(IOException e)
            {}catch(LineUnavailableException e)
            {}catch(UnsupportedAudioFileException e)
            {}
        }
        public void run()
        {
            levelup.setBounds(locationx-68,backgroundy[mapcounter]-580+locationy-232,246,345);
            levelup.setVisible(true);
            clip.start();
            for(int i =0;i<leveluppicture.length;i++)
            {
                levelup.setIcon(leveluppicture[i]);
                try{
                    Thread.sleep(100);
                    System.out.print("");
                }catch(InterruptedException e)
                {}
            }
            levelup.setVisible(false);
        }
    }

    private class LevelThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(islevelup)
                {
                    realhp = hpmax;
                    experiencevalue-=experience[level-120];
                    level+=1;
                    lvpane.changeLevel(level);
                    leveluptimer.schedule(new LevelTimerTask(),100);
                    islevelup=false;
                    abilitypoint+=5;
                    pointfield.setText(String.valueOf(abilitypoint));
                }
                System.out.print("");
            }
        }
    }
    private class AttackThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(mapcounter != 4&&mapcounter != 5 &&mapcounter != 7 && mapcounter != 3&&isattack&&!isghost)
                {
                    isattack=false;
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e)
                    {}
                    boolean over=false;
                    if(way==0)
                    {
                        for(int i=0;!over&&i<monsterlocationx.length;i++)
                        {
                            if(!death[i]&&monsterlocationx[i]>locationx-70+26-monstersize[mapcounter][0]&&monsterlocationx[i]<locationx+5)
                            {
                                isattacked[i]=true;
                                monster[i].setBounds(monsterlocationx[i],backgroundy[mapcounter]-580+monsterlocationy[i]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                monster[i].setIcon(monsterrhit[mapcounter]);
                                monsterlocationx[i]-=5;
                                hasattacked[i]=true;
                                monsterway[i] = 1;
                                over = true;
                                attackrange = (str*30)+randnumber.nextInt(4000)+4000;
                                monsterblood[mapcounter][i]-=attackrange;
                                attackx = monsterlocationx[i];
                                attacky = monsterlocationy[i];
                                isShow=true;
                                try{
                                    Thread.sleep(500);
                                    isattacked[i]=false;
                                }catch(InterruptedException ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                    else
                    {
                        for(int i=0;!over&&i<monsterlocationx.length;i++)
                        {
                            if(!death[i]&&monsterlocationx[i]<locationx+120&&monsterlocationx[i]>=locationx)
                            {
                                isattacked[i]=true;
                                monster[i].setBounds(monsterlocationx[i],backgroundy[mapcounter]-580+monsterlocationy[i]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);
                                monster[i].setIcon(monsterlhit[mapcounter]);
                                hasattacked[i]=true;
                                monsterlocationx[i]+=5;
                                monsterway[i] = 0;
                                attackrange = (str*30)+randnumber.nextInt(4000)+4000;
                                monsterblood[mapcounter][i]-=attackrange;
                                over = true;
                                attackx = monsterlocationx[i];
                                attacky = monsterlocationy[i];
                                isShow=true;
                                try{
                                    Thread.sleep(500);
                                    isattacked[i]=false;
                                }catch(InterruptedException ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }
                else if(mapcounter ==4||mapcounter ==5||mapcounter ==7)
                    isattack = false;
                else if(mapcounter==3&&isattack&&!isghost)
                {
                    isattack = false;
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e)
                    {}
                    if(way==0)
                    {
                        if(!bdeath&&bosslocationx+210>locationx-70+26-150&&bosslocationx+210+150<locationx+5)
                        {
                            avoid = randnumber.nextInt(7);
                            bisattacked = true;
                            boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                            if(avoid>4)
                            boss.setIcon(bossrhit);
                            bosslocationx-=3;
                            bhasattacked = true;
                            bossway = 1;
                            attackrange = str*25+randnumber.nextInt(4000)+3200;
                            bossblood -= attackrange;
                            attackx = bosslocationx+210;
                            attacky = bosslocationy;
                            isShow=true;
                            try{
                                Thread.sleep(500);
                                bisattacked = false;
                            }catch(InterruptedException e)
                            {}
                        }
                    }else
                    {
                        if(!bdeath&&bosslocationx+210<locationx+120&&bosslocationx+210>=locationx)
                        {
                            avoid = randnumber.nextInt(7);
                            bisattacked = true;
                            boss.setBounds(bosslocationx,backgroundy[3]-580+bosslocationy-bosssize[1]+26,bosssize[0],bosssize[1]);
                            if(avoid>4)
                            boss.setIcon(bosslhit);
                            bosslocationx+=3;
                            bhasattacked = true;
                            bossway = 0;
                            attackrange = str*25+randnumber.nextInt(4000)+3200;
                            bossblood -= attackrange;
                            attackx = bosslocationx+210;
                            attacky = bosslocationy;
                            isShow=true;
                            try{
                                Thread.sleep(500);
                                bisattacked = false;
                            }catch(InterruptedException e)
                            {}
                        }
                    }
                }
                System.out.print("");
                isShow=false;
            }
        }
    }
    private class AttackActionThread extends Thread{
        public void run()
        {
            int counter = 0;
            while(true)
            {
                if(isstandingattack&&!isghost)
                {
                    counter++;
                    if(way==1)
                        chara.setIcon(attackrightwitheff[counter%3]);
                    else    
                        chara.setIcon(attackleftwitheff[counter%3]);
                    try{
                        if(counter%3==0)
                            Thread.sleep(100);
                        if(counter%3==2)
                            Thread.sleep(100);
                        if(counter%3==1)
                            Thread.sleep(300);
                    }catch(InterruptedException e)
                    {}
                }
                else
                    counter=0;
                System.out.print("");
            }
        }
    }
    private class JumpThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(isJump&&!isghost)
                {
                    System.out.print("");
                    while(copylocationy+40>=locationy)
                    {
                        copylocationy-=5;
                        if(way==1)
                        {
                            if(locationx<965)
                                locationx+=rate;
                        }
                        else
                        {
                            if(locationx>=5)
                                locationx-=rate;
                        }
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+copylocationy,100,69);
                        try{
                            Thread.sleep(24);
                        }catch(InterruptedException ex)
                        {}
                    }
                    while(copylocationy<locationy)
                    {
                        copylocationy+=5;
                        if(way==1)
                        {
                            if(locationx<965)
                                locationx+=rate;
                        }
                        else
                        {
                            if(locationx>=5)
                                locationx-=rate;
                        }
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+copylocationy,100,69);
                        try{
                            Thread.sleep(24);
                        }catch(InterruptedException ex)
                        {}
                    }
                    isstanding = true;
                }
                System.out.print("");
            }
        }
    }

    private class Remove implements Runnable{
        private JLabel[] copy;
        public Remove(JLabel []copy)
        {
            this.copy = copy;
        }
        synchronized public void run()
        {
            for(int i=0;i<copy.length;i++)
            {
                copy[i].setBounds(1500,1500,0,0);
                First_2.this.remove(copy[i]);
            }
        }
    }

    private class Add implements Runnable{
        private JLabel[] copy;
        private int x;
        private int y;
        public Add(JLabel []copy,int x,int y)
        {
            this.copy = copy;
            this.x = x;
            this.y =y;
        }
        synchronized public void run()
        {
            for(int i=0 ;i<copy.length;i++)
            {
                First_2.this.add(copy[i],1);
                copy[i].setBounds(x+37*i,y-50,37,38);
            }
        }
    }
    private class MAttackTimerTask extends TimerTask{
        private JLabel []copylabel;
        private int x;
        private int y;

        public MAttackTimerTask(JLabel []copylabel,int x,int y)
        {
            this.copylabel = new JLabel [copylabel.length];
            for(int i =0 ;i<copylabel.length;i++)
                this.copylabel[i] = new JLabel(copylabel[i].getIcon());
            this.x = x;
            this.y = y;
        }
        public void run()
        {
            for(int i = 0 ;i<3; i++)
            {
                isinvincible = true;
                solo.invokeLater(new Add(copylabel,x,y));
                try{
                    Thread.sleep(150);
                }catch(InterruptedException e)
                {}
            }
            solo.invokeLater(new Remove(copylabel));
        }
    }
    
    private class Monsterattack extends Thread{
        public void run()
        {   
            while(true)
            {
                int monsterattackvalue = 1500+randnumber.nextInt(1500);
                for(int i = 0;i<monsternumber[mapcounter]&&mapcounter!=3;i++)
                {
                    if(!isattack&&!isdattack)
                    {
                        if(!isghost&&!death[i]&&monsterlocationx[i]<locationx&&monsterlocationx[i]+monstersize[i][0]-20>=locationx)
                        {
                            if(!isinvincible){
                                monstershowattack(monsterattackvalue,locationx,locationy);
                                try{
                                Thread.sleep(500);
                                }catch(InterruptedException e)
                                {}
                            }
                        }
                    }
                    else
                    {
                        if(way==0)
                        {
                            if(!isghost&&!death[i]&&monsterlocationx[i]<locationx+65&&monsterlocationx[i]+monstersize[i][0]-20>=locationx+113)
                            {
                                if(!isinvincible)
                                {
                                    monstershowattack(monsterattackvalue,locationx+65,locationy);
                                    try{
                                        Thread.sleep(500);
                                    }catch(InterruptedException e)
                                    {}
                                }
                            }
                        }
                        if(!isghost&&!death[i]&&monsterlocationx[i]<locationx&&monsterlocationx[i]+monstersize[i][0]-20>=locationx+50)
                        {
                            if(!isinvincible)
                            {
                                monstershowattack(monsterattackvalue,locationx,locationy);
                                try{
                                Thread.sleep(500);
                                }catch(InterruptedException e)
                                {}
                            }
                        }
                    }
                }try{
                    Thread.sleep(30);
                }catch(InterruptedException e)
                {}
                System.out.print("");
            }
        }
    }
    private void monstershowattack(int value,int x,int y)
    {
        int length = 0;
        int copyvalue = value;
        realhp-=value;
        if(realhp<0)
        {
            realhp = 0;
            isghost = true;
        }
        while(value!=0)
        {
            value/=10;
            length++;
        }
        monsterattacklabel = new JLabel[length];
        for(int i = 0;i<monsterattacklabel.length;i++)
        {
            monsterattacklabel[length-1-i] = new JLabel(new ImageIcon("monstervalue/value"+copyvalue%10+".png"));
            copyvalue/=10;
        }
        Timer monstershowValue = new Timer();
        monstershowValue.schedule(new MAttackTimerTask(monsterattacklabel,locationx,locationy),0);
    }

    private void showAttack(int value,int x,int y)
    {
        int length = 0;
        int copyvalue = value;
        while(value!=0)
        {
            value/=10;
            length++;
        }
        attacklabel= new JLabel[length];
        for(int i = 0;i<attacklabel.length;i++)
        {
            attacklabel[length-1-i] = new JLabel(new ImageIcon(String.format("Value/value"+copyvalue%10+".png")));
            copyvalue/=10;
        }
        Timer showValue = new Timer();
        showValue.schedule(new AttackTimerTask(attacklabel,x,y),0);
    }

    private class AttackTimerTask extends TimerTask{
        private float alpha = 0.0f;
        private int x;
        private int y;
        public AttackTimerTask(JLabel []realcopy,int x,int y)
        {
            copy = new JLabel[realcopy.length];
            this.x = x;
            this.y =y;
            for(int i = 0;i<copy.length;i++)
                copy[i] = new JLabel(realcopy[i].getIcon());
        } 
        public void run()
        {
            for(int i=0;i<3;i++)
            {
                solo.invokeLater(new Add(copy,x,y));
                try{
                    alpha+=0.1f;
                    Thread.sleep(100);
                    y = y-3;
                    for(int j = 0;j<copy.length;j++)
                    {
                        copy[j].firePropertyChange("flpha",alpha-0.1f,alpha);
                    }
                    System.out.print("");
                }catch(InterruptedException e)
                {}
            }
            solo.invokeLater(new Remove(copy));
        }
    }
    private class AttackValueThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(mapcounter!=4&&isShow&&!isghost)
                {
                    showAttack(attackrange,attackx,attacky);
                    isShow=false;
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e)
                    {
                    }
                }
                System.out.print("");
            }
        }
    }
    
    private class InvincibleThread extends Thread{
        public void run()
        {
            while(true)
            {
                if(isinvincible)
                {
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e)
                    {}
                    if(mapcounter==7||mapcounter==4||mapcounter==5||isChange)
                        isinvincible = true;
                    if(mapcounter != 4&&mapcounter != 5&&!isChange&&mapcounter != 7)
                        isinvincible = false;
                }
                System.out.print("");
            }
        }
    }

    private class ChatPane extends JPanel{
        private ImageIcon background;
        public ChatPane (){
            background = new ImageIcon("Other/chatpicture.png");
            //setFocusable(true);
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(background.getImage(),0,0,570,27,null);
        }
    }

    private class DesktopContainer extends JDesktopPane{
        public void paintComponent(Graphics g)
        {
            g.drawImage(background[mapcounter].getImage(),0,0,1017,720,null);
        }
    }
    private class StatePanel extends JPanel{
        private ImageIcon background;
        private JTextField experience;
        private JTextField health;
        private JTextField maxhealth;
        private JTextField magic;
        private JTextField maxmagic;
        private JTextField pa;
        public StatePanel ()
        {
            background = new ImageIcon("ButtonImage/statebackground.png");
            setSize(359,34);
            setVisible(true);
            experience = new JTextField();
            experience.setEditable(false);
            experience.setForeground(Color.white);
            experience.setOpaque(false);
            experience.setBorder(new LineBorder(new Color(0,0,0,0)));
            experience.setHorizontalAlignment(SwingUtilities.RIGHT);
            experience.setFont(new Font(null,Font.BOLD,10));

            health = new JTextField();
            health.setEditable(false);
            health.setForeground(Color.white);
            health.setOpaque(false);
            health.setBorder(new LineBorder(new Color(0,0,0,0)));
            health.setHorizontalAlignment(SwingUtilities.RIGHT);
            health.setFont(new Font(null,Font.BOLD,10));

            magic = new JTextField();
            magic.setEditable(false);
            magic.setForeground(Color.white);
            magic.setOpaque(false);
            magic.setBorder(new LineBorder(new Color(0,0,0,0)));
            magic.setHorizontalAlignment(SwingUtilities.RIGHT);
            magic.setFont(new Font(null,Font.BOLD,10));


            maxhealth = new JTextField(String.valueOf(hpmax));
            maxhealth.setEditable(false);
            maxhealth.setForeground(Color.white);
            maxhealth.setOpaque(false);
            maxhealth.setBorder(new LineBorder(new Color(0,0,0,0)));
            maxhealth.setHorizontalAlignment(SwingUtilities.RIGHT);
            maxhealth.setFont(new Font(null,Font.BOLD,10));

            maxmagic = new JTextField(String.valueOf(mpmax));
            maxmagic.setEditable(false);
            maxmagic.setForeground(Color.white);
            maxmagic.setOpaque(false);
            maxmagic.setBorder(new LineBorder(new Color(0,0,0,0)));
            maxmagic.setHorizontalAlignment(SwingUtilities.RIGHT);
            maxmagic.setFont(new Font(null,Font.BOLD,10));

            pa = new JTextField();
            pa.setEditable(false);
            pa.setForeground(Color.white);
            pa.setOpaque(false);
            pa.setBorder(new LineBorder(new Color(0,0,0,0)));
            pa.setHorizontalAlignment(SwingUtilities.RIGHT);
            
            pa.setFont(new Font(null,Font.BOLD,10));

            hp = new JLabel[51];
            mp = new JLabel[55];
            exp = new JLabel[55];


            ExpThread expthread = new ExpThread();
            expthread.start();
            HpMpThread hpmpthread = new HpMpThread();
            hpmpthread.start();
            StateThread statethread = new StateThread();
            statethread.start();
            
        }
        public void paintComponent(Graphics g)
        {
            g.drawImage(background.getImage(),0,0,359,34,null);
            add(pa);
            add(experience);
            add(health);
            add(maxhealth);
            add(magic);
            add(maxmagic);

            magic.setBounds(141,1,32,15);
            maxmagic.setBounds(180,1,32,15);
            maxhealth.setBounds(66,1,32,15);
            health.setBounds(28,1,32,15);
            experience.setBounds(254,1,57,15);
            pa.setBounds(316,1,21,15);
        }
        private class ExpThread extends Thread{
            public void run()
            {
                while(true)
                {
                    int about = (experiencevalue*100)/First_2.this.experience[level-120]; 
                    experience.setText(String.valueOf(experiencevalue));
                    pa.setText(String.valueOf(about));
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e)
                    {
                    }
                }
            }
        }
        private class HpMpThread extends Thread{
            public void run()
            {
                while(true)
                {
                    int about = (realhp)/hpmax;
                    health.setText(String.valueOf(realhp));
                    hpfield.setText(String.valueOf(realhp)+"/"+String.valueOf(hpmax));
                    magic.setText(String.valueOf(realmp));
                    mpfield.setText(String.valueOf(realmp)+"/"+String.valueOf(mpmax));
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e)
                    {}
                }
            }
        }
        private class StateThread extends Thread{
            public void run()
            {
                while(true)
                {
                    int about = (experiencevalue*55)/(First_2.this.experience[level-120]);
                    for(int i =1;i<=about&&i<exp.length;i++)
                    {
                        if(exp[i-1]!=null)
                        exp[i-1].setVisible(true);
                    }
                    for(int i =about+1;i<exp.length;i++)
                    {
                        if(exp[i-1]!=null)
                        exp[i-1].setVisible(false);
                    }
                    about = (realhp*55)/hpmax;
                    for(int i =1;i<=about&&i<hp.length;i++)
                    {
                        if(hp[i-1]!=null)
                        hp[i-1].setVisible(true);
                    }
                    for(int i = about+1;about>=0&&i<hp.length;i++)
                    {
                        if(hp[i-1]!=null)
                        hp[i-1].setVisible(false);
                    }
                    about = (realmp)*55/mpmax;
                    for(int i =1;i<about&&i<mp.length;i++)
                    {
                        if(mp[i-1]!=null)
                            mp[i-1].setVisible(true);
                    }
                    for(int i =about;i<mp.length;i++)
                    {
                        if(mp[i-1]!=null)
                            mp[i-1].setVisible(false);
                    }
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e)
                    {
                    }
                    about = experiencevalue/First_2.this.experience[level-120];
                    maxhealth.setText(String.valueOf(hpmax));
                    maxmagic.setText(String.valueOf(mpmax));
                    expfield.setText(String.valueOf(experiencevalue)+"("+String.valueOf(about)+")");
                    strfield.setText(String.valueOf(str));
                    dexfield.setText(String.valueOf(dex));
                    intfield.setText(String.valueOf(inte));
                    lukfield.setText(String.valueOf(luk));
                }
            }
        }
    }

    private class AbilityInternalFrame extends JInternalFrame{
        private JButton []button;
        private Cursor cursor;
        private Cursor cursor2;
        private Image cimage1;
        private Image cimage2;
        private JLabel []state;
        private class buttonhandler implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                if(abilitypoint>0)
                {
                    abilitypoint--;
                    for(int i =0;i<button.length;i++)
                    {
                        if(e.getSource()==button[i])
                        {
                            if(i==0)
                                hpmax+=117;
                            else if(i==1)
                                mpmax+=52;
                            else if(i==2)
                                str+=1;
                            else if(i==3)
                                dex+=1;
                            else if(i==4)
                                inte+=1;
                            else if(i==5)
                                luk+=1;
                        }
                    }
                    pointfield.setText(String.valueOf(abilitypoint));
                }
            }
        }
        private class AbilityMouseHandler extends MouseAdapter{
            public void mousePressed(MouseEvent e)
            {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    AbilityInternalFrame.this.setCursor(cursor2);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    AbilityInternalFrame.this.setCursor(cursor);
                }
            }
        }

        private class ButtonThread extends Thread{
            public void run()
            {
                while(true)
                {
                    if(abilitypoint==0)
                    {
                        for(int i = 0;i<button.length;i++)
                            button[i].setVisible(false);
                    }else
                    {
                        for(int i = 0;i<button.length;i++)
                            button[i].setVisible(true);
                    }
                    System.out.print("");
                }
            }
        }
        public AbilityInternalFrame(String title,boolean re,boolean cl,boolean ma,boolean ic)
        {
            super(title,re,cl,ma,ic);
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            try{
                cimage1=ImageIO.read(new File("Cursor/cursor.png"));
                cimage2=ImageIO.read(new File("Cursor/cursor2.png"));
                cursor=toolkit.createCustomCursor(cimage1,new Point(10,4),"cursor");
                cursor2=toolkit.createCustomCursor(cimage2,new Point(10,4),"cursor2");
                setCursor(cursor);
            }catch(IOException ex)
            {}

            addMouseListener(new AbilityMouseHandler());
            buttonhandler statehandler = new buttonhandler();
            
            setContentPane(new JLabel(new ImageIcon("ButtonImage/abilitybackground.png")));
            button = new JButton[6];
            state = new JLabel [21];
            pointfield = new JTextField(String.valueOf(abilitypoint));
            namefield = new JTextField(name);
            namefield.setOpaque(false);
            namefield.setBorder(new LineBorder(new Color(0,0,0,0)));
            jobfield = new JTextField("WARRIOR");
            jobfield.setOpaque(false);
            jobfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            JTextField subjobfield = new JTextField("[DARK KNIGHT]");
            subjobfield.setFont(new Font(null,Font.BOLD,9));
            subjobfield.setOpaque(false);
            subjobfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            subjobfield.setForeground(Color.PINK);
            levelfield = new JTextField(String.valueOf(level));
            levelfield.setOpaque(false);
            levelfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            hpfield = new JTextField (String.valueOf(realhp)+"/"+String.valueOf(hpmax));
            hpfield.setOpaque(false);
            hpfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            mpfield = new JTextField (String.valueOf(realmp)+"/"+String.valueOf(mpmax));
            mpfield.setOpaque(false);
            mpfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            expfield = new JTextField (String.valueOf(experiencevalue)+"/"+experience[level-120]);
            expfield.setOpaque(false);
            expfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            famefield = new JTextField(String.valueOf(fame));
            famefield.setOpaque(false);
            famefield.setBorder(new LineBorder(new Color(0,0,0,0)));
            strfield = new JTextField(String.valueOf(str));
            strfield.setOpaque(false);
            strfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            dexfield = new JTextField(String.valueOf(dex));
            dexfield.setOpaque(false);
            dexfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            intfield = new JTextField(String.valueOf(inte));
            intfield.setOpaque(false);
            intfield.setBorder(new LineBorder(new Color(0,0,0,0)));
            lukfield = new JTextField(String.valueOf(luk));
            lukfield.setOpaque(false);
            lukfield.setBorder(new LineBorder(new Color(0,0,0,0)));

            pointfield.setHorizontalAlignment(SwingUtilities.RIGHT);
            
            namefield.setEditable(false);
            jobfield.setEditable(false);
            subjobfield.setEditable(false);
            levelfield.setEditable(false);
            hpfield.setEditable(false);
            mpfield.setEditable(false);
            expfield.setEditable(false);
            famefield.setEditable(false);
            strfield.setEditable(false);
            dexfield.setEditable(false);
            intfield.setEditable(false);
            lukfield.setEditable(false);

            pointfield.setEditable(false);
            add(namefield);
            add(jobfield);
            add(subjobfield);
            add(levelfield);
            add(hpfield);
            add(mpfield);
            add(expfield);
            add(famefield);
            add(strfield);
            add(dexfield);
            add(intfield);
            add(lukfield);

            add(pointfield);
            for(int i=0;i<6;i++)
            {
                    button[i] = new JButton(new ImageIcon("ButtonImage/IncreaseButton.png"));
                    add(button[i]);
                    button[i].addActionListener(statehandler);
            }

            for(int i = 0 ;i<21;i++)
            {
                state[i] = new JLabel(new ImageIcon("ButtonImage/statelabel"+i+".png"));
                add(state[i]);
            }
            pointfield.setBounds(54,191,28,16);
            button[0].setBounds(147,94,12,12);
            button[1].setBounds(147,112,12,12);
            button[2].setBounds(147,224,12,12);
            button[3].setBounds(147,242,12,12);
            button[4].setBounds(147,260,12,12);
            button[5].setBounds(147,278,12,12);

            state[0].setBounds(2,9,48,16);
            state[1].setBounds(2,27,48,26);
            state[2].setBounds(2,55,48,16);
            state[3].setBounds(2,73,48,16);
            state[4].setBounds(2,91,48,16);
            state[5].setBounds(2,109,48,16);
            state[6].setBounds(2,127,48,16);
            state[7].setBounds(2,145,48,16);
            state[8].setBounds(2,221,48,16);
            state[9].setBounds(2,239,48,16);
            state[10].setBounds(2,257,48,16);
            state[11].setBounds(2,275,48,16);
            namefield.setBounds(53,10,110,15);
            jobfield.setBounds(53,28,110,13);
            subjobfield.setBounds(53,41,110,13);
            levelfield.setBounds(53,56,110,13);

            hpfield.setBounds(53,92,90,15);
            mpfield.setBounds(53,110,90,15);
            expfield.setBounds(53,128,110,15);
            famefield.setBounds(53,146,110,15);
            strfield.setBounds(53,222,90,15);
            dexfield.setBounds(53,240,90,15);
            intfield.setBounds(53,258,90,15);
            lukfield.setBounds(53,276,90,15);

            state[0].setToolTipText("<html>" + "Name of the Character "+ "<br>" + "Name Changed coupon can be bought in the"+"<br>"+"Cash Shop." + "</html>");
            state[1].setToolTipText("<html>" + "Job of the Character"+"<br>"+"Can make the job advancement to Warrior,"+"<br>"+"Bowman, Thief, Magician, or Pirate."+"<br>"+"Warrior:Minimum of Level 10, Perion"+"<br>"+"Bowman:Minimum of Level 10, Henesys"+"<br>"+"Magician:Minimum of Level 8, Ellinia"+"<br>"+"Thief:Minimum of Leel 10, Kerning City"+"<br>"+"Pirate:Minimum of Level 10, The Nautitus"+"</html>");
            state[2].setToolTipText("<html>"+"Level"+"<br>"+"Accumulate enough EXP to raise the level of the character."+"<html>");
            state[3].setToolTipText("<html>"+"Main Guild"+"<br>"+"The main community of the communities "+"<br>"+"the account belongs to. Press \"G\" to check"+"<br>"+" guild info.");
            state[4].setToolTipText("<html>"+"Health Point"+"<br>"+"It's a health stat, and if it reaches 0. the"+"<br>"+"character dies."+"<br>"+"HP decreases if either attacked by an"+"<br>"+"enemy or if a certain skill is used."+"<br>"+"It can go up to the maximum of 30,000"+"<br>"+"points."+"</html>");
            state[5].setToolTipText("<html>"+"Mana Point"+"<br>"+"The stat needed to use various skills."+"<br>"+"It can go up to maximum of 30,000 "+"<br>"+"points."+"</html>");
            state[6].setToolTipText("<html>"+"EXP"+"<br>"+"The amount of experience gained."+"<br>"+"Obtained by killing a monster or completing"+"<br>"+"a quest."+"</html>");
            state[7].setToolTipText("<html>"+"Fame"+"<br>"+"The level of fame can be increased or"+"<br>"+"decreased, based on other users. Some"+"<br>"+"equipments and quests require the"+"<br>"+"character reach acertain level of fame"+"</html>");
            state[8].setToolTipText("<html>"+"Strength(STR)"+"<br>"+"Strength determines the attack strength of "+"<br>"+"Warriors and Pirates (Brawiers) with melee"+"<br>"+"weapons."+"</html>");
            state[9].setToolTipText("<html>"+"Dexterity(DEX)"+"<br>"+"As this stat increases, Accuracy and"+"<br>"+"Avoidability increase. It determines the "+"<br>"+"attack strength of Bowmen and Pirates"+"<br>"+"(Gunslingers)."+"</html>");
            state[10].setToolTipText("<html>"+"Intelligence(INT)"+"<br>"+"The higher this stat, the higher the accuracy"+"<br>"+"and strength of your magic attack. The most"+"<br>"+"important stat that determines the magic"+"<br>"+" attacks for Mage's"+"</html>");
            state[11].setToolTipText("<html>"+"Luck(LUK)"+"<br>"+"The higher it is, the higher the avoidability is."+"<br>"+"<br>"+"It determines the Thief's attacking ability"+"<br>"+"and the Mage's magic attack accuracy."+"<br>"+"Also, the higher it is, the less EXP a character loses by dying."+"</html>");
            ButtonThread buttonthread = new ButtonThread();
            buttonthread.start();

            setVisible(true);
            setDefaultCloseOperation(1);
            addInternalFrameListener(new internalframehandler());
            pack();
        }
        private class internalframehandler extends InternalFrameAdapter{
            public void internalFrameClosed(InternalFrameEvent e)
            {
                AbilityInternalFrame.this.setVisible(false);
                chara.requestFocus();
            }
        }
    }

    public First_2 (String name) {
        setLayout(null);
        this.name = name;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~data//
        Scanner cin;
        level = 120;
        file = new File[totalmap];
        monsternumber = new int [totalmap];
        monstermoverightcounter = new int[totalmap];
        monstermoveleftcounter = new int[totalmap];
        monsterdeathcounter = new int [totalmap];
        filemonsterblood = new int [totalmap];
        monsterexperience = new int [totalmap];
        backgroundy = new int [totalmap];
        deliverlocationx = new int [totalmap][];
        delivernumber = new int[totalmap];
        deliverdata = new int [totalmap][][];
        monstersize = new int [totalmap][2];

        for(int i = 0;i<totalmap;i++)
        {
            file[i] = new File("data/data"+i+".txt");
            try{
                cin = new Scanner(file[i]);
                monsternumber[i] = cin.nextInt();
                monstermoverightcounter[i] = cin.nextInt();
                monstermoveleftcounter[i] = cin.nextInt();
                monsterdeathcounter[i] = cin.nextInt();
                filemonsterblood[i] = cin.nextInt();
                monsterexperience[i] = cin.nextInt();
                backgroundy[i] = cin.nextInt();
                delivernumber[i] = cin.nextInt();
                deliverdata[i] = new int [delivernumber[i]][2];

                if(delivernumber[i]>maxdelivernumber)
                    maxdelivernumber = delivernumber[i];
                deliverlocationx[i] = new int [delivernumber[i]];
                File deliverfile = new File ("data/deliver/data"+i+".txt");
                Scanner cin2 = new Scanner(deliverfile);
                for(int j = 0 ;j<deliverlocationx[i].length;j++)
                {
                    deliverlocationx[i][j] = cin2.nextInt(); 
                    deliverdata[i][j][0] = cin2.nextInt();
                    deliverdata[i][j][1] = cin2.nextInt();
                }
            }catch(IOException e)
            {}
        }
        try{
            expfile = new File("data/exp/exp.txt");
            cin = new Scanner(expfile);
            experience = new int [cin.nextInt()];
            for(int i =0;i<10;i++)
            {
                experience[i] = cin.nextInt();
            }
            
            statefile = new File("data/state/state.txt");
            cin = new Scanner(statefile);
            hpmax = cin.nextInt();
            realhp = hpmax;
            mpmax = cin.nextInt();
            realmp = mpmax;
            str = cin.nextInt();
            dex = cin.nextInt();
            inte = cin.nextInt();
            luk = cin.nextInt();
            fame = cin.nextInt();

            File monsterfile = new File("data/monster/monstersize.txt");
            cin = new Scanner(monsterfile);
            for(int i =0;i<totalmap;i++)
            {
                monstersize[i][0] = cin.nextInt();
                monstersize[i][1] = cin.nextInt();
            }

        }catch(IOException e)
        {}

        dropitempicture = new ImageIcon[itemtypenumber];
        for(int i = 0;i<itemtypenumber;i++)
            dropitempicture[i] = new ImageIcon("Item/item"+i+".png");
        dropitem =new DropItem[100];

        mesoitempicture = new ImageIcon[mesoitemtypenumber];
        for(int i =0;i<mesoitemtypenumber ;i++)
            mesoitempicture[i] = new ImageIcon("Item/meso"+i+".png");
        mesoitem = new MesoItem[100];


        questitempicture = new ImageIcon[questitemtypenumber];
        for(int i =0;i<questitemtypenumber;i++)
            questitempicture[i] = new ImageIcon("questitem/questitem"+i+".png");
        questitem = new QuestItem[100];
        questitemlist = new int [questitemtypenumber];
        for(int i =0;i<questitemtypenumber ;i++)
            questitemlist[i] = 0;

        itemlist = new int [itemtypenumber];
        for(int i =0;i<itemtypenumber ;i++)
            itemlist[i] = 0;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~data//

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~savedata
        data = new File("savedata/data.txt");
        itemdata = new File("savedata/itemdata.txt");
        questdata = new File("savedata/questdata.txt");
        missiondata = new File("savedata/missiondata.txt");
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~npcdata
        try{
            npcfile = new File("data/npc/npc.txt");
            cin = new Scanner(npcfile);
            npcnumber = cin.nextInt();
            missionnumber = npcnumber;
            
            missionname = new String [npcnumber];
            missionreward = new int [npcnumber][2];

            npccontentnumber = new int [npcnumber];
            npcquestcontentnumber = new int [npcnumber];
            npcquestyetcontentnumber = new int [npcnumber];
            npcquestfinishcontentnumber = new int [npcnumber];

            npccontent = new String[npcnumber][][];
            npcquestcontent = new String[npcnumber][][];
            npcquestyetcontent = new String[npcnumber][][];
            npcquestfinishcontent = new String[npcnumber][][];

            npclocationx = new int [npcnumber];
            npclabel = new JLabel[npcnumber];
            npcpicture = new ImageIcon[npcnumber][];
            npcpicturenumber  = new int [npcnumber];
            npcchatpane = new NpcChatPane[npcnumber];
            for(int i = 0;i<npcnumber;i++)
            {
                npcpicturenumber[i] = cin.nextInt();
                npcpicture[i] = new ImageIcon[npcpicturenumber[i]];
                npclocationx[i] = cin.nextInt();
                npccontentnumber[i] = cin.nextInt();
                npcquestcontentnumber[i] = cin.nextInt();
                npcquestyetcontentnumber[i] = cin.nextInt();
                npcquestfinishcontentnumber[i] = cin.nextInt();

                npccontent[i] = new String[npccontentnumber[i]][];
                npcquestcontent[i] = new String[npcquestcontentnumber[i]][];
                npcquestyetcontent[i] = new String[npcquestyetcontentnumber[i]][];
                npcquestfinishcontent[i] = new String[npcquestfinishcontentnumber[i]][];
            }
            for(int i =0;i<npcnumber;i++)
            {
                for(int j = 0;j<npccontentnumber[i] ; j++)
                {
                    File file = new File("data/npc/npccontent/npc"+i+j+".txt");
                    String number;
                    cin = new Scanner(file);
                    number = cin.nextLine();
                    npccontent[i][j] = new String[Integer.parseInt(number)];

                    for(int k = 0;k<Integer.parseInt(number);k++)
                    {
                        npccontent[i][j][k] = cin.nextLine();
                    }
                }
            }
            for(int i =0;i<npcnumber;i++)
            {
                for(int j = 0;j<npcquestcontentnumber[i] ; j++)
                {
                    File file = new File("data/npc/npcquestcontent/npc"+i+j+".txt");
                    String number;
                    cin = new Scanner(file);
                    number = cin.nextLine();
                    npcquestcontent[i][j] = new String[Integer.parseInt(number)];
                    for(int k = 0;k<Integer.parseInt(number);k++)
                    {
                        npcquestcontent[i][j][k] = cin.nextLine();
                    }
                }
            }

            for(int i =0;i<npcnumber;i++)
            {
                for(int j = 0;j<npcquestyetcontentnumber[i] ; j++)
                {
                    File file = new File("data/npc/npcquestyetcontent/npc"+i+j+".txt");
                    String number;
                    cin = new Scanner(file);
                    number = cin.nextLine();
                    npcquestyetcontent[i][j] = new String[Integer.parseInt(number)];

                    for(int k = 0;k<Integer.parseInt(number);k++)
                    {
                        npcquestyetcontent[i][j][k] = cin.nextLine();
                    }
                }
            }

            for(int i =0;i<npcnumber;i++)
            {
                for(int j = 0;j<npcquestfinishcontentnumber[i] ; j++)
                {
                    File file = new File("data/npc/npccontent/npc"+i+j+".txt");
                    String number;
                    cin = new Scanner(file);
                    number = cin.nextLine();
                    npcquestfinishcontent[i][j] = new String[Integer.parseInt(number)];

                    for(int k = 0;k<Integer.parseInt(number);k++)
                    {
                        npcquestfinishcontent[i][j][k] = cin.nextLine();
                    }
                }
            }
            File file = new File ("data/npc/questname.txt");
            cin = new Scanner(file);
            for(int i =0;i<npcnumber;i++)
            {
                missionname[i] = cin.nextLine();
            }
            File file2 = new File ("data/npc/questreward.txt");
            cin = new Scanner(file2);
            for(int i =0;i<npcnumber;i++)
            {
                missionreward[i][0] = cin.nextInt();
                missionreward[i][1] = cin.nextInt();
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~npcdata//

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~salemandata
        try{

            buyitemlabel = new BuyItemLabel();
            disablelabel = new DisableLabel();
            File itemfile = new File("Item/item.txt");
            cin = new Scanner(itemfile);
            itemname = new String[itemtypenumber];
            itemprice = new String[itemtypenumber];
            for(int i = 0;i<itemtypenumber-1 ;i++)
            {
                itemname[i] = cin.next();
                itemprice[i] = cin.next();
            }


            File salemanfile = new File("data/saleman/saleman.txt");
            cin = new Scanner(salemanfile);
            salemannumber = cin.nextInt();
            salemanpicturenumber = new int [salemannumber];
            saleman = new JLabel[salemannumber];
            salemanpicture = new ImageIcon[salemannumber][];
            salemanlocationx = new int [salemannumber];
            salepane = new SalePane[salemannumber];
            salemanmousehandler = new SaleManMouseHandler();
            for(int i =0;i<salemannumber;i++)
            {
                salemanpicturenumber[i] = cin.nextInt();
                salemanlocationx[i] =cin.nextInt();
                salemanpicture[i] = new ImageIcon[salemanpicturenumber[i]];
                for(int j = 0;j<salemanpicturenumber[i];j++)
                {
                    salemanpicture[i][j] = new ImageIcon("Saleman/saleman"+i+"/saleman"+j+".png");
                }
                saleman[i] = new JLabel(salemanpicture[i][0]);
                saleman[i].addMouseListener(salemanmousehandler);
                salepane[i] = new SalePane(i,salemanpicture[i][0]);
            }
        }catch(IOException e)
        {
        }

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~salemandata//

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~boss
        boss = new JLabel();
        bosslocationx = 380;
        bosslocationy = 580-26;
        bossmoveleftcounter = 5;
        bossmoverightcounter = 5;
        bossdeathcounter = 3;
        bossstandingleft = new ImageIcon("Boss/monster/monsterstandingleft.png");
        bossstandingright = new ImageIcon("Boss/monster/monsterstandingright.png");
        bosslhit = new ImageIcon("Boss/monster/monsterlhit.png");
        bossrhit = new ImageIcon("Boss/monster/monsterrhit.png");
        bosslmagic = new ImageIcon[8];
        bossrmagic = new ImageIcon[8];
        bossmoveright = new ImageIcon[bossmoverightcounter];
        bossmoveleft = new ImageIcon[bossmoveleftcounter];
        bossrdeath = new ImageIcon[bossdeathcounter];
        bossldeath = new ImageIcon[bossdeathcounter];
        magicleffect = new ImageIcon[6];
        magicreffect = new ImageIcon[6];
        bossblood = bossmaxblood;
        bosssize = new int [2];
        bosshp = new JLabel(new ImageIcon("ButtonImage/bosshp.png"));
        blank = new JLabel[100];

        for(int i = 0;i<100;i++)
        {
            blank[i] = new JLabel(new ImageIcon("ButtonImage/blank.png"));
        }

        for(int i =0;i<6;i++)
        {
            magicleffect[i] = new ImageIcon("Effect/magicl"+i+".png");
            magicreffect[i] = new ImageIcon("Effect/magicr"+i+".png");
        }
        magic = new JLabel(magicleffect[0]);
        for(int i =0;i<bosslmagic.length;i++)
        {
            bosslmagic[i] = new ImageIcon("Boss/monster/monsterlmagic"+i+".png");
            bossrmagic[i] = new ImageIcon("Boss/monster/monsterrmagic"+i+".png");
        }

        for(int i =0;i<bossmoveleftcounter;i++)
        {
            bossmoveleft[i] = new ImageIcon("Boss/monster/monstermoveleft"+i+".png");
            bossmoveright[i] = new ImageIcon("Boss/monster/monstermoveright"+i+".png");
        }

        for(int i =0;i<bossdeathcounter;i++)
        {
            bossrdeath[i] = new ImageIcon("Boss/monster/monsterrdeath"+i+".png");
            bossldeath[i] = new ImageIcon("Boss/monster/monsterldeath"+i+".png");
        }

        bosssize[0] = 600;
        bosssize[1] = 200;


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~bassdata//
        background = new ImageIcon[totalmap];
        for(int i =0;i<totalmap;i++)
            background[i] = new ImageIcon("mbackground/background"+i+".png");
        container =new DesktopContainer();
        setContentPane(container);
        add(changeMapbackground = new JLabel(new ImageIcon("Other/changeMapbackground.png")));
        locationx=500;
        locationy=511;
        copylocationy=locationy;
        way=1;
        isJump=false;
        rate=0;

        Toolkit toolkit=Toolkit.getDefaultToolkit();
        try{
            cimage1=ImageIO.read(new File("Cursor/cursor.png"));
            cimage2=ImageIO.read(new File("Cursor/cursor2.png"));
            cursor=toolkit.createCustomCursor(cimage1,new Point(10,4),"cursor");
            cursor2=toolkit.createCustomCursor(cimage2,new Point(10,4),"cursor2");
            setCursor(cursor);
        }catch(IOException ex)
        {}
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("ToolTip.background",new Color(11,11,28));
            UIManager.put("ToolTip.foreground",Color.WHITE);
            UIManager.put("InternalFrame.background",Color.black);
            UIManager.put("InternalFrame.activeTitleBackground", Color.black);
            UIManager.put("InternalFrame.activeTitleForeground", Color.white);
            UIManager.put("InternalFrame.inactiveTitleBackground", Color.black);
            UIManager.put("InternalFrame.inactiveTitleForeground", Color.white);
        }catch(Exception e)
        {}

        randnumber=new SecureRandom();
        gainarea = new JTextArea();
        gainarea.setOpaque(false);
        gainarea.setForeground(Color.RED);
        gainarea.setEditable(false);

        deathmessagebackground = new JLabel(new ImageIcon("ButtonImage/deathmessagebackground.png"));
        okbutton = new JButton (new ImageIcon("ButtonImage/ok.png"));

        standingleft = new ImageIcon[3];
        standingright =new ImageIcon[3];
        walkleft = new ImageIcon[4];
        walkright = new ImageIcon[4];
        attackleftwitheff=new ImageIcon[3];
        attackrightwitheff=new ImageIcon[3];
        onfloorright=new ImageIcon ("chara2/onfloorright.png");
        onfloorleft=new ImageIcon("chara2/onfloorleft.png");
        rjump = new ImageIcon("chara2/rjump.png");
        ljump = new ImageIcon("chara2/ljump.png");
        rdattack = new ImageIcon[2];
        ldattack = new ImageIcon[2];
        ghost = new ImageIcon[3];

        isattack=false;

        monsterlhit = new ImageIcon[totalmap];
        for(int i = 0;i<totalmap;i++)
            monsterlhit[i] = new ImageIcon ("Monster/monster"+i+"/monsterlhit.png");
        monsterrhit = new ImageIcon[totalmap];
        for(int i = 0 ;i<totalmap;i++)
            monsterrhit[i] = new ImageIcon ("Monster/monster"+i+"/monsterrhit.png");
        monsterstandingleft=new ImageIcon[totalmap];
        for(int i = 0 ;i<totalmap;i++)
            monsterstandingleft[i] = new ImageIcon("Monster/monster"+i+"/monsterstandingleft.png");
        monsterstandingright = new ImageIcon[totalmap];
        for(int i = 0 ;i<totalmap;i++)
            monsterstandingright[i]=new ImageIcon("Monster/monster"+i+"/monsterstandingright.png");
        isMonsterMoving = new boolean[monsternumber[mapcounter]];
        monstermoveleft = new ImageIcon[totalmap][];
        monstermoveright = new ImageIcon[totalmap][];
        monsterrdeath = new ImageIcon[totalmap][];
        monsterldeath = new ImageIcon[totalmap][];

        monsterlocationx= new int [monsternumber[mapcounter]];
        monsterlocationy= new int [monsternumber[mapcounter]];
        monsterway=new int[monsternumber[mapcounter]];
        monster=new JLabel[monsternumber[mapcounter]];
        isattacked = new boolean [monsternumber[mapcounter]];
        hasattacked = new boolean[monsternumber[mapcounter]];
        death = new boolean[monsternumber[mapcounter]];
        monsterdeadover = new boolean[monsternumber[mapcounter]];
        monsterblood = new int [totalmap][];
        dfirsttime = new int [monsternumber[mapcounter]];

        for(int j = 0;j<totalmap;j++)
        {
            monstermoveright[j] = new ImageIcon[monstermoverightcounter[j]];
            monstermoveleft[j] = new ImageIcon[monstermoverightcounter[j]];
            for(int i = 0;i<monstermoverightcounter[j];i++)
            {
                monstermoveright[j][i] = new ImageIcon("Monster/monster"+j+"/monstermoveright"+i+".png");
                monstermoveleft[j][i] = new ImageIcon("Monster/monster"+j+"/monstermoveleft"+i+".png");
            }
        }
        for(int j = 0;j<totalmap;j++)
        {
            monsterrdeath[j] = new ImageIcon[monsterdeathcounter[j]];
            monsterldeath[j] = new ImageIcon[monsterdeathcounter[j]];
            for(int i = 0;i<monsterdeathcounter[j];i++)
            {
                monsterrdeath[j][i] = new ImageIcon("Monster/monster"+j+"/monsterrdeath"+i+".png");
                monsterldeath[j][i] = new ImageIcon("Monster/monster"+j+"/monsterldeath"+i+".png");
            }
        }
        for(int i = 0;i<monsternumber[mapcounter];i++)
        {
            monsterdeadover[i] = false;
        }

        for(int i = 0;i<monsternumber[mapcounter];i++)
        {
            dfirsttime[i] = 0;
        }
        for(int j = 0;j<totalmap;j++)
        {
            monsterblood[j] = new int [monsternumber[j]];
            for(int i = 0;i<monsternumber[j];i++)
                {
                    monsterblood[j][i] = filemonsterblood[j];
                }
        }

        toAll = new JButton(new ImageIcon("Other/toAll.png"));
        input = new JTextField(300);

        addMouseListener(new FirstMouseHandler(this));


        deliverpicture = new ImageIcon[3];
        leveluppicture = new ImageIcon[13];
        lvpane = new LVpane(name,level);
        volumepane = new audiovolume();
        chatpane = new ChatPane();
        inputArea = new JTextArea();
        inputArea.setEditable(false);
        inputArea.setBackground(new Color(30,30,30));
        inputArea.setForeground(new Color(255,255,255));
        inputpane =new JScrollPane(inputArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputhandler handler = new inputhandler();
        input.addActionListener(handler); 

        Toolbuttonhandler toolbuttonhandler = new Toolbuttonhandler();
        toolframe = new ToolInternalFrame("ITEM INVENTORY",false,true,false,false);
        toolframe.setVisible(false);
        toolButton = new JButton(new ImageIcon("ButtonImage/toolbutton.png"));
        toolButton.addActionListener(toolbuttonhandler);


        Abilitybuttonhandler abilitybuttonhandler = new Abilitybuttonhandler();
        abilityframe = new AbilityInternalFrame("CHARACTER STATS",false,true,false,false);
        abilityframe.setVisible(false);
        abilityButton = new JButton(new ImageIcon("ButtonImage/abilitybutton.png"));
        abilityButton.addActionListener(abilitybuttonhandler);

        statepane = new StatePanel();

        quickbuttonpane = new QuickButtonPane();

        for(int i=0;i<3;i++)
        {
            deliverpicture[i] = new ImageIcon(String.format("Other/delivery"+(i+1)+".png"));
        }
        for(int i=0;i<13;i++)
        {
            leveluppicture[i] = new ImageIcon(String.format("Other/levelup"+i+".png"));
        }
        for(int i=0;i<4;i++)
        {
            walkleft[i] = new ImageIcon("chara2/walkleft"+i+".png");
            walkright[i] = new ImageIcon("chara2/walkright"+i+".png");
        }

        for(int i = 0;i<3;i++)
        {
            standingleft[i] = new ImageIcon("chara2/standingleft"+i+".png");
            standingright[i] = new ImageIcon("chara2/standingright"+i+".png");
        }

        for(int i = 0;i<2;i++)
        {
            rdattack[i] = new ImageIcon("chara2/rdattack"+i+".png");
            ldattack[i] = new ImageIcon("chara2/ldattack"+i+".png");
        }

        for(int i = 0;i<3;i++)
        {
            attackrightwitheff[i] = new ImageIcon("chara2/attackrightwitheff"+i+".png");
            attackleftwitheff[i] = new ImageIcon("chara2/attackleftwitheff"+i+".png");
        }

        for(int i = 0;i<3; i++)
        {
            ghost[i] = new ImageIcon("chara2/tomb"+i+".png");
        }

        levelup = new JLabel(leveluppicture[0]);
        deliverypoint = new JLabel[maxdelivernumber];


        Quitbuttonhandler quitbuttonhandler = new Quitbuttonhandler();  
        quitbutton = new JButton(new ImageIcon("ButtonImage/quitbutton.png"));
        quitbutton.addActionListener(quitbuttonhandler);

        SaveButtonhandler savebuttonhandler = new SaveButtonhandler();
        savebutton = new JButton(new ImageIcon("ButtonImage/savebutton.png"));
        savebutton.addActionListener(savebuttonhandler);

        keyboardhintlabel = new KeyBoardHintLabel();
        keyboardhintlabel.setVisible(false);
        KeyHintHandler keyhinthandler = new KeyHintHandler();
        keyboardhintbutton = new JButton(new ImageIcon("ButtonImage/keyboard.png"));
        keyboardhintbutton.addActionListener(keyhinthandler);

        for(int i =0;i<deliverypoint.length;i++)
            deliverypoint[i] = new JLabel(deliverpicture[0]);

        for(int i=0;i<51;i++)
        {
            mp[i] = new JLabel(new ImageIcon("Other/mp.png"));
            add(mp[i]);
            mp[i].setBounds(213+119+2*i,720-34+16,2,14);
            mp[i].setVisible(false);
        }

        for(int i=0;i<55;i++)
        {
            exp[i] = new JLabel(new ImageIcon("Other/exp.png"));
            add(exp[i]);
            exp[i].setBounds(213+232+2*i,720-34+16,2,14);
            exp[i].setVisible(false);
        }

        for(int i= 0;i<51;i++)
        {
            hp[i] = new JLabel(new ImageIcon("Other/hp.png"));
            add(hp[i]);
            hp[i].setBounds(213+11+2*i,720-34+16,2,14);
            hp[i].setVisible(false);
        }
        isstanding = true;
        chara = new JLabel(standingright[0]);

        for(int i = 0 ;i<maxdelivernumber;i++)
            add(deliverypoint[i],2);

        for(int i =0;i<itemtypenumber;i++)
            add(movinglabel[i]);

        mission = new boolean[missionnumber];
        missioncondition = new boolean[missionnumber];
        hasmission = new boolean[missionnumber];
        acceptmission = new boolean[missionnumber];

        mission[1] = true;

        hasmission[0] = true;
        hasmission[2] = true;
        hasmission[3] = true;

        questlabelpicture = new ImageIcon[questlabeltype];

        for(int i =0;i<questlabeltype;i++)
        {
            questlabelpicture[i] = new ImageIcon("ButtonImage/quest"+i+".png");
        }
        questlabel = new JLabel[npcnumber];
        for(int i =0;i<2;i++)
        {
            for(int j = 0;j<npcpicturenumber[i];j++)
            {
                npcpicture[i][j] = new ImageIcon("Npc/npc"+i+"/npc"+j+".png"); 
            }
            questlabel[i] = new JLabel();
            add(questlabel[i]);
            npclabel[i] = new JLabel(npcpicture[i][0]);
            add(npclabel[i]);
            questlabel[i].setBounds(npclocationx[i]+30,500,46,42);
            npclabel[i].setBounds(npclocationx[i],521,60,70);
            npclabel[i].addMouseListener(new NpcMouseHandler());
            npcchatpane[i] = new NpcChatPane(npcpicture[i][0],i);
            add(npcchatpane[i]);
            npcchatpane[i].setVisible(false);
            npcchatpane[i].setBounds(300,300,521,202);
        }

        for(int i =2;i<4;i++)
        {
            for(int j = 0;j<npcpicturenumber[i];j++)
            {
                npcpicture[i][j] = new ImageIcon("Npc/npc"+i+"/npc"+j+".png"); 
            }
            questlabel[i] = new JLabel();
            add(questlabel[i]);
            npclabel[i] = new JLabel(npcpicture[i][0]);
            add(npclabel[i]);
            questlabel[i].setBounds(npclocationx[i]+30,500,46,42);
            npclabel[i].setBounds(npclocationx[i],524-backgroundy[4]+580,60,70);
            npclabel[i].addMouseListener(new NpcMouseHandler());
            npcchatpane[i] = new NpcChatPane(npcpicture[i][0],i);
            add(npcchatpane[i]);
            npcchatpane[i].setVisible(false);
            npcchatpane[i].setBounds(300,300,521,202);
        }

        for(int i=0;i<salemannumber;i++)
        {
            add(salepane[i]);
            salepane[i].setVisible(false);
        }
        for(int i=0;i<1;i++)
        {
            add(saleman[i]);
            saleman[i].setBounds(salemanlocationx[i],backgroundy[7]-79,60,79);
            saleman[i].setVisible(false);
        }



        for(int i = 0;i<blank.length;i++)
            add(blank[i]);

        add(bosshp);
        add(keyboardhintlabel);
        add(boss);
        add(magic);
        add(levelup);
        add(lvpane);
        add(volumepane);
        add(toAll);
        add(input);
        add(chatpane);
        add(inputpane);
        add(toolframe);
        add(toolButton);
        add(abilityframe);
        add(abilityButton);
        add(statepane);
        add(quitbutton);
        add(savebutton);
        add(keyboardhintbutton);
        add(gainarea);
        add(chara);
        add(deathmessagebackground);
        add(okbutton);
        add(quickbuttonpane);

        magic.setBounds(0,0,0,0);
        statepane.setBounds(213,720-34,359,34);
        abilityButton.setBounds(677,658,28,20);
        abilityframe.setBounds(200,81,180,350);
        toolButton.setBounds(649,658,28,20);
        toolframe.setBounds(403,81,180,320);
        volumepane.setBounds(1017-174,0,174,20);
        lvpane.setBounds(0,720-35,213,35);
        chatpane.setBounds(0,658,570,27);
        inputpane.setBounds(0,618,570,40);
        toAll.setBounds(2,663,78,18);
        input.setBounds(83,662,450,20);
        quitbutton.setBounds(1017-82,695,82,25);
        savebutton.setBounds(1017-82-70,695,64,25);
        keyboardhintbutton.setBounds(1017-82-70-70,695,65,25);
        gainarea.setBounds(mapwidth-100,backgroundy[mapcounter]-580+510,100,70);
        quickbuttonpane.setBounds(857,612,160,83);
        changeMapbackground.setBounds(0,0,1017,720);
        keyboardhintlabel.setBounds(100,100,700,415);
        chara.setFocusable(true);
        deathmessagebackground.setVisible(false);
        changeMapbackground.setVisible(false);
        for(int i=0;i<monster.length;i++)
        {
            monsterway[i]=randnumber.nextInt(2);
            if(monsterway[i]==0)
            monster[i]=new JLabel(monsterstandingleft[mapcounter]);
            else    
            monster[i]=new JLabel(monsterstandingright[mapcounter]);
            monsterlocationx[i]=randnumber.nextInt(160)*4+40;
            monsterlocationy[i]=580-26;
            add(monster[i]);
            monster[i].setBounds(monsterlocationx[i],backgroundy[mapcounter]-580+monsterlocationy[i]-monstersize[mapcounter][1]+26,monstersize[mapcounter][0],monstersize[mapcounter][1]);

        }

        bosshp.setBounds(200,0,643,38);
        for(int i = 0;i<100;i++)
            blank[i].setBounds(243+6*i,9,6,20);

        AttackThread detectAttack = new AttackThread();
        detectAttack.start();
        AttackActionThread attackactionthread = new AttackActionThread();
        attackactionthread.start();
        AttackValueThread attackValueThread = new AttackValueThread();
        attackValueThread.start();
        MonsterMove []monsterthread=new MonsterMove[monsternumber[mapcounter]];
        MonsterActionThread []monsteractionthread = new MonsterActionThread[monsternumber[mapcounter]];
        for(int i =0;i<monsternumber[mapcounter];i++)
        {
            monsterthread[i] = new MonsterMove(i);
            monsterthread[i].start();
            monsteractionthread[i] = new MonsterActionThread(i);
            monsteractionthread[i].start();
        }
        JumpThread detectJump=new JumpThread();
        detectJump.start();
        MoveThread charaThread = new MoveThread();
        charaThread.start();
        MoveActionThread moveactionthread = new MoveActionThread();
        moveactionthread.start();
        MDeathThread mdeaththread = new MDeathThread();
        mdeaththread.start();
        MDeathActionThread []mdeathactionthread = new MDeathActionThread[monsternumber[mapcounter]];
        for(int i = 0;i<monsternumber[mapcounter];i++)
        {
            mdeathactionthread[i] = new MDeathActionThread(i);
            mdeathactionthread[i].start();
        }
        MReliveThread mrelivethread = new MReliveThread();
        mrelivethread.start();
        GainingThread gainthread = new GainingThread();
        gainthread.start();
        LevelThread levelthread = new LevelThread();
        levelthread.start();
        StandActionThread standingactionthread = new StandActionThread();
        standingactionthread.start();
        DattackActionThread dattackactionthread = new DattackActionThread();
        dattackactionthread.start();
        Monsterattack monsterattackthread = new Monsterattack();
        monsterattackthread.start();
        InvincibleThread invinciblethread = new InvincibleThread();
        invinciblethread.start();
        GhostThread ghostthread = new GhostThread();
        ghostthread.start();
        RefreshThread refreshthread = new RefreshThread();
        refreshthread.start();
        DeliveryThread deliverythread = new DeliveryThread();
        deliverythread.start(); 
        PickThread pickthread = new PickThread();
        pickthread.start();
        HoldThread holdthread = new HoldThread();
        holdthread.start();
        NpcThread npcthread = new NpcThread();
        npcthread.start();
        NpcActionThread []npcactionthread = new NpcActionThread[npcnumber];
        for(int i = 0;i<npcactionthread.length;i++)
        {
            npcactionthread[i] = new NpcActionThread(i);
            npcactionthread[i].start();
        }

        SaleManThread salemanthread = new SaleManThread();
        salemanthread.start();
        SaleManActionThread []salemanactionthread = new SaleManActionThread[salemannumber];
        for(int i =0;i<salemannumber;i++)
        {
            salemanactionthread[i] = new SaleManActionThread(i);
            salemanactionthread[i].start();
        }

        BossThread bossthread = new BossThread();
        bossthread.start();
        BossActionThread bossactionthread = new BossActionThread();
        bossactionthread.start();
        BossAttackThread bossattackthread = new BossAttackThread();
        bossattackthread.start();
        BossMagicThread bossmagicthread = new BossMagicThread();
        bossmagicthread.start();
        BossHpThread bosshpthread = new BossHpThread();
        bosshpthread.start();
        BossDeathThread bossdeaththread = new BossDeathThread();
        bossdeaththread.start();


        leveluptimer = new Timer();
        magictimer = new Timer();
        delivertimer = new Timer();
        delivertimer.schedule(new TimerTask(){
            private int counter;
            public void run()
            {
                counter++;
                for(int i = 0;i<delivernumber[mapcounter];i++)
                {
                    deliverypoint[i].setIcon(deliverpicture[(counter+i)%3]);
                    deliverypoint[i].setBounds(deliverlocationx[mapcounter][i],backgroundy[mapcounter]-580+470,107,117);
                }
            }
        },0,200);

        Action left = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!islevelup)
                {
                    isMove=true;
                    isPMove=true;
                    way=0;
                    if(rate<4)
                    rate+=2;
                    isdown=false;
                }
            }
        };
        Action right= new AbstractAction(){

            public void actionPerformed(ActionEvent e){
                if(!islevelup)
                {
                    
                    way=1;
                    isMove=true;
                    isPMove=true;
                    if(rate<4)
                    rate+=2;
                    isdown=false;
                }
            }
        };
        Action fleft= new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                isstanding = true;
                isMove=false;
                isPMove=false;
                rate=0;
            }
        };
        Action fright= new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                isstanding = true;
                isMove=false;
                isPMove=false;
                rate=0;
            }
        };

        Action attack=new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                if(!islevelup&&!isghost)
                {
                    isattack=true;
                    isJump=false;
                    isMove=false;
                    isPMove=false;
                    if(!isdown)
                    {
                        if(way==0)
                            chara.setBounds(locationx-58,backgroundy[mapcounter]-580+locationy+3,160,73);
                        else
                            chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy+3,160,73);
                        isstandingattack =true;
                    }
                    else
                    {
                        isdattack=true;
                        if(way==1)
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy+13,163,62);
                        else
                        chara.setBounds(locationx-70,backgroundy[mapcounter]-580+locationy+13,163,62);
                    }
                }
            }
        };
        Action fattack = new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                isstandingattack = false;
                if(isdown&&!isghost)
                {    
                    if(way==1)
                    {
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy+13,146,62);
                        chara.setIcon(onfloorright);
                    }
                    else
                    {
                        chara.setBounds(locationx-70,backgroundy[mapcounter]-580+locationy+13,146,62);
                        chara.setIcon(onfloorleft);
                    }
                    isdown=true;
                }
                else
                    isstanding = true;
            }
        };

        Action onfloor = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!isghost)
                {
                    if(way==1)
                    {
                        chara.setIcon(onfloorright);
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+locationy+15,146,62);
                    }
                    else    
                    {
                        chara.setIcon(onfloorleft);
                        chara.setBounds(locationx-50,backgroundy[mapcounter]-580+locationy+15,146,62);
                    }
                    isdown=true;
                }
            }
        };

        Action fdown = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!isghost)
                {
                    if(locationy!=511)
                    {
                        locationy=511;
                        chara.setBounds(locationx,backgroundy[mapcounter]-580+511,100,69);
                    }
                    isdown = false;
                    isJump=false;
                }
            }
        };

        Action fupdown = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                isstanding = true;
                isJump=false;
                isdown=false;
            }
        };

        Action jump=new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!isghost)
                {
                    if(isPMove)
                    {
                        isPMove=false;
                    }
                    if(way==1)
                        chara.setIcon(rjump);
                    else if(way==0)
                        chara.setIcon(ljump);
                    isJump=true;
                }
            }
        };

        Action enter = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                input.requestFocus();
            }
        };

        Action deliver = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                isup = true;
            }
        };

        Action uprelease = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                isup = false;
            }
        };

        Action pickup = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                ispickup = true;
            }
        };

        Action pickrelease = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                ispickup = false;
            }
        };
        
        Action openitem = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!toolframe.isVisible())
                    toolframe.setVisible(true);
                else
                    toolframe.setVisible(false);
                chara.requestFocus();
            }
        };

        Action openstate = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!abilityframe.isVisible())
                    abilityframe.setVisible(true);
                else
                    abilityframe.setVisible(false);
                chara.requestFocus();
            }
        };

        Action Using1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int type;
                type = subquickbuttonpane[0].getType();
                if(type!=itemtypenumber-1)
                {
                    if(itemlist[type]!=0)
                    {
                        usedropitem[type].effect();
                        itemlist[type]--;
                        numbertextfield[0].setText(String.valueOf(itemlist[type]));
                        usedropitem[type].setText(String.valueOf(itemlist[type]));
                        if(itemlist[type]==0)
                        {
                            arrangeuseitemthread = new ArrangeUseItemThread();
                            arrangeuseitemthread.start();
                        }
                    }
                }
            }
        };

        Action Using2 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int type;
                type = subquickbuttonpane[1].getType();
                if(type!=itemtypenumber-1)
                {
                    if(itemlist[type]!=0)
                    {
                        usedropitem[type].effect();
                        itemlist[type]--;
                        numbertextfield[1].setText(String.valueOf(itemlist[type]));
                        usedropitem[type].setText(String.valueOf(itemlist[type]));
                        if(itemlist[type]==0)
                        {
                            arrangeuseitemthread = new ArrangeUseItemThread();
                            arrangeuseitemthread.start();
                        }
                    }
                }
            }
        };

        Action Using3 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int type;
                type = subquickbuttonpane[2].getType();
                if(type!=itemtypenumber-1)
                {
                    if(itemlist[type]!=0)
                    {
                        usedropitem[type].effect();
                        itemlist[type]--;
                        numbertextfield[2].setText(String.valueOf(itemlist[type]));
                        usedropitem[type].setText(String.valueOf(itemlist[type]));
                        if(itemlist[type]==0)
                        {
                            arrangeuseitemthread = new ArrangeUseItemThread();
                            arrangeuseitemthread.start();
                        }
                    }
                }
            }
        };

        chara.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"moveleft");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,true),"faceleft");


        chara.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"moveright");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,true),"faceright");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ALT,InputEvent.ALT_MASK),"jump");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ALT,0,true),"fdown");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL,InputEvent.CTRL_MASK),"attack");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL,0,true),"fattack");

        chara.getInputMap().put(KeyStroke.getKeyStroke("UP"),"deliver");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,true),"uprelease");

        chara.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"onfloor");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,true),"fupdown");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,InputEvent.ALT_MASK),"moveleft");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,InputEvent.ALT_MASK),"moveright");
        chara.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"input");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,0,false),"pickup");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,0,true),"pickrelease");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_I,0,true),"openitem");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0,true),"openstate");

        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_END,0,true),"Using1");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN,0,true),"Using2");
        chara.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT,0,true),"Using3");

        chara.getActionMap().put("input",enter);
        chara.getActionMap().put("fupdown",fupdown);
        chara.getActionMap().put("onfloor",onfloor);
        chara.getActionMap().put("fdown",fdown);
        chara.getActionMap().put("moveleft",left);
        chara.getActionMap().put("moveright",right);
        chara.getActionMap().put("jump",jump);
        chara.getActionMap().put("faceleft",fleft);
        chara.getActionMap().put("faceright",fright);
        chara.getActionMap().put("attack",attack);
        chara.getActionMap().put("fattack",fattack);
        chara.getActionMap().put("deliver",deliver);
        chara.getActionMap().put("uprelease",uprelease);
        chara.getActionMap().put("pickup",pickup);
        chara.getActionMap().put("pickrelease",pickrelease);
        chara.getActionMap().put("openitem",openitem);
        chara.getActionMap().put("openstate",openstate);
        chara.getActionMap().put("Using1",Using1);
        chara.getActionMap().put("Using2",Using2);
        chara.getActionMap().put("Using3",Using3);


        okbutton.addActionListener(new okhandler());

        chara.setBounds(locationx,backgroundy[mapcounter]-580+511,100,69);
        
        setLocation(1360-1017,0);
        setFocusable(true);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(1017,720);
    }
    private void setFocus()
    {
        chara.requestFocus();
    }
    public void inGame(int past,int mapcounter,int level,int meso,int experiencevalue,int []missionstate,int itemlist[],int questitemlist[],int crocodile,int hpmax,int mpmax,int str,int dex,int luk,int inte,String name)
    {
        if(past!=0)
        {
            changeMap(mapcounter,520);
            this.level = level;
            lvpane.changeLevel(level);

            mesovalue.setText(String.valueOf(meso));
            this.experiencevalue = experiencevalue;
            

            for(int i =0;i<missionnumber;i++)
            {
                if(missionstate[i] == 0)
                {
                    hasmission[i] = false;
                    mission[i] = true;   
                }
                else if(missionstate[i] == 1)
                {
                    mission[i] = false;
                    hasmission[i] = true;
                }else if(missionstate[i] == 2)
                {
                    mission[i] = true;
                    hasmission[i] = true;
                    missioncondition[i] = false;
                }
                else
                {
                    mission[i] = true;
                    hasmission[i] = true;
                    missioncondition[i] = true;
                }
            }
            this.crocodile = crocodile;

            for(int i =0;i<(this.itemlist).length;i++)
            {
                this.itemlist[i] = itemlist[i];
            }

            for(int i =0;i<(this.questitemlist).length;i++)
            {
                this.questitemlist[i] = questitemlist[i];
            }

            arrangeuseitemthread = new ArrangeUseItemThread();
            arrangeuseitemthread.start();

            arrangeetcitemthread = new ArrangeEtcItemThread();
            arrangeetcitemthread.start();

            this.crocodile = crocodile;

            this.hpmax = hpmax;
            this.mpmax = mpmax;
            this.str = str;
            this.dex = dex;
            this.luk = luk;
            this.inte = inte;
            this.name = name;

        }
    }
    public static void main(String args[])
    {
        First_2 application = new First_2("Maplestory");
        application.requestFocus();
    }

}