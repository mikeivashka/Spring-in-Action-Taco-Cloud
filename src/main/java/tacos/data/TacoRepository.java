package tacos.data;

import tacos.beans.Taco;

public interface TacoRepository {
    Taco save(Taco taco);
}
