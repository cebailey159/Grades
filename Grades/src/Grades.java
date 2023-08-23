// Casey Bailey
// CIS 1502
// Programming Assignment #2


import java.util.*;

public class Grades {

	// Declares Scanner object
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		// Get the weights of Homework and Exam 1
		System.out.print("Homework and Exam 1 weights? ");
		
		// Set total max weight value to 100
		int totalMaxWeight = 100;
		
		// Get user input for weighted homework
		int weightOfHomework = scanner.nextInt();
		
		// Get user input for weighted Exam 1
		int weightOfExam1 = scanner.nextInt();
		
		// Get remaining weight by subtracting the sum of the homework and exam weight to the total max weight
		int remainingWeight = totalMaxWeight - (weightOfHomework + weightOfExam1);
		
			//Get the validated value of the weight for exam 2
        		int weightOfExam2 = validateConstraints(totalMaxWeight, 0, remainingWeight);
		
		// Print weight values
		System.out.print("Using weights of " + weightOfHomework + " " + weightOfExam1 + " " + weightOfExam2);
		System.out.println();
		System.out.println();
		
		// Compute Weighted Homework score
		double homeworkWeightScore = computeHomeworkWeightScore(weightOfHomework);
		System.out.println();
		
		// Compute Weighted exam1 score
		System.out.println("Exam 1:");
		double exam1WeightScore = computeExamWeightScore(weightOfExam1);
		System.out.println();
		
		// Compute Weighted exam2 score
		System.out.println("Exam 2:");
		double exam2WeightScore = computeExamWeightScore(weightOfExam2);
		System.out.println();
		
		// Compute the sum of homework, exam1, and exam2 weighted score
		double totalGrade = homeworkWeightScore + exam1WeightScore + exam2WeightScore;
		System.out.println("Course grade = " + round2(totalGrade));
		}
	
	// Returns the given double value rounded to the nearest hundredth
	public static double round2(double number) {
		return Math.round(number * 100.0) / 100.0;
		}
	
	// Validated value given min and max constraints 
	public static int validateConstraints(int max, int min, int value) {
		value = Math.min(max,  value);
		value = Math.max(min, value);
			return value;
			}
	// Returns the weight score
	public static double computeWeightScore(double totalScore, double totalMaxScore, double weight) {
		return (totalScore / totalMaxScore) * weight;
		}
	
	// Prints the total weight score
	public static double displayAndGetWeightScore(int score, int maxScore, int weight) {
		System.out.println("Total points = " + score + " / " + maxScore);
		
	// Get computed weight score 
		double weightScore = computeWeightScore( score, maxScore, weight);
			System.out.println("Weighted score = " + round2(weightScore));
				return weightScore; 
				}
	
	// Returns the homework weight score
	public static double computeHomeworkWeightScore(int weight) {
		
		// Obtains input from the user for assignment numbers
		System.out.println("Homework:");
		System.out.print("Number of assignments? ");
			int assignments = scanner.nextInt();
			
			// Declares min and max scores
			int totalScore = 0;
			int totalMaxScore = 0;
			
			// Sets limit (max) for section points
			int maxSectionPoints = 20;
			
			// Sum of max sections points to the total max score
			totalMaxScore += maxSectionPoints;
			
				// Adds max sections points to the max score
				totalMaxScore += maxSectionPoints;
				
			//Loop using for loop to iterate each assignment up to the number of assignments
		        for (int number = 1; number <= assignments; number++) {
		            
		        	//Prompt to input assignment score and max score
		            System.out.print("Assignment " + number + " score and max? ");
		            
		            //Get the inputs for score and the max score
		            int score = scanner.nextInt();
		            int max = scanner.nextInt();

		            //Add the score to the total score
		            totalScore += score;
		            
		            //Add the max score to the total max score
		            totalMaxScore += max;
		        	}	
	
	//Prompt user to enter the sections attended
		        System.out.print("Sections attended? ");
		        
		        //Get the sections
		        int sections = scanner.nextInt();

		        //Get the validated sections points, with max value according to max section points
		        //each section amounts to 4 points
		        int sectionPoints = validateConstraints(maxSectionPoints, 0, sections * 4);

		        //Add the section point to the total score
		        totalScore += sectionPoints;

		        //Validate the total score, with the max value according to the total max score
		        totalScore = validateConstraints(totalMaxScore, 0, totalScore);

		        //Display and return the homework weight score
		        return displayAndGetWeightScore(totalScore, totalMaxScore, weight);
				}
	//Takes the exam weight, receives score and curve input, then returns the weighted scores for exams
    public static double computeExamWeightScore(int weight) {

        //Set the total max score to 100
        int totalMaxScore = 100;

        //Prompt to get the score
        System.out.print("Score? ");
        //Get the input for score
        int score = scanner.nextInt();

        //Prompt to get the curve
        System.out.print("Curve? ");
        //Get the input for curve
        int curve = scanner.nextInt();

        //Get the total score by validating the sum of the score and curve
        //with the max constraint value according to the total max score
        int totalScore = validateConstraints(totalMaxScore, 0, score + curve);

        return displayAndGetWeightScore(totalScore, totalMaxScore, weight);
	 	}			
		
	}


