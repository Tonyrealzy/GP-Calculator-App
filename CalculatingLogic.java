package GPCalculatorApp;

import java.util.ArrayList;

import GPCalculatorApp.Models.UserInputModel;
public class CalculatingLogic {

    //Make sure these features are applied on the user input model...
    public ArrayList<UserInputModel> UserInput;
    public boolean output;

    public ArrayList<UserInputModel> CourseTotalDetails() {
        UserInput = new ArrayList<UserInputModel>();
        return UserInput;
    }

    //Method of computing the total quality points and grade units...
    public double getTheGPA(ArrayList<UserInputModel> UserInput){
        double GP = 0;

        ArrayList<Integer> gradeUnit = new ArrayList<Integer>();
        ArrayList<Integer> qualityPoint = new ArrayList<Integer>();

        for (UserInputModel userInput : UserInput) {
            gradeUnit.add(userInput.gradeUnit);  // GradeUnit being an Integer field in UserInputModel
            qualityPoint.add(userInput.qualityPoint);  // QualityPoint being a Double field in UserInputModel
        }

        int SumOfGradeUnits = calculateSum(gradeUnit);
        int SumOfQualityPoints = calculateSum(qualityPoint);
        GP = SumOfQualityPoints / SumOfGradeUnits;
        return GP;
    }

    //Defining my method of getting sum of values in an array...
    private int calculateSum(ArrayList<Integer> array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }
        return sum;
    }

}
        
