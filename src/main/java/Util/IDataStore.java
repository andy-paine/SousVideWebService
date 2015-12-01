package Util;

import java.util.List;

/**
 * Created by Andy on 01/12/2015.
 */
public interface IDataStore {

    boolean newCycle(Cycle cycle);

    List<Cycle> getQueue();

    List<Cycle> getHistory();

    Temperature getTemperature();

    List<Temperature> getTemperatures();

    boolean logTemperature(Temperature temp);

    boolean updateCycle(String id, List<Pair<String, ?>> updates);

    boolean cancelCycle(String cycleID);

    boolean moveToHistory(String cycleID);
}