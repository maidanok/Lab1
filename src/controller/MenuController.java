package controller;

import static java.lang.System.out;

import java.util.List;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;
import logic.filter.Filtrator;
import logic.filter.FiltratorImpl;
import logic.filter.SizeFilter;
import logic.filter.StyleFilter;
import logic.sort_service.SortedBySize;
import logic.sort_service.SortedByStyle;

/**
 * Created by Pasha on 23.03.2017.
 */
public class MenuController {
    private KeyboardController keyboardController =new KeyboardController();
    private TrackStorage trackStorage = new TrackStorageImpl();

    protected void shouMainMenu() throws Exception {
        List<Track> allTrack = trackStorage.getAllTrack();
        int userSelection;
        out.println("Основное меню программы");
        out.println("Вберите пункт меню");
        out.println("1 Вывести весь список песен");
        out.println("2 Сортировать список песен");
        out.println("3 Выбрать песни из списка");
        out.println("4 Выход");

        userSelection=Integer.valueOf(keyboardController.getUserInput());
        switch (userSelection){
        case(1):{
            this.printAlltrack(allTrack);
            this.shouMainMenu();
            break;
        }
        case (2):{
            this.sortMenu();
            break;
        }
        case (3):{
            this.filterMenu();
            break;
        }
        case (4):{
            out.println("ByBy");
            break;
        }
        }
    }
    
    private void printAlltrack(List<Track>tracks) throws Exception{
        for (Track track:tracks){
            out.println(track);
        }
    }
    
    private void sortMenu() throws Exception{
        out.println("Меню сортировки");
        out.println("1 Сортировать по размеру");
        out.println("2 Сортировать по стилю");
        out.println("3 Основное меню");
        int userSelection=Integer.valueOf(keyboardController.getUserInput());
        List<Track> allTrack = trackStorage.getAllTrack();
        switch (userSelection){
        case (1):{
            allTrack.sort(new SortedBySize());
            this.printAlltrack(allTrack);
            this.sortMenu();
            break;
        }
        case (2):{
            allTrack.sort(new SortedByStyle());
            this.printAlltrack(allTrack);
            this.sortMenu();
            break;
        }
        case (3):
            this.shouMainMenu();
            break;
        }
    }
    
    private void filterMenu() throws Exception{
        out.println("Меню фильтра");
        out.println("1 Фильтровать по стилю");
        out.println("2 Фильтровать по размеру");
        out.println("3 Основное меню");
        int userSelection=Integer.valueOf(keyboardController.getUserInput());
        Filtrator filtrator;
        List <Track> filterTrack;
        switch (userSelection){
        case (1):
            filtrator= new FiltratorImpl(trackStorage);
            filterTrack = filtrator.filter(new StyleFilter("рок"));
            this.printAlltrack(filterTrack);
            break;
        case (2):
            filtrator= new FiltratorImpl(trackStorage);
            filterTrack = filtrator.filter(new SizeFilter(400,500));
            this.printAlltrack(filterTrack);
            break;
        case (3):
            this.shouMainMenu();
            break;
        }
    }
    
}
