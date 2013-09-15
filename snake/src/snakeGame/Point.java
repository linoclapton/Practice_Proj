package snakeGame;

public class Point {

	private int x;
	private int y;
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean compareTo(Point another){
		if(this.x == another.x&&this.y == another.y)
			return true;
		else return false;
		
	}
}
