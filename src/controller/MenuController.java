package controller;

import datalayer.datamodel.Track;
import datalayer.storage.TrackStorage;
import datalayer.storage.TrackStorageImpl;
import logic.filter.Filtrator;
import logic.filter.FiltratorImpl;
import logic.filter.SizeFilter;
import logic.filter.StyleFilter;
import logic.sort_service.SortedBySize;
import logic.sort_service.SortedByStyle;

import java.time.LocalTime;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Pasha on 23.03.2017.
 */
public class MenuController {
    private KeyboardController keyboardController = new KeyboardController();
    private TrackStorage trackStorage = new TrackStorageImpl();

    public MenuController() {
    }

    protected void showMainMenu() {
        List<Track> allTrack = trackStorage.getAllTrack();
        int userSelection;
        out.println("Основное меню программы");
        out.println("Вберите пункт меню");
        out.println("1 Вывести весь список песен");
        out.println("2 Сортировать список песен");
        out.println("3 Выбрать песни из списка");
        out.println("4 Проиграть все мелодии");
        out.println("5 Выход");

        userSelection = Integer.valueOf(keyboardController.getUserInput());
        switch (userSelection) {
            case (1): {
                this.printAllTrack(allTrack);
                this.showMainMenu();
                break;
            }
            case (2): {
                this.sortMenu();
                break;
            }
            case (3): {
                this.filterMenu();
                break;
            }
            case (4): {
                trackStorage.playTracks();
                this.showMainMenu();
                break;
            }
            case (5): {
                out.println("ByBy");
                break;
            }
        }
    }

    private void printAllTrack(List<Track> tracks) {
        TrackStorage printTrackStorage = new TrackStorageImpl(tracks);
        for (Track track : tracks) {
            out.println(track);
        }
        out.println("размер всех композиций " + printTrackStorage.getSize());
    }

    private void sortMenu() {
        out.println("Меню сортировки");
        out.println("1 Сортировать по размеру");
        out.println("2 Сортировать по стилю");
        out.println("3 Основное меню");
        int userSelection = Integer.valueOf(keyboardController.getUserInput());
        List<Track> allTrack = trackStorage.getAllTrack();
        switch (userSelection) {
            case (1): {
                allTrack.sort(new SortedBySize());
                this.printAllTrack(allTrack);
                this.sortMenu();
                break;
            }
            case (2): {
                allTrack.sort(new SortedByStyle());
                this.printAllTrack(allTrack);
                this.sortMenu();
                break;
            }
            case (3):
                this.showMainMenu();
                break;
        }
    }

    private void filterMenu() {
        out.println("Меню фильтра");
        out.println("1 Фильтровать по стилю");
        out.println("2 Фильтровать по размеру");
        out.println("3 Основное меню");
        int userSelection = Integer.valueOf(keyboardController.getUserInput());
        Filtrator filtrator;
        List<Track> filterTrack = null;
        switch (userSelection) {
            case (1):
                filtrator = new FiltratorImpl(trackStorage);
                filterTrack = filtrator.filter(new StyleFilter("rock"));
                this.printAllTrack(filterTrack);
                break;
            case (2):
                filtrator = new FiltratorImpl(trackStorage);
                try {
                    filterTrack = filtrator.filter(new SizeFilter(LocalTime.parse("00:03:10"), LocalTime.parse("00:04:30")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.printAllTrack(filterTrack);
                break;
            case (3):
                this.showMainMenu();
                break;
        }
    }

}
