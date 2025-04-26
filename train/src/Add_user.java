import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Add_user {
    public Add_user() throws IOException {
        JFrame f1;

        Image img;
        JLabel label;
        JPanel p1;
        JTextField jt1;
        JTextField jt2;
        JTextField jt3;
        JTextField jt4;
        JTextField jt5;

        Font font;
        JButton btn1;
        JButton btn2;

        f1=new JFrame();
        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        font = new Font("΢���ź�", Font.BOLD, 25);


        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        label=new JLabel("�ֻ���");
        label.setFont(font);
        jt1=new JTextField(20);
        jt1.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt1);
        p1.setBounds(50,100,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        label=new JLabel("����");
        label.setFont(font);
        jt2=new JTextField(20);
        jt2.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt2);
        p1.setBounds(50,200,400,60);
        f1.add(p1);


        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        label=new JLabel("ID");
        label.setFont(font);
        jt3=new JTextField(20);
        jt3.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt3);
        p1.setBounds(50,300,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        label=new JLabel("����");
        label.setFont(font);
        jt4=new JTextField(20);
        jt4.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt4);
        p1.setBounds(550,100,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        label=new JLabel("�Ա�");
        label.setFont(font);
        jt5=new JTextField(20);
        jt5.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt5);
        p1.setBounds(550,200,400,60);
        f1.add(p1);





        btn2=new JButton("����");
        btn2.setBounds(10,10,100,40);
        btn2.addActionListener(e -> {
            f1.dispose();
            try {
                Manage_user manage_user=new Manage_user();
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        f1.add(btn2);
        btn1=new JButton("�ύ");
        btn1.setBounds(430,500,100,40);
        f1.add(btn1);
        btn1.addActionListener(e -> {
            if(jt1.getText().isEmpty()||jt2.getText().isEmpty()||jt3.getText().isEmpty()||jt4.getText().isEmpty()||jt5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
            }
            else if(jt1.getText().length()!=11){
                JOptionPane.showMessageDialog(null, "�����Ϲ淶���ֻ�����");
            }
            else if(jt5.getText()!="��"&&jt5.getText()!="Ů"){
                JOptionPane.showMessageDialog(null, "�����Ϲ淶���Ա�");
            }
            else{

                try {
                    Do_add_user do_add_user=new Do_add_user(jt1.getText(),jt2.getText(),jt3.getText(),jt4.getText(),jt5.getText());
                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }


                f1.dispose();
                try {
                    Manage_user manage_user=new Manage_user();
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);
        f1.setVisible(true);
    }
}