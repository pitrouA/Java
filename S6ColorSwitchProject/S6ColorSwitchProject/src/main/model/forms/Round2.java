package main.model.forms;

class Round2 extends Round1{

	Round2(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
	}

	@Override
	public void deplacer() {
		if(rotation < 0) {//la rotation reste modulo 360
			rotation += 360;
		}
		rotation -= speed;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "Round2 [posX=" + posX + ", posY=" + posY + ", speed=" + speed + ", forme=" + forme + ", rotation="
				+ rotation + "]";
	}
}
