import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class FileFinder {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the folder path: ");
            String folderPath = scanner.nextLine();

            if (folderPath.isEmpty() || !Files.exists(Paths.get(folderPath))) {
                System.out.println("Invalid folder path.");
                return;
            }

            System.out.print("Enter search words (comma separated): ");
            String input = scanner.nextLine();
            String[] searchWords = input.split(",");

            if (searchWords.length == 0) {
                System.out.println("At least one search word must be provided.");
                return;
            }

            Set<String> searchWordSet = Arrays.stream(searchWords)
                    .map(String::trim)
                    .collect(Collectors.toSet());

            List<Path> files = Files.list(Paths.get(folderPath)).collect(Collectors.toList());

            ExecutorService executor = Executors.newFixedThreadPool(searchWordSet.size());

            for (String searchWord : searchWordSet) {
                executor.submit(() -> {
                    String folderName = "MatchedFiles_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + searchWord;
                    Path newFolderPath = Paths.get(folderPath, folderName);
                    try {
                        Files.createDirectory(newFolderPath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    int matchedFileCount = 0;

                    for (Path file : files) {
                        try (BufferedReader reader = Files.newBufferedReader(file)) {
                            String line;
                            boolean fileContainsSearchWord = false;

                            while ((line = reader.readLine()) != null) {
                                if (line.toUpperCase().contains(searchWord.toUpperCase().trim())) {
                                    fileContainsSearchWord = true;
                                    break;
                                }
                            }

                            if (fileContainsSearchWord) {
                                Path destinationPath = newFolderPath.resolve(file.getFileName());
                                Files.copy(file, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                matchedFileCount++;
                            }
                        } catch (Exception ex) {
                            System.out.println("Error reading file " + file + ": " + ex.getMessage());
                        }
                    }

                    if (matchedFileCount > 0) {
                        System.out.println(matchedFileCount + " file(s) containing the word \"" + searchWord + "\" have been copied to: " + newFolderPath);
                    } else {
                        System.out.println("No files containing the word \"" + searchWord + "\" were found.");
                        try {
                            Files.delete(newFolderPath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}
