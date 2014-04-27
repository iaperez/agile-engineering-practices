

package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {

    private List<Link> neighbors;
    private static int NO_PATH = Integer.MAX_VALUE;


    public Node() {
        neighbors = new ArrayList<Link>();
    }

    public void connect(Link to) {
        neighbors.add(to);
    }

    public boolean canReach(Node node) {
        return canReach(node, new HashSet<Node>());

    }

    protected boolean canReach(Node node, Set<Node> visitedNodes) {
        if (this == node) return true;
        if (!visitedNodes.add(this)) return false;
        for (Link neighbor : neighbors) {
            if (neighbor.canReach(node, visitedNodes)) return true;
            visitedNodes.remove(neighbor.getNode());
        }
        return false;
    }

    public int hopsTo(Node node) {
        Set visitedNodes = new HashSet<Node>();
        if (canReach(node, visitedNodes))
            return visitedNodes.size();
        throw new UnreachableException();
    }

    public int countingHops(Node node) {
        int hops = hopsTo(node, new HashSet<Node>());
        if (hops == NO_PATH) throw new UnreachableException();
        return hops;
    }

    protected int hopsTo(Node node, Set<Node> visited) {
        if (!visited.add(this)) return NO_PATH;
        if (node.equals(this)) return 0;
        for (Link child : neighbors) {
            int childHops = child.hopsTo(node, visited);
            if (childHops != NO_PATH) {
                return 1 + childHops;
            }

        }
        return NO_PATH;
    }

    public int minHops(Node node) {
        int hops = minHops(node, new HashSet<Node>());
        return hops;
    }

    public int minHops(Node node, Set<Node> visited) {
        if (!visited.add(this)) return NO_PATH;
        if (node.equals(this)) return 0;
        int minimum = NO_PATH;
        for (Link child : neighbors) {
            int possibleCost = child.minHops(node, visited);
            if (minimum > possibleCost) minimum = 1+possibleCost;
            else visited.remove(child.getNode());
        }
        return minimum;

    }



}