package Krabel.Julian.controller;

import Krabel.Julian.entity.Merchandise;
import Krabel.Julian.service.MerchandiseService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class MerchandiseController {
    @Getter
    @Setter
    private MerchandiseService magazine;

    public void addNewMerch()
    {
        for (int i=0;i<5;i++) {
            magazine.getMr().getTowary().add(new Merchandise("Towar" + String.valueOf(i), 0));
        }
    }
}
