Kazi Jamal Period 1

Guitar Hero: Plucking a Guitar String (5 points)
----------------------------------------------------------------------------------------------------------------
This program simulates the plucking of a guitar string using the Karplus-Strong algorithm
It uses a ring buffer feedback mechanism and an averaging operation which acts as a gentle low-pass filter
It consists of three source files:
	- RingBuffer.java is the data type modeling a ring buffer for the ring buffer feedback mechanism
	- GuitarString.java is the data type modeling a vibrating guitar string, using the ring buffer data type
	- GuitarHero.java is a GuitarString client and interactive guitar player that plays the guitar in real-time, using the keyboard to input notes. It supports 37 notes which are represented by the following keys: q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'S (S is space/spacebar)
It also uses the StdAudio.java and StdDraw.java libraries

Instructions to Run the Program:
1. Compile StdAudio.java, StdDraw.java, RingBuffer.java, GuitarString.java, and GuitarHero.java
2. Run GuitarHero
	$ java GuitarHero
3. Use the keys: q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'S (S is space/spacebar) to play the guitar with the Standard Draw window opened and in the foreground
4. Close the Standard Draw window to end the program

Output:
The only output of the program is the audio played through the Standard Draw window upon receiving input.



Pictures from Space (3 points)
----------------------------------------------------------------------------------------------------------------
This program detects and fixes data errors in transmission using a Hadamard code
The program uses a 32 x 32 Hadamard matrix and compares a given 32 bit codeword to each row of the matrix
If no errors were made, the codeword will perfectly match exactly one of the rows
Otherwise, the program returns the row of the matrix that it most closely resembles
It consists of one source file:
	- Mariner.java detects and fixes data errors in an input codeword provided to a Scanner object

Instructions to Run the Program:
1. Compile Mariner.java
	$ javac Mariner.java
2. Run Mariner
	$ java Mariner
3. Enter a 32 bit codeword, and the program will print out whether or not it has errors, and the closest codeword it resembles if it does have errors

Output:
There are three possible outputs:
	- Given a codeword that is not 32 bits, the program will print:
		entered codeword is not a 32 bit codeword
		enter a 32 bit codeword: 
	it will keep asking for a valid codeword until the input is a 32 bit codeword
	- Given a codeword without errors, the program will print:
		codeword does not have errors
	this output validates that the codeword had no errors made in transmission
	- Given a codeword with errors, the program will print:
		codeword has errors
		codeword most closely resembles <codeword that given codeword most closely resembles>
	this output validates that the codeword had errors made in transmission and provides the closest codeword



Linear Feedback Shift Register (4 points + 1 point extra credit)
----------------------------------------------------------------------------------------------------------------
This program encrypts images using a linear feedback shift register
It consists of three source files:
	- LFSR.java simulates the operation of a linear feedback shift register
	- PhotoMagic.java is an LFSR client that can encrypt images given an image, binary password, and tap number
	- PhotoMagicDeluxe.java is similar to PhotoMagic.java but uses an alphanumeric password (extra credit)
It also uses the Picture.java library

Instructions to Run the Program:
1. Compile Picture.java, LFSR.java, PhotoMagic.java, and PhotoMagicDeluxe.java
2. Run PhotoMagic with three command-line arguments, an image name, a binary password (an initial LFSR seed), and a tap number
It is preferred that the password is longer than 12 bits
Suggested tap numbers for corresponding bits in the password are as follows: 5 bits, tap 2; 6 bits, tap 4; 9 bits, tap 4; 10 bits, tap 6; 11 bits, tap 8; 20 bits, tap 16; 30 bits, tap 22; 36 bits, tap 24; 48 bits, tap 42
	$ java PhotoMagic <image name> <binary password> <tap number>
3. The encrypted image will be displayed on the screen, and it is saved in a file named by prepending an X to the given file name
4. To decrypt the encrypted image, run PhotoMagic on the encrypted image using the binary password and tap number originally used to encrypt the image
5. Run PhotoMagicDeluxe with three command-line arguments, an image name, a alphanumeric password, and a tap number
	$ java PhotoMagic <image name> <alphanumeric password> <tap number>
6. The encrypted image will be displayed on the screen, and it is saved in a file named by prepending an X to the given file name
7. To decrypt the encrypted image, run PhotoMagicDeluxe on the encrypted image using the alphanumeric password and tap number originally used to encrypt the image

Output:
The program outputs the encrypted image in a new window, and saves the encrypted image in a file named by prepending an X to the original file name