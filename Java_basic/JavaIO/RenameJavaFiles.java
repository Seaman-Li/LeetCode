package Java_basic.JavaIO;

import java.io.*;

public class RenameJavaFiles {
    public static void main(String[] args) {
        File rootDir = new File("D:\\Learning\\LeetCode");
        renameFilesInDir(rootDir);
    }

    public static void renameFilesInDir(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                if (file.getName().equals(".git") || file.getName().equals(".idea") ) {
                    continue; // Skip these directories
                }
                renameFilesInDir(file);
            } else if (file.isFile() && file.getName().matches("LC\\d{3}_.+\\.java")) {
                renameAndModifyClass(file);
            }
        }
    }

    public static void renameAndModifyClass(File file) {
        String oldName = file.getName();
        String newName = oldName.replaceFirst("LC(\\d{3})_", "LC0$1_");

        if (!oldName.equals(newName)) {
            File newFile = new File(file.getParent(), newName);

            // Rename the file
            if (file.renameTo(newFile)) {
                System.out.println("Renamed: " + oldName + " -> " + newName);

                // Update the class name inside the file
                updateClassName(newFile, oldName.replace(".java", ""), newName.replace(".java", ""));
            } else {
                System.err.println("Failed to rename: " + oldName);
            }
        }
    }

    public static void updateClassName(File file, String oldClassName, String newClassName) {
        try {
            File tempFile = new File(file.getParent(), file.getName() + ".tmp");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Replace only if the line contains the old class declaration
                writer.write(line.replaceFirst("\\bpublic\\s+class\\s+" + oldClassName + "\\b", "public class " + newClassName));
                writer.newLine();
            }

            reader.close();
            writer.close();

            // Replace old file with modified file
            if (file.delete()) {
                tempFile.renameTo(file);
            } else {
                System.err.println("Failed to update class name in: " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
