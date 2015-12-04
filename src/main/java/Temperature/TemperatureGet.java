package Temperature;

import Util.IDataStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 01/12/2015.
 */
public class TemperatureGet extends ServerResource {

    @Get
    public Representation getTemperatures() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String json = gson.toJson(((IDataStore) getContext().getAttributes().get("DATA_STORE")).getTemperatures());
        return new JsonRepresentation(json);
    }

}
