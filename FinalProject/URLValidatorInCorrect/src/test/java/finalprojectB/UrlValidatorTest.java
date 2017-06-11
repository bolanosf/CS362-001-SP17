/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;




/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
   		System.out.println("\nManual tests");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		System.out.println("URL=http://www.amazon.com -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.com"));
		System.out.println("URL=http://www.google.com:80/test1?action=view -> Expected = true :: Actual = " + urlVal.isValid("http://www.google.com:80/test1?action=view")); //bug in the UrlValidator there is a bug when you have a url with action=view
		System.out.println("URL=ftp://go.com:65535/t123?action=edit&mode=up -> Expected = true :: Actual = " + urlVal.isValid("ftp://go.com:65535/t123?action=edit&mode=up"));
		System.out.println("URL=h3t://go.au:0/$23 -> Expected = true :: Actual = " + urlVal.isValid("h3t://go.au:0/$23"));
		System.out.println("URL=http:0.0.0.0:6553?action=view -> Expected = false :: Actual = " + urlVal.isValid("http:0.0.0.0:6553?action=view"));
		System.out.println("URL=http/0.0.0.0 -> Expected = false :: Actual = " + urlVal.isValid("http/0.0.0.0"));
		System.out.println("URL=http://www.google.com:80/..//file?action=view -> Expected = false :: Actual = " + urlVal.isValid("http://www.google.com:80/..//file?action=view"));
		System.out.println("URL=ftp://go.com:65a/t123?action=edit&mode=up -> Expected = false :: Actual = " + urlVal.isValid("ftp://go.com:65a/t123?action=edit&mode=up"));
		
		
		
		System.out.println(urlVal.isValid("http://255.258.255.255:80")); //test for bad ip address
   }
   
   
	public void testYourFirstPartition()
	{
		System.out.println("\nFirst Partition tests");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		System.out.println("URL=http://www.amazon.com -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.com"));
		System.out.println("URL=http://www.amazon.zw -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.zw")); //test for country codes
		System.out.println("URL=http://www.amazon.org -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.org"));
		System.out.println("URL=http://www.amazon.edu -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.edu"));
		System.out.println("URL=http://www.amazon.tel -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.tel"));
		System.out.println("URL=http://www.amazon.cat -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.cat"));
		System.out.println("URL=http://www.amazon.cc -> Expected = false :: Actual = " + urlVal.isValid("http://www.amazon.cc"));
		System.out.println("URL=http://www.amazon.aaa -> Expected = false :: Actual = " + urlVal.isValid("http://www.amazon.aaa"));
		System.out.println("URL=http://www.amazon.a -> Expected = false :: Actual = " + urlVal.isValid("http://www.amazon.a"));
	}
   
	public void testYourSecondPartition()
	{
		System.out.println("\nSecond Partition tests");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		System.out.println("URL=http://www.amazon.com -> Expected = true :: Actual = " + urlVal.isValid("http://www.amazon.com"));
		System.out.println("URL=ftp://www.amazon.com -> Expected = true :: Actual = " + urlVal.isValid("ftp://www.amazon.com"));
		System.out.println("URL=h3t://www.amazon.com -> Expected = true :: Actual = " + urlVal.isValid("h3t://www.amazon.com"));
		System.out.println("URL=2ht://www.amazon.com -> Expected = false :: Actual = " + urlVal.isValid("2ht://www.amazon.com"));
		System.out.println("URL=http:/www.amazon.com -> Expected = false :: Actual = " + urlVal.isValid("http:/www.amazon.com"));
		System.out.println("URL=http:www.amazon.com -> Expected = false :: Actual = " + urlVal.isValid("http:www.amazon.com"));
		System.out.println("URL=http/www.amazon.com -> Expected = false :: Actual = " + urlVal.isValid("http/www.amazon.com"));
		System.out.println("URL=://www.amazon.com -> Expected = false :: Actual = " + urlVal.isValid("://www.amazon.com"));
	}
   
   
   public void testIsValid()
   {
		System.out.println("\nProgramming Based tests");
		//String[] urlSchemeVal = {"http://", "ftp://", "het://"};
		//String[] urlAuthorityVal = {"www.google", "1.2.3.4", "255.255.255.255"};
		//String[] urlSuffixVal = {".com", ".net", ".zw"};
		//String[] urlPathVal = {":80/test1?action=view", ":65535/t123?action=edit&mode=up", "/t123"};
		//String[] urlSchemeInVal = {"2ht://", "http:/", "://"};
		//String[] urlAuthorityInVal = {"256.256.256.256", "1.2.3.", "1.2.3.4.5"};
		//String[] urlSuffixInVal = {".cc", ".a", ".aaa"};
		//String[] urlpathInVal = {"/../", ":65a", "/test1//file"};

	   //for(int i = 0;i<10000;i++)
	  // {
		//	UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		//	int n1 = (int)(Math.random()*urlSchemeVal.length);
		//	int n2 = (int)(Math.random()*urlAuthorityVal.length);
		//	int n3 = (int)(Math.random()*urlSuffixVal.length);
		//	int n4 = (int)(Math.random()*urlPathVal.length);
		//	String testURL = prefix[n1] + middle[n2] + suffix[n3] + path[n4];
		   
	  // }






	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        Random rand = new Random();
        int PassOrFail; // 0 or 1
        int FailSection; // 0,1,2,3 for each section
 
        String[] urlSchemeVal = {"http://", "ftp://", "h3t://"};
        String[] urlAuthorityVal = {"www.google", "1.2.3.4", "255.255.255.255"};
        String[] urlSuffixVal = {".com", ".net", ".zw"};
        String[] urlPathVal = {"/test1", ":65535/t123?action=edit&mode=up", "/t123"};
 
        String[] urlSchemeInVal = {"2ht://", "http:/", "://"};
        String[] urlAuthorityInVal = {"256.256.256.256", "1.2.3.", "1.2.3.4.5"};
        String[] urlSuffixInVal = {".cc", ".a", ".aaa"};
        String[] urlPathInVal = {"/../", ":65a", "/test1//file"};
 
 
         int n1,n2,n3,n4;
        String testURL;

for(int i = 0; i<100; i++)
        {
               if(Math.random() < 0.5) {
					PassOrFail = 1;
				}
				else{
					PassOrFail = 0;
				}
                if(PassOrFail == 1) // expected pass
                {
                        n1 = (int)(Math.random()*urlSchemeVal.length);
                        n2 = (int)(Math.random()*urlAuthorityVal.length);
                        n3 = (int)(Math.random()*urlSuffixVal.length);
                        n4 = (int)(Math.random()*urlPathVal.length);
                        testURL = urlSchemeVal[n1] + urlAuthorityVal[n2] + urlSuffixVal[n3] + urlPathVal[n4];
                        System.out.println("URL="+ testURL + "-> Expected = true :: Actual = " + urlVal.isValid(testURL));
                }
 
	else // expected fail
                {
                        FailSection = rand.nextInt(3);
                        switch (FailSection) {
                        case 0:
                                n1 = (int)(Math.random()*urlSchemeInVal.length);
                                n2 = (int)(Math.random()*urlAuthorityVal.length);
                                n3 = (int)(Math.random()*urlSuffixVal.length);
                                n4 = (int)(Math.random()*urlPathVal.length);
                                testURL = urlSchemeInVal[n1] + urlAuthorityVal[n2] + urlSuffixVal[n3] + urlPathVal[n4];
                                System.out.println("URL="+ testURL + "-> Expected = false :: Actual = " + urlVal.isValid(testURL));
                                break;
 
                        case 1:
                                n1 = (int)(Math.random()*urlSchemeVal.length);
                                n2 = (int)(Math.random()*urlAuthorityInVal.length);
                                n3 = (int)(Math.random()*urlSuffixVal.length);
                                n4 = (int)(Math.random()*urlPathVal.length);
                                testURL = urlSchemeVal[n1] + urlAuthorityInVal[n2] + urlSuffixVal[n3] + urlPathVal[n4];
                                System.out.println("URL="+ testURL + "-> Expected = false :: Actual = " + urlVal.isValid(testURL));
                                break;
                        case 2:
                                n1 = (int)(Math.random()*urlSchemeVal.length);
                                n2 = (int)(Math.random()*urlAuthorityVal.length);
                                n3 = (int)(Math.random()*urlSuffixInVal.length);
                                n4 = (int)(Math.random()*urlPathVal.length);
                                testURL = urlSchemeVal[n1] + urlAuthorityVal[n2] + urlSuffixInVal[n3] + urlPathVal[n4];
                                System.out.println("URL="+ testURL + "-> Expected = false :: Actual = " + urlVal.isValid(testURL));
                                break;
 
                        case 3:
                                n1 = (int)(Math.random()*urlSchemeVal.length);
                                n2 = (int)(Math.random()*urlAuthorityVal.length);
                                n3 = (int)(Math.random()*urlSuffixVal.length);
                                n4 = (int)(Math.random()*urlPathInVal.length);
                                testURL = urlSchemeVal[n1] + urlAuthorityVal[n2] + urlSuffixVal[n3] + urlPathInVal[n4];
                                System.out.println("URL="+ testURL + "-> Expected = false :: Actual = " + urlVal.isValid(testURL));
                                break;
 
                        default:
                                break;
 
                        }
                }
 
        }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
