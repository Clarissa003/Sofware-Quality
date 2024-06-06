package com.nhlstenden.presentation;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.slide.Slide;
import com.nhlstenden.slide.SlideDirector;

import java.util.ArrayList;
import java.util.List;

public class Presentation implements PresentationObserver {
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;
    private SlideViewerFrame slideViewerFrame;
    private SlideDirector slideDirector;
    private final List<PresentationObserver> observers;

    public Presentation() {
        observers = new ArrayList<>();
        slideViewComponent = null;
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        observers = new ArrayList<>();
        clear();
    }

    public int getSize() {
        return showList.size();
    }

    public String getTitle() {
        return showTitle;
    }

    public void setTitle(String nt) {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSlideNumber() {
        return currentSlideNumber;
    }

    public void setSlideNumber(int number) {
        currentSlideNumber = number;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
            notifyObservers();
        }
    }

    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    public void clear() {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    public void append(Slide slide) {
        showList.add(slide);
    }

    public Slide getSlide(int number) {
        if (number < 0 || number >= getSize()) {
            return null;
        }
        return showList.get(number);
    }

    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public void exit(int n) {
        System.exit(n);
    }

    public void addObserver(PresentationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PresentationObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (PresentationObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
        notifyObservers();
    }
}
