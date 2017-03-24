package datalayer.storage;

import java.io.IOException;

/**
 * Created by Pasha on 23.03.2017.
 */
interface DataConnector {
    Object readData() throws IOException, ClassNotFoundException;
    void saveData(Object object) throws IOException, ClassNotFoundException;
}
