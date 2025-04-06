package wordle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class wordle extends JFrame implements ActionListener {
    boolean[] flags =new boolean[wordlel.wordsize];
    int chances=5;
    JPanel container,main;
    JLabel chance;
    Font f1=new Font("Tahoma",Font.BOLD,16);
    static ArrayList<JTextField> tf=new ArrayList<>();
    JButton check,cancel;
    wordle(){
        setSize(500,500);
        main=new JPanel();
        setContentPane(main);
        main.setBackground(Color.BLACK);

        container = new JPanel();
        container.setBackground(Color.white);
        container.setBounds(100,100,300,70);
//      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container,BoxLayout.X_AXIS));
        add(container);
        generator();

        chance = new JLabel("Chances Remaining : "+chances);
        chance.setBounds(170,270,200,50);
        chance.setFont(new Font("Tahoma",Font.PLAIN,14));
        chance.setForeground(Color.white);
        add(chance);

        check = new JButton("Check");
        check.setBounds(100,350,100,50);
        check.setFont(f1);
        check.addActionListener(this);
        add(check);

        cancel =new JButton("Cancel");
        cancel.setBounds(300,350,100,50);
        cancel.setFont(f1);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void generator(){
        for (int i = 0; i < wordlel.wordsize; i++) {
            tf.add(new JTextField());
            tf.get(i).setFont(f1);
            tf.get(i).setBackground(Color.lightGray);
            tf.get(i).setForeground(Color.white);
            tf.get(i).setHorizontalAlignment(JTextField.CENTER);
        }
        for (int i = 0; i < wordlel.wordsize; i++) {
            container.add(tf.get(i));
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            if(chances>1){
                for (int i=0;i<wordlel.wordsize;i++){
                    if(wordlel.exactLetter(i)==true){
                        tf.get(i).setBackground(Color.green);
                        flags[i]=true;
                    } else if (wordlel.containLetter(i)==true) {
                        tf.get(i).setBackground(Color.yellow);
                    }
                }
                for (int i = 0; i < flags.length; i++) {
                    if(flags[i]==false){
                        JOptionPane.showMessageDialog(null,"oops try again");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"hoooray u done it");
                        JOptionPane.showMessageDialog(null,"a small gift ❤️❤️❤️");
                        this.setVisible(false);
                    }
                }
                chances--;
                chance.setText("Chances Remaining : "+chances);
            }
        }
        if(ae.getSource()==cancel){
            for (int i = 0; i < wordlel.wordsize; i++) {
                tf.get(i).setText(" ");
                tf.get(i).setBackground(Color.lightGray);
            }
        }

    }

    public static void main(String[] args) {
        new wordlel();
        new wordle();
    }
}
