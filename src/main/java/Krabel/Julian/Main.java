package Krabel.Julian;

import Krabel.Julian.controller.ConsumerController;
import Krabel.Julian.controller.MerchandiseController;
import Krabel.Julian.controller.ProducerController;
import Krabel.Julian.repository.MerchandiseRepository;
import Krabel.Julian.service.MerchandiseService;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        MerchandiseController mc = MerchandiseController.builder()
                                        .magazine(MerchandiseService.builder()
                                        .mr(MerchandiseRepository.builder()
                                            .towary(new ArrayList<>())
                                                        .build())
                                            .build())
                                        .build();
        mc.addNewMerch();

        ProducerController pc = ProducerController.builder()
                                    .threads(new ArrayList<>())
                                    .mc(mc)
                                    .build();

        ConsumerController cc = ConsumerController.builder()
                                .threads(new ArrayList<>())
                                .mc(mc)
                                .build();

        pc.createThreads();
        cc.createThreads();

        pc.startThreads();
        cc.startThreads();

        pc.joinThreads();
        cc.joinThreads();
    }
}
