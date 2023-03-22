# ErrorsCorrection_usingHammingCode

A Task consists of implementing Hamming Code on a web page with backend support, which is used to Encode bitstream and Decodes it into original bitstream even if errors occurred in certain limit. It can detect 2 bit error and correct a single bit error in each group (depends on version of HC applied) if may occur while transmission of data. <br/>

## Demo

- Select version of Hamming code from checklist to be used to Encode Bitstream. 
![image](https://user-images.githubusercontent.com/74758376/226928789-ed83e771-6ec3-4b92-87eb-5b5a4e465122.png)

- Input bitstream to be Encoded and press ENCODE.
![image](https://user-images.githubusercontent.com/74758376/226929299-76fb183d-1c0c-40af-8b67-59eb1ff344e3.png)

- Result will appear as Encoded bitstream with other req details.
![image](https://user-images.githubusercontent.com/74758376/226929702-80cb587f-bf86-421b-b735-98438d03eb9b.png)

  
        *** Suppose the error occured in Encoded stream due to Transmission or any other cause. 1111010010 --> 1011010110 ***
        
![image](https://user-images.githubusercontent.com/74758376/226930926-d536ad38-54d5-4be1-a89a-4f696a2e7db8.png)

        * CASE 1:  Resulted output is Original Bitstream after correcting single errors.
        
 ![image](https://user-images.githubusercontent.com/74758376/226930926-d536ad38-54d5-4be1-a89a-4f696a2e7db8.png)
 
 ![image](https://user-images.githubusercontent.com/74758376/226932485-7c209de9-9214-4c31-921a-5d56438fbb6b.png)

        * CASE 2:  Resulted output as Double error detected,can't decode further (Gives Total no of Errors detected).

![image](https://user-images.githubusercontent.com/74758376/226933403-0f0f2ec9-03d4-4e73-a579-f77027785a7b.png)

![image](https://user-images.githubusercontent.com/74758376/226933369-14afe581-f635-42b0-b8e5-2c3bd61f6038.png)


## Prerequisite 

- Node.js runtime environment 
     
     node -v  (to check Node.js is installed) 
- WebDriver of Browsers Installed - Chrome, Microsoft Edge, Firefox 


## Webdrivers

| WebDrivers             | Download Link                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Chrome| [https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads)|
| Firefox| https://github.com/mozilla/geckodriver/releases|
| Microsoft Edge |[https://developer.microsoft.com/en-us/microsoft-edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads)| |

 Move all Drivers in any specific folder and add this folder into PATH of Environmental Variables. <br />
-- Search for 'edit environmental variable' > Environmental variable > System variable > PATH <br />
-- Add a new folder's path in PATH.  <br />
![image](https://user-images.githubusercontent.com/74758376/170932144-40f6f187-fea2-46d2-8725-c8b5bca77f2e.png)


## Used Library / tools with supported browsers

| Library / Tools             |  Browsers                                                               |
| ----------------- | ------------------------------------------------------------------ |
| Selenium  |  Chrome, Firefox, Microsoft Edge |
| Playwright|  Chrome, Firefox, Webkit |
| Puppeteer |  Chrome, Microsoft Edge | |


## Installation to Run Locally


 -  Step 1 - Clone the project and navigate to the project directory
  
```bash
git init 
git clone < repo link >

```


  -  Step 2 - Install required Dependencies 

```bash
  npm install --save

```
![image](https://user-images.githubusercontent.com/74758376/170021068-62a60db1-28f2-4850-a123-d4415c7e5378.png)

 -  Step 3 - Run the project

```bash
  node index 

```



  -  Step 4 - Open admin panel to analysis test results 

```bash
  node admin 

```
URL - https://localhost:3000/admin

## Documentations

- [Selenium](https://www.selenium.dev/documentation)
- [Playwright](https://playwright.dev/docs/intro)
- [Puppeteer](https://pptr.dev)




