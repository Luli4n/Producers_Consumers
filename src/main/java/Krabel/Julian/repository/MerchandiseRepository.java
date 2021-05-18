package Krabel.Julian.repository;

import Krabel.Julian.entity.Merchandise;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public class MerchandiseRepository {
    @Getter
    @Setter
    private List<Merchandise> towary;
}
