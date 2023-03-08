package tests;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

import enums.StepStatus;
import enums.Steps;
import helpers.RegistrationHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.TermsOfUsePage;

@Owner("svetlanaoborina")
@Feature("Registration")
@DisplayName("Registration test")
public class RegistrationTest extends BaseTest {

  private static final String USERNAME = RandomStringUtils.randomAlphabetic(6) + "test";
  private static final String EMAIL = USERNAME + "@test.com";
  private static final String PASSWORD = RandomStringUtils.randomAlphabetic(6) + "123$!";

  private final LoginPage loginPage = new LoginPage();
  private final RegistrationPage registrationPage = new RegistrationPage();
  private final TermsOfUsePage termsOfUsePage = new TermsOfUsePage();


  @Test
  @DisplayName("Check registration user with business plan")
  void registrationWithBusinessAccountTest() {
    open("/");

    var user = User.builder()
        .username(USERNAME)
        .email(EMAIL)
        .password(PASSWORD)
        .build();

    loginPage.registerNewUser(user)
        .chooseBusinessAccountType()
        .inputPersonalDetails(RegistrationHelper.getRandomPersonalDetails())
        .inputCompanyDetails(RegistrationHelper.getRandomCompanyDetails())
        .nextStep();

    assertThat(registrationPage.getStatusStep(Steps.AGREEMENT))
        .describedAs("Check step agreement is active")
        .contains(StepStatus.ACTIVE.toString());

    registrationPage.agreeToTerm().nextStep();

    assertThat(registrationPage.getStatusStep(Steps.VERIFICATION))
        .describedAs("Check step verification is active")
        .contains(StepStatus.ACTIVE.toString());

    registrationPage
        .uploadDocuments()
        .finishRegistration();

    termsOfUsePage
        .chooseAllTermsOfUse()
        .inputLegalCompanyInfo(RegistrationHelper.getLegalCompanyDetails())
        .certify();

    assertThat(registrationPage.getHeaderCompeteRegistration())
        .describedAs("Check header complete registration")
        .isEqualTo("Complete registration on FapHouse");

    assertThat(registrationPage.getDescriptionCompleteRegistration())
        .describedAs("Check email is correct")
        .containsIgnoringCase(user.getEmail());
  }
}
