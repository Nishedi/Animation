package view;

import model.FlyWheel;
import model.History;

import javax.swing.*;

public class SpeedFrame extends JFrame {
    //okno statystyk do utworzenia wymaga obiekt typu CSimulator
    SpeedPanel panelspeed;//panel statystyk
    FlyWheel flyWheel;
    History history;

    public SpeedFrame(FlyWheel flyWheel, History history) throws Exception{
        this.history=history;
        this.flyWheel=flyWheel;
        panelspeed=new SpeedPanel(flyWheel, history);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ustawia domyślną akcję zamknięcia okna
        this.add(panelspeed);//dodaje do kontenera okna obiekty typu panelstat
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);//ustawienie widzialnosci okna

    }
}
