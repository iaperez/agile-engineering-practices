package edu.berkeley.ischool.aep;

import java.util.Set;

/**
 * Created by Ignacio on 4/25/14.
 */
public class Link {
    Node to;
    int cost;
    public Link(Node b, int cost){
        this.to = b;
        this.cost = cost;
    }

    public boolean canReach(Node node, Set<Node> visited) {

        return to.canReach(node, visited);
    }

    public int hopsTo(Node node, Set<Node> visited) {

        return to.hopsTo(node, visited);
    }

    public int minHops(Node node, Set<Node> visited) {
        return to.minHops(node,visited);
    }

    public Node getNode()
    {
        return to;
    }
}
