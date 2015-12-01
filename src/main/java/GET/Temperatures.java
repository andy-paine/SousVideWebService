package GET;

import Util.IDataStore;
import com.google.gson.Gson;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 01/12/2015.
 */
public class Temperatures extends ServerResource {

    private IDataStore dataStore;

    public Temperatures() {
    }

    protected void doInit() throws ResourceException {
        this.dataStore = (IDataStore) getContext().getAttributes().get("DATA_STORE");
    }

    @Get
    public Representation getTemperatures() {
        String json = new Gson().toJson(dataStore.getTemperatures());
        return new JsonRepresentation(json);
    }
}
