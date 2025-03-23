
package TestingNewThings.exceptions;

import java.io.IOException;

public class DataReaderException extends Exception {
    public DataReaderException() {
        super("Error reading data");
    }

    public DataReaderException(String message) {
        super(message);
    }
}
