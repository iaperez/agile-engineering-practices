package edu.berkeley.ischool.aep;

import org.junit.Test;

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
        h.connect(b);
        b.connect(a);
        b.connect(c);
        a.connect(f);
        c.connect(d);
        c.connect(e);
        c.connect(e);
        d.connect(e);
        e.connect(b);

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

        nodeH.connect(nodeB);
        nodeB.connect(nodeF);
        nodeB.connect(nodeC);

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

}