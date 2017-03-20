/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinesimulatorapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author contia
 */
public class MachineSimulatorApp {
    
    private static Machine myMachine;
    private static Parser parser = Parser.getInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        myMachine = new Machine(256,100);
        
        if (args.length == 0){
            while (menu() != -1);               
        }else{
            
        }
    }
    
    private static int menu(){
        System.out.println("Which choice??");
        System.out.println("a) Insert a chunk of code");
        System.out.println("b) Show memory");
        System.out.println("c) Fill memory randomly");
        System.out.println("d) Start execution");
        System.out.println("e) Exit");
        String choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();
        switch(choice){
            case "a":{
                
                String command;
                while (!( command = sc.nextLine()).isEmpty()){
                    
                    if (command.length() != 4){
                        System.out.println("The command has four symbols - Try again");
                    }else {
                        parser.addCommand(command);
                        
                    }
                }
                ArrayList<String> binaryCommands = parser.parsing();
                myMachine.addCommandsInMemory(binaryCommands);
                break;
            }
            case "b":{
                myMachine.showMemory();
                break;
            }
            case "c":{
                myMachine.fillMemoryRandomly();
                break;
            }
            case "d":{
                myMachine.startExecution();
                break;
            }
            case "e":{
                return -1;
            }
        }
        return 1;
    }
    
}
