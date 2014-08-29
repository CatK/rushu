package rushu.proto.fights;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import objects.fight.Fight;
import objects.fight.Fighter;
import rushu.cat.exceptions.FightException;

public class Turn {

	private final Fight fight;
    private final Fighter fighter;
    private final Timer timer;

    private long finish;
    private boolean abandoned;

    public Turn(Fighter fighter, Fight fight) {
        this.fighter = fighter;
        this.fight = fight;
        // A REMPLACER PAR UN scheduledExecutor mais timer pour proto @Kitten+
        this.timer = new Timer(30 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    end();
                } catch (FightException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void begin() throws FightException {
        int turnDelay = 30 * 1000;
        finish = System.currentTimeMillis() + 30 * 1000;
        timer.start();
        onStarted();
        //faire une notif que tour a commencer           
    }

    public void end() throws FightException {
    	timer.stop();
    }

    private void onStarted() throws FightException {
    }

    private void onEnded() throws FightException {
    	//Refresh tout . Jor les buff etc...
    	//Les Spells qui agiront en fin de tour .
    	// A voir quoi @Kitten
    }

    public Fighter getFighter() {
        return fighter;
    }

    public long remainingTime(){
        return finish - System.currentTimeMillis();
    }

    public boolean hasAbandoned() {
        return abandoned;
    }

    public void setAbandoned(boolean abandoned) {
        this.abandoned = abandoned;
    }
}

