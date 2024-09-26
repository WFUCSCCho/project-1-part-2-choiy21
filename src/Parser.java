import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    // Create a BST tree of Wine class type
    private BST<Wine> mybst = new BST<>();
    private List<String> results = new ArrayList<>();  // Store the results for writing to file later

    public Parser(String csvFilePath, String commandFilePath) throws FileNotFoundException {
        loadCSV(new File(csvFilePath));  // Load the CSV file into the BST
        process(new File(commandFilePath));  // Process input.txt file commands
        writeToFile("./result.txt");  // Write all results to the output file at once
    }

    // Load CSV data and populate the BST with Wine objects
    public void loadCSV(File csvFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(csvFile);
        scanner.nextLine(); // Skip the header

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length >= 11) {
                try {
                    String title = data[0].replace("\"", "").trim();
                    double price = Double.parseDouble(data[1].replace("£", "").replace(" per bottle", "").trim());
                    String capacity = data[2].trim();
                    String grape = data[3].trim();
                    String closure = data[4].trim();
                    String country = data[5].trim();
                    String characteristics = data[6].trim();
                    String type = data[7].trim();
                    String abv = data[8].trim();
                    String region = data[9].trim();
                    String style = data[10].trim();
                    String vintage = (data.length > 11) ? data[11].trim() : "NV";

                    Wine wine = new Wine(title, price, capacity, grape, closure, country, characteristics, type, abv, region, style, vintage);
                    mybst.insert(wine);  // Insert wine into the BST
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line);
                }
            }
        }

        scanner.close();
    }

    // Process input commands from input.txt
    public void process(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] command = line.split("\\s+");  // Split command into words
                operate_BST(command);  // Operate on the BST based on the command
            }
        }

        scanner.close();
    }

    // Execute the command based on the input
    // Execute the command based on the input
    public void operate_BST(String[] command) {
        if (command.length == 2) {
            switch (command[0].toLowerCase()) {
                case "search" -> search(command[1]);
                case "remove" -> remove(command[1]);
                default -> results.add("Invalid Command: " + command[0]);
            }
        } else if (command.length == 1 && command[0].equalsIgnoreCase("print")) {
            // Only call printBST if the command is 'print'
            printBST();
        } else {
            results.add("Invalid Command: " + String.join(" ", command));
        }
    }


    // Search for wines based on a single attribute (vintage, region, etc.)
    public void search(String value) {
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for (Wine wine : mybst) {
            if (wine.getVintage().equalsIgnoreCase(value) || wine.getRegion().equalsIgnoreCase(value) || wine.getCountry().equalsIgnoreCase(value)) {
                result.append(wine).append("\n");
                found = true;
            }
        }
        if (found) {
            results.add("Found: " + result.toString().trim());
        } else {
            results.add("No matching wines found for: " + value);
        }
    }

    // Remove wines based on a single attribute (region, vintage, etc.)
    // Remove wines based on the region attribute
    public void remove(String region) {
        List<Wine> toRemove = new ArrayList<>();
        for (Wine wine : mybst) {
            if (wine.getRegion().equalsIgnoreCase(region)) {
                toRemove.add(wine);
            }
        }
        for (Wine wine : toRemove) {
            mybst.remove(wine);
            results.add("removed " + wine);
        }
        if (toRemove.isEmpty()) {
            results.add("No wines removed for region: " + region);
        }
    }


    // Print the entire BST in in-order traversal (sorted by default)
    public void printBST() {
        StringBuilder result = new StringBuilder();
        for (Wine wine : mybst) {
            result.append(wine).append("\n");
        }
        results.add(result.toString().trim());
    }

    // Helper method to write all results to a file at once
    public void writeToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String result : results) {
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
