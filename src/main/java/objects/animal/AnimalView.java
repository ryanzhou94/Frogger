package objects.animal;

import javafx.scene.image.Image;

/**
 * The view (V in MVC pattern) of Animal.
 * <p>
 * It saves images of all status of Animal including still images, moving images, water death and car death images.
 * It is only responsible for keeping the images of Animal and has no control of any other modules or components.
 * The controllers of Animal will access to AnimalView to set the image of Animal.
 * 
 * @author ryan
 *
 */
public class AnimalView {

	/**
	 * Images for live Animal.
	 */
	private Image[] aliveImages = new Image[8];
	
	/**
	 * Images for Animal with car death.
	 */
	private Image[] carDeathImages = new Image[3];
	
	/**
	 * Images for Animal with water death.
	 */
	private Image[] waterDeatImages = new Image[4];
	
	/**
	 * The size of each images for Animal.
	 */
	private int imgSize;
	
	/**
	 * Initialize image size with 40 and load all images for Animal.
	 */
	public AnimalView() {
		this.imgSize = 40;
		loadImages();
	}

	/**
	 * Load images of all status of Animal.
	 */
	private void loadImages() {
		loadAliveImages();
		loadCarDeathImages();
		loadWaterDeathImages();
	}

	/**
	 * Load 8 living images.
	 */
	private void loadAliveImages() {
		this.aliveImages[0] = loadImage("file:src/main/resources/froggerUp.png");
		this.aliveImages[1] = loadImage("file:src/main/resources/froggerLeft.png");
		this.aliveImages[2] = loadImage("file:src/main/resources/froggerDown.png");
		this.aliveImages[3] = loadImage("file:src/main/resources/froggerRight.png");
		this.aliveImages[4] = loadImage("file:src/main/resources/froggerUpJump.png");
		this.aliveImages[5] = loadImage("file:src/main/resources/froggerLeftJump.png");
		this.aliveImages[6] = loadImage("file:src/main/resources/froggerDownJump.png");
		this.aliveImages[7] = loadImage("file:src/main/resources/froggerRightJump.png");
	}
	
	/**
	 * Load 4 water death images.
	 */
	private void loadWaterDeathImages() {
		this.waterDeatImages[0] = loadImage("file:src/main/resources/waterdeath1.png");
		this.waterDeatImages[1] = loadImage("file:src/main/resources/waterdeath2.png");
		this.waterDeatImages[2] = loadImage("file:src/main/resources/waterdeath3.png");
		this.waterDeatImages[3] = loadImage("file:src/main/resources/waterdeath4.png");
	}

	/**
	 * Load 3 car death images.
	 */
	private void loadCarDeathImages() {
		this.carDeathImages[0] = loadImage("file:src/main/resources/cardeath1.png");
		this.carDeathImages[1] = loadImage("file:src/main/resources/cardeath2.png");
		this.carDeathImages[2] = loadImage("file:src/main/resources/cardeath3.png");
	}

	/**
	 * Create an instance of Image with given URL.
	 * 
	 * @param path file path of a image
	 * @return an instance of Image
	 */
	private Image loadImage(String path) {
		return new Image(path, this.imgSize, this.imgSize, true, true);
	}
	
	@SuppressWarnings("exports")
	public Image[] getAliveImages() {
		return aliveImages;
	}

	@SuppressWarnings("exports")
	public void setAliveImages(Image[] aliveImages) {
		this.aliveImages = aliveImages;
	}

	@SuppressWarnings("exports")
	public Image[] getCarDeathImages() {
		return carDeathImages;
	}

	@SuppressWarnings("exports")
	public void setCarDeathImages(Image[] carDeathImages) {
		this.carDeathImages = carDeathImages;
	}

	@SuppressWarnings("exports")
	public Image[] getWaterDeatImages() {
		return waterDeatImages;
	}

	@SuppressWarnings("exports")
	public void setWaterDeatImages(Image[] waterDeatImages) {
		this.waterDeatImages = waterDeatImages;
	}
	
}
