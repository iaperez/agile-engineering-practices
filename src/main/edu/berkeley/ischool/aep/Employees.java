package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ignacio on 3/21/14.
 *
 */
public class Employees {

    //using composition is better, naive solution: extends arraylist
    //private ArrayList group = new ArrayList();
    // this is java more generic
    //rules expose as little as possible
    private Collection<Employee> group = new ArrayList<Employee>();
    public void add(Employee employee) {group.add(employee);}
    public void remove(Employee employee) {group.remove(employee);}


}
