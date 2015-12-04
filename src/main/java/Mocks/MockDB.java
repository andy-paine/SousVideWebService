package Mocks;

import Util.*;
import org.bson.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by andy on 29/10/15.
 */
public class MockDB implements IDataStore {

    List<Cycle> cycleQueue = new ArrayList<>();
    List<Cycle> cycleHistory = new ArrayList<>();
    List<Temperature> temperatures = new ArrayList<>();

    public MockDB() {
        List<Stage> stages = new ArrayList<>();
        stages.add(new Stage(55.0, 10));
        stages.add(new Stage(60.0, 5));
        Cycle cycle = new Cycle(new Date(), "Test", 0, "", stages, false);
        cycleQueue.add(cycle);
    }

    @Override
    public boolean newCycle(Cycle cycle) {
        cycleQueue.add(cycle);
        return true;
    }

    @Override
    public List<Cycle> getQueue() {
        return cycleQueue;
    }

    @Override
    public List<Cycle> getHistory() {
        return cycleHistory;
    }

    @Override
    public Temperature getTemperature() {
        return temperatures.get(temperatures.size()-1);
    }

    @Override
    public List<Temperature> getTemperatures() {
        temperatures.add(new Temperature(50.0));
        temperatures.add(new Temperature(51.0));
        temperatures.add(new Temperature(52.0));
        temperatures.add(new Temperature(53.0));
        temperatures.add(new Temperature(54.0));
        temperatures.add(new Temperature(55.0));
        temperatures.add(new Temperature(56.0));
        temperatures.add(new Temperature(57.0));
        temperatures.add(new Temperature(58.0));
        temperatures.add(new Temperature(59.0));
        return temperatures;
    }

    @Override
    public boolean logTemperature(Temperature temp) {
        System.out.println("Temp: " + temp.temperature());
        temperatures.add(temp);
        return true;
    }

    @Override
    public boolean updateCycle(Cycle cycle) {
        for (Cycle queue: cycleQueue) {
            if (queue.getId().trim().equals(cycle.getId().trim()))
                cycleQueue.set(cycleQueue.indexOf(queue), cycle);
        }

        return true;
    }

    @Override
    public boolean cancelCycle(String cycleID) {
        return false;
    }

    @Override
    public boolean moveToHistory(String cycleID) {
        Cycle remove = null;
        for (Cycle cycle: cycleQueue)
            if (cycle.getId().matches(cycleID))
                remove = cycle;
        if (remove != null) {
            cycleQueue.remove(remove);
            cycleHistory.add(remove);
        }

        return true;
    }
}
