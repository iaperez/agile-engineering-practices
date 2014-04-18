package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/12/14.
 */
public class DbConnection {

    protected int hello;

    DbConnection(){
        hello = 1;
    }

    public DbConnection(int hola){
        hello = hola;
    }

    static int notMovingMethod(int test){
        return 0;
    }

    private DbConnection(double hello){
        this.hello = (int) hello;
    }
}
