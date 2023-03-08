package enums;

public enum Countries {
  //This list doesn't contain all available counties, just few for example

  ALBANIA,
  ARGENTINA,
  BAHRAIN,
  GABON,
  POLAND;

  @Override
  public String toString() {
    return name().substring(0, 1) + name().substring(1).toLowerCase();
  }
}
