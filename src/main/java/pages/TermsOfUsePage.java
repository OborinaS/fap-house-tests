package pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

import io.qameta.allure.Step;
import java.time.Duration;
import models.LegalCompanyInfo;
import org.openqa.selenium.By;

public class TermsOfUsePage {

  @Step("Agree with all terms of use")
  public TermsOfUsePage chooseAllTermsOfUse() {
    $(By.id("affidavit-modal")).shouldBe(visible);
    var elements = $$(By.xpath("//div[contains(@id, 'field-element-checkbox')]"));
    elements.asFixedIterable().forEach(element ->
        element.scrollTo().click());
    return this;
  }

  @Step("Input legal company info")
  public TermsOfUsePage inputLegalCompanyInfo(LegalCompanyInfo legalInfo) {
    $(By.id("field-element-fullLegalName")).setValue(legalInfo.getFullLegalName());
    $(By.id("field-element-jobTitle")).setValue(legalInfo.getJobTitle());
    $(By.id("field-element-companyLegalName")).setValue(legalInfo.getCompanyLegalName());
    return this;
  }

  @Step("Certify terms of use")
  public RegistrationPage certify() {
    var certifyButton = $(By.id("affidavit-modal__ok"));
    certifyButton.click();
    certifyButton.shouldBe(disappear, Duration.ofSeconds(15));
    return page(RegistrationPage.class);
  }
}
