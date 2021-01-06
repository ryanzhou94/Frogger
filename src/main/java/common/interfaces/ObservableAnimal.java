package common.interfaces;

public interface ObservableAnimal {
	
	public void register(AnimalObserver newObserver);
	
	public void unregister(AnimalObserver deleteObserver);
	
	public void notifyAnimalObserver();
	
}
