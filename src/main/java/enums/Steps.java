package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Steps {
  DETAILS ("Details"),
  AGREEMENT ("Agreement"),
  VERIFICATION ("Verification");

  private final String stepName;
}
