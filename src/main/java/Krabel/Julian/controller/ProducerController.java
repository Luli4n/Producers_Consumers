package Krabel.Julian.controller;

import Krabel.Julian.service.ProducerService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ProducerController extends ThreadController{

    private MerchandiseController mc;

    private final int producersC = 6;

    public void createThreads() {
        for (int k = 0; k < producersC; k++) {
            threads.add(new Thread(ProducerService.builder().magazyn(mc.getMagazine()).build()));
        }
    }
}
