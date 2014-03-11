package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 3/7/14.
 */
public interface Bestable<anyOtherTypeThatILike> {

    boolean betterThan(anyOtherTypeThatILike challenger) throws Exception;
}
