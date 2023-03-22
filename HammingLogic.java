
package com.HammingCodee;

import java.util.ArrayList;

public class HammingLogic {
    static ArrayList<Integer> finalCode = new ArrayList<>();
    static String input = "";
    static int countDiv = 0;
    static int parityCount = 0;
    static String encoded = "";
    static String correctedEncode = "";
    static String output = "";
    static int errCount = 0;
    static float codeRate ; 
    static long timeTakenToEncode;
    static long timeTakenToDecode;

   
     
     public static HammingLogic mainnEncode(String inputStream ,String hammVersion) {

    	 

        String intData[] = hammVersion.split(",");

        int dataSize =  Integer.parseInt(intData[1]) ;
        int groupSize=Integer.parseInt(intData[0]) ;
       codeRate = (float) dataSize/groupSize;

        System.out.println(dataSize);
        System.out.println(groupSize);
        System.out.println(codeRate);

    	HammingLogic.encoded="";
    	HammingLogic.countDiv=0;
    	HammingLogic.parityCount=0;
    	HammingLogic.input="";
    	HammingLogic.encoded = "";
    	HammingLogic.correctedEncode = "";
    	HammingLogic.output = "";
    	HammingLogic.errCount = 0;
    	
    	finalCode.clear();
		
		
        // get input
    	 HammingLogic hl = new HammingLogic();
    	 hl.input=inputStream;
    	 
         long startEncode = System.currentTimeMillis();
         


        input = inputStream;
        int size;
        int arr[];
        size = inputStream.length();
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[size - i - 1] = Integer.parseInt(String.valueOf(inputStream.charAt(i)));
        }
        

    

        // call getHammingCode() method and store its return value to the hammingCode
        // array
        encodeInGroups(arr,dataSize); // -- store encoded data in finalcode

        String tempp = "";
        for (int inx = 0; inx < finalCode.size(); inx++) {

            tempp += finalCode.get(inx);
            if (tempp.length() == groupSize || inx == finalCode.size() - 1) {
                encoded = tempp + encoded;
                // System.out.println(encoded + " --" + tempp);
                tempp = "";
            }
            // System.out.println(finalCode.get(inx));
        }

        long endEncode = System.currentTimeMillis();   
         timeTakenToEncode = endEncode - startEncode;
        

