package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class NodeTest {
    Node a = new Node();
    Node b = new Node();
    Node c = new Node();
    Node d = new Node();
    Node e = new Node();
    Node f = new Node();
    Node g = new Node();
    Node h = new Node();

    public NodeTest() {
        h.connect(new Link(b, 0));
        b.connect(new Link(a, 0));
        b.connect(new Link(c, 0));
        a.connect(new Link(f, 0));
        c.connect(new Link(d, 0));
        c.connect(new Link(e, 0));
        c.connect(new Link(e, 0));
        d.connect(new Link(e, 0));
        e.connect(new Link(b, 0));

    }

    @Test
    public void shouldReturnZeroNeighbors() {
        Node node = new Node();
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeAShouldBeConnectedToNodeB() {

        assertTrue(b.canReach(a));
        assertFalse(a.canReach(c));
    }


    @Test
    public void nodeHShouldReachC() {
        Node nodeH = new Node();
        Node nodeB = new Node();
        Node nodeC = new Node();

        Node nodeF = new Node();

        nodeH.connect(new Link(nodeB,0));
        nodeB.connect(new Link(nodeF,0));
        nodeB.connect(new Link(nodeC,0));

        assertTrue(nodeB.canReach(nodeC));
    }


    @Test
    public void nodeShouldBeAbleToReachFurthestNode(){
        assertTrue(h.canReach(e));
        assertTrue(c.canReach(f));

    }

    @Test
    public void nodeShouldNotBeAbleToReachFurthestNode(){
        assertFalse(h.canReach(g));
    }

    @Test
    public void hToCShouldBeTwoHops()  {
        assertEquals(2, h.hopsTo(c));
        assertEquals(3, b.hopsTo(e));
        assertEquals(3, h.hopsTo(d));
        assertEquals(0, h.hopsTo(h));

    }

    @Test(expected=RuntimeException.class)
    public void hIsUnreachable() {
        assertEquals(0 , h.hopsTo(g));
    }

    @Test
    public void hToCShouldBeTwoHopsCounting() {
        assertEquals(2, h.countingHops(c));
        assertEquals(3, b.countingHops(e));
        assertEquals(3, h.countingHops(d));
        assertEquals(0, h.countingHops(h));

    }

    @Test(expected=UnreachableException.class)
    public void hIsUnreachableByCounting(){
        assertEquals(0 , h.countingHops(g));
    }


    @Test
    public void minHops(){

        assertEquals(2, b.minHops(e));
        assertEquals(1, c.minHops(e));
    }


}