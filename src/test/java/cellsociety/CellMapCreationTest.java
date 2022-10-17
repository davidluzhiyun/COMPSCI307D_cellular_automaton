package cellsociety;

import static cellsociety.CellMapCreator.CreateMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellMapCreationTest {

  @Test
  void CellMapCreationNumberOfCellsTest(){
    List<Cell> cellList = new List<Cell>() {
      @Override
      public int size() {
        return 0;
      }

      @Override
      public boolean isEmpty() {
        return false;
      }

      @Override
      public boolean contains(Object o) {
        return false;
      }

      @Override
      public Iterator<Cell> iterator() {
        return null;
      }

      @Override
      public Object[] toArray() {
        return new Object[0];
      }

      @Override
      public <T> T[] toArray(T[] a) {
        return null;
      }

      @Override
      public boolean add(Cell cell) {
        return false;
      }

      @Override
      public boolean remove(Object o) {
        return false;
      }

      @Override
      public boolean containsAll(Collection<?> c) {
        return false;
      }

      @Override
      public boolean addAll(Collection<? extends Cell> c) {
        return false;
      }

      @Override
      public boolean addAll(int index, Collection<? extends Cell> c) {
        return false;
      }

      @Override
      public boolean removeAll(Collection<?> c) {
        return false;
      }

      @Override
      public boolean retainAll(Collection<?> c) {
        return false;
      }

      @Override
      public void clear() {

      }

      @Override
      public Cell get(int index) {
        return null;
      }

      @Override
      public Cell set(int index, Cell element) {
        return null;
      }

      @Override
      public void add(int index, Cell element) {

      }

      @Override
      public Cell remove(int index) {
        return null;
      }

      @Override
      public int indexOf(Object o) {
        return 0;
      }

      @Override
      public int lastIndexOf(Object o) {
        return 0;
      }

      @Override
      public ListIterator<Cell> listIterator() {
        return null;
      }

      @Override
      public ListIterator<Cell> listIterator(int index) {
        return null;
      }

      @Override
      public List<Cell> subList(int fromIndex, int toIndex) {
        return null;
      }
    };
    for(int i = 0; i<10; i++){
      for(int j = 0; j<10; j++){
        Cell newCell = new Cell(i, j);
        cellList.add(newCell);
      }
    }
    HashMap<Cell, Integer> testMap = CreateMap(cellList);
    for(Cell c : cellList){
      assertEquals(1, testMap.get(c));
    }
  }


}
