package main.model.forms;

abstract class Bonus extends Form{

	Bonus(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
	}

	@Override
	public String toString() {
		return "Bonus [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}
	
}
