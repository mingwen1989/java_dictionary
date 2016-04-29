import java.time.LocalDateTime;
import java.util.ArrayList;


public class Definition {
  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
    }

  public String getDescription() {
    return mDescription;
    }
  public boolean isCompleted(){
    return mCompleted;
  }
  public LocalDateTime getCreatedAt(){
    return mCreatedAt;
  }
  public static ArrayList<Definition> all() {
    return instances;
  }

  public static void clear(){
    instances.clear();
  }
  public int getId(){
    return mId;
  }
  public static Definition find(int id) {
  try {
    return instances.get(id - 1);
  } catch (IndexOutOfBoundsException e) {
    return null;
  }
}

}
