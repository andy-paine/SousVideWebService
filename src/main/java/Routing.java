import Cycle.*;
import Temperature.*;
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
        Router router = new Router(getContext());

        IDataStore dataStore = new MongoDB();

        router.getContext().getAttributes().put("DATA_STORE", dataStore);

        router.attach("/cycle/new", CycleNew.class);
        router.attach("/cycle/queue", CycleQueue.class);
        router.attach("/cycle/history", CycleHistory.class);
        router.attach("/cycle/movetohistory", CycleMoveToHistory.class);
        router.attach("/cycle/update", CycleUpdate.class);
        router.attach("/cycle/cancel", CycleCancel.class);

        router.attach("/temperature/get", TemperatureGet.class);
        router.attach("/temperature/log", TemperatureLog.class);

        return router;
    }

}
