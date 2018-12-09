package dataStructures.generalPurpose.trees.binary.segmentTree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SegmentTreeSumTest {

  @Before
  public void setUp() throws Exception {}

  @Test
  public void test() {
     int[] b= {1,3,5,7,9,11};
    SegmentTreeSum sTree= new SegmentTreeSum(b);
    assertEquals(36,sTree.sum(0, 5));
  }
  
  @Test
  public void testSum(){
    int[] b= {1,3,5,7,9,11};
    SegmentTreeSum sTree= new SegmentTreeSum(b);
    assertEquals(8,sTree.sum(1,2));
  }
  
  @Test
  public void testUpdate(){
    int[] b= {1,3,5,7,9,11};    
    SegmentTreeSum sTree= new SegmentTreeSum(b);
    sTree.update(5, 12);    
    assertEquals(37, sTree.sum(0,5));
    sTree.update(2, 0);
    assertEquals(32,sTree.sum(0,5));
  }

}
