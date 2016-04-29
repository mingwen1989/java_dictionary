import org.junit.*;
import static org.junit.Assert.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.time.LocalDateTime;

public class DefinitionTest {

  @Test
    public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("stupendous");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
    public void Definition_instantiatesWithDescription_String() {
    Definition myDefinition = new Definition("stupendous");
    assertEquals("stupendous", myDefinition.getDescription());
  }
  @Test
    public void isCompleted_isFalseAfterInstantiation_false() {
    Definition myDefinition = new Definition("stupendous");
    assertEquals(false, myDefinition.isCompleted());
  }
  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today(){
    Definition myDefinition = new Definition("stupendous");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myDefinition.getCreatedAt().getDayOfWeek());
  }
  @Test
  public void all_returnsAllInstancesOfDefinition_true(){
    Definition firstDefinition = new Definition("stupendous");
    Definition secondDefinition = new Definition("itchy");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }
  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("stupendous");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
@Test
public void getId_DefinitionsInstantiatesWithAnId_1(){
  Definition.clear();
  Definition myDefinition = new Definition("stupendous");
  assertEquals(1, myDefinition.getId());
}
@Test
public void find_returnsDefinitionWithSameId_secondDefinition() {
  Definition firstDefinition = new Definition("stupendous");
  Definition secondDefinition = new Definition("itchy");
  assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
}
@Test
 public void find_returnsNullWhenNoDefinitionFound_null() {
   assertTrue(Definition.find(999) == null);
 }

}
