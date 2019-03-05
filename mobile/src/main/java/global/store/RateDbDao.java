package global.store;

import global.TranscendenceRate;

/**
 * Created by akshaynexus on 3/3/18.
 */

public interface RateDbDao<T> extends AbstractDbDao<T>{

    TranscendenceRate getRate(String coin);


    void insertOrUpdateIfExist(TranscendenceRate transcendenceRate);

}
