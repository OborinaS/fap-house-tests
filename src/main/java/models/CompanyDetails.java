package models;

import enums.Countries;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDetails {
  private String directorsFirstName;
  private String directorsLastName;
  private String companyName;
  private Integer registrationNumber;
  private String vatNumber;
  private Countries countryOfCompany;
  private String cityOfCompany;
  private String region;
  private String postcode;
  private String addressOfCompany;
  private String custodianRecordsAddress;
}
