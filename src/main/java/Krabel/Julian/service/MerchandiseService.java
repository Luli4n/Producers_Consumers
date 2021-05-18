package Krabel.Julian.service;

import Krabel.Julian.entity.Merchandise;
import Krabel.Julian.repository.MerchandiseRepository;
import lombok.Builder;
import lombok.Getter;


import java.util.Optional;
import java.util.Random;

@Builder
public class MerchandiseService {
    @Getter
    private MerchandiseRepository mr;
    private final int maxElements = 50;
    private int suma=0;

    public synchronized Merchandise take() throws InterruptedException {
        while (suma == 0) {
            wait();
        }

        int numbOfEls = new Random().nextInt(9)+1;
        int index = new Random().nextInt(mr.getTowary().size());

        while(mr.getTowary().get(index).getIlosc() == 0)
        {
            index = new Random().nextInt(mr.getTowary().size());
        }

        Merchandise ret = mr.getTowary().get(index);
        if(numbOfEls < ret.getIlosc()) {
            ret.setIlosc(ret.getIlosc()-numbOfEls);
        }
        else
        {
            numbOfEls = ret.getIlosc();
            ret.setIlosc(0);
        }

        suma-=numbOfEls;

        if(suma <= maxElements-1)
        {
            notifyAll();
        }

        printMagazine(false,ret, numbOfEls);

        return ret;
    }

    public synchronized void put(String tow) throws InterruptedException{

        while(suma==maxElements) {
            wait();
        }
        int numbOfEls = new Random().nextInt(5)+1;

        Optional<Merchandise> existing = mr.getTowary().stream().filter(el -> el.getNazwa().equals(tow)).findAny();

        if(existing.isPresent())
        {
            if(suma+numbOfEls>=maxElements)
            {
                numbOfEls=maxElements-suma;
                existing.get().setIlosc(numbOfEls);
                suma=maxElements;
            }
            else {
                existing.get().setIlosc(existing.get().getIlosc() + numbOfEls);
                suma+=numbOfEls;
            }
            printMagazine(true, existing.get(), numbOfEls);
        }
        notifyAll();
    }

    public synchronized void printMagazine(boolean added, Merchandise tow, int number)
    {
        System.out.println("Zajetość magazynu "+String.valueOf(suma)+"/50");
        if(added) System.out.println("Dodano "+tow.getNazwa()+" w ilości "+String.valueOf(number));
        else System.out.println("Pobrano "+tow.getNazwa()+" w ilości "+String.valueOf(number));
        System.out.println(mr.getTowary());
        System.out.println("");
    }
}