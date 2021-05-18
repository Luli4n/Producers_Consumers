package Krabel.Julian.service;

import lombok.Builder;
import lombok.SneakyThrows;

import java.util.Random;


@Builder
public class ProducerService implements Runnable {

    private final MerchandiseService magazyn;

    @SneakyThrows
    @Override
    public void run() {
        long time;
        int index;
        for (int i = 0; i < 10; i++) {
            try {
                time = new Random().nextInt(4000) + 1000;
                index= new Random().nextInt(5);
                magazyn.put("Towar"+String.valueOf(index));
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

}
