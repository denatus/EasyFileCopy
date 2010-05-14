/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package DomainLogic;

import DomainLogic.TreeDataStructure.SimpleTree;

public interface FileDomainModel {
    /**
     * Should be implemented such that it is platform independant
     * @return Returns a SimpleTree<FileDirStruct> containing an initial directory setup
     */
    public SimpleTree<FileDirStruct> getInitialDirectories();

    /**
     * Should be implemented such that it is platform independant
     * @param fileDirStruct The directory that wants expanding. WARNING: We might be leaking domain knowledge!
     * @return Returns a SimpleTree<FileDirStruct> containing a extended directory setup including the path
     */
    public SimpleTree<FileDirStruct> getDirectories(FileDirStruct fileDirStruct);
}
