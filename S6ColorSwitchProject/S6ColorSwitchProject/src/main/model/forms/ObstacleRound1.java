package main.model.forms;

class ObstacleRound1 extends Obstacles{
	private final Form part1;
	private final Form part2;
	private final Form part3;
	
	ObstacleRound1(int posX, int posY, int width, int height, int speed, int rotate){
		super(posX, posY, width, height, speed, rotate);
		part1 = FormsFactory.build("ROUND1", posX, posY, width, height, speed, rotate);
		part2 = FormsFactory.build("ROUND2", posX, posY, width-20, height-20, speed, rotate);
		part3 = FormsFactory.build("ROUND1", posX, posY, width-40, height-40, speed, rotate);
		
		addObstacle(part1.getForme());
		addObstacle(part2.getForme());
		addObstacle(part3.getForme());
		
		addStar(posX, posY);
	}
	
	@Override
	public void deplacer() {
		part1.deplacer();
		part2.deplacer();
		part3.deplacer();
	}

	@Override
	public String toString() {
		return "ObstacleRound1 [part1=" + part1 + ", part2=" + part2 + ", part3=" + part3 + ", posX=" + posX + ", posY="
				+ posY + ", width=" + width + ", height=" + height + ", speed=" + speed + ", forme=" + forme
				+ ", rotation=" + rotation + "]";
	}
}
