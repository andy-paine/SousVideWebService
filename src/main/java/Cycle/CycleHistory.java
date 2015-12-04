package Cycle;

import Util.Cycle;
import Util.IDataStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.List;

/**
 * Created by Andy on 04/12/2015.
 */
public class CycleHistory extends ServerResource {

    @Get
    public Representation getHistory() {
        IDataStore dataStore = (IDataStore) getContext().getAttributes().get("DATA_STORE");
        List history = dataStore.getHistory();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String historyAsJson = gson.toJson(history);

        return new JsonRepresentation(historyAsJson);
    }
}
