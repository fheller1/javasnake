package objects;

public abstract class GameObject {
	protected char sign;
	protected Coordinate cd;
	
	public char getSign() {
		return sign;
	}
	public void setSign(char sign) {
		this.sign = sign;
	}
	public Coordinate getCoordinate() {
		return cd;
	}
	public void setCoordinate(Coordinate cd) {
		this.cd = cd;
	}
}
