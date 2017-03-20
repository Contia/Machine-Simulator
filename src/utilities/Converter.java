/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author contia
 */
public class Converter {
   private static Converter instance = null;
   
   protected Converter() {
      // Exists only to defeat instantiation.
   }
   public static Converter getInstance() {
      if(instance == null) {
         instance = new Converter();
      }
      return instance;
   }    
   public String binaryToHex(String binary){
       String hexStr="";
       for (int i=0;i<binary.length();i+=4)
       {
           String chunkBinary="";
           for (int j=i;j<i+4;j++){
               chunkBinary += binary.charAt(j);
           }
           int decimal = Integer.parseInt(chunkBinary,2);
           hexStr += Integer.toString(decimal,16);
           
       }
       return hexStr;
   }
   public String HexToBinary(String hex){
       String binary = "";
       for (int i=0;i<hex.length();i++){
               String character = Character.toString(hex.charAt(i));
               int integer  = Integer.parseInt(character, 16);
               String tempBinary = Integer.toBinaryString(integer);
               if (tempBinary.length() <4){
                    String zeros="0";
                    for (int j=0;j<3-tempBinary.length();j++)
                         zeros += "0";
                    tempBinary = zeros + tempBinary;
               }
               binary += tempBinary;
       }
       return binary;
   }
   public int HexToDecimal(String hex){
       return Integer.parseInt(hex,16);
   }
   public int BinaryToDecimal(String binary){
       return Integer.parseInt(binary,2);
   }
   public String DecimalToBinary(int decimal){
       return Integer.toBinaryString(decimal);
   }
}
