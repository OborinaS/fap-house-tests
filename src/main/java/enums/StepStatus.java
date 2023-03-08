package enums;


public enum StepStatus {
  ACTIVE,
  COMPLETE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
