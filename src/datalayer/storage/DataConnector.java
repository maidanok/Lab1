package datalayer.storage;

/**
 * Created by Pasha on 23.03.2017.
 */
interface DataConnector {
    Object readData();
    void saveData(Object object);
}
