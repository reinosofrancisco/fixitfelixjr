package game;

import java.util.LinkedList;
import java.util.List;

public class GameEvent {
	
	private List<Event> events=new LinkedList<Event>();
	
	
	public void WindowBroke() {
		events.add(Event.WINDOW_BROKE);
	}
	
	
	
	
	
	
	
	

}

enum Event {
	WINDOW_BROKE,
}