package POST;

import Util.Cycle;
import com.google.gson.Gson;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Created by Andy on 01/12/2015.
 */
public class NewCycle extends ServerResource {

    @Post("json")
    public boolean createNewCycle(String json) {
        System.out.println(json);
        Cycle cycle = new Gson().fromJson(json, Cycle.class);
        System.out.println(cycle);

        return true;
    }
}
