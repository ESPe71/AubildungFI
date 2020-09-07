package de.penetti.ausbildung.fachinformatiker.sortieren;

public class BubbleSort {
  public static int[] sort(int...toSort) {

    for(int i = 1; i <= toSort.length; i++) {
      for(int j = toSort.length - 1; j >= i; j--) {
        if(toSort[j - 1] > toSort[j]) {
          int tmp = toSort[j - 1];
          toSort[j -1] = toSort[j];
          toSort[j] = tmp;
        }
      }
    }
    return toSort;
  }

  public static int[] sort2(int...toSort) {

    for(int i = 1, wurdeGetauscht = 1;
        i <= toSort.length && wurdeGetauscht == 1;
        i++) {
      wurdeGetauscht = 0;
      for(int j = toSort.length - 1; j >= i; j--) {
        if(toSort[j - 1] > toSort[j]) {
          int tmp = toSort[j - 1];
          toSort[j -1] = toSort[j];
          toSort[j] = tmp;
          wurdeGetauscht = 1;
        }
      }
    }
    return toSort;
  }
}
