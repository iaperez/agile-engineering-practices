

package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Job of Node: Understands its neighbors
 * Created by jhess on 11.04.14.
 */
public class Node {

    private List<Node> neighbors;

    public Node() {
        neighbors = new ArrayList<Node>();
    }

    public void connect(Node nodeB) {
        neighbors.add(nodeB);
    }

    public boolean canReach(Node node) {
        return canReach(node, new HashSet<Node>());

    }

    private boolean canReach(Node node, Set<Node> visitedNodes) {
        if (this == node) return true;
        if (!visitedNodes.add(this)) return false;
        for (Node neighbor : neighbors) {
            if (neighbor.canReach(node, visitedNodes)) return true;
        }
        return false;
    }


}