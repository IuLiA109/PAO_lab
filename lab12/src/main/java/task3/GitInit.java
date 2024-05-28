package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GitInit {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java GitInit <path>");
            System.exit(1);
        }

        String path = args[0];
        File gitDir = new File(path, ".git");

        try {
            createGitStructure(gitDir);
            System.out.println("Initialized empty Git repository in " + gitDir.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error initializing Git repository: " + e.getMessage());
        }
    }

    private static void createGitStructure(File git) throws IOException {
        if (!git.exists() && !git.mkdirs()) {
            throw new IOException("Failed to create directory: " + git);
        }

        File objects = new File(git, "objects");
        File refs = new File(git, "refs");

        if (!objects.exists() && !objects.mkdirs()) {
            throw new IOException("Failed to create directory: " + objects);
        }

        if (!refs.exists() && !refs.mkdirs()) {
            throw new IOException("Failed to create directory: " + refs);
        }

        File headFile = new File(git, "HEAD");
        try (FileWriter writer = new FileWriter(headFile)) {
            writer.write("ref: refs/heads/main\n");
        }
    }
}
