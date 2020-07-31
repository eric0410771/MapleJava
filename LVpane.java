import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Graphics;


public class LVpane extends JPanel{
    private int Level;
    private JTextField namefield;
    private JTextField Jobfield;
    private JTextField dolevelfield;
    private JTextField dtlevelfield;
    private JTextField dhlevelfield;
    private ImageIcon background;

    public LVpane (String name,int level)
    {
        Level = level;
        setLayout(null);
        background=new ImageIcon("Buttonimage/LV.png");
        namefield = new JTextField(name);
        dolevelfield=new JTextField(String.valueOf(Level%10));
        dtlevelfield=new JTextField(String.valueOf(((Level-Level%10)%100)/10));
        dhlevelfield=new JTextField(String.valueOf(((Level-Level%100)/100)));
        
        dolevelfield.setBorder(new LineBorder(new Color(0,0,0,0)));
        dtlevelfield.setBorder(new LineBorder(new Color(0,0,0,0)));
        dhlevelfield.setBorder(new LineBorder(new Color(0,0,0,0)));
        namefield.setBorder(new LineBorder(new Color(0,0,0,0)));
        setFocusable(true);
        setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(background.getImage(),0,0,213,35,null);

        add(dolevelfield);
        add(dtlevelfield);
        add(dhlevelfield);
        add(namefield);
        dhlevelfield.setBounds(40,11,10,13);
        dtlevelfield.setBounds(52,11,10,13);
        dolevelfield.setBounds(65,11,10,13);
        namefield.setBounds(100,7,55,20);
        
        namefield.setEditable(false);
        dhlevelfield.setEditable(false);
        dtlevelfield.setEditable(false);
        dolevelfield.setEditable(false);

        namefield.setOpaque(false);
        dhlevelfield.setOpaque(false);
        dtlevelfield.setOpaque(false);
        dolevelfield.setOpaque(false);

        dolevelfield.setForeground(Color.white);
        dtlevelfield.setForeground(Color.white);
        dhlevelfield.setForeground(Color.white);
        namefield.setForeground(Color.white);

    }
    public void changeLevel(int level)
    {
        Level = level;
        dolevelfield.setText(String.valueOf(Level%10));
        dtlevelfield.setText(String.valueOf(((Level-Level%10)%100)/10));
        dhlevelfield.setText(String.valueOf(((Level-Level%100)/100)));
    }
}