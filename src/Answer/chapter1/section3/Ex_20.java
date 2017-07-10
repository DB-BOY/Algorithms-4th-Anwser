package Answer.chapter1.section3;

import Answer.base.Answer0;
import Answer.base.BaseAnswer;
import linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_20 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<5;i++){
            simpleLinked.addFirst(i);
        }
        println(simpleLinked);
        simpleLinked.deleteForIndex(4);
        println(simpleLinked);
        simpleLinked.deleteForIndex(0);
        println(simpleLinked);
        simpleLinked.deleteForIndex(1);
        println(simpleLinked);
        simpleLinked.deleteForIndex(1);
        println(simpleLinked);
        simpleLinked.deleteForIndex(0);
        println(simpleLinked);
    }
}