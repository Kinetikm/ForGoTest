package go.test;

import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        long stringCounter = 0;
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        Option filenameOption = new Option("f", "fileForCount", true, "Input file path");
        filenameOption.setRequired(true);
        options.addOption(filenameOption);

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("Import arguments are not given");
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return;
        }

        String filename = cmd.getOptionValue("fileForCount");

        try(BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            while(bf.readLine() != null){
                stringCounter++;
            }
            System.out.println("String number: "+stringCounter);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Internal exception");
        }
    }
}
