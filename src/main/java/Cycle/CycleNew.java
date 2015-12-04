package Cycle;

import Util.Cycle;
import Util.IDataStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 01/12/2015.
 */
public class CycleNew extends ServerResource {

    @Post("json")
    public void createNewCycle(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").excludeFieldsWithoutExposeAnnotation().create();
        Cycle cycle = gson.fromJson(json, Cycle.class);
        ((IDataStore)getContext().getAttributes().get("DATA_STORE")).newCycle(cycle);
    }
}
