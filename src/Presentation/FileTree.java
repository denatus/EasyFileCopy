/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package Presentation;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import DomainLogic.*;
import DomainLogic.TreeDataStructure.*;

public class FileTree extends JTree implements TreeSelectionListener {

    private FileDomainModel fileDomainModel = null;
    private DefaultMutableTreeNode top = new DefaultMutableTreeNode();

    public FileTree(FileDomainModel fileDomainModel) {
        super();
        this.fileDomainModel = fileDomainModel;
        this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("TEST TOP NODE");
        initializeFromModel(top);
        addTreeSelectionListener(this);
        
    }

    /**
     * Initial directory structure, aux for recursiveTreeLoop
     */
    private void initializeFromModel(DefaultMutableTreeNode top) {
        SimpleTree<FileDirStruct> initDirs = fileDomainModel.getInitialDirectories();
        if (initDirs != null) // TEMPORARY CODE CHECK, THIS SHOULD NOT HAPPEN!
            recursiveTreeLoop(initDirs.getRootNode(), top);
    }

    /**
     * Recursively loops through the tree structure
     * @param fileDirNode
     * @param treeNode
     */
    private void recursiveTreeLoop(Node<FileDirStruct> fileDirNode, DefaultMutableTreeNode treeNode) {
        System.out.println("recursive 1...");
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(fileDirNode.getData().getName());
        treeNode.add(newNode);
        for (int i = 0; i < fileDirNode.getChildren().size(); i++) {
            recursiveTreeLoop(fileDirNode.getChildren().get(i), newNode);
        }
    }

    /**
     * Handles selections in the treeviews
     * @param e TreeSelectionEvent
     */
    public void valueChanged(TreeSelectionEvent e) {

    }
}
