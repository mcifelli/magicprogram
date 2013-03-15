package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView implements HasAllMouseHandlers {
//	private static final long serialVersionUID = 1L;
	private Game model;
	public Canvas canvas;
	Point mouse;
	
	public GameView(FlowPanel panel) {
		
		//set up game canvas
		canvas = Canvas.createIfSupported();
		canvas.setStyleName("h1");
		panel.add(canvas);
		canvas.setSize("500px", "500px");
		mouse = new Point(0, 0);
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	public void start() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				updateGame();
//				drawCanvas(canvas);
			}
		};
		timer.scheduleRepeating(10);
		
		canvas.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				// TODO Auto-generated method stub
				clickHandle(event);
//				drawBlue(canvas);
			}
		});
		
//	    canvas.addTouchMoveHandler(new TouchMoveHandler() {
//	        public void onTouchMove(TouchMoveEvent event) {
//	          event.preventDefault();
//	          if (event.getTouches().length() > 0) {
//	            Touch touch = event.getTouches().get(0);
//	            mouse.setX(touch.getRelativeX(canvas.getElement()));
//	            mouse.setY(touch.getRelativeY(canvas.getElement()));
//	          }
//	          event.preventDefault();
//	          System.out.println("hey");
//	          drawBlue(canvas);
//	        }
//	    });
		
		
	}
	
	//mouse has been clicked
	protected void clickHandle(MouseDownEvent event) {
		mouse.setX(event.getClientX());
		mouse.setY(event.getClientY());
//		model.getBoard().addCreep(new Creep(new Rectangle(new Point(mouse.getX(), mouse.getY()), Game.CSIZE, Game.CSIZE), 10, 2, new Point(mouse.getX(), mouse.getY())));
	}
	
	//update UI
	public void updateGame() {
		model.update();
	}
	
	public void drawBlue(Canvas canvas) {
		canvas.getContext2d().setFillStyle("Blue");
		canvas.getContext2d().fillRect(4, 4, 80, 40);
	}
	
	public void drawCanvas(Canvas canvas) {
		for(int i = 0; i < model.getBoard().getCreeps().size(); i++) {
			if(model.getBoard().getCreeps().size() > 0) {
				canvas.getContext2d().setFillStyle("Blue");
				canvas.getContext2d().fillRect(model.getBoard().getCreeps().get(i).getCenter().getX(), model.getBoard().getCreeps().get(i).getCenter().getY(), model.getBoard().getCreeps().get(i).getBody().getWidth(), model.getBoard().getCreeps().get(i).getBody().getHeight());
			}
		}
//		canvas.getContext2d().setFillStyle("#ff0000");
//		canvas.getContext2d().fillRect(20, 20, 80, 40);
	}

	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

}
