/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package DomainLogic.TreeDataStructure;

import java.util.List;
import java.util.LinkedList;

public class Node<T> {
    private List<Node<T>> children = null;
    private T data;

    public Node(T data) {
        // Using LinkedList here, this may be slow...
        children = new LinkedList<Node<T>>();
        this.data = data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public boolean hasChildren() {
        if (children.size() > 0) {
            return true;
        }
        return false;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
