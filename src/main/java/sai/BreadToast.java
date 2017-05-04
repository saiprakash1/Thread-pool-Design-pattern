package sai;

/**
 * 
 * BreadToast is a concrete task
 *
 */
public class BreadToast extends Task {

  private static final int TIME_PER_BREAD = 50;

  public BreadToast(int numBread) {
    super(numBread * TIME_PER_BREAD);
  }

  @Override
  public String toString() {
    return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
  }
}
