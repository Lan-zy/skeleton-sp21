package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> test = new BuggyAList<>();
        for(int i=0;i<3;i++){
            correct.addLast(i);
            test.addLast(i);
        }
        for(int i=0;i<3;i++){
            assertEquals(correct.removeLast(),test.removeLast());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Test = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Test.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = Test.size();
                assertEquals(size1,size2);
            }else if (operationNumber == 2) {
                //getLast
                if(L.size()!=0){
                    int last1 = L.getLast();
                    int last2 = Test.getLast();
                    assertEquals(last1,last2);
                }
            }else if (operationNumber == 3) {
                //removeLast
                if(L.size()!=0){
                    int last1 = L.removeLast();
                    int last2 = Test.removeLast();
                    assertEquals(last1,last2);
                }
            }
        }
    }
}
