package datalayer.storage;

import java.io.*;

/**
 * Created by Pasha on 23.03.2017.
 */
class DataConnectorImpl implements DataConnector {
    //читаем объект
    @Override
    public Object readData() throws IOException, ClassNotFoundException {
        Object object = new Object();
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        object = oin.readObject();
        oin.close();
        return object;
    }

    //сохраняем объект
    @Override
    public void saveData(Object object) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }
}
