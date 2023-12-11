package GPCalculatorApp;

import java.util.ArrayList;
import java.util.Scanner;
import GPCalculatorApp.Models.UserInputModel;



public class GPCalc {
    //This is the main application.
    public static CalculatingLogic Calc = new CalculatingLogic();

    private static Scanner input = new Scanner(System.in);
    
    private static UserInputModel WhatUserInput() {
        Scanner input = new Scanner(System.in);
        UserInputModel HisInput = new UserInputModel();
        
        System.out.println("Enter the course name (type 'exit' to finish): ");
        String CName = input.next();
        if (CName == null || CName.equalsIgnoreCase("exit")) {
            return HisInput;
        }
        System.out.print("Enter the course code: ");
        String Code = input.next();
        System.out.print("Enter the course unit: ");
        int Weight = input.nextInt();
        System.out.print("Enter your score for this course: ");
        int Score = input.nextInt();
        
        HisInput.courseName = CName;
        HisInput.courseCode = Code;
        HisInput.courseWeight = Weight;
        HisInput.courseScore = Score;
        HisInput.gradeType = Grade(Score);
        HisInput.gradeUnit = GradUnit(Score);
        HisInput.qualityPoint = QualityPoint(Weight, GradUnit(Score));
        return HisInput;
    }

    private static char Grade(int Score) {
        char grade = 'F';
        if(Score >= 70 && Score <= 100){
            grade = 'A';
        }
        else if(Score >= 60 && Score < 70){
            grade = 'B';
        }
        else if(Score >= 50 && Score < 60){
            grade = 'C';
        }
        else if(Score >= 45 && Score < 50){
            grade = 'D';
        }
        else if(Score >= 40 && Score < 45){
            grade = 'E';
        }
        return grade; 
    }

    private static int GradUnit(int Score){
        int unit = 0;
        if(Score >= 70 && Score <= 100){
            unit = 5;
        }
        if(Score >= 60 && Score < 70){
            unit = 4;
        }
        if(Score >= 50 && Score < 60){
            unit = 3;
        }
        if(Score >= 45 && Score < 50){
            unit = 2;
        }
        if(Score >= 40 && Score < 45){
            unit = 1;
        }
        return unit;
    }

    private static int QualityPoint(int Weight, int GradUnit){
        int qualityPoint = Weight * GradUnit;
        return qualityPoint;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Hello. This is your GPA Calculator. What's your name?");
        String UserName = input.next();
        System.out.printf("Welcome %s!", UserName);
        ArrayList<UserInputModel> AllUserInput = new ArrayList<>();

        while (true) {
            UserInputModel HisInput = WhatUserInput();

            if (HisInput.courseName == null || HisInput.courseName.equalsIgnoreCase("exit")) {
            System.out.println("Please hold on while we compute your GPA!\n\n");
            break;
            }

            AllUserInput.add(HisInput);
        }

        //Computing the GPA...
        double GPA = Calc.getTheGPA(AllUserInput);

        //16 14 7 12

        System.out.println("|----------------|--------------|-------|------------|");
    

        System.out.println("| COURSE & CODE  | COURSE UNIT  | GRADE | GRADE-UNIT |");

        System.out.println("|----------------|--------------|-------|------------|");

        for(UserInputModel HisInput : AllUserInput){
            System.out.printf("|%-16s|%-14s|%-7s|%-12s|\n",
            HisInput.courseName + " " + HisInput.courseCode, HisInput.courseWeight, HisInput.gradeType, HisInput.gradeUnit);
        }

        System.out.println("|----------------------------------------------------|\n\n");

        System.out.printf("Your GPA is = %.2f to 2 decimal places.", GPA);
    }

}
