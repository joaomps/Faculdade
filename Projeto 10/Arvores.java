/**
 * @author João Silva, no.48782
 */

import java.util.Random;

public class Arvores extends Turtle {

	public Arvores(LabPImage im, int x, int y) {
		super(im, x, y);
		super.turn(90);
	}

	private void ramos(double comp, double larg, boolean green) {
		if (green && comp < 22.5) {
			super.setRGBT(100, 255, 0, 255);
		} else {
			super.setRGBT(150, 90, 30, 255);
		}
		super.penDown();
		super.turn(-90);
		super.forward(larg / 2);
		super.turn(90);
		super.forward(comp);
		super.turn(90);
		super.forward(larg);
		super.turn(90);
		super.forward(comp);
		super.turn(90);
		super.forward(larg / 2);
		super.penUp();
		super.turn(90);
		super.forward(comp);
	}

	public void arvore1(double length) {
		ramos(length, length / 5, false);
		if (length / 5 > 2) {
			super.turn(60);
			arvore1(length / 2);
			super.turn(-120);
			arvore1(length / 2);
			super.turn(60);
		}
		super.forward(-length);
	}

	public void arvore2(double length) {
		ramos(length, length / 5, false);
		if (length / 5 > 2) {
			super.turn(60);
			arvore2(length / 2);
			super.turn(-60);
			arvore2(length / 2);
			super.turn(-60);
			arvore2(length / 2);
			super.turn(60);
		}
		super.forward(-length);
	}

	public void arvore3(double length) {
		ramos(length, length / 5, false);
		if (length / 5 > 2) {
			super.turn(60);
			arvore3(length / 2);
			super.turn(-40);
			arvore3(length / 2);
			super.turn(-40);
			arvore3(length / 2);
			super.turn(-40);
			arvore3(length / 2);
			super.turn(60);
		}
		super.forward(-length);
	}

	public void arvore4(double length) {
		Random rnd = new Random();
		ramos(length, length / 5, false);
		if (length / 5 > 2) {
			super.turn(60);
			arvore4(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(-40);
			arvore4(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(-40);
			arvore4(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(-40);
			arvore4(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(60);
		}
		super.forward(-length);
	}

	public void arvore5(double length) {
		Random rnd = new Random();
		ramos(length, length / 5, false);
		double var;
		if (length / 5 > 2) {
			do {
				var = Math.ceil(-40 * (rnd.nextDouble() * 0.5 + 0.75));
			} while (var * 3 != -120);
			super.turn(60);
			arvore5(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(var);
			arvore5(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(var);
			arvore5(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(var);
			arvore5(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
			super.turn(60);
		}
		super.forward(-length);
	}

	public void arvore6(double length) {
		Random rnd = new Random();
		ramos(length, length / 5, false);
		double gaussian = rnd.nextGaussian();
		if (length / 5 > 2) {
			if (gaussian < -0.8) {
				double var;
				do {
					var = Math.ceil(-120 * (rnd.nextDouble() + 0.5));
				} while (var != -120);
				double var2 = (var / 2) * -1;
				super.turn(var2);
				arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
				super.turn(var);
				arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
				super.turn(var2);
			} else {
				if (gaussian < 0.2) {
					double var;
					do {
						var = Math.ceil(-60 * (rnd.nextDouble() + 0.5));
					} while (var * 2 != -120);
					double var2 = var * -1;
					super.turn(var2);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var2);
				} else if (gaussian > 0.1) {
					double var;
					do {
						var = Math.ceil(-40 * (rnd.nextDouble() + 0.5));
					} while (var * 3 != -120);
					double var2 = ((var * 3) / 2) * -1;
					super.turn(var2);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore6(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var2);
				}
			}
		}
		super.forward(-length);
	}

	public void arvore7(double length) {
		Random rnd = new Random();
		ramos(length, length / 5, true);
		double gaussian = rnd.nextGaussian();
		if (length / 5 > 1) {
			if (gaussian < -0.8) {
				double var;
				do {
					var = Math.ceil(-120 * (rnd.nextDouble() + 0.5));
				} while (var != -120);
				double var2 = (var / 2) * -1;
				super.turn(var2);
				arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
				super.turn(var);
				arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
				super.turn(var2);
			} else {
				if (gaussian < 0.2) {
					double var;
					do {
						var = Math.ceil(-60 * (rnd.nextDouble() + 0.5));
					} while (var * 2 != -120);
					double var2 = var * -1;
					super.turn(var2);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var2);
				} else if (gaussian > 0.1) {
					double var;
					do {
						var = Math.ceil(-40 * (rnd.nextDouble() + 0.5));
					} while (var * 3 != -120);
					double var2 = ((var * 3) / 2) * -1;
					super.turn(var2);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var);
					arvore7(length / 2 * (rnd.nextDouble() * 0.5 + 0.75));
					super.turn(var2);
				}
			}
		}
		super.forward(-length);
	}
}
