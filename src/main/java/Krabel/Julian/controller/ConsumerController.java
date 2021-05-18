package Krabel.Julian.controller;

import Krabel.Julian.service.ConsumerService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ConsumerController extends ThreadController {

    private MerchandiseController mc;

    private final int consumersC = 4;

    public void createThreads() {
        for (int k = 0; k < consumersC; k++) {
            threads.add(new Thread(ConsumerService.builder().magazyn(mc.getMagazine()).build()));
        }
    }
}
