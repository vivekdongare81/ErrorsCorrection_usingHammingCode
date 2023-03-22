# ErrorsCorrection_usingHammingCode

A Task consists of implementing Hamming Code on a web page with backend support, which is used to Encode bitstream and Decodes it into original bitstream even if errors occurred in certain limit. It can detect 2 bit error and correct a single bit error in each group (depends on version of HC applied) if may occur while transmission of data. <br/>



## Prerequisite 

- Tomcat Server, Java SE 8 (JDK 1.8)


## Installation to Run Locally


 -  Step 1 - Clone the project and navigate to the project directory
  
```bash
git init 
git clone < repo link >

```


  -  Step 2 - Run home.jsp with Tomcat server 

```bash
 >> home.jsp

```


URL - http://localhost:8080/ErrorDetectionNCorrection/homeServelet


## Demo

- Select version of Hamming code from checklist to be used to Encode Bitstream. 

![image](https://user-images.githubusercontent.com/74758376/226928789-ed83e771-6ec3-4b92-87eb-5b5a4e465122.png)

- Input bitstream to be Encoded and press ENCODE.

![image](https://user-images.githubusercontent.com/74758376/226929299-76fb183d-1c0c-40af-8b67-59eb1ff344e3.png)

- Result will appear as Encoded bitstream with other req details.

![image](https://user-images.githubusercontent.com/74758376/226933917-fc7afdd2-7727-4ba3-85ab-cc523ff84a77.png)

  
        *** Suppose the error occured in Encoded stream due to Transmission or any other cause. 1111010010 --> 1011010110 ***
        
 .
 
        * CASE 1:  Resulted output is Original Bitstream after correcting single errors.
        
 ![image](https://user-images.githubusercontent.com/74758376/226930926-d536ad38-54d5-4be1-a89a-4f696a2e7db8.png)
 
 ![image](https://user-images.githubusercontent.com/74758376/226932485-7c209de9-9214-4c31-921a-5d56438fbb6b.png)

        * CASE 2:  Resulted output as Double error detected,can't decode further (Gives Total no of Errors detected).

![image](https://user-images.githubusercontent.com/74758376/226933403-0f0f2ec9-03d4-4e73-a579-f77027785a7b.png)

![image](https://user-images.githubusercontent.com/74758376/226933369-14afe581-f635-42b0-b8e5-2c3bd61f6038.png)


## References 

- [Wikipedia](https://en.wikipedia.org/wiki/Hamming_code)




