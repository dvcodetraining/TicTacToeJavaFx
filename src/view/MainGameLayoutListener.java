package view;

import java.util.EventListener;

public interface MainGameLayoutListener extends EventListener
{
	public void moveChoosen(BoardTile tile);
//	public void moveChoosen(MoveEvent event);
}
