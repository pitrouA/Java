package main.model.forms;

public class RondDeRondsAccelere extends RondDeRonds{
	
	private int timeline = 0;

	public RondDeRondsAccelere(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
	}
	
	@Override
	public void deplacer() {
		super.deplacer();
		
		timeline=(timeline + 1)%50;//fait avancer la timeline
		
		if(timeline > 35 && timeline < 50) {
			this.setSpeed(speed-1);
		}else if(timeline > 5 && timeline < 20) {
			this.setSpeed(speed+1);
		}
	}
}
