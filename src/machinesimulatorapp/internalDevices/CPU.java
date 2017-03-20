/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinesimulatorapp.internalDevices;

import utilities.Converter;

/**
 *
 * @author contia
 */
public class CPU {
    private int pc; //program counter
    private String ir; // instruction register
    private String[] registers;
    public CPU(int pc){
        registers = new String[16];
        this.pc=pc; //indicates the first position in memory
        ir = ""; //there is no command yet
    }
    public void increaseProgramCounter(){
        pc+=2;
    }
    public void setInstructionRegister(String cell1, String cell2){
        Converter converter = Converter.getInstance();
        ir = converter.binaryToHex(cell1+cell2);
    }
    public String getInstructionRegister(){
        return ir;
    }
    public int getProgramCounter(){
        return pc;
    }
    public boolean isFinished(boolean run){
        return !run;
    }
    public boolean run(Memory memory){
        Converter converter = Converter.getInstance();
        int indexRegister, indexRegister2,indexRegister3;
        int adressInMemory;
        switch(ir.charAt(0)){
           case '1': 
               indexRegister = converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               adressInMemory = converter.HexToDecimal(String.valueOf(ir.charAt(2))+String.valueOf(ir.charAt(3)));
               registers[indexRegister] = memory.getContent(adressInMemory);
               System.out.println("Load bits from Memory address: " +String.valueOf(ir.charAt(2))+String.valueOf(ir.charAt(3)));
               System.out.println("to the register " + indexRegister);
               break;
           case '2':
               indexRegister = converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               String content = converter.HexToBinary(String.valueOf(ir.charAt(2))+String.valueOf(ir.charAt(3)));
               System.out.println("Load the bits: " + content + " to register " + indexRegister );
               registers[indexRegister] = content;
               break;
           case '3':
               indexRegister = converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               adressInMemory = converter.HexToDecimal(String.valueOf(ir.charAt(2))+String.valueOf(ir.charAt(3)));
               memory.addInMemory(adressInMemory, registers[indexRegister]);
               System.out.println("Store the bits located in register " + indexRegister  + " to the " + String.valueOf(ir.charAt(2))+String.valueOf(ir.charAt(3)));
               System.out.println(" memory adress");
               break;
           case '4':
               indexRegister = converter.HexToDecimal(String.valueOf(ir.charAt(2)));
               indexRegister2 = converter.HexToDecimal(String.valueOf(ir.charAt(3)));
               System.out.println("Move the bits from register " + indexRegister + " to " + indexRegister2);
               registers[indexRegister2] = registers[indexRegister];
               break;
           case '5':
               indexRegister =  converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               indexRegister2 = converter.HexToDecimal(String.valueOf(ir.charAt(2)));
               indexRegister3 = converter.HexToDecimal(String.valueOf(ir.charAt(3)));
               System.out.println("Operation + in registers " + indexRegister2 + " " + indexRegister3);
               System.out.println("Store the result to " + indexRegister);
               registers[indexRegister] = converter.DecimalToBinary(converter.BinaryToDecimal(registers[indexRegister2]) + 
                                                                    converter.BinaryToDecimal(registers[indexRegister3]));
               break;
           case '6':
               System.out.println("Function code is not supported");
               break;
           case '7':
               indexRegister =  converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               indexRegister2 = converter.HexToDecimal(String.valueOf(ir.charAt(2)));
               indexRegister3 = converter.HexToDecimal(String.valueOf(ir.charAt(3)));   
               System.out.println("Operation Or in registers " + indexRegister2 + " " + indexRegister3);
               registers[indexRegister] = converter.DecimalToBinary(converter.BinaryToDecimal(registers[indexRegister2]) | 
                                                                    converter.BinaryToDecimal(registers[indexRegister3]));
               break;
           case '8':
               indexRegister =  converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               indexRegister2 = converter.HexToDecimal(String.valueOf(ir.charAt(2)));
               indexRegister3 = converter.HexToDecimal(String.valueOf(ir.charAt(3)));   
               System.out.println("Operation And in registers " + indexRegister2 + " " + indexRegister3);
               registers[indexRegister] = converter.DecimalToBinary(converter.BinaryToDecimal(registers[indexRegister2]) & 
                                                                    converter.BinaryToDecimal(registers[indexRegister3]));
               break; 
           case '9':
               indexRegister =  converter.HexToDecimal(String.valueOf(ir.charAt(1)));
               indexRegister2 = converter.HexToDecimal(String.valueOf(ir.charAt(2)));
               indexRegister3 = converter.HexToDecimal(String.valueOf(ir.charAt(3)));   
               System.out.println("Operation Xor in registers " + indexRegister2 + " " + indexRegister3);
               registers[indexRegister] = converter.DecimalToBinary(converter.BinaryToDecimal(registers[indexRegister2]) ^ 
                                                                    converter.BinaryToDecimal(registers[indexRegister3]));
               break;    
               
           case 'C':
               System.out.println("The program has been finished.");
               return false;
           default:
               System.out.println("Function is not supported");
        }

        if (memory.getContent(pc+1) == null) return false;
        return true;
    }

}
