# APIAssessment
How to execute the code?
1.	Open CMD
  
2.	Change director to project directory
 
3.	Type “mvn clean test” and press, enter execution should start.
 
How to view report
1.	Open the project and navigate to target\surefire-reports folder
 
2.	Open index.html
3.	Under results they are three methods executed named 
	shouldReturnAllBreeds which returns a list of all dog breeds 
	shouldContainRetriever verify “retriever” breed is within the list 
	shouldReturnOnlyListOfSpecifiedBreed returns a list of sub-breeds for “retriever” 
	mustReturnRandomBreedImage produce a random image / link for the sub-breed “golden” 
