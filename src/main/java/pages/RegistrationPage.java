package pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Condition;
import enums.Steps;
import io.qameta.allure.Step;
import java.io.File;
import java.time.Duration;
import java.util.Objects;
import models.CompanyDetails;
import models.PersonalDetails;
import org.openqa.selenium.By;

public class RegistrationPage {

  @Step("Choose business account type")
  public RegistrationPage chooseBusinessAccountType() {
    $(By.className("value-business")).shouldBe(enabled).click();
    return this;
  }

  @Step("Input personal details")
  public RegistrationPage inputPersonalDetails(PersonalDetails personalDetails) {
    $(By.id("field-element-producerName")).setValue(personalDetails.getProducerBand());
    $(By.id("field-element-contactFirstname")).setValue(personalDetails.getContactFirstName());
    $(By.id("field-element-contactLastname")).scrollTo()
        .setValue(personalDetails.getContactLastName());
    return this;
  }

  @Step("Input company details")
  public RegistrationPage inputCompanyDetails(CompanyDetails companyDetails) {
    $(By.id("field-element-directorFirstname")).setValue(companyDetails.getDirectorsFirstName());
    $(By.id("field-element-directorLastname")).setValue(companyDetails.getDirectorsLastName());
    $(By.id("field-element-companyName")).setValue(companyDetails.getCompanyName());
    $(By.id("field-element-registrationNumber")).setValue(
        companyDetails.getRegistrationNumber().toString());
    $(By.id("field-element-vatNumber")).scrollTo().setValue(companyDetails.getVatNumber());

    $(By.id("field-element-addressCountryCode")).click();
    $(By.xpath("//*[text() = '" + companyDetails.getCountryOfCompany() + "']")).click();

    $(By.id("field-element-addressCity")).scrollTo().setValue(companyDetails.getCityOfCompany());
    $(By.id("field-element-addressRegion")).setValue(companyDetails.getRegion());
    $(By.id("field-element-addressPostCode")).setValue(companyDetails.getPostcode());
    $(By.id("field-element-addressStreet")).setValue(companyDetails.getAddressOfCompany());
    $(By.id("field-element-custodianOfRecordsAddress")).setValue(
        companyDetails.getCustodianRecordsAddress());
    return this;
  }

  @Step("Go to next step")
  public RegistrationPage nextStep() {
    $(By.xpath("//span[text() = 'Next']/..")).click();
    return this;
  }

  @Step("Get status step")
  public String getStatusStep(Steps stepName) {
    return $(By.xpath("//div[text() = '" + stepName.getStepName() + "']"))
        .shouldHave(Condition.attributeMatching("class", ".+ active"))
        .getAttribute("class");
  }

  @Step("Agree to term")
  public RegistrationPage agreeToTerm() {
    $(By.id("form-field-contractSigned")).click();
    return this;
  }

  @Step("Upload documents")
  public RegistrationPage uploadDocuments() {
    File[] files = new File("src/main/resources/documents").listFiles();
    $(By.id("field-element-passport")).uploadFile(Objects.requireNonNull(files)[0]);
    $(By.id("field-element-passportSecondPage")).uploadFile(files[1]);
    $(By.id("field-element-commercialRegisterExtract")).uploadFile(files[2]);
    $(By.id("field-element-certificateOfIncorporation")).uploadFile(files[3]);
    return this;
  }

  @Step("Finish registration")
  public TermsOfUsePage finishRegistration() {
    var finishButton = $(By.xpath("//span[text() = 'Finish registration']/.."));
    finishButton.click();
    finishButton.shouldBe(disappear, Duration.ofSeconds(40));
    return page(TermsOfUsePage.class);
  }

  @Step("Get header complete registration")
  public String getHeaderCompeteRegistration() {
    return $(By.id("wizard-page-title")).getText();
  }

  @Step("Get description complete registration")
  public String getDescriptionCompleteRegistration() {
    return $(By.xpath("//div[contains(text(), 'check your email')]")).getText();
  }


}
