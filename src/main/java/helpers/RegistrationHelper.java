package helpers;

import com.github.javafaker.Faker;
import enums.Countries;
import io.qameta.allure.Step;
import models.CompanyDetails;
import models.LegalCompanyInfo;
import models.PersonalDetails;

public class RegistrationHelper {

  public static Faker faker = new Faker();

  @Step("Get random valid users personal details")
  public static PersonalDetails getRandomPersonalDetails() {
    return PersonalDetails.builder()
        .producerBand(faker.name().name())
        .contactFirstName(faker.name().firstName())
        .contactLastName(faker.name().lastName())
        .build();
  }

  @Step("Get random valid users company details")
  public static CompanyDetails getRandomCompanyDetails() {
    return CompanyDetails.builder()
        .directorsFirstName(faker.name().firstName())
        .directorsLastName(faker.name().lastName())
        .companyName(faker.company().name())
        .registrationNumber(faker.number().numberBetween(100, 99999))
        .vatNumber("2-" + faker.number().numberBetween(10, 999))
        .countryOfCompany(Countries.ARGENTINA)
        .cityOfCompany(faker.address().city())
        .region(faker.address().state())
        .postcode(faker.address().zipCode())
        .addressOfCompany(faker.address().streetAddress())
        .custodianRecordsAddress(faker.address().secondaryAddress())
        .build();
  }

  @Step("Get random valid users company legal details")
  public static LegalCompanyInfo getLegalCompanyDetails() {
    return LegalCompanyInfo.builder()
        .fullLegalName(faker.company().logo())
        .jobTitle(faker.company().profession())
        .companyLegalName(faker.company().name()).build();
  }
}
