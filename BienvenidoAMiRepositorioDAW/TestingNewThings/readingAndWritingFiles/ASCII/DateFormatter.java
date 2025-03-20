package ASCII;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
    public String dateFormat(long lastModified) {
    
        Date date = new Date(lastModified);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        return sdf.format(date);    
    }
}
