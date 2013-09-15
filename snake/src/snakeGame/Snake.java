package snakeGame;


import java.util.ArrayList;

public class Snake {

	
	ArrayList<Point> line;
	Point lastPoint;
	Direction direction;
	private final int beginX = 20,beginY = 15;
	private final int borderX = 40,borderY = 30;
	public Snake(int length){
		
		line = new ArrayList<>();
		for(int i = 0;i<length;i++)
			line.add(new Point(beginX-i, beginY));
		lastPoint = line.get(length-1);
		direction = Direction.RIGHT;
	}

	public boolean down(){
		Point point = line.get(0);
		if(point.getY()>borderY-1||eatSelf())
		return false;
		else {
			if(isAllowed(Direction.DOWN)){
			direction = Direction.DOWN;
			lastPoint = line.get(line.size()-1);
			for(int i = line.size()-1;i>0;i--)
				line.set(i, line.get(i-1));
			line.set(0, new Point(point.getX(),point.getY()+1));}
			return true;
		}
	}
	public boolean up(){
		Point point = line.get(0);
		if(point.getY()<0||eatSelf())
		return false;
		else {
			if(isAllowed(Direction.UP)){
			direction = Direction.UP;
			lastPoint = line.get(line.size()-1);
			for(int i = line.size()-1;i>0;i--)
				line.set(i, line.get(i-1));
			line.set(0, new Point(point.getX(),point.getY()-1));}
			return true;
		}
	}
	
	public boolean left(){
		Point point = line.get(0);
		
		if(point.getX()<0||eatSelf())
		return false;
		else {
			if(isAllowed(Direction.LEFT)){
			direction = Direction.LEFT;
			lastPoint = line.get(line.size()-1);
			for(int i = line.size()-1;i>0;i--)
				line.set(i, line.get(i-1));
			line.set(0, new Point(point.getX()-1,point.getY()));}
			return true;
		}
	
	}
	public boolean right(){
		Point point = line.get(0);
		if(point.getX()>borderX-1||eatSelf())
		return false;
		else {
			if(isAllowed(Direction.RIGHT)){
			direction = Direction.RIGHT;
			lastPoint = line.get(line.size()-1);
			for(int i = line.size()-1;i>0;i--)
				line.set(i, line.get(i-1));
			line.set(0, new Point(point.getX()+1,point.getY()));}
			return true;
		}
	}
	public boolean forward(){
		boolean alive = true;
		switch (direction) {
		case DOWN:
			alive = down();
			break;
		case UP:
			alive = up();
			break;
		case LEFT:
			alive = left();
			break;
		case RIGHT:
			alive = right();
			break;
		}
		return alive;
		
	}

	private boolean eatSelf(){
		Point head = line.get(0);
		for(int i = line.size()-1;i>2;i--)
			if(line.get(i).compareTo(head))
				return true;
		return false;
	}
	
	public void add(){
		line.add(lastPoint);
	}
	
	public boolean minus(){
		if(line.size()>2)
			{line.remove(line.size()-1);return true;}
		else
			return false;//������
	}
	
	

	public Point get(int index){
		return line.get(index);
	}
	
	public int length(){
		return line.size();
	}
	
	private boolean isAllowed(Direction turn){
		int t = turn.ordinal();
		int d = direction.ordinal();

		if(t!=((d+2)%4))
			return true;
		
		return false;
		
	}
}
