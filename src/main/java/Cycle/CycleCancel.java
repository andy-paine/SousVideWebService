package Cycle;

import Util.IDataStore;
import com.google.gson.JsonParser;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 04/12/2015.
 */
public class CycleCancel extends ServerResource {

    @Post("json")
    public void cancelCycle(String json) {
        String id = new JsonParser().parse(json).getAsJsonObject().get("id").getAsString();
        ((IDataStore)getContext().getAttributes().get("DATA_STORE")).cancelCycle(id);
    }
}
