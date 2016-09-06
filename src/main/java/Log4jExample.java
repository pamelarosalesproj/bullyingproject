 
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
       
        if (true) {
            logger.error("NO SE HIZO NADA");
        }
        logger.trace("SALIR");
        
       
        
    }
}
