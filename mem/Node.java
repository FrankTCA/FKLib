public class Node {
  private Object[] valuesArray;
  private int[][] pointsArray;
  private int len;

  public Node() {
    len = 0;
    pointsArray = new int[2][len];
    valuesArray = new Object[len];
  }

  public void addValue(Object value) {
    len++;
    pointsArray1 = new int[2][len + 1];
    for (int i = 0; i < pointsArray.length; i++) {
      pointsArray1[i] = pointsArray[i];
    }
    pointsArray1[len] = {len, len + 1};
    pointsArray = pointsArray1;
    valuesArray1 = new Object[len + 1];
    for (int i = 0; i < valuesArray.length; i++) {
      valuesArray1[i] = valuesArray[i];
    }
    valuesArray1[len] = value;
    valuesArray = valuesArray1;
  }

  public void addValueAfter(int location, Object value) {
    len++;
    pointsArray1 = new int[2][len+1];
    int after = 0;
    for (int i = 0; i < pointsArray.length; i++) {
      if (pointsArray[i][1] == location) {
        pointsArray1[i] = pointsArray[i];
        i++;
        pointsArray1[i] = {pointsArray[i][0], len};
        after = pointsArray[i][1];
        i++;
      }
      pointsArray1[i] = pointsArray[i];
    }
    pointsArray1[len] = {location + 1, len};
    pointsArray = pointsArray1;
    valuesArray1 = new Object[len + 1];
    for (int i = 0; i < valuesArray.length; i++) {
      valuesArray1[i] = valuesArray[i];
    }
    valuesArray1[len] = value;
    valuesArray = valuesArray1;
  }

  public Object get(int index) {
    int next = 0;
    int num = 0;
    while (index > 0) {
      index--;
      num = pointsArray[next][0];
      next = pointsArray[next][1];
    }
    return valuesArray[num];
  }

  public int getLength() {
    return len;
  }
}
