/*
 * https://leetcode.com/problems/clone-graph/description/
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> mapOfClonedNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> bfsQueue = new LinkedList<>();
        Node clonedNode = new Node(node.val, new ArrayList<>());
        mapOfClonedNodes.put(node, clonedNode);
        bfsQueue.add(node);
        while(!bfsQueue.isEmpty()) {
            Node currentNode = bfsQueue.poll();
            Node cloneOfCurrentNode = mapOfClonedNodes.get(currentNode);
            for (Node neighbor: currentNode.neighbors) {
                if (!mapOfClonedNodes.containsKey(neighbor)) {
                   Node clonedNeighbor = new Node(neighbor.val, new ArrayList<>());
                    mapOfClonedNodes.put(neighbor, clonedNeighbor);
                    bfsQueue.offer(neighbor);
                }
                cloneOfCurrentNode.neighbors.add(mapOfClonedNodes.get(neighbor));
            }
        }
        return clonedNode;
    }
}
