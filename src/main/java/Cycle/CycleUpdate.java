package Cycle;

import Util.Cycle;
import Util.IDataStore;
import Util.Pair;
import com.google.gson.*;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 04/12/2015.
 */
public class CycleUpdate extends ServerResource {

    @Post("json")
    public void updateCycle(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Cycle cycle = gson.fromJson(json, Cycle.class);
        ((IDataStore)getContext().getAttributes().get("DATA_STORE")).updateCycle(cycle);
    }
}
