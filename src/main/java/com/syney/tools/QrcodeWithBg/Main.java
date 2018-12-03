package com.syney.tools.QrcodeWithBg;

import org.apache.commons.cli.*;

import java.awt.*;
import java.io.IOException;

public class Main {

    private static String url;
    private static String background;
    private static String output;
    private static String quality;

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("u", "url", true, "encode URL to qrcode.");
        options.addOption("b", "background", true, "background of the qrcode.");
        options.addOption("o", "output", true, "output filename and its path for qrcode.");
        options.addOption("q", "quality", true, "quality of the qrcode.");
//        options.addOption("c", "color", true, "dot color.");

//        CommandLine commandLine;
//        try{
//            commandLine = parser.parse(options, args);
//        }catch (ParseException pe) {
//            printHelp(options);
//
//            return;
//        }
//
//        url = commandLine.getOptionValue("u");
//        background = commandLine.getOptionValue("b");
//        output = commandLine.getOptionValue("o");
//        quality = commandLine.getOptionValue("q");

        url = "HON12345678";
        background = "C:\\temps\\qrcode logo\\OBD.png";
        output = "c:\\temps\\qrcodewithbg_for_obd.png";

        try {
            QrcodeWithBg.createQRCode(url, background, output, 'H', new Color(0, 0, 0), null, null, null, true, QrcodeWithBg.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE, QrcodeWithBg.FILL_SHAPE_MODEL_CIRCLE);
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finish building qrcode.");
    }

    private static void printHelp(Options options) {
        System.out.printf("-%s, \t--%s\t\t\t\t: %s\n", options.getOption("u").getOpt(), options.getOption("u").getLongOpt(), options.getOption("u").getDescription());
        System.out.printf("-%s, \t--%s\t\t\t\t: %s\n", options.getOption("b").getOpt(), options.getOption("b").getLongOpt(), options.getOption("b").getDescription());
        System.out.printf("-%s, \t--%s\t\t\t: %s\n", options.getOption("o").getOpt(), options.getOption("o").getLongOpt(), options.getOption("o").getDescription());
        System.out.printf("-%s, \t--%s\t\t: %s\n", options.getOption("q").getOpt(), options.getOption("q").getLongOpt(), options.getOption("q").getDescription());
        System.out.println("Example command:");
        System.out.println("\tjava -jar qrcode-with-bg.jar -u=https://xxxx -b=c:\\aaa.png -o=c:\\bbb.png -q=h");
        System.out.println("Or");
        System.out.println("\tjava -jar qrcode-with-bg.jar -u https://xxxx -b c:\\aaa.png -o c:\\bbb.png -q h");
    }
}
