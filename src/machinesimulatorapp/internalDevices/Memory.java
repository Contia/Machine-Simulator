/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinesimulatorapp.internalDevices;

import java.util.Random;

/**
 *
 * @author contia
 */
public class Memory {
    private final String[] cells;
    private final int memoryLimit;
    private final int dataLimit;
    private final int codeLimit;
    
    public Memory(int memoryLimit, int dataLimit){
        this.memoryLimit = memoryLimit;
        cells = new String[memoryLimit];
        this.dataLimit = dataLimit;
        codeLimit = this.memoryLimit - this.dataLimit;
    }
    public void show(){
        System.out.println("------------------------------------------------ Data");
        for (int i=0;i<cells.length;i++){
            String memoryElement = cells[i];
            if ( cells[i] == null) memoryElement = "--";
            if (i==dataLimit) 
                System.out.println("------------------------------------------------ Code");
            System.out.println(Integer.toHexString(i) +":"+ i + "\t" + memoryElement);
        }
            
    }
    public int getMemoryLimit(){
        return memoryLimit;
    }
    public void addInMemory(int i,String byteStream){
        cells[i] = byteStream;
    }
    public int getDataLimit(){
        return dataLimit;
    }
    public String getContent(int i){
        return cells[i];
    }
}
