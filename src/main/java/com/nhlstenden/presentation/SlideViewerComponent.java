package com.nhlstenden.presentation;

import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.slide.Slide;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * <p>com.nhlstenden.presentation.SlideViewerComponent is a graphical component that can show slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent
{

    Slide slide; // current slide
    private Font labelFont = null; // font for labels
    private Presentation presentation = null; // the presentation
    private JFrame frame = null;

    private static final long serialVersionUID = 227L;

    private static final Color BGCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;
    private static final int XPOS = 1100;
    private static final int YPOS = 20;

    public SlideViewerComponent (Presentation presentation, JFrame frame)
    {
        setBackground (BGCOLOR);
        this.presentation = presentation;
        labelFont = new Font (FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.frame = frame;
    }

	//Get chosen size
	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	//Update presentation
	public void update(Presentation presentation, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentation;
		this.slide = data;
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	// draw the slide
	public void paintComponent(Graphics graphics) {
		graphics.setColor(BGCOLOR);
		graphics.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		graphics.setFont(labelFont);
		graphics.setColor(COLOR);
		graphics.drawString("com.nhlstenden.slide.Slide " + (1 + presentation.getSlideNumber()) + " of " +
				presentation.getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(graphics, this, area);
	}
}