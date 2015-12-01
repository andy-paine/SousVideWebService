import GET.Temperatures;
import Mocks.MockDB;
import POST.NewCycle;
import Util.IDataStore;
import Util.MongoDB;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by Andy on 01/12/2015.
 */
public class Routing extends Application {

    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        IDataStore dataStore = new MockDB();

        router.getContext().getAttributes().put("DATA_STORE", dataStore);
        // Defines only one route
        router.attach("/cycle/new", NewCycle.class);
        router.attach("/temperature", Temperatures.class);

        return router;
    }

}
