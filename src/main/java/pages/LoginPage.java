package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;


public class LoginPage {

  @Step("Input username")
  private LoginPage setName(String username) {
    $(By.name("username")).setValue(username);
    return this;
  }

  @Step("Input email")
  private LoginPage setEmail(String email) {
    $(By.name("email")).setValue(email);
    return this;
  }

  @Step("Set password")
  private LoginPage setPassword(String password) {
    $(By.name("password")).setValue(password);
    return this;
  }

  @Step("Register new user")
  public RegistrationPage registerNewUser(User user) {
    setName(user.getUsername()).setEmail(user.getEmail()).setPassword(user.getPassword());
    $(By.cssSelector("form[id = create-account]  button[type = 'submit']")).click();
    return page(RegistrationPage.class);
  }

}
