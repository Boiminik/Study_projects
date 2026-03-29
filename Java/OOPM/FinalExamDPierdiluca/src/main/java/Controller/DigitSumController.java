package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DigitSumController {
    int usgcnt = 0; //the counter for the usages

    @RequestMapping ("/api/digitsum") //calculates digitsum of a number
    public int digitSum (@RequestParam int number){
        int digit; //current digit taken from the number
        int sum = 0; //digit sum
        while (number != 0){
            digit = number %10; //take digit out of number
            sum = sum + digit; //add it to the digit sum
            number = number/10; //take digit away from number
        }
        usgcnt++; //adds a count to the usages
        return sum;
    }
    @RequestMapping ("/api/usage") //returns how many times the feature digitSum was used
    public int usage(){
        return usgcnt;
    }

}
