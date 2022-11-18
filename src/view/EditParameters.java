package view;

import model.FlyWheel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class EditParameters extends JFrame{
    public JPanel Panel;
    public JTextArea l1TextArea;
    public JTextArea l2TextArea;
    public JTextArea dTextArea;
    public JTextArea hTextArea;
    public JButton STARTButton;
    public JButton OKButton;
    public JButton button1;
    FlyWheel flyWheel = null;


    public EditParameters(FlyWheel flyWheel){
        this.flyWheel = flyWheel;
        this.setLocation(1400,600);
        this.setContentPane(this.Panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200,300);
    }
    public void OKButtonListener(ActionListener listenForCalcButton){
        OKButton.addActionListener(listenForCalcButton);
    }
    public void Button1Listener(ActionListener listenForButton){
        button1.addActionListener(listenForButton);
    }

}
