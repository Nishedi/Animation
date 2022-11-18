package controller;

import main.MainFrame;
import model.FlyWheel;
import model.History;
import view.EditParameters;
import view.FlyWheelView;
import view.SpeedFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.highestOneBit;
import static java.lang.Integer.parseInt;

public class AppController {
    private static FlyWheel flyWheel;
    private EditParameters editParameters;
    MainFrame mainFrame;
    SpeedFrame speedFrame;
    Timer timer;
    History history;


    public AppController(FlyWheel flyWheel, EditParameters editParameters, MainFrame mainFrame, SpeedFrame speedFrame, History history) {

        this.flyWheel = flyWheel;
        this.editParameters = editParameters;
        this.mainFrame = mainFrame;
        this.speedFrame=speedFrame;
        this.editParameters.OKButtonListener(new OKButtonListeners());
        this.editParameters.Button1Listener(new Button1Listener());
        this.history = history;
        timer = new Timer(100, new TimerListener());//ustawienie wyzwalania (100ms)
        timer.start();//uruchomienie timera

    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            speedFrame.repaint();
        }
    }

    class OKButtonListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String l1 = editParameters.l1TextArea.getText();
            mainFrame.mp.flyWheel.l1 = parseInt(l1);
            String l2 = editParameters.l2TextArea.getText();
            mainFrame.mp.flyWheel.l2 = parseInt(l2);
            String d = editParameters.dTextArea.getText();
            mainFrame.mp.flyWheel.d = parseInt(d);
            String h = editParameters.hTextArea.getText();
            mainFrame.mp.flyWheel.h = parseInt(h);
        }
    }

    class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            history.axlelist.clear();
        }
    }
}
