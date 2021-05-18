package Krabel.Julian.service;

import Krabel.Julian.entity.Merchandise;
import lombok.Builder;

import java.util.Random;

@Builder
public class ConsumerService implements Runnable {

    private final MerchandiseService magazyn;

    @Override
    public void run() {

        Merchandise tow;
        long time;
        for(int i=0;i<10;i++) {
            try {
                time = new Random().nextInt(4000) + 1000;
                tow = magazyn.take();
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
