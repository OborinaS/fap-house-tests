package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LegalCompanyInfo {

  private String fullLegalName;
  private String jobTitle;
  private String companyLegalName;
}
