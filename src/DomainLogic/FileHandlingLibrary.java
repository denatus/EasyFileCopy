/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package DomainLogic;

import java.io.File;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import DomainLogic.TreeDataStructure.SimpleTree;
import DomainLogic.TreeDataStructure.Node;

public class FileHandlingLibrary implements FileDomainModel {

    private SimpleTree<FileDirStruct> currentFileTree = null;

    /**
     * Implemented from FileDomainModel, uses the local directories as source
     * @return Returns a SimpleFileTree<FileDirStruct> containing a initial directory setup
     */
    public SimpleTree<FileDirStruct> getInitialDirectories() {
        Node<FileDirStruct> initialRootNode = new Node<FileDirStruct>(new FileDirStruct("temp", "temp", true));
        SimpleTree<FileDirStruct> initialDirectories = new SimpleTree<FileDirStruct>(initialRootNode);
        File[] children = File.listRoots();
        for (File root : children) {
            FileDirStruct fds = new FileDirStruct(root.getName(), root.getAbsolutePath(), root.isDirectory());
            initialRootNode.addChild(new Node<FileDirStruct>(fds));
        }
        currentFileTree = initialDirectories;
        return initialDirectories;
    }

    /**
     * Implemented from FileDomainModel, uses the local directories as source
     * @param path String containing the wanted path, WARNING: We might be leaking domain knowledge!
     * @return Returns a SimpleFileTree<FileDirStruct> containing a extended directory setup including the path
     */
    public SimpleTree<FileDirStruct> getDirectories(FileDirStruct fileDirStruct) {
        throw new NotImplementedException();
    }
}
