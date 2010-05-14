/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

/**
 * 1) Server-side socket behaviour definitions:
 * - As a design choice I've kept this simple. By simple I mean the following:
 * - Each instance will attempt to set up a server socket at port 23456.
 * - If port 23456 is taken, the server socket will attempt to open ports counting from 23456
 *   to 23556(23456 + 100) incrementing by 1. By agreeing on this design, a client
 *   can attempt connections in the same way.
 * 
 * 2) Protocol definition(modified to look like a simple FTP):
 * <to be written...>
 */

package DomainLogic;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

import DomainLogic.TreeDataStructure.SimpleTree;

public class SocketHandlingLibrary implements Runnable, FileDomainModel {
    // Port number that the sockets defaults to
    private final int PORT_NR = 23456;

    private boolean connected = false;
    private Socket connectionSocket = null;
    private Socket clientSocket = null;

    /**
     * Constructor, creates a new SocketHandlingLibrary
     */
    public SocketHandlingLibrary() {
        createServerSocket();
    }

    /**
     * Sets up the server functionality.(threaded)
     */
    private void createServerSocket() {
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * Safely handles the open connections. Ideally called before program execution ends.
     */
    public void quit() {
        try {
            if (connectionSocket != null)
                connectionSocket.close();
            if (clientSocket != null)
                clientSocket.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Exception while quitting: " + ioe.getMessage());
        }
    }

    /**
     * Attempts to connect to the specified hostname
     * @param hostname String describing the hostname to connect to. Port will be handled internally
     */
    public void connect(String hostname) {
        int i = 0;
        do {
            try {
                clientSocket = new Socket(hostname, PORT_NR + i);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("Client socket exception: " + ioe.getMessage());
            }
            i++;
        } while(!clientSocket.isConnected() && (i < 100));
        if (clientSocket != null && clientSocket.isConnected()) {
            connected = true;
        }
        else {
            connected = false;
        }
    }

    /**
     * Attempts to disconnect from the host, does nothing when not connected
     */
    public void disconnect() {
        if (clientSocket != null && clientSocket.isConnected()) {
            try {
                clientSocket.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("Disconnect client socket exception: " + ioe.getMessage());
            }
        }
        connected = false;
    }

    /**
     * Returns a boolean indicating a connection status
     * @return a boolean indicating the current connection status
     */
    public boolean isConnected() {
        return connected;
    }

   /**
     * Implemented from FileDomainModel, uses the connection as source
     * @return Returns a TreeSet<String> containing a initial directory setup
     */
    public SimpleTree<FileDirStruct> getInitialDirectories(){
        if (this.isConnected()) {
            
        }
        return null;
    }

    /**
     * Implemented from FileDomainModel, uses the connection as source
     * @param path String containing the wanted path, WARNING: We might be leaking domain knowledge!
     * @return Returns a TreeSet<String> containing a extended directory setup including the path
     */
    public SimpleTree<FileDirStruct> getDirectories(FileDirStruct fileDirStruct) {
        if (this.isConnected()) {

        }
        return null;
    }

    /**
     * Implemented from runnable...
     * Short story: When started the thread will attempt to bind to a socket,
     * details on how this is done can be seen in the definitions(top of this file).
     */
    public void run() {
        int i = 0;
        ServerSocket serverSocket = null;
        do {
            try {
                serverSocket = new ServerSocket(PORT_NR + i);
            }
            catch (IOException ioe) {
                //ioe.printStackTrace();
                //System.out.println("Server socket exception: " + ioe.getMessage());
                System.out.println("Tried bind port: " + (PORT_NR + i));
            }
            i++;
        } while ((serverSocket == null || !serverSocket.isBound()) && (i < 100));
        // Waits for incoming connections, can be running forever when program is used as a client.
        // Consider writing "isClient?" handling to stop this while... Or ?
        System.out.println("ServerSocket i: " + i);
        while (connectionSocket == null || !connectionSocket.isConnected()) {
            try {
                connectionSocket = serverSocket.accept();
            }
            catch (IOException ioe) {
                //ioe.printStackTrace();
                //System.out.println("Server accept exception: " + ioe.getMessage());
                System.out.println("Server could not accept properly!");
            }
        }
    }
}
