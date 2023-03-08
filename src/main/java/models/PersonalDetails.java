package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDetails {

  private String producerBand;
  private String contactFirstName;
  private String contactLastName;

}
