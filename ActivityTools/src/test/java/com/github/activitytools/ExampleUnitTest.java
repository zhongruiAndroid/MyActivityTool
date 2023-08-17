package com.github.activitytools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void sfd() {
        int a=0;
        boolean flag=true;
        while (flag){
            if(a>=10){
                flag=false;
                System.out.println(a);
            }else{
                System.out.println(a);
            }
            a++;
        }

    }
}