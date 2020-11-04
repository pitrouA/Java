package main.model.forms;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.model.Level;

/**
 * Une explosion a jouer quand la balle touche un obstacle
 * @author CALVO-FERNANDEZ Adelie
 * @version 1.0
 * @since 03/03/18
 * */
public class Explosion extends Form {
	private Rectangle r1;
	private Rectangle r2;
	private Rectangle r3;
	private Rectangle r4;
	private Rectangle r5;
	private Rectangle r6;
	private Rectangle r7;
	private Rectangle r8;

	public Explosion(){
		super(0, 0, 0, 0, 0, 0);
		Rectangle r1 = new Rectangle(0, 0, 10, 10);
		Rectangle r2 = new Rectangle(0, 0, 10, 10);
		Rectangle r3 = new Rectangle(0, 0, 10, 10);
		Rectangle r4 = new Rectangle(0, 0, 10, 10);
		Rectangle r5 = new Rectangle(0, 0, 10, 10);
		Rectangle r6 = new Rectangle(0, 0, 10, 10);
		Rectangle r7 = new Rectangle(0, 0, 10, 10);
		Rectangle r8 = new Rectangle(0, 0, 10, 10);
		r1.setFill(Color.BEIGE);
		r2.setFill(Color.BEIGE);
		r3.setFill(Color.BEIGE);
		r4.setFill(Color.BEIGE);
		r5.setFill(Color.BEIGE);
		r6.setFill(Color.BEIGE);
		r7.setFill(Color.BEIGE);
		r8.setFill(Color.BEIGE);
		forme.getChildren().add(r1);
		forme.getChildren().add(r2);
		forme.getChildren().add(r3);
		forme.getChildren().add(r4);
		forme.getChildren().add(r5);
		forme.getChildren().add(r6);
		forme.getChildren().add(r7);
		forme.getChildren().add(r8);
	}

	public List<Node> getRec() {
		List<Node> listRec=new ArrayList<Node>();
		listRec.add(r1);
		listRec.add(r2);
		listRec.add(r3);
		listRec.add(r4);
		listRec.add(r5);
		listRec.add(r6);
		listRec.add(r7);
		listRec.add(r8);
		return listRec;
	}
	public void seDeplacer(Ball b){

		/*r1.setFill(b.getCouleur());
		r2.setFill(b.getCouleur());
		r3.setFill(b.getCouleur());
		r4.setFill(b.getCouleur());
		r5.setFill(b.getCouleur());
		r6.setFill(b.getCouleur());
		r7.setFill(b.getCouleur());
		r8.setFill(b.getCouleur());*/
		int posx=b.getPosX();
		int posy=b.getPosY();
		final KeyFrame kf1 = new KeyFrame(Duration.ZERO, new KeyValue(this.r1.translateYProperty(), posy));
        final KeyFrame kf11 = new KeyFrame(Duration.seconds(1), new KeyValue(this.r1.translateYProperty(), -30));
        final Timeline timeline1 = new Timeline(kf1, kf11);
        //timeline1.setCycleCount(Timeline.INDEFINITE);


		final KeyFrame kf2 = new KeyFrame(Duration.ZERO, new KeyValue(r2.translateXProperty(), posx), new KeyValue(r2.translateYProperty(), posy));
        final KeyFrame kf12 = new KeyFrame(Duration.seconds(1), new KeyValue(r2.translateXProperty(), 30), new KeyValue(r2.translateYProperty(), -30));
        final Timeline timeline2 = new Timeline(kf2, kf12);
        //timeline1.setCycleCount(Timeline.INDEFINITE);

		final KeyFrame kf3 = new KeyFrame(Duration.ZERO, new KeyValue(r3.translateXProperty(), posx));
        final KeyFrame kf13 = new KeyFrame(Duration.seconds(1), new KeyValue(r3.translateXProperty(), 30));
        final Timeline timeline3 = new Timeline(kf3, kf13);
        timeline1.setCycleCount(Timeline.INDEFINITE);


		final KeyFrame kf4 = new KeyFrame(Duration.ZERO, new KeyValue(r4.translateXProperty(), posx), new KeyValue(r4.translateYProperty(), posy));
        final KeyFrame kf14 = new KeyFrame(Duration.seconds(1), new KeyValue(r4.translateXProperty(), 30), new KeyValue(r4.translateYProperty(), 30));
        final Timeline timeline4 = new Timeline(kf4, kf14);
        timeline1.setCycleCount(Timeline.INDEFINITE);

		final KeyFrame kf5 = new KeyFrame(Duration.ZERO, new KeyValue(r5.translateYProperty(), posy));
        final KeyFrame kf15 = new KeyFrame(Duration.seconds(1), new KeyValue(r5.translateYProperty(), -30));
        final Timeline timeline5 = new Timeline(kf5, kf15);
        timeline1.setCycleCount(Timeline.INDEFINITE);


		final KeyFrame kf6 = new KeyFrame(Duration.ZERO, new KeyValue(r6.translateXProperty(), posx), new KeyValue(r6.translateYProperty(), posy));
        final KeyFrame kf16 = new KeyFrame(Duration.seconds(1), new KeyValue(r6.translateXProperty(), -30), new KeyValue(r6.translateYProperty(), 30));
        final Timeline timeline6 = new Timeline(kf6, kf16);
        timeline1.setCycleCount(Timeline.INDEFINITE);

		final KeyFrame kf7 = new KeyFrame(Duration.ZERO, new KeyValue(r7.translateYProperty(), posy));
        final KeyFrame kf17 = new KeyFrame(Duration.seconds(1), new KeyValue(r7.translateXProperty(), -30));
        final Timeline timeline7 = new Timeline(kf7, kf17);
        timeline1.setCycleCount(Timeline.INDEFINITE);


		final KeyFrame kf8 = new KeyFrame(Duration.ZERO, new KeyValue(r8.translateXProperty(), posx), new KeyValue(r8.translateYProperty(),posy));
        final KeyFrame kf18 = new KeyFrame(Duration.seconds(1), new KeyValue(r8.translateXProperty(), -30), new KeyValue(r8.translateYProperty(), -30));
        final Timeline timeline8 = new Timeline(kf8, kf18);
        timeline1.setCycleCount(Timeline.INDEFINITE);
        //timeline2.setAutoReverse(true);
        timeline1.playFromStart();
        timeline2.playFromStart();
        timeline3.playFromStart();
        timeline4.playFromStart();
        timeline5.playFromStart();
        timeline6.playFromStart();
        timeline7.playFromStart();
        timeline8.playFromStart();
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}

	@Override
	public boolean doCollision(Level level) {
		return false;//jamais de collisions
	}
}

