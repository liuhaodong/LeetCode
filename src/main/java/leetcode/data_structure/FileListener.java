package leetcode.data_structure;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by haodongl on 1/31/16.
 */
public class FileListener {
    public static void main(String[] args){
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("start listener!!");
                    WatchService watcher = FileSystems.getDefault().newWatchService();
                    java.nio.file.Path dir = Paths.get("/Users/haodongl/Documents/workspace/mbrcoder-r1/src/main/resources");
                    dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
                    while (true) {
                        WatchKey key;
                        try {
                            // wait for a key to be available
                            key = watcher.take();
                        } catch (InterruptedException ex) {
                            return;
                        }

                        for (WatchEvent<?> event : key.pollEvents()) {
                            // get event type
                            WatchEvent.Kind<?> kind = event.kind();

                            // get file name
                            @SuppressWarnings("unchecked")
                            WatchEvent<Path> ev = (WatchEvent<Path>) event;
                            Path fileName = ev.context();

                            System.out.println(kind.name() + ": " + fileName);

                            if (kind == StandardWatchEventKinds.OVERFLOW) {
                                continue;
                            } else if (kind == StandardWatchEventKinds.ENTRY_CREATE) {

                                // process create event

                            } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {

                                // process delete event

                            } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

                                // process modify event

                            }
                        }

                        // IMPORTANT: The key must be reset after processed
                        boolean valid = key.reset();
                        if (!valid) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
