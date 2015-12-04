package Temperature;

import Util.IDataStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 04/12/2015.
 */
public class TemperatureLog extends ServerResource {

    @Put("json")
    public void logTemperature(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Util.Temperature temp = gson.fromJson(json, Util.Temperature.class);
        ((IDataStore)getContext().getAttributes().get("DATA_STORE")).logTemperature(temp);
    }
}
