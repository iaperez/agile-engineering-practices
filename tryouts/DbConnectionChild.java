package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/12/14.
 */
public class DbConnectionChild  extends DbConnection{
    int HiThere;

    public DbConnectionChild (){
        DbConnection t= new DbConnection(1);
        HiThere = 1;
        this.hello = 0;
    }

    static int notMovingMethod(int test){
        return 1;
    }
}
