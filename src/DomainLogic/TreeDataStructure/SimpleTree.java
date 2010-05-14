/**
 * 
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package DomainLogic.TreeDataStructure;

public class SimpleTree<T> {
    private Node<T> rootNode = null;

    /**
     * Returns a SimpleTree with a default initiated Node<T>
     */
    public SimpleTree() {
        this.rootNode = new Node<T>(null);
    }

    /**
     * Creates an instance of SimpleTree with rootNode as the root node
     * @param rootNode Node<T> rootNode for the SimpleTree
     */
    public SimpleTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Returns the root node for this SimpleTree
     * @return Returns the root node for this SimpleTree
     */
    public Node<T> getRootNode() {
        return rootNode;
    }

    /**
     * Sets the root node for this SimpleTree
     * @param rootNode The Node that will be set as the root node
     */
    public void setRootNode(Node<T> rootNode) {
        this.rootNode = rootNode;
    }
}
