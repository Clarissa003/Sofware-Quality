package com.nhlstenden.presentation;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.slide.Slide;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>com.nhlstenden.presentation.Presentation maintains the slides in the presentation.</p>
 * <p>There is only instance of this class.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation implements PresentationObserver
{
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;
    private SlideViewerFrame slideViewerFrame;
    private final List<PresentationObserver> observers;

    public Presentation()
    {
        observers = new ArrayList<>();
        slideViewComponent = null;
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
        observers = new ArrayList<>();
        clear();
    }

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    // give the number of the current slide
    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    // change the current slide number and signal it to the window
    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
            notifyObservers();
        }
    }

    // go to the previous slide unless your at the beginning of the presentation
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    // go to the next slide unless your at the end of the presentation.
    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    // Delete the presentation to be ready for the next one.
    public void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    public void append(Slide slide)
    {
        showList.add(slide);
    }

    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    public void executeCommand(Command command)
    {
        command.execute();
    }

    public void exit(int n)
    {
        System.exit(n);
    }

    public void addObserver(PresentationObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(PresentationObserver observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers()
    {
        for (PresentationObserver observer : observers)
        {
            observer.update();
        }
    }

    @Override
    public void update()
    {
        if (slideViewComponent != null)
        {
            slideViewComponent.update(this, getCurrentSlide());
        }

        notifyObservers();
    }
}