        System.out.println("Input Stream " + input);
        System.out.println("total div - " + countDiv);
        System.out.println("total parity - " + parityCount);
        System.out.println("Encoded stream - " + encoded);
        System.out.println("Code Rate - " + codeRate);
        System.out.println("Time to Encode- " +timeTakenToEncode + " ms");


        
     return hl;
 
    }
     
     public static HammingLogic mainnDecode(String errorStream ,String hammVersion) {

     	HammingLogic.encoded="";
     	HammingLogic.countDiv=0;
     	HammingLogic.parityCount=0;
     	HammingLogic.input="";
     	HammingLogic.encoded = "";
     	HammingLogic.correctedEncode = "";
     	HammingLogic.output = "";
     	HammingLogic.errCount = 0;
     	
     	finalCode.clear();
     	
    	 HammingLogic hl = new HammingLogic();
    

         String intData[] = hammVersion.split(",");

         int dataSize =  Integer.parseInt(intData[1]) ;
         int groupSize=Integer.parseInt(intData[0]) ;
        codeRate = (float) dataSize/groupSize;

         long startDecode = System.currentTimeMillis();

         String tempp = "";
         for (int inx = 0; inx < errorStream.length(); inx++) {

             tempp += errorStream.charAt(errorStream.length() - 1 - inx);

             if (tempp.length() == groupSize || inx == errorStream.length()- 1) { 
                 tempp = new StringBuilder(tempp).reverse().toString();
                System.out.println(encoded + " --" + tempp);

                 int[] symptomsBitArr = new int[tempp.length()];
                 for (int i = 0; i < symptomsBitArr.length; i++) {
                     symptomsBitArr[i] = Integer.parseInt(String.valueOf(tempp.charAt(tempp.length() - i - 1)));
                 }
             
                 receiveData(symptomsBitArr);
          
                 tempp = "";
             }

             // System.out.println(finalCode.get(inx));
         }

         long endDecode = System.currentTimeMillis();
         timeTakenToDecode = endDecode-startDecode;
         System.out.println("The corrected encoded data:");
         System.out.println(correctedEncode);
         System.out.println("The original data after correction :");
         System.out.println(output);
         System.out.println("Err count:");
          System.out.println(errCount);
          System.out.println("Time to Decode- " +timeTakenToDecode + " ms");
          return hl;
          
     }

    public static void encodeInGroups(int arr[],int dataSize) {

        int temp[];
        if (arr.length < dataSize) {    
            temp = new int[arr.length];
        } else {
            temp = new int[dataSize];
        }

        int encodedGROUP[];
        int cnt = 0;

        for (int k = 0; k < arr.length; k++) {

            temp[cnt] = arr[k];
            cnt++;
     
            if (cnt == temp.length) {

                System.out.println("end");
        
                encodedGROUP = encodingFUNC(temp,dataSize);
                System.out.println(" hamming code generated :");
                countDiv++;

                for (int i = 0; i < encodedGROUP.length; i++) {
                    finalCode.add(encodedGROUP[(encodedGROUP.length - i - 1)]);
                    System.out.print(encodedGROUP[(encodedGROUP.length - i - 1)]);
                }
                System.out.println();

                cnt = 0;
             
                if (arr.length - k - 1 < dataSize && arr.length - k - 1 != 0) { 

                    System.out.println("warn" + (arr.length - k - 1));
                    temp = new int[arr.length - k - 1];
                } else {
                    temp = new int[dataSize]; 
                }

            }

        }
        System.out.println();

    }

    // encode using hamming code
    static int[] encodingFUNC(int data[],int dataSize) {

        int encodedData[];
        int size;
        int i = 0, parityLength = 0;

        size = data.length;
       
            while (i < size) {

                if (Math.pow(2, parityLength) == (i + parityLength + 1)) {
                    parityLength++;
                } else {
                    i++;
                }
            }       
        parityCount += parityLength;

        // initiate encoded
        encodedData = new int[size + parityLength];

        // initializze parity with val -1
        int j = 0, k = 0; 
        // j to iterate encoded , k to iterate original arr

        for (i = 1; i <= encodedData.length; i++) {
        
            if (Math.pow(2, j) == i) {

                encodedData[(i - 1)] = -1;
                j++;
            } else {
                encodedData[(k + j)] = data[k];
                k++;
            }
        }

        for (i = 0; i < parityLength; i++) {
            int temp = parityVal(encodedData, i);

            encodedData[((int) Math.pow(2, i)) - 1] = temp;
        }

        return encodedData;
    }

    static int parityVal(int encodedData[], int pow) {

        int m = 1;

        Integer ans = null;
        while (m <= encodedData.length) {

            if (m % (int) Math.pow(2, pow) == 0) {
                int n = 1;
                while (n <= (int) Math.pow(2, pow) && m <= encodedData.length) { // p0 n1 p1 n2 p2 n4
                    //System.out.println(pow + " " + m + " " + n + " " + ans + " " + encodedData[m - 1]);
                    if (encodedData[m - 1] != -1) {
                        if (ans == null) {
                            ans = encodedData[m - 1];
                        } else {
                            ans = ans ^ encodedData[m - 1]; // Exor oper
                        }
                        System.out.println(ans);
                    }
                    n++;
                    m++;
                }
            }
            m++;
        }
        return (int) ans;
    }

    static void receiveData(int data[]) {
        int parityBits = 0;
 //System.out.println(data.length);
        int size;
        // code to get the required number of parity bits

        int n = 0;

        size = data.length;

        while(n<size){
         if((Math.pow(2, n)<size)){
 //System.out.println(Math.pow(2, n));
 parityBits++;
         }
        n++;
        }

        int pow;

        int parityArray[] = new int[parityBits];
       
        String errorLoc = new String();
     
        for (pow = 0; pow < parityBits; pow++) {
            // use for loop to extract the bit from 2^(power)
            for (int i = 0; i < size; i++) {
                int j = i + 1;
              
                String str = Integer.toBinaryString(j);
            
                int bit = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;
                if (bit == 1) {
                    if (data[i] == 1) {
                        parityArray[pow] = (parityArray[pow] + 1) % 2;
                    }
                }
            }
            errorLoc = parityArray[pow] + errorLoc;
        }
        

        int exor=parityArray[0];int check1=0;
        for(int i=0;i<parityArray.length;i++){
            if(parityArray[i]==1){
                check1++;
            }
            System.out.println("arr "+ parityArray[i]);
            exor^=parityArray[i];
            System.out.println(exor+" exor");
        }
        System.out.println(exor+" "+check1);
        if(check1>0 && exor==0){
            System.out.println("double err");
            errCount++;
            errCount++;
            correctedEncode="Can not correct as Double error occured";
            output="Can not process as Double error occured";
           
        }else{
        	
       
     
        int finalLoc = Integer.parseInt(errorLoc, 2);
        String temp = "";
        if (finalLoc != 0) {
          
            errCount++;
            data[finalLoc - 1] = (data[finalLoc - 1] + 1) % 2;
      
            System.out.println();
        }
          
        for (int i = 0; i < size; i++) {
            // System.out.print(data[size - i - 1]);
            temp += data[size - i - 1];
        }
        correctedEncode = temp + correctedEncode;
        System.out.println("correct - " +correctedEncode);

        pow = parityBits - 1;
        String tempp = "";
        for (int k = size; k > 0; k--) {
            if (Math.pow(2, pow) != k) {
                // System.out.print(data[k - 1]);
                tempp += data[k - 1] ; //System.out.println(tempp);
            } else {

                pow--;
            }
        }
        output = tempp + output;

        System.out.println("output - " + output);
        System.out.println();
        }
    }

}
