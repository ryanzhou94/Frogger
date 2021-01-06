package common.interfaces;

/**
 * This interface provides method(s) for physical objects to sink into water and emerge from water.
 * 
 * @author ryan
 *
 */
public interface Sinkable {

	/**
	 * The object sinks to water.
	 */
	public void sink();
	
	/**
	 * The object emerges from water.
	 */
	public void emerge();
	
}
