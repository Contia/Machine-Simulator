/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinesimulatorapp;

import java.util.ArrayList;
import java.util.Random;
import machinesimulatorapp.internalDevices.CPU;
import machinesimulatorapp.internalDevices.Memory;



/**
 *
 * @author contia
 */
public class Machine {
    private final CPU cpu;
    private final Memory memory;
    
    public Machine(int memoryLimit,int dataLimit){
         
         memory = new Memory(memoryLimit,dataLimit);
         cpu = new CPU(memory.getDataLimit());
    }
    public void startExecution(){
        boolean run=true;
        int counter=0;
        while (!cpu.isFinished(run)){
            System.out.println("Command:" + counter++);
            cpu.setInstructionRegister(memory.getContent(cpu.getProgramCounter()), memory.getContent(cpu.getProgramCounter()+1));
            cpu.increaseProgramCounter();
            run = cpu.run(memory);   
                
            
        }
        
    }
    public void showMemory(){
        memory.show();
    }
    public void fillMemoryRandomly(){
        Random random = new Random();
        for (int i=0;i<memory.getDataLimit()/2;i++){
            int randomEntry = random.nextInt(256);
            String binary = Integer.toBinaryString(randomEntry);
            if (binary.length() <8){
                String zeros = "";
                for (int j=0;j<8-binary.length();j++){
                    zeros += "0";
                    
                }
                binary = zeros.concat(binary);
            }
            memory.addInMemory(i, binary);
            
        }
    }
    public void addCommandsInMemory(ArrayList<String> commands){
       int j=0;
       for (int i=memory.getDataLimit();i<memory.getMemoryLimit();i++){
           if (j < commands.size()){
            memory.addInMemory(i, commands.get(j));
            j++;
           }
       } 
    }
}
