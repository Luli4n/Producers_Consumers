package Krabel.Julian.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Merchandise {

    @Getter
    @Setter
    String nazwa;

    @Getter
    @Setter
    Integer ilosc;

}
