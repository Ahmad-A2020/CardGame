public class StringTest {
    public static void main(String[] args) {
        String str1= "java";
        String str2= "javax";
        String str3= "Javax";
        String str4= "JAVA";

        // equals
        System.out.println("is "+str1+" equal "+str2+ ":"+str1.equals(str2));
        System.out.println("is "+str2+" equal "+str3+ ":"+str2.equals(str3));
        System.out.println("is "+str2+" equal "+str3+ " with ignore to capital case of the :"+str2.equalsIgnoreCase(str3));

            // compareTo
        if(str1.compareTo(str2)==0){
            System.out.println(str1+" is equal "+str2);
        }else{
            System.out.println(str1+" is not equal "+str2);
        }

            // toUpperCase() and toLowerCase()

        System.out.println("The capital letter case of "+str1+" is:"+str1.toUpperCase());
        System.out.println("The lower letter case of "+str4+" is:"+str4.toLowerCase());

            // length

        System.out.println("the length of the "+str1+" is: "+str1.length());

        // indexOf()
        System.out.println("The index of v in "+str1+" is: "+str1.indexOf("v") );

        // charAt()
        System.out.println("The character at position 3 in "+str1+" is: "+str1.charAt(2)  );

        // endsWith()
        System.out.println("is "+str1+" end with character  a: "+str1.endsWith("a")  );
        System.out.println("is "+str1+" end with character  x: "+str1.endsWith("x")  );

        // startsWith()
        System.out.println("is "+str1+" start with character  j: "+str1.startsWith("j")  );
        System.out.println("is "+str1+" start with character  x: "+str1.startsWith("x")  );

        // replace()
        System.out.println("replace all a in "+str1+" with x: "+str1.replace("a","x")  );

        // substring()
        System.out.println("The first two character of  "+str1+" are: "+str1.substring(0,2)  );

        // regionMatches()
        System.out.println("is the first three character of  "+str1+" are same as the first three character of "+str2+" : "+str1.regionMatches(0, str2,0,3)  );



    }
}
