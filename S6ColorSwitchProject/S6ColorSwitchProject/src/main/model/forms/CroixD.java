package main.model.forms;

class CroixD extends CroixG{

	public CroixD(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);

	}

	public void deplacer() {
		int rotation=-8;
		if(rotation > 360 ) {//la rotation reste modulo 360
			rotation -= 360;
		}else if(rotation<-360){
			rotation += 360;
		}
		rotation -= 8;
		forme.setRotate(rotation);
	}

	@Override
	public String toString() {
		return "CroixD [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed="
				+ speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}
}
