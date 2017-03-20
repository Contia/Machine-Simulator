/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinesimulatorapp;

import java.util.ArrayList;
import utilities.Converter;

/**
 *
 * @author contia
 */
public class Parser {
   private static Parser instance = null;
   private static ArrayList<String> commands;
   
   protected Parser() {
      // Exists only to defeat instantiation.
   }
   public static Parser getInstance() {
      if(instance == null) {
         commands = new ArrayList<>(); 
         instance = new Parser();
      }
      return instance;
   }    
   public void addCommand(String command){
       commands.add(command);
   }
   public ArrayList<String> parsing(){
       ArrayList<String> binaryCommands = new ArrayList<>(); 
       Converter converter = Converter.getInstance();
       for (String command: commands){
           String binaryCommand = converter.HexToBinary(command);
           binaryCommands.add(binaryCommand.substring(0, binaryCommand.length()/2));
           binaryCommands.add(binaryCommand.substring(binaryCommand.length()/2,binaryCommand.length()));
       }
       return binaryCommands;
   }
}
