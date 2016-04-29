import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }
  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Word"));
    fill("#name").with("Einstenium");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }
  @Test
  public void wordIsClickedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Word"));
    fill("#name").with("Einstenium");
    submit(".btn");
    goTo("http://localhost:4567/");
    click("a", withText("Einstenium"));
    assertThat(pageSource()).contains("Entry");
  }
  @Test
  public void wordDefinitionIsCreated() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Word"));
    fill("#name").with("Extremely");
    submit(".btn");
    goTo("http://localhost:4567/");
    click("a", withText("Extremely"));
    click("a", withText("Add a new definition"));
    fill("#description").with("to a pronounced degree");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  public void wordDefinitionIsAccessed() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Word"));
    fill("#name").with("Extremely");
    submit(".btn");
    goTo("http://localhost:4567/");
    click("a", withText("Extremely"));
    click("a", withText("Add a new definition"));
    fill("#description").with("to a pronounced degree");
    submit(".btn");
    click("a", withText("View Entry"));
    assertThat(pageSource()).contains("to a pronounced degree");
  }
}
