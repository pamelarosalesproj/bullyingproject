 
// Import log4j classes.
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.util.logging.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author pamela
 */
public class Log4jExample {
    
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);
 
    public static void main(final String... args) {
 
        // Set up a simple configuration that logs on the console.
        System.out.println("hola..");
        logger.trace("ENTRAR");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("NO SE HIZO NADA");
        }
        logger.trace("SALIR");
        
        
        
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyARRmwp65-nVtfJeUACJ79G1YLpLyxJK4M");
        GeocodingResult[] results;
        try {
            results = GeocodingApi.geocode(context,  "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            System.out.println(results[0].formattedAddress);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
