package com.algorithms.others;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author smallgod
 */
public class BiggestFilesInDir {

    static List<FileSizes> fileSizes = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File rootFile = new File("/Users/smallgod/Desktop/Biggest_files/");
        readFilesBFS(rootFile);
        //readFilesDFS(rootFile);
    }

    static void readFilesDFS(File file) {

        //skip exceptional files e.g. .DS STORE on mac
        System.out.println("Reading file: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("No file exists with given file name");
            return;
        }

        if (file.isFile()) {
            fileSizes.add(new FileSizes(file.getAbsolutePath(), file.length()));
            return;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File insideFile : files) {
                readFilesDFS(insideFile);
            }
        }
    }

    static Map<String, Long> readFilesBFS(File file) {

        Map<String, Long> fileMap = new TreeMap<>();

        Queue<File> queue = new LinkedList<>();
        queue.add(file);
        
        Set<String> visitedPaths = new HashSet<>();

        while (!queue.isEmpty()) {

            File currFile = queue.poll();
            String path = currFile.getAbsolutePath();
            
            if(visitedPaths.contains(path)){
                continue;
            }
            visitedPaths.add(path);

            if (currFile.isDirectory()) { // add all children
                queue.addAll(Arrays.asList(currFile.listFiles()));
            } else {
                
                if(fileMap.containsKey(currFile.getAbsolutePath())){
                    System.err.println("Danger: " + currFile.getAbsolutePath());
                }
                fileMap.put(currFile.getAbsolutePath(), currFile.length());
            }
        }
        for(Map.Entry<String, Long> entry : fileMap.entrySet()){
            System.out.println(entry.getKey());
        }

        return fileMap;
    }
}

class FileSizes implements Comparator<FileSizes> {

    private long size;
    private String filePath;

    public FileSizes() {
    }

    public FileSizes(String filePath, long size) {
        this.size = size;
        this.filePath = filePath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int compare(FileSizes o1, FileSizes o2) {

        if (this == null || o2 == null) {
            return 3;
        }

        Long x = o1.getSize();
        Long y = o2.getSize();

        return (x.compareTo(y));
    }
}
