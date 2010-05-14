/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

package DomainLogic;

public class FileDirStruct {
    private String name;
    private String absolutePathname;
    private boolean isDirectory;

    public FileDirStruct(String name, String absolutePathname, boolean isDirectory) {
        this.name = name;
        this.absolutePathname = absolutePathname;
        this.isDirectory = isDirectory;
    }

    public String getName() {
        return name;
    }

    public String getAbsolutePathname() {
        return absolutePathname;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof FileDirStruct) {
            FileDirStruct fds = (FileDirStruct) anObject;
            if (name.equals(fds.getName()) && absolutePathname.equals(fds.getAbsolutePathname())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
