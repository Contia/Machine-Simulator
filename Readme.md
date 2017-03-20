# Machine-Simulator 
It is a java-based program implemented in Netbeans that simulates a simple machine with main memory and cpu. It also supports a machine language. 

## System's Characteristics
- Main Memory: consists of 256 cells. In the half of these cells, the data is stored. The rest cells stores the code. Each cell's capacity is 8 bits (1 byte). 
  >The representation of memory's addresses is in hex format. 
- CPU: consists of 16 registers, an Instruction Register (IR) and a Program Counter (PC).
  >Each instruction consists of 16 bits
- Machine: consists of a main memory and a cpu. 
  >It arranges the connection between cpu and main memory.
## Representation
- Instruction: a user gives as input a string that consists of 4 characters. Each character represents 
  a hex number. The internal represetation of the instruction is in binary format. 
- Data: They are integers in range [0,256). The user cannot add data without writing code in machine language. 

## Machine Language
The instructions of the machine language are 9.
- 1RXY: Loads bits from memory address XY and stores them to register R. 
- 2RXY: Loads bits XY to register R
- 3RXY: Stores bits from register R to memory in XY address. 
- 40RS: Moves bits from register R to register S. 
- 5RST: Adds the contents in registers S and T and stores them in register R.
- 7RST: Executes the operation OR in registers S and T and stores them in register R.
- 8RST: Executes the operation AND in registers S and T and stores them in register R.
- 9RST: Executes the operation XOR in registers S and T and stores them in register R.
- C000: Halts 

## Installation
You should download the source code from the git repository and open it with the Netbeans. 

## Execution
It is a console-based program. When it starts, a menu is appeared to the user. There are 4 choices.
- Insert a chunk of code: The user writes each instruction and presses enter. If an instruction is empty, then the program returns to the menu. 
- Show memory: Shows a table of three columns and 256 rows. 
  > 'memory address in hex' : 'memory address in decimal' 'content'
- Fill memory randomly: stores random bits in the data segment of memory. 
- Start execution: executes the instructions that the user has given.

Feel free to ask about this tiny project (info@contia.gr)
