package datalayer.storage;

import java.io.*;

/**
 * Created by Pasha on 23.03.2017.
 */
class DataConnectorImpl implements DataConnector {

    private DataConnectorImpl() {

    }

    static private DataConnectorImpl dataConnector;

    static public DataConnectorImpl getInstance() {
        if (dataConnector == null) {
            dataConnector = new DataConnectorImpl();
        }
        return dataConnector;
    }

    //читаем объект
    @Override
    public Object readData() {
        Object object = new Object();
        FileInputStream fis;
        ObjectInputStream oin = null;
        try {
            fis = new FileInputStream("temp.out");
            oin = new ObjectInputStream(fis);
            object = oin.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close();
            } catch (Exception e) {
            }
        }
        return object;
    }

    //сохраняем объект
    @Override
    public void saveData(Object object) {
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("temp.out");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (Exception e) {
            }
        }
    }
}